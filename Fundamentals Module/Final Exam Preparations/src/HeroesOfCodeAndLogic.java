import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> hpMap = new TreeMap<>();
        Map<String, Integer> mpMap = new TreeMap<>();
        int party = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < party; i++) {
            String inputParty = scanner.nextLine();
            String[] tokenParty = inputParty.split(" ");
            String hero = tokenParty[0];
            int hp = Integer.parseInt(tokenParty[1]);
            int mana = Integer.parseInt(tokenParty[2]);
            hpMap.putIfAbsent(hero, hp);
            mpMap.putIfAbsent(hero, mana);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] token = input.split(" - ");
            String command = token[0];
            String hero = token[1];

            switch (command){
                case "CastSpell":
                    String spellName = token[3];
                    int spellMana = Integer.parseInt(token[2]);
                    int currentMana = mpMap.get(hero);
                    if (currentMana >= spellMana){
                        mpMap.put(hero, currentMana-spellMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",hero, spellName, mpMap.get(hero));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", hero, spellName);
                    }
                    break;
                case "TakeDamage":
                    String attacker = token[3];
                    int damage = Integer.parseInt(token[2]);
                    int currentHp = hpMap.get(hero);
                    if (currentHp>damage){
                        hpMap.put(hero, currentHp-damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, hpMap.get(hero));
                    } else {
                        System.out.printf("%s has been killed by %s!%n",hero,attacker);
                        mpMap.remove(hero);
                        hpMap.remove(hero);
                    }

                    break;
                case "Recharge":
                    int manaAmount = Integer.parseInt(token[2]);
                    int currentMp = mpMap.get(hero);
                    if (manaAmount+currentMp > 200){
                        System.out.printf("%s recharged for %d MP!%n", hero, 200-currentMp);
                        mpMap.put(hero, 200);
                    } else {
                        mpMap.put(hero, manaAmount+currentMp);
                        System.out.printf("%s recharged for %d MP!%n", hero, manaAmount);
                    }
                    break;
                case "Heal":
                    int hpAmount = Integer.parseInt(token[2]);
                    int currentLife = hpMap.get(hero);
                    if (hpAmount+currentLife > 100){
                        System.out.printf("%s healed for %d HP!%n", hero, 100-currentLife);
                        hpMap.put(hero, 100);
                    } else {
                        hpMap.put(hero, hpAmount+currentLife);
                        System.out.printf("%s healed for %d HP!%n", hero, hpAmount);
                    }
                    break;
            }
            input= scanner.nextLine();
        }

        hpMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s%n  HP: %d%n  MP: %d%n",e.getKey(),e.getValue(),mpMap.get(e.getKey())));

    }
}
