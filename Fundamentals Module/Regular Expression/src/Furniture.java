import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="(?<product>[A-Za-z\\s]+)<<(?<price>\\d+(.\\d+)?)!(?<quantity>\\d+)";

        String text =scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        List<String> products = new ArrayList<>();
        double price = 0;

        while (!"Purchase".equals(text)){

            Matcher mather = pattern.matcher(text);
            while (mather.find()) {
                products.add(mather.group("product"));
                price = price + (Double.parseDouble(mather.group("price")) * Double.parseDouble(mather.group("quantity")));
            }
            text= scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.printf("Total money spend: %.2f%n", price);
    }
}
