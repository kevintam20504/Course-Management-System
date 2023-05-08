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

        while (userOption != 1 && userOption != 2 && userOption != 3 && userOption != 4) {
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

    public static int displayActions(Account accountType) {
        if (accountType.getClass() == Student.class) {
            return studentMenu();
        } else if (accountType.getClass() == Instructor.class) {
            return instructorMenu();
        } else if (accountType.getClass() == Admin.class) {
            return adminMenu();
        }
        return 0;
    }

    public static int adminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Admin Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]  View all Courses
                         [2]  Create Course
                         [3]  Delete Course
                         [4]  Create new Account
                         [5]  Delete an Account
                         [6]  Assign Course to a Student
                         [7]  View all Students
                         [8]  View all Instructors
                         [9]  Logout
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
    
    public static String enterFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message do you want to send: ");
        String message = sc.next();
        return message;
    }

    public static void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the account you want to delete: ");
        int inputID = sc.nextInt();
        if (Student.getDatabase().containsKey(inputID)) {
            Student.getDatabase().remove(inputID);
            Student.getStudents().remove(inputID);
        } else if (Instructor.getDatabase().containsKey(inputID)) {
            Instructor.getDatabase().remove(inputID);
            Instructor.getTeachers().remove(inputID);
        } else {
            System.out.println("Cannot delete this user, try again");
            deleteAccount();
        }
        System.out.println("Account deleted");
    }

    public static void newAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fname = sc.next();
        System.out.println("Enter last name: ");
        String lname = sc.next();
        System.out.println("Enter new ID: ");
        int newId = sc.nextInt();
        while (Student.getDatabase().containsKey(newId) || Instructor.getDatabase().containsKey(newId)) {
            System.out.println("Cannot create this ID, try again: ");
            newId = sc.nextInt();
        }
        System.out.println("Enter password: ");
        String newPass = sc.next();
        System.out.println("Is this person:\n1. A student\n2. An instructor\nEnter: ");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid, try again: ");
            choice = sc.nextInt();
        }
        // if account is student
        if (choice == 1) {
            Student newStudent = new Student(fname, lname, newId, newPass);
            Student.getDatabase().put(newId, newPass);
            Student.getStudents().put(newId, newStudent);
            System.out.println("Account created!");
        } //if account is instructor
        else {
            Instructor newInstructor = new Instructor(fname, lname, newId, newPass);
            Instructor.getDatabase().put(newId, newPass);
            Instructor.getTeachers().put(newId, newInstructor);
            System.out.println("Account created!");
        }

    }

    public static void assignCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who is the Student that needs a class added (enter their ID): ");
        int inputID = sc.nextInt();
        while (!Student.getStudents().containsKey(inputID)) {
            System.out.println("Invalid ID try again: ");
            inputID = sc.nextInt();
        }
        Student student = Student.getStudents().get(inputID);
        System.out.println("What class does " + student.getFirstName() + " want to add (enter course ID): ");
        int inputCourseID = sc.nextInt();
        while (!Course.getCourses().containsKey(inputCourseID)) {
            System.out.println("Invalid ID try again: ");
            inputCourseID = sc.nextInt();
        }
        Course course = Course.getCourses().get(inputCourseID);
        if (course.getStudents().size() == Course.getMAX_STUDENTS()) {
            System.out.println(course.getName() + " is already full");
        } else {
            System.out.println(course.getName() + " has been added to " + student.getFirstName() + "'s schedule");
        }
    }

    public static void newCourse() { //need to make exception handling better
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the course you want to add: ");
        String newCourseName = sc.nextLine();
        int newCourseId = 0;
        int inputInstructorId = 0;
        try {
            System.out.println("Enter the course ID: ");
            newCourseId = sc.nextInt();
            if (Course.getCourses().containsKey(newCourseId)) {
                throw new ArithmeticException();
            }

            try {
                System.out.println("Who will teach this class (enter the instructor's id): ");
                inputInstructorId = sc.nextInt();
                while (!Instructor.getTeachers().containsKey(inputInstructorId)) {
                    System.out.println("That instructor ID doesn't exist, try again: ");
                    inputInstructorId = sc.nextInt();
                }
                Instructor instructor = Instructor.getTeachers().get(inputInstructorId);
                Course newCourse = new Course(newCourseId, newCourseName, instructor);
                instructor.getCourses().add(newCourse);
                System.out.println(newCourseName + " has been created");

            } catch (Exception e) {
                System.out.println("Invalid ID, try again");
            }

        } catch (Exception e) {
            System.out.println("Invalid course ID");
        }

    }

    public static void deleteCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course ID that you want to delete: ");
        int inputCourseId = sc.nextInt();
        while (!Course.getCourses().containsKey(inputCourseId)) {
            System.out.println("Invalid course ID, try again: ");
            inputCourseId = sc.nextInt();
        }
        System.out.println(Course.getCourses().get(inputCourseId).getName() + " has been deleted");
        Course.getCourses().remove(inputCourseId);

    }

}
