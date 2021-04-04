import java.util.*;

public class PiratesOneMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> populationGoldMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Sail")) {
            String[] token = input.split("\\|\\|");
            String city = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);

            if (!populationGoldMap.containsKey(city)) {

                List<Integer> list = new ArrayList<>();
                list.add(0, population);
                list.add(1, gold);
                populationGoldMap.put(city, list);
            } else {
                int newPopulation = (populationGoldMap.get(city).get(0) + population);
                int newGold = (populationGoldMap.get(city).get(1)) + gold;

                populationGoldMap.get(city).set(0, newPopulation);
                populationGoldMap.get(city).set(1, newGold);

            }

            input = scanner.nextLine();
        }

        String inputAfterSail = scanner.nextLine();

        while (!inputAfterSail.equals("End")) {
            String[] tokenAfterSail = inputAfterSail.split("=>");
            String event = tokenAfterSail[0];
            String town = tokenAfterSail[1];

            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(tokenAfterSail[2]);
                    int gold2 = Integer.parseInt(tokenAfterSail[3]);
                    int newPeople = populationGoldMap.get(town).get(0) - people;
                    int newGold = populationGoldMap.get(town).get(1) - gold2;


                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold2, people);

                    if (newPeople <= 0 || newGold <= 0) {
                        populationGoldMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    } else {
                        populationGoldMap.get(town).set(0, newPeople);
                        populationGoldMap.get(town).set(1, newGold);
                    }
                    break;

                case "Prosper":
                    int gold3 = Integer.parseInt(tokenAfterSail[2]);
                    if (gold3 < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        int newGoldReserve = populationGoldMap.get(town).get(1) + gold3;
                        populationGoldMap.get(town).set(1, newGoldReserve);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , gold3, town, populationGoldMap.get(town).get(1));
                    }

                    break;
            }


            inputAfterSail = scanner.nextLine();
        }

        if (populationGoldMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", populationGoldMap.size());

            populationGoldMap.entrySet()
                    .stream()
                    .sorted((g1, g2) -> g2.getValue().get(1).compareTo(g1.getValue().get(1)))
                    .forEach(g -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", g.getKey(), g.getValue().get(0), g.getValue().get(1)));

        }

    }
}

