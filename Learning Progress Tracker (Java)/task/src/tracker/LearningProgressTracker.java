package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearningProgressTracker {
    private static List<Student> studentList = new ArrayList<>();
    static final List<String> options = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    static {
        options.add("Exit");
    }

    public static void run(){
//        CommandLineMenu.showMenu();
        processOption();
    }

//    static void showMenu(){
//        for (int i = 0; i <= options.size()-1; i++) {
//            System.out.println("Menu");
//            System.out.println((i+1) + ". " + options.get(i));
//
//        }
//    }

    static void processOption() {
        while (true) {
            String option = SCANNER.nextLine().trim();
            if (option.isEmpty()) {
                System.out.println("No input.");
            } else {
                switch (option.toLowerCase()) {
                    case "back" -> {
                        System.out.println("Enter 'exit' to exit the program.");
                    }
                    case "add students" ->{
                         Student.addStudents(studentList);
                    }
                    case "exit" -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Unknown command!");

                }
            }
        }
    }


}
