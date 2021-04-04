import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[]commandsArray = command.split( " ");
            String currentCommand = commandsArray[0];

            switch (currentCommand){
                case ("Add"):
                    numbers.add(Integer.parseInt(commandsArray[1]));
                    break;
                case ("Remove"):
                    numbers.remove(Integer.valueOf(commandsArray[1]));
                    break;
                case ("RemoveAt"):
                    numbers.remove(Integer.parseInt(commandsArray[1]));
                    break;
                case ("Insert"):
                    numbers.add(Integer.parseInt(commandsArray[2]),Integer.parseInt(commandsArray[1]));
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
