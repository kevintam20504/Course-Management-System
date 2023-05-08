package coursemanagementsystem;

import java.util.Scanner;

public class UserInputManager {

    public static int mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         ---------------------------------------------
                         Welcome to Course Management System for Vanier
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]Login
                         [2]Quit
                         ---------------------------------------------
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static Account login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         ---------------------------------------------
                         Select one of the following options.
                         ---------------------------------------------
                         [1]Student
                         [2]Instructor
                         [3]Admin
                         [4]Back
                         ---------------------------------------------
                         """);
        int userOption = sc.nextInt();

        while (userOption < 1 || userOption > 4) {
            System.out.println("Invalid input. Please try again.");
            userOption = sc.nextInt();
        }

        if (userOption == 4) {
            System.out.println("Returning to main menu.");
            return null;
        }

        System.out.println("Enter your ID:");
        int id = sc.nextInt();
        System.out.println("Enter password");
        String password = sc.next();

        switch (userOption) {
            case 1:
                if (Student.getDatabase().containsKey(id) && Student.getDatabase().get(id).equals(password)) {
                    return Student.getStudents().get(id);
                }
                break;

            case 2:
                if (Instructor.getDatabase().containsKey(id) && Instructor.getDatabase().get(id).equals(password)) {
                    return Instructor.getTeachers().get(id);
                }
                break;

            case 3:
                if (Admin.getDatabase().containsKey(id) && Admin.getDatabase().get(id).equals(password)) {
                    return Admin.getAdmin().get(id);
                }
                break;

            default:
                break;
        }
        System.out.println("Wrong id or password. Please try again.");
        // call login() again if user enters wrong combination
        return login();
    }

    public static void displayActions(Account accountType) {
        if (accountType != null) {
            if (accountType.getClass() == Student.class) {
                studentMenu();
            } else if (accountType.getClass() == Instructor.class) {
                instructorMenu();
            } else if (accountType.getClass() == Admin.class) {
                adminMenu();
            }
        }
    }

    public static int adminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Admin Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]Add Account
                         [2]Delete Account
                         [3]Add Course
                         [4]Delete Course
                         [5]View Students
                         [6]View Instructors
                         [7]View Courses
                         [8]Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static int studentMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Student Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]View Courses
                         [2]View Grades
                         [3]View Class Feedback
                         [4]View Individual Feedback
                         [5]Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static int instructorMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Instructor Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]View Courses
                         [2]Submit Grades
                         [3]View Students
                         [4]Submit Class Feedback
                         [5]Submit Individual Feedback
                         [6]Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

}
