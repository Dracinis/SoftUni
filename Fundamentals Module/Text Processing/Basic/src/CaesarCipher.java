import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        StringBuilder encryptedSentence = new StringBuilder();

        for (int i = 0; i < sentence.length() ; i++) {
            char currentSymbol = sentence.charAt(i);
            encryptedSentence.append((char)(currentSymbol + 3));
        }
        System.out.println(encryptedSentence.toString());

    }
}
