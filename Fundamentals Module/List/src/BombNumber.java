import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
         int[] bombNumber = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();


        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber[0]){
                for (int leftBombing = bombNumber[1]; leftBombing > 0; leftBombing--){
                    if (i - leftBombing >= 0){
                        numbers.remove(i-leftBombing);
                        i--;
                    }
                }
                for (int rightBombing = bombNumber[1]; rightBombing > 0; rightBombing--){
                    if (i+rightBombing < numbers.size()){
                        numbers.remove(i+rightBombing);
                    }
                }
                numbers.remove(i);
                i--;
            }

        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
