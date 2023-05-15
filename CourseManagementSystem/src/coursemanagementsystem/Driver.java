package coursemanagementsystem;

public class Driver {

    public static void main(String[] args) {
        Admin adm = new Admin("pw"); //id 0
        
        Student s1 = new Student("Student", "1", "password1"); //id 1
        Student s2 = new Student("Student", "2", "password2"); //id 2
        Student s3 = new Student("Student", "3", "password3"); //id 3
        Student s4 = new Student("Student", "4", "password4"); //id 4
        
        Instructor i1 = new Instructor("Teacher", "1", "pass"); //id 5
        Instructor i2 = new Instructor("Teacher", "2", "pass2"); //id 6
        Instructor i3 = new Instructor("Teacher", "3", "pass3");
        
        Course algebra = new Course(101, "Algebra", i1);
        Course calculus = new Course(102, "Calculus I", i1); 
        Course calculus2 = new Course(103, "Calculus II", i2); 
        Course english = new Course(104, "English", i3);
        Course french = new Course(301, "French", i3);

       s1.getCourses().add(algebra);
        algebra.getStudents().add(s1);
        
        s1.getCourses().add(calculus);
        calculus.getStudents().add(s1);

        s1.getCourses().add(calculus2);
        calculus2.getStudents().add(s1);
        
        s1.getCourses().add(english);
        english.getStudents().add(s1);

        s1.getCourses().add(french);
        french.getStudents().add(s1);

        s2.getCourses().add(algebra);
        algebra.getStudents().add(s2);
        
        s2.getCourses().add(calculus);
        calculus.getStudents().add(s2);

        s2.getCourses().add(calculus2);
        calculus2.getStudents().add(s2);
        
        s2.getCourses().add(english);
        english.getStudents().add(s2);
        
        s3.getCourses().add(algebra);
        algebra.getStudents().add(s3);
        
        s3.getCourses().add(calculus);
        calculus.getStudents().add(s3);
        
        s3.getCourses().add(calculus2);
        calculus2.getStudents().add(s3);
        
        s4.getCourses().add(algebra);
        algebra.getStudents().add(s4);
        
        s4.getCourses().add(calculus);
        calculus.getStudents().add(s4);
        
        
        algebra.getGrades().put(s1, 99);
        algebra.getGrades().put(s2, 64);
        algebra.getGrades().put(s3, 68);
        algebra.getGrades().put(s4, 55);
        
        calculus.getGrades().put(s1, 90);
        calculus.getGrades().put(s2, 80);
        calculus.getGrades().put(s3, 60);
        calculus.getGrades().put(s4, 30);
        
        calculus2.getGrades().put(s1, 34);
        calculus2.getGrades().put(s2, 23);
        calculus2.getGrades().put(s3, 10);
        
        english.getGrades().put(s1, 76);
        english.getGrades().put(s2, 45);
        
        french.getGrades().put(s1, 77);


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
