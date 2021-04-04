import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mine = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            mine.putIfAbsent(input, 0);
            mine.put(input, mine.get(input) + quantity);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mine.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(), entry.getValue());
        }
    }
}
