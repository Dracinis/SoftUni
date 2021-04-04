import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Map<Double, Integer> numbers= new TreeMap<>();

        double[] nums = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();

        for (double number : nums) {
            if (!numbers.containsKey(number)){
                numbers.put(number, 1);
            } else {
                int occurrences = numbers.get(number);
                occurrences++;
                numbers.put(number, occurrences);
            }
        }
        DecimalFormat df = new DecimalFormat("#.#######");
         for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
