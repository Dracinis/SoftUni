import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String commands = scanner.nextLine();
        while (!commands.equals("Generate")){
            String[] token = commands.split(">>>");
            String command = token[0];
            switch (command){
                case "Contains":
                    String substring = token[1];
                    if (text.contains(substring)){
                        System.out.printf("%s contains %s%n", text, substring);
                    } else {
                        System.out.printf("Substring not found!%n");
                    }
                    break;
                case "Flip":
                    String state = token[1];
                    int startIndex = Integer.parseInt(token[2]);
                    int endIndex = Integer.parseInt(token[3]);
                    StringBuilder temp = new StringBuilder();
                    String toChange = text.substring(startIndex, endIndex);
                    if (state.equals("Upper")){
                        toChange=toChange.toUpperCase();
                        temp.append(text);
                        temp.replace(startIndex,endIndex,toChange);
                        text = temp.toString();
                    }else if (state.equals("Lower")){
                        toChange=toChange.toLowerCase();
                        temp.append(text);
                        temp.replace(startIndex,endIndex,toChange);
                        text = temp.toString();
                    }
                    System.out.println(text);
                    break;
                case "Slice":
                    int startIn = Integer.parseInt(token[1]);
                    int endIn = Integer.parseInt(token[2]);
                    StringBuilder delete = new StringBuilder();

                    delete.append(text);
                    delete.replace(startIn,endIn,"");
                    text = delete.toString();
                    System.out.println(text);
                    break;
                default:
                throw new IllegalStateException("wrong input!!!");
            }

            commands = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", text);
    }
}
