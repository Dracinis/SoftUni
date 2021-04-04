import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


         int sum = 0;

         while (!numbers.isEmpty()){
             int command = Integer.parseInt(scanner.nextLine());
             int indexToRemove = 0;

             if (command < 0) {
                 indexToRemove = numbers.remove(0);
                 sum += indexToRemove;
                 numbers.add(0, numbers.get(numbers.size() - 1));

             } else if (command > numbers.size() - 1 ){
                 indexToRemove = numbers.remove(numbers.size() - 1);
                 numbers.add(numbers.get(0));
                 sum += indexToRemove;

             } else {
                 indexToRemove = numbers.remove(command);
                 sum += indexToRemove;
             }

             for (int i = 0; i < numbers.size(); i++) {
                 if (numbers.get(i) <= indexToRemove) {
                     numbers.set(i, numbers.get(i) + indexToRemove);
                 } else {
                     numbers.set(i, numbers.get(i) - indexToRemove);
                 }
             }
         }

        System.out.println(sum);
    }
}