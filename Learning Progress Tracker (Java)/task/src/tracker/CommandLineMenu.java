package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandLineMenu {
    static final List<String> options = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    static {
        options.add("Exit");
    }

//    static void showMenu(){
//        for (int i = 0; i <= options.size(); i++) {
//            System.out.println(options.get(i));
//        }
//    }

    static void processOption() {
        while (true) {
            String option = SCANNER.nextLine().trim();
            if (option.isEmpty()) {
                System.out.println("No input.");
            } else {
                switch (option.toLowerCase()) {
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
