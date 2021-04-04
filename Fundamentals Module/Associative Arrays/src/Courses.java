import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input;

        while (!"end".equals(input = scanner.nextLine())){
            String[] data = input.split(" : ");
            String courseName = data[0];
            String registeredStudent = data[1];

            List<String> currentRegisteredStudent = courses.get(courseName);
            if (currentRegisteredStudent == null){
                currentRegisteredStudent = new ArrayList<>();
                courses.put(courseName, currentRegisteredStudent);
            }
            currentRegisteredStudent.add(registeredStudent);
        }

       courses.entrySet().stream()
               .sorted((left, right)-> Integer.compare(right.getValue().size(), left.getValue().size()))
               .forEach(entry ->{
                   System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());
                   entry.getValue().stream().sorted(String::compareTo).forEach(e-> System.out.printf("-- %s%n",e));
               });
    }
}
