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
                         [1]  Login
                         [2]  Initialize or Change Password
                         [3]  Quit
                         ---------------------------------------------
                         """);
        int userOption = sc.nextInt();

        return userOption;
    }

    public static Account login() {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.print("""
                         ---------------------------------------------
                         Select one of the following options.
                         ---------------------------------------------
                         [1]  Student
                         [2]  Instructor
                         [3]  Admin
                         [4]  Back
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
        try {
            System.out.println("Enter password");
            password = sc.next();
            if (Student.getDatabase().get(id) == null && Instructor.getDatabase().get(id) == null && Admin.getDatabase().get(id) == null) {
                throw new NullPointerException();
            }

        } catch (NullPointerException e) {
            if (Student.getStudents().get(id) == null) {
                System.out.println("Wrong id or password. Please try again.");
                return login();
            } else {
                System.out.println("You need to initialize your password.");
                return null;
            }
        }

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

    /*
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
     */
    public static int adminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Admin Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]  Create Course
                         [2]  Delete Course
                         [3]  Create new Account
                         [4]  Delete an Account
                         [5]  Assign Course to a Student
                         [6]  View all Courses
                         [7]  View all Students
                         [8]  View all Instructors
                         [9]  Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        while (userOption < 1 || userOption > 9) {
            System.out.println("Invalid choice, try again:");
            userOption = sc.nextInt();
        }
        return userOption;
    }

    public static int studentMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Student Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]  View Courses
                         [2]  View Grades
                         [3]  View Class Feedback
                         [4]  View Individual Feedback
                         [5]  Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        while (userOption < 1 || userOption > 5) {
            System.out.println("Invalid choice, try again:");
            userOption = sc.nextInt();
        }
        return userOption;
    }

    public static int instructorMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Instructor Menu
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]  View Courses
                         [2]  Submit Grades
                         [3]  View Students
                         [4]  Submit Class Feedback
                         [5]  Submit Individual Feedback
                         [6]  Logout
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        while (userOption < 1 || userOption > 6) {
            System.out.println("Invalid choice, try again:");
            userOption = sc.nextInt();
        }
        return userOption;
    }

    public static String enterFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message do you want to send: ");
        String message = "[" + Time.getTime() + "]: " + sc.nextLine();
        return message;
    }

    public static void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the account you want to delete (Enter \"-1\" to go back): ");
        int inputID = sc.nextInt();
        if (Student.getDatabase().containsKey(inputID)) {
            Student.getDatabase().remove(inputID);
            Student.getStudents().remove(inputID);
            System.out.println("Account deleted");
        } else if (Instructor.getDatabase().containsKey(inputID)) {
            Instructor.getDatabase().remove(inputID);
            Instructor.getTeachers().remove(inputID);
            System.out.println("Account deleted");
        } else if (inputID == -1) {
            System.out.println("Going back to main menu.");
        } else {
            System.out.println("Cannot delete this user, try again");
            deleteAccount();
        }
    }

    public static void newAccount() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Enter first name: ");
        String fname = sc.next();
        System.out.println("Enter last name: ");
        String lname = sc.next();
        System.out.println("Enter new ID: ");
        int newId = sc.nextInt();
        while (Student.getDatabase().containsKey(newId) || Instructor.getDatabase().containsKey(newId)) {
            System.out.println("Cannot create this ID, try again (Enter \"-1\" to go back to main menu): ");
            newId = sc.nextInt();
            if (newId == -1) {
                exit = true;
                break;
            }
        }
        if (exit == false) {
            System.out.println("Is this person:\n1. A student\n2. An instructor\nEnter: ");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Invalid, try again (Enter \"-1\" to go back to main menu): ");
                choice = sc.nextInt();
                if (choice == -1) {
                    exit = true;
                    break;
                }
            }
            if (exit == false) {
                // if account is student
                if (choice == 1) {
                    Student newStudent = new Student(fname, lname, newId, null);
                    Student.getDatabase().put(newId, null);
                    Student.getStudents().put(newId, newStudent);
                } //if account is instructor
                else {
                    Instructor newInstructor = new Instructor(fname, lname, newId, null);
                    Instructor.getDatabase().put(newId, null);
                    Instructor.getTeachers().put(newId, newInstructor);
                }
                System.out.println("Account created! User needs to create password");
            } else {
                System.out.println("Going back to main menu.");
            }
        } else {
            System.out.println("Going back to main menu.");
        }
    }

    public static void assignCourse() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Who is the Student that needs a class added (enter their ID): ");
        int inputID = sc.nextInt();
        while (!Student.getStudents().containsKey(inputID)) {
            System.out.println("Invalid ID try again (Enter \"-1\" to go back to main menu): ");
            inputID = sc.nextInt();
            if (inputID == -1) {
                exit = true;
                break;
            }
        }
        if (exit == false) {
            Student student = Student.getStudents().get(inputID);
            System.out.println("What class does " + student.getFirstName() + " want to add (enter course ID): ");
            int inputCourseID = sc.nextInt();
            while (!Course.getCourses().containsKey(inputCourseID)) {
                System.out.println("Invalid ID try again (Enter \"-1\" to go back to main menu): ");
                inputCourseID = sc.nextInt();
                if (inputCourseID == -1) {
                    exit = true;
                    break;
                }
            }
            if (exit == false) {
                Course course = Course.getCourses().get(inputCourseID);
                if (course.getStudents().size() == Course.getMAX_STUDENTS()) {
                    System.out.println(course.getName() + " is already full");
                } else {
                    student.getCourses().add(course);
                    course.getStudents().add(student);
                    System.out.println(course.getName() + " has been added to " + student.getFirstName() + "'s schedule");
                }
            } else {
                System.out.println("Going back to main menu.");
            }
        } else {
            System.out.println("Going back to main menu.");
        }
    }

    public static void newCourse() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("What is the name of the course you want to add: ");
        String newCourseName = sc.nextLine();
        int newCourseId = 0;
        int inputInstructorId = 0;
        try {
            System.out.println("Enter the course ID: ");
            newCourseId = sc.nextInt();
            while (Course.getCourses().containsKey(newCourseId)) {
                System.out.println("That class already exists, try again (Enter \"-1\" to go back to main menu): ");
                newCourseId = sc.nextInt();
                if (newCourseId == -1) {
                    exit = true;
                    break;
                }
            }
            if (exit == false) {

                try {
                    System.out.println("Who will teach this class (enter the instructor's id): ");
                    inputInstructorId = sc.nextInt();
                    while (!Instructor.getTeachers().containsKey(inputInstructorId)) {
                        System.out.println("That instructor ID doesn't exist, try again (Enter \"-1\" to go back to main menu): ");
                        inputInstructorId = sc.nextInt();
                        if (inputInstructorId == -1) {
                            exit = true;
                            break;
                        }
                    }
                    if (exit == false) {
                        Instructor instructor = Instructor.getTeachers().get(inputInstructorId);
                        Course newCourse = new Course(newCourseId, newCourseName, instructor);
                        System.out.println(newCourseName + " has been created");
                    } else {
                        System.out.println("Going back to main menu.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid ID");
                }
            } else {
                System.out.println("Going back to main menu.");
            }

        } catch (Exception e) {
            System.out.println("Invalid course ID");
        }

    }

    public static void deleteCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course ID that you want to delete (Enter \"-1\" to go back to main menu): ");
        int inputCourseId = sc.nextInt();
        while (!Course.getCourses().containsKey(inputCourseId) && inputCourseId != -1) {
            System.out.println("Invalid course ID, try again (Enter \"-1\" to go back to main menu): ");
            inputCourseId = sc.nextInt();
        }
        if (inputCourseId == -1) {
            System.out.println("Going back to main menu.");
        } else {
            System.out.println(Course.getCourses().get(inputCourseId).getName() + " has been deleted");
            //remove courses from student schedules
            Course courseToRemove = Course.getCourses().get(inputCourseId);
            for (Student s : courseToRemove.getStudents()) {
                s.getCourses().remove(courseToRemove);
            }
            //remove from teacher
            courseToRemove.getTeacher().getCourses().remove(courseToRemove);
            Course.getCourses().remove(inputCourseId);
        }

    }

    //for viewCourses(), viewStudents(), viewGrades(), etc
    public static void goBack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           ---------------------------------------------
                           Enter "b" to go back: 
                           """);
        String choice = sc.next();
        String back = "b";
        while (!choice.equalsIgnoreCase(back)) {
            System.out.println("Invalid, enter \"b\" to go back: ");
            choice = sc.next();
        }

    }

    public static void newPassword() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Enter your ID: ");
        int inputId = sc.nextInt();
        while (!Student.getDatabase().keySet().contains(inputId) && !Instructor.getDatabase().keySet().contains(inputId)) {
            System.out.println("That ID does not exist, try again (Enter \"-1\" to go back to main menu): ");
            inputId = sc.nextInt();
            if (inputId == -1) {
                exit = true;
                break;
            }
        }
        if (exit == false) {
            if (Student.getDatabase().get(inputId) != null || Instructor.getDatabase().get(inputId) != null) {

                System.out.println("Update your password: ");
                String newPassword = sc.next();
                System.out.println("Password has been updated");
                if (Student.getDatabase().keySet().contains(inputId)) {
                    Student.getDatabase().put(inputId, newPassword);
                    Student.getStudents().get(inputId).setPassword(newPassword);
                } else {
                    Instructor.getDatabase().put(inputId, newPassword);
                    Instructor.getTeachers().get(inputId).setPassword(newPassword);
                }

            } else {
                System.out.println("Create your password: ");
                String newPassword = sc.next();
                System.out.println("Account has been created");
                if (Student.getDatabase().keySet().contains(inputId)) {
                    Student.getDatabase().put(inputId, newPassword);
                    Student.getStudents().get(inputId).setPassword(newPassword);
                } else {
                    Instructor.getDatabase().put(inputId, newPassword);
                    Instructor.getTeachers().get(inputId).setPassword(newPassword);
                }
            }
            System.out.println("Going back to main menu.");
        } else {
            System.out.println("Going back to main menu.");
        }
    }

    public static Course getCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the course you want to find (Enter \"-1\" to go back to main menu): ");
        int inputId = sc.nextInt();
        if (inputId == -1) {
            System.out.println("Going back to main menu.");
            return null;
        }
        while (!Course.getCourses().containsKey(inputId)) {
            System.out.println("Invalid course ID, try again (Enter \"-1\" to go back to main menu): ");
            inputId = sc.nextInt();
            if (inputId == -1) {
                System.out.println("Going back to main menu.");
                return null;
            }
        }
        return Course.getCourses().get(inputId);

    }

    public static Student getStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the student you want to find (Enter \"-1\" to go back to main menu): ");
        int inputId = sc.nextInt();
        if (inputId == -1) {
            System.out.println("Going back to main menu.");
            return null;
        }
        while (!Student.getStudents().containsKey(inputId)) {
            System.out.println("Invalid student ID, try again (Enter \"-1\" to go back to main menu): ");
            inputId = sc.nextInt();
            if (inputId == -1) {
                System.out.println("Going back to main menu.");
                return null;
            }
        }
        return Student.getStudents().get(inputId);
    }

    public static int getGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the grade you wish to assign the student (Enter \"-1\" to go back to main menu):");
        int grade = sc.nextInt();
        while (grade < -1 || grade > 100) {
            System.out.println("Please enter a number between 0 and 100 (Enter \"-1\" to go back to main menu):");
            grade = sc.nextInt();
        }
        if(grade ==-1)
            System.out.println("Going back to main menu.");
        return grade;
    }

}
