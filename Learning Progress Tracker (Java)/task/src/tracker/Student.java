package tracker;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private String email;

    public Student() {
    }

    private Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static void addStudents(List<Student> studentList) {
        int totalCounter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student credentials or 'back' to return:");
        String input;
        Student tempStudent = new Student();
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]{1,}$"); //"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]{2,}"
        Matcher email_matcher;


        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("back".trim())) {
                System.out.println("Total " + totalCounter + " students have been added.");
                return;
            }
            String[] studentInfo = input.trim().split("\\s+");
            email_matcher = emailPattern.matcher(studentInfo[studentInfo.length - 1]);


            if (studentInfo.length > 2) { //checking for firstName, lastName and email (at least 3 words)
                if (email_matcher.find()) {
                    tempStudent.email = studentInfo[studentInfo.length - 1];
                } else {
                    System.out.println("Incorrect email.");
                    continue;
                }

                if (isFirstValidName(studentInfo[0])) {
                    tempStudent.firstName = studentInfo[0];
                } else {
                    System.out.println("Incorrect first name.");
                    continue;
                }
                String[] lastName = Arrays.copyOfRange(studentInfo, 1, studentInfo.length);
                if (isValidLastName(lastName)) {
                    tempStudent.lastName = input.substring((studentInfo[0].length() + 1), (input.length() - studentInfo[studentInfo.length - 1].length() + 1));
                } else {
                    System.out.println("Incorrect last name.");
                    continue;
                }
                System.out.println("The student has been added.");
                studentList.add(tempStudent);
                totalCounter++;
            } else {
                System.out.println("Incorrect credentials");
            }
        }
    }

    private static boolean isFirstValidName(String name) {
        return name.matches("[A-Za-z]+([ '-][A-Za-z]+)*") && name.length() >= 2;
    }

    private static boolean isValidLastName(String[] lastname) {
        boolean result = true;
        for (int i = 0; i < lastname.length - 1; i++) {
            if (isFirstValidName(lastname[i])) {
                continue;
            } else {
                return false;
            }
        }
        return result;
    }
}
