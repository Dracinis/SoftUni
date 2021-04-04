import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int size = Math.min(listOne.size(), listTwo.size());
        for (int i = 0; i < size; i++) {
            System.out.print(listOne.get(i)+ " "+ listTwo.get(i) + " ");
        }
        printTheRest(listOne, size);
        printTheRest(listTwo, size);
    }
    private  static void  printTheRest(List<Integer> numbers, int beginIndex){
        for (int i = beginIndex; i < numbers.size(); i++) {
            System.out.print(numbers.get(i)+ " ");
        }
    }
}
