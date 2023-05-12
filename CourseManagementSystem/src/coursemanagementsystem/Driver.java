package coursemanagementsystem;

public class Driver {

    public static void main(String[] args) {
        Student s1 = new Student("Student", "1", 1, "password1");
        Student s2 = new Student("Student", "2", 2, "password2");
        Student s3 = new Student("Student", "3", 3, "password3");
        Student s4 = new Student("Student", "4", 4, "password4");
        Instructor i1 = new Instructor("Teacher", "1", 4, "pass");
        Instructor i2 = new Instructor("Teacher", "1", 5, "pass2");
        Admin adm = new Admin(9999, "pw");
        Course calculus = new Course(102, "Calculus I", i1);
        Course calculus2 = new Course(103, "Calculus II", i2);
        Course english = new Course(104, "English", i1);

        //ading courses to student's course list and adding students to course's student list
        s1.getCourses().add(calculus);
        calculus.getStudents().add(s1);

        s1.getCourses().add(calculus2);
        calculus2.getStudents().add(s1);

        s2.getCourses().add(calculus);
        calculus.getStudents().add(s2);

        s2.getCourses().add(calculus2);
        calculus2.getStudents().add(s2);

        //adding grades to check class average
        calculus.getGrades().put(s1, 60);
        calculus.getGrades().put(s2, 80);

        boolean exitCondition = false;

        while (!exitCondition) {
            try {//try catch only here now for ease of testing in case you type something wrong
                switch (UserInputManager.mainMenu()) {
                    case 1:
                        Account account = UserInputManager.login();
                        if (account == null) {
                            break;
                        } else {
                            System.out.println("\nWelcome " + account.getFirstName() + " " + account.getLastName());
                            account.performAction();
                            break;
                        }

                    case 2:
                        UserInputManager.newPassword();
                        break;
                    case 3:
                        System.out.println("See you again!");
                        exitCondition = true;
                        break;

                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("oops");
            }

        }

    }
}
