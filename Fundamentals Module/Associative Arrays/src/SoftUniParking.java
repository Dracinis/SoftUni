import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingLot = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String command = input[0];
            String username = input[1];

            if (command.equals("register")){
                String licensePlateNumber = input[2];
                if (!parkingLot.containsKey(username)){
                    parkingLot.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n",username, licensePlateNumber);
                } else if (parkingLot.containsKey(username)){
                    System.out.printf("ERROR: already registered with plate number %s%n", parkingLot.get(username));
                }
            } else if (command.equals("unregister")){
                if (parkingLot.containsKey(username)){
                    System.out.printf("%s unregistered successfully%n", username);
                    parkingLot.remove(username);
                } else if (!parkingLot.containsKey(username)){
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }
        for (Map.Entry<String, String> entry : parkingLot.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(), entry.getValue());
        }
    }
}
