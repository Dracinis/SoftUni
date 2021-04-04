import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import static java.util.stream.Collectors.*;

public class SoftuniCoursePlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> schedule = new ArrayList<>();
        Arrays.asList(sc.nextLine().split(", ")).stream().distinct().forEach(schedule::add);

        String command = "";

        while (!"course start".equals(command = sc.nextLine())) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add":
                    if (!schedule.contains(tokens[1])) {
                        schedule.add(tokens[1]);
                    }
                    break;
                case "Insert":
                    if (!schedule.contains(tokens[1])) {
                        int index = Integer.parseInt(tokens[2]);
                        if (index >= 0 && index < schedule.size()) {
                            schedule.add(index, tokens[1]);
                        }

                    }
                    break;
                case "Remove":

                    schedule.remove(tokens[1]);
                    String ex = tokens[1] + "-Exercise";
                    schedule.remove(ex);


                    break;
                case "Swap":
                    String exOne = tokens[1] + "-Exercise";
                    String exTwo = tokens[2] + "-Exercise";

                    if (schedule.contains(tokens[1]) && schedule.contains(tokens[2])) {
                        String firstElement = tokens[1];
                        int firstIndex = schedule.indexOf(tokens[1]);
                        String secondElement = tokens[2];
                        int secondIndex = schedule.indexOf(tokens[2]);
                        schedule.set(firstIndex, secondElement);
                        schedule.set(secondIndex, firstElement);
                        if (schedule.contains(exOne)) {
                            schedule.remove(schedule.indexOf(exOne));
                            schedule.add(schedule.indexOf(tokens[1]) + 1, exOne);
                        }
                        if (schedule.contains(exTwo)) {
                            schedule.remove(schedule.indexOf(exTwo));
                            schedule.add(schedule.indexOf(tokens[2]) + 1, exTwo);
                        }
                    }


                    break;
                case "Exercise":
                    String ex1 = tokens[1] + "-Exercise";
                    if (!schedule.contains(tokens[1])) {
                        schedule.add(tokens[1]);
                        schedule.add(ex1);

                    } else if (schedule.contains(tokens[1]) && !schedule.contains(ex1)) {
                        int index = schedule.indexOf(tokens[1]);
                        schedule.add(index + 1, ex1);
                    }
                    break;
            }
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println((i + 1) + "." + schedule.get(i));
        }
    }
}

