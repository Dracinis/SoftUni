import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            String repeatedWord = repeat(input[i], input[i].length());
            System.out.print(repeatedWord);
        }
    }
    private static String repeat (String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
           repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }
}
