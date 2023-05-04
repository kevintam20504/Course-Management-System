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

    public static Object login() {
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

        while (userOption < 1  || userOption > 4) {
            System.out.println("Invalid input. Please try again.");
            userOption = sc.nextInt();
        }

        if (userOption == 4) {
            System.out.println("Returning to main menu.");
            return false;
        }

        System.out.println("Enter your ID:");
        int id = sc.nextInt();
        System.out.println("Enter password");
        String password = sc.next();

        switch (userOption) {
            case 1:
                if (Student.database.containsKey(id) && Student.database.get(id).equals(password)) {
                    return Student.students.get(id);
                }
                break;

            case 2:
                if (Instructor.database.containsKey(id) && Instructor.database.get(id).equals(password)) {
                    return Instructor.teachers.get(id);
                }
                break;

            case 3:
                if (Admin.database.containsKey(id) && Admin.database.get(id).equals(password)) {
                    return Admin.admin.get(id);
                }
                break;

            default:
                break;
        }
        System.out.println("Wrong id or password. Please try again.");
        // call login() again if user enters wrong combination
        return login();
    }

    public static void displayActions(Object accountType) {
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
                         Admin Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]admin
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static int studentMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Student Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]student
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static int instructorMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Instructor Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]instructor
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

}
