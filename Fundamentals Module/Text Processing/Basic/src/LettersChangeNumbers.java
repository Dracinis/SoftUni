
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words =input.split("\\s+");
        double totalSum = 0;
        for (String word : words) {

            double sumOfWords = getWordSum(word);
            totalSum +=sumOfWords;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getWordSum(String word) {
        char firstLetter = word.charAt(0);
        char secondLetter = word.charAt(word.length()-1);
        double number = Double.parseDouble(word.substring(1, word.length()-1));

        if (Character.isUpperCase(firstLetter)){
            number = number / (firstLetter-64);
        } else {
            number = number * (firstLetter - 96);
        }

        if (Character.isUpperCase(secondLetter)){
            number = number - (secondLetter-64);
        } else {
            number = number + (secondLetter - 96);
        }
        return number;
    }

}
