import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="[@][#+]+[A-Z][A-Za-z0-9]{4,}[A-Z][@][#]+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()){
                String numbers = "";
                for (char c : input.toCharArray()) {
                    if (Character.isDigit(c)){
                        numbers += c;
                    }
                }
                if (!numbers.equals("")){
                    System.out.printf("Product group: %s%n", numbers);
                } else  {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
