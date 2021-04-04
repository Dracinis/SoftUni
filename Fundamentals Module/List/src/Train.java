import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
         int maxPassengers = Integer.parseInt(scanner.nextLine());

         String command = scanner.nextLine();

         while (!command.equals("end")){
                     String[]commandsArray = command.split( " ");
                     String currentCommand = commandsArray[0];

                     if (currentCommand.equals("Add")){
                         wagons.add(Integer.parseInt(commandsArray[1]));
                     } else {
                         for (int i = 0; i < wagons.size(); i++ ) {
                             if (wagons.get(i) + Integer.parseInt(currentCommand) <= maxPassengers) {
                                 wagons.set(i, wagons.get(i) + Integer.parseInt(currentCommand));
                                 break;
                             }
                         }
                     }
                     command = scanner.nextLine();
                     }
         System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
