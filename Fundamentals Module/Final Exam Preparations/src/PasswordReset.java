import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String password = scanner.nextLine();

         String input = scanner.nextLine();
         while (!input.equals("Done")){
             String[] tokens = input.split(" ");

             String command = tokens[0];
             switch (command){
                 case "TakeOdd":
                     StringBuilder temp = new StringBuilder();
                     for (int i = 1; i < password.length(); i++) {
                         temp.append(password.charAt(i));
                         i++;
                     }
                     password = temp.toString();
                     System.out.println(password);
                     break;
                 case  "Cut":
                     int startIndex = Integer.parseInt(tokens[1]);
                     int endIndex = startIndex + Integer.parseInt(tokens[2]);
                     StringBuilder cut =  new StringBuilder();
                     cut.append(password);
                     cut.replace(startIndex, endIndex, "");
                     password = cut.toString();
                     System.out.println(password);
                     break;
                 case "Substitute":
                     String substring = tokens[1];
                     String replacement = tokens[2];
                     String temporary ="";

                     if (password.contains(substring)){
                         temporary = password.replaceAll(substring, replacement);
                         password = temporary;
                         System.out.println(password);
                     } else {
                         System.out.println("Nothing to replace!");
                     }
                     break;
             }
             input = scanner.nextLine();
         }
        System.out.printf("Your password is: %s%n", password);
    }
}
