import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        List<Character> field = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            field.add(currentChar);

            if (currentChar == '>'){
                i++;
                int bomb = text.charAt(i) -'0';

                int j = i;
                for (; j < i + bomb && j < text.length(); j++) {
                    if (text.charAt(j) == '>') {
                        field.add('>');
                        j++;
                        bomb += (text.charAt(j) - '0') + 1;
                    }
                }

                i = j - 1;
            }
        }

        for (int i = 0; i < field.size() ; i++) {
            System.out.print(field.get(i));
        }
    }
}