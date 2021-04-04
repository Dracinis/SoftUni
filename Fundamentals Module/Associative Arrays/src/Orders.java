import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> orders = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> rememberProducts = new LinkedHashMap<>();
        String input;

        while (!"buy".equals(input = scanner.nextLine())){
            String[] data = input.split("\\s++");

            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            orders.putIfAbsent(product, 1.1);
            rememberProducts.putIfAbsent(product, 0);

            rememberProducts.put(product, rememberProducts.get(product) + quantity);
            orders.put(product, rememberProducts.get(product) * price);
        }
        for (Map.Entry<String, Double> entry : orders.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());

        }
    }
}
