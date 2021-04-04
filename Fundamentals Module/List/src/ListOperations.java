import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
                    String[]commandsArray = command.split( " ");
                    String currentCommand = commandsArray[0];

                    switch (currentCommand){
                        case ("Add"):
                            numbers.add(Integer.parseInt(commandsArray[1]));
                            break;
                        case ("Insert"):
                            if (isValidIndex(Integer.parseInt(commandsArray[2]), numbers.size())) {
                                numbers.add(Integer.parseInt(commandsArray[2]), Integer.parseInt(commandsArray[1]));
                            } else{
                                System.out.println("Invalid index");
                            }
                            break;
                        case ("Remove"):
                            if (isValidIndex(Integer.parseInt(commandsArray[1]), numbers.size())) {
                                numbers.remove(Integer.parseInt(commandsArray[1]));
                            } else{
                                System.out.println("Invalid index");
                            }
                            break;
                        case ("Shift"):
                            if (commandsArray[1].equals("left")){
                                for (int i = 0; i < Integer.parseInt(commandsArray[2]); i++) {
                                    int shiftingNumber = numbers.get(0);
                                    numbers.remove(0);
                                    numbers.add(shiftingNumber);
                                }
                            } else {
                                for (int i = 0; i < Integer.parseInt(commandsArray[2]); i++) {
                                    int shiftingNumber = numbers.get(numbers.size()-1);
                                    numbers.remove(numbers.size()-1);
                                    numbers.add(0, shiftingNumber);
                                }
                            }
                            break;
                    }
                    command = scanner.nextLine();
                    }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
    private static boolean isValidIndex(int index, int length){
        return index >=0 && index <= length - 1;
    }
}
