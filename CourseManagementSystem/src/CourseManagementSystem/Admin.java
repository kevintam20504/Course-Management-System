
import java.util.HashSet;
import java.util.Scanner;

public class Admin extends Account {

    Scanner input = new Scanner(System.in);
    //Hashset containing all admin IDs
    static HashSet<Integer> allAdmins = new HashSet<>();
    static Admin adm = new Admin();

    public Admin() {
        firstName = null;
        lastName = null;
        id = 0;
        password = null;
    }

    @Override
    public void displayActions() {
        printSeperation();
        System.out.println("1. View all Courses\n2. Delete Course\n3. Create new Account\n4. Delete an Account\n5. Logout");
        System.out.println("Please enter your choice: ");
        int choice = input.nextInt();
        //keep prompting user if they make an invalid choice
        while (choice < 1 || choice > 7) {
            System.out.println("Invalid choice, try again: ");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1:
                viewCourses();
                break;
            case 2:
                deleteCourse();
                break;
            case 3:
                createAccount();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                Driver.logout();
        }

    }

    @Override
    public void viewCourses() {

    }

    public static void createAccount() {
        Scanner input = new Scanner(System.in);
        printSeperation();
        System.out.println("Enter first name: ");
        String fname = input.next();
        System.out.println("Enter last name: ");
        String lname = input.next();
        System.out.println("Enter new ID: ");
        int newId = input.nextInt();
        System.out.println("Enter password: ");
        String newPass = input.next();
        System.out.println("Is this person:\n1. A student\n2. An instructor\n3. An admin\nEnter: ");
        int choice = input.nextInt();
        if (choice == 1) {
        } else if (choice == 2) {
        } else if (choice == 3) {
            allAdmins.add(newId);
            Account.database.put(newId, newPass);
        }
        System.out.println("Account created!");
        adm.displayActions();
    }

    public static void deleteAccount() {

    }

    public static void createCourse() {

    }

    public static void deleteCourse() {

    }

}
