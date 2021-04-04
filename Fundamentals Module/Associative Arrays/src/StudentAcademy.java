import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (studentsGrades.containsKey(name)){
                studentsGrades.put(name, (studentsGrades.get(name) + grade) /2);
            }
            studentsGrades.putIfAbsent(name, grade);

        }
        studentsGrades.entrySet().stream()
                .filter(e -> e.getValue() >= 4.5)
                .sorted((left, right) -> Double.compare(right.getValue(), left.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue()));
    }
}
