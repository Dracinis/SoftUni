import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String[] path = input[input.length - 1].split("\\.");
        String fileName = path[0];
        String extension = path[1];

        System.out.printf("File name: %s%n",fileName);
        System.out.printf("File extension: %s%n",extension);
    }
}
