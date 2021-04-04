import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String bannedWord : input) {
            text = text.replace(bannedWord, repeat("*", bannedWord.length()));
        }
        System.out.println(text);
    }
    private static String repeat (String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }
}
