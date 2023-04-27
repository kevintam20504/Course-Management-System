
import java.util.Scanner;

public class Driver {

    public static void login() {
        Scanner input = new Scanner(System.in);
        int inputID = 0;
        String password = null;

        System.out.println("Enter your ID:");
        inputID = input.nextInt();
        System.out.println("Enter password");
        password = input.next();

        // prompts user until they enter a valid ID and password combination
        while (!Account.database.containsKey(inputID) || !Account.database.containsValue(password) || !Account.database.get(inputID).equals(password)) {
            System.out.println("Incorrect ID or password, try again");
            System.out.println("Enter your ID:");
            inputID = input.nextInt();
            System.out.println("Enter password");
            password = input.next();
        }
        System.out.println("Welcome");
        //checks if the user is an admin, a student or an instructor based on their ID
        if (Admin.allAdmins.contains(inputID)) {
            Admin adm = new Admin();
            adm.displayActions();
        }
        //other else ifs for students and instructors
    }

    public static void logout() {
        System.out.println("Logout successful");
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("-----------------------------------------------------------------\n        Welcome to Course Management System for Vanier\n-----------------------------------------------------------------");
        System.out.println("\n1. Login\n2. Quit\n\nPlease enter your choice:");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid input, please try again: ");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                input.close();
                System.out.println("See you again!");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        //create a main admin account that will exist as soon as program is running
        Account.database.put(9999, "password");
        Admin.allAdmins.add(9999);
        mainMenu();

    }
}
