
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> populationMap = new TreeMap<>();
        Map<String, Integer> goldMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Sail")){
            String[] token = input.split("\\|\\|");
            String city = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);

            goldMap.putIfAbsent(city, 0);
            goldMap.put(city, goldMap.get(city)+gold);
            populationMap.putIfAbsent(city, 0);
            populationMap.put(city, populationMap.get(city)+population);

            input = scanner.nextLine();
        }

        String inputAfterSail = scanner.nextLine();
        while (!inputAfterSail.equals("End")){
            String[] tokenAfterSail = inputAfterSail.split("=>");
            String command = tokenAfterSail[0];
            String town = tokenAfterSail[1];

            switch (command){
                case "Plunder":
                    int people = Integer.parseInt(tokenAfterSail[2]);
                    int newPeople = populationMap.get(town) - people;
                    int gold = Integer.parseInt(tokenAfterSail[3]);
                    int newGold = goldMap.get(town) - gold;

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town, gold, people);

                    if (newPeople <=0 || newGold <=0){
                        System.out.printf("%s has been wiped off the map!%n", town);
                        populationMap.remove(town);
                        goldMap.remove(town);
                    } else {
                        populationMap.put(town, newPeople);
                        goldMap.put(town, newGold);
                    }

                    break;
                case "Prosper":
                    int goldTwo = Integer.parseInt(tokenAfterSail[2]);
                    int newGoldTwo = goldMap.get(town) + goldTwo;
                    if (goldTwo < 0){
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldTwo, town, newGoldTwo);
                        goldMap.put(town, newGoldTwo);
                        break;
                    }
            }
            inputAfterSail = scanner.nextLine();
        }

        if (goldMap.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", goldMap.size());

            goldMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",e.getKey(), populationMap.get(e.getKey()), e.getValue()));
        }

    }
}
