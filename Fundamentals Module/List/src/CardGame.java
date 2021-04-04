import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> playerOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
         List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (playerOne.size()>0 && playerTwo.size()>0){

            if (playerOne.get(0)>playerTwo.get(0)){
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));

                playerTwo.remove(0);
                playerOne.remove(0);
            } else if (playerOne.get(0)<playerTwo.get(0)){
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));

                playerTwo.remove(0);
                playerOne.remove(0);

            } else if (playerTwo.get(0).equals(playerOne.get(0))){
                playerOne.remove(0);
                playerTwo.remove(0);
            }
        }
        if (!playerOne.isEmpty()){
            int sum = playerOne.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("First player wins! Sum: %d",sum);
        } else if (!playerTwo.isEmpty()){
            int sum = playerTwo.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Second player wins! Sum: %d",sum);
        }
    }
}
