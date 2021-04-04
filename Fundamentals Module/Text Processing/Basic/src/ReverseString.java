import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while (!"end".equals(text)){
            StringBuilder reversedText = new StringBuilder();
            for (int i = text.length() - 1; i >= 0 ; i--) {
                reversedText.append(text.charAt(i));
            }
            System.out.printf("%s = %s%n",text, reversedText.toString());
            text = scanner.nextLine();
        }
    }
}
