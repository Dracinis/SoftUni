import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="(?<emoji>([:]{2}|[*]{2})[A-Z][a-z]{2,}\\2)";
        String regexDigit ="\\d";
        String text =scanner.nextLine();

        List<String> emojis = new ArrayList<>();
        List<String> emojisAll = new ArrayList<>();
        int coolness = 1;
        String currentEmoji;
        int coolnessCheck;

        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(text);

        Pattern patternDigit = Pattern.compile(regexDigit);
        Matcher matherDigit = patternDigit.matcher(text);

        while (matherDigit.find()){
            coolness *= Integer.parseInt(matherDigit.group());
        }


        while (mather.find()){
            currentEmoji = mather.group("emoji");
            coolnessCheck = 0;
            for (int i = 2; i < currentEmoji.length()-2; i++) {
                char sign = currentEmoji.charAt(i);
                coolnessCheck += (int) sign;
            }
            if (coolnessCheck > coolness){
                emojis.add(mather.group());
            }
            emojisAll.add(mather.group());
        }
        System.out.printf("Cool threshold: %d%n", coolness);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisAll.size());
        for (String emoji : emojis) {
            System.out.printf("%s%n",emoji);
        }
    }
}
