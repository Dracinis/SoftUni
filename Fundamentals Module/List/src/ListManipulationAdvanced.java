import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandsArray = command.split(" ");
            String currentCommand = commandsArray[0];

            switch (currentCommand){
                case ("Contains"):
                    if (numbers.contains(Integer.parseInt(commandsArray[1]))){
                        System.out.println("Yes");
                    } else{
                        System.out.println("No such number");
                    }
                    break;
                case ("Print"):
                    if (commandsArray[1].equals("even")){
                        for (Integer number : numbers) {
                            if (number % 2 == 0){
                                 System.out.print(number + " ");
                        }
                    }
                    }else if (commandsArray[1].equals("odd")) {
                        for (Integer number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

                case ("Get"):
                    int sum = numbers.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(sum);
                    break;
                case ("Filter"):
                    String outputFilter = "";
                    int num = Integer.parseInt(commandsArray[2]);
                    if (commandsArray[1].equals("<")){
                        for (Integer number : numbers) {
                            if (number < num){
                                outputFilter += String.valueOf(number) +" ";
                            }
                        }
                    }
                    if (commandsArray[1].equals("<=")){
                        for (Integer number : numbers) {
                            if (number <= num){
                                outputFilter += String.valueOf(number) +" ";
                            }
                        }
                    }
                    if (commandsArray[1].equals(">")){
                        for (Integer number : numbers) {
                            if (number > num){
                                outputFilter += String.valueOf(number) +" ";
                            }
                        }
                    }
                    if (commandsArray[1].equals(">=")){
                        for (Integer number : numbers) {
                            if (number >= num){
                                outputFilter += String.valueOf(number) +" ";
                            }
                        }
                    }
                    System.out.println(outputFilter);
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
