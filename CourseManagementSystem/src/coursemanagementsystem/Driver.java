package coursemanagementsystem;

public class Driver {

    public static void main(String[] args) {
        System.out.println(Admin.getAdmin().get(9999));
        Student s1 = new Student("Student", "1", 1, "password1");
        Student s2 = new Student("Student", "2", 2, "password2");
        Student s3 = new Student("Student", "3", 3, "password3");
        Student s4 = new Student("Student", "4", 4, "password4");
        Instructor i1 = new Instructor("Teacher", "1", 4, "pass");
        Admin adm = new Admin(9999, "pw");
        Course calculus = new Course(102, "Calculus I", i1);
        
//        Student.getStudents().put(s1.getId(), s1);
//        Student.getStudents().put(s2.getId(), s2);
//        Student.getStudents().put(s3.getId(), s3);
//        Student.getStudents().put(s4.getId(), s4);
//        Instructor.getTeachers().put(i1.getId(), i1);
//
//        adding calculus to s1 and s2 Courses list
//        s1.getCourses().add(calculus);
//        s2.getCourses().add(calculus);
        
        //adding grades to check class average
        calculus.getGrades().put(s1, 60);
        calculus.getGrades().put(s2, 80);

        boolean exitCondition = false;

        while (!exitCondition) {
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
        }

    }
}
