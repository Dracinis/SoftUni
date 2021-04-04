import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> namePoints = new TreeMap<>();
        Map<String, Integer> languageCount = new TreeMap<>();

        String input;
        while (!"exam finished".equals(input=scanner.nextLine())){
            String[] data = input.split("-");
            String user = data[0];
            String operation = data[1];

            if (operation.equals("banned")){
                namePoints.remove(user);
            } else {
                Integer point = Integer.parseInt(data[2]);
                namePoints.putIfAbsent(user, point);
                if (namePoints.get(user) < point) {
                    namePoints.put(user, point);
                }
                languageCount.putIfAbsent(operation, 0);
                languageCount.put(operation, languageCount.get(operation) + 1);

            }
        }
        System.out.println("Results:");
        namePoints.entrySet().stream()
                .sorted((left, right)-> Integer.compare(right.getValue(), left.getValue()))
                .forEach(entry -> System.out.printf("%s | %d%n",entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");
        languageCount.entrySet().stream()
                .sorted((left, right)-> Integer.compare(right.getValue(), left.getValue()))
                .forEach(entry -> System.out.printf("%s - %d%n",entry.getKey(), entry.getValue()));
    }
}

