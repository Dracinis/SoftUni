import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="\\b[A-Z][a-z]+ [A-Z][a-z]*\\b";
        String text =scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(text);

        while (mather.find()){
            System.out.print(mather.group()+ " ");
        }
    }
}
