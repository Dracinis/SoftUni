import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyUser = new TreeMap<>();

        String input;

        while (!"End".equals(input = scanner.nextLine())){
            String[] data = input.split("\\s+->\\s+");
            String user = data[0];
            String employeeId = data[1];

            List<String> currentRegisteredUsers = companyUser.get(user);
            if (currentRegisteredUsers == null){
                currentRegisteredUsers = new ArrayList<>();
                companyUser.put(user, currentRegisteredUsers);
                currentRegisteredUsers.add(employeeId);
            }
            if (!currentRegisteredUsers.contains(employeeId)){
                currentRegisteredUsers.add(employeeId);
            }
        }
        companyUser.entrySet().stream().forEach(entry ->{
            System.out.printf("%s%n",entry.getKey());
            entry.getValue().stream().forEach(e-> System.out.printf("-- %s%n",e));
        });
     }
}

