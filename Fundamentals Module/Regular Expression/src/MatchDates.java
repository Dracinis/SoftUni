import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="\\b(?<day>\\d{2})([/.-])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        String text =scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(text);

        while (mather.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",mather.group("day"), mather.group("month"), mather.group("year"));
        }
    }
}
