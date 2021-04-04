import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().replaceAll(" ","").split("");

        Map<String, Integer> charCount = new LinkedHashMap<>();

        for (String in : input) {
                charCount.putIfAbsent(in, 0);
                charCount.put(in, charCount.get(in) + 1);
        }

        for (Map.Entry<String, Integer> entry : charCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
