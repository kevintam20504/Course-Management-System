package coursemanagementsystem;

public class Driver {

    public static void main(String[] args) {
        Student s1 = new Student(1, "password1", "fName", "lName");
        Student s2 = new Student(2, "password2", "fName", "lName");
        Student s3 = new Student(3, "password3", "fName", "lName");

        boolean exitCondition = false;

        while (!exitCondition) {
            switch (UserInputManager.mainMenu()) {
                case 1:
                    Account account = UserInputManager.login();
                    UserInputManager.displayActions(account);
                    break;

                case 2:
                    System.out.println("See you again!");
                    exitCondition = true;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

    }
}
