import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        for (String in : input) {
            if (isValidUsername(in)){
                System.out.println(in);
            }
        }


    }
    static boolean isValidUsername (String username){
        if (username.length() < 3 || username.length() > 16){
            return  false;
        }
        for (int index = 0; index <= username.length() - 1 ; index++) {
            char currentSymbol = username.charAt(index);
            if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '_' && currentSymbol != '-'){
                return  false;
            }
        }
        return true;
    }
}
