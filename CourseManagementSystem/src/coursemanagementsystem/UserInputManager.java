package coursemanagementsystem;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInputManager {

    public static int mainMenu() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value between 1 - 3.");
            return mainMenu();
        }

    }

    public static Account login() {
        try {
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

            System.out.println("Enter your ID (Enter \"-1\" to go back to main menu):");
            int id = sc.nextInt();
            if (id == -1) {
                System.out.println("Going back to main menu.");
                return null;
            }
            try {
                System.out.println("Enter password");
                password = sc.next();
                if (Student.getDatabase().get(id) == null && Instructor.getDatabase().get(id) == null && Admin.getDatabase().get(id) == null) {
                    throw new NullPointerException();
                }

            } catch (NullPointerException e) {
                if (Student.getStudents().get(id) == null && Instructor.getTeachers().get(id) == null) {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            return login();
        }
    }

    public static int adminMenu() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value between 1 - 9. ");
            return adminMenu();
        }
    }

    public static int studentMenu() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value between 1 - 5.");
            return studentMenu();
        }
    }

    public static int instructorMenu() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value between 1 - 6.");
            return instructorMenu();
        }
    }

    public static String enterFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message do you want to send: ");
        String message = "[" + Time.getTime() + "]: " + sc.nextLine();
        return message;
    }

    public static void deleteAccount() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            deleteAccount();
        }
    }

    public static void newAccount() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first name (Enter \"-1\" to go back to main menu): ");
            String fname = sc.next();
            if (fname.equals("-1")) {
                System.out.println("Going back to main menu.");
                return;
            }
            System.out.println("Enter last name (Enter \"-1\" to go back to main menu): ");
            String lname = sc.next();
            if (lname.equals("-1")) {
                System.out.println("Going back to main menu.");
                return;
            }
            
            System.out.println("Is this person:\n1. A student\n2. An instructor\n\n(\"-1\" to go back to main menu)\nEnter: ");
            int choice = sc.nextInt();
            if (choice == -1) {
                System.out.println("Going back to main menu.");
                return;
            }
            while (choice != 1 && choice != 2) {
                System.out.println("Invalid, try again (Enter \"-1\" to go back to main menu): ");
                choice = sc.nextInt();
                if (choice == -1) {
                    System.out.println("Going back to main menu.");
                    return;
                }
            }
            // if account is student
            if (choice == 1) {
                Student newStudent = new Student(fname, lname, null);
                int newId = newStudent.getId();
                Student.getDatabase().put(newId, null);
                Student.getStudents().put(newId, newStudent);
                System.out.println("Added new student: " + newStudent);
            } //if account is instructor
            else {
                Instructor newInstructor = new Instructor(fname, lname, null);
                int newId = newInstructor.getId();
                Instructor.getDatabase().put(newId, null);
                Instructor.getTeachers().put(newId, newInstructor);
                System.out.println("Added new intructor: " + newInstructor);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            newAccount();
        }
    }

    public static void assignCourse() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Who is the Student that needs a class added (enter their ID, or \"-1\" to go back to main menu): ");
            int inputID = sc.nextInt();
            if (inputID == -1) {
                System.out.println("Going back to main menu.");
                return;
            }
            while (!Student.getStudents().containsKey(inputID)) {
                System.out.println("Invalid ID try again (Enter \"-1\" to go back to main menu): ");
                inputID = sc.nextInt();
                if (inputID == -1) {
                    System.out.println("Going back to main menu.");
                    return;
                }
            }
            Student student = Student.getStudents().get(inputID);
            System.out.println("What class does " + student.getFirstName() + " want to add (enter course ID, or \"-1\" to go back to main menu): ");
            int inputCourseID = sc.nextInt();
            if (inputCourseID == -1) {
                System.out.println("Going back to main menu.");
                return;
            }
            while (!Course.getCourses().containsKey(inputCourseID)) {
                System.out.println("Invalid ID try again (Enter \"-1\" to go back to main menu): ");
                inputCourseID = sc.nextInt();
                if (inputCourseID == -1) {
                    System.out.println("Going back to main menu.");
                    return;
                }
            }
            Course course = Course.getCourses().get(inputCourseID);
            if (course.getStudents().contains(student)) {
                System.out.println(student.getFirstName() + " is already in " + course.getName());
            } else if (course.getStudents().size() == Course.getMAX_STUDENTS()) {
                System.out.println(course.getName() + " is already full");
            } else {
                student.getCourses().add(course);
                course.getStudents().add(student);
                course.getGrades().put(student, 0);
                System.out.println(course.getName() + " has been added to " + student.getFirstName() + "'s schedule");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            assignCourse();
        }
    }

    public static void newCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the course you want to add (Enter \"-1\" to go back to main menu): ");
        String newCourseName = sc.nextLine();
        if (newCourseName.equals("-1")) {
            System.out.println("Going back to main menu.");
            return;
        }
        int newCourseId = 0;
        int inputInstructorId = 0;
        try {
            System.out.println("Enter the course ID (Enter \"-1\" to go back to main menu): ");
            newCourseId = sc.nextInt();
            if (newCourseId == -1) {
                System.out.println("Going back to main menu.");
                return;
            }
            while (Course.getCourses().containsKey(newCourseId)) {
                System.out.println("That class already exists, try again (Enter \"-1\" to go back to main menu): ");
                newCourseId = sc.nextInt();
                if (newCourseId == -1) {
                    System.out.println("Going back to main menu.");
                    return;
                }
            }

            System.out.println("Who will teach this class (enter the instructor's id, or \"-1\" to go back to main menu): ");
            inputInstructorId = sc.nextInt();
            if (inputInstructorId == -1) {
                System.out.println("Going back to main menu.");
                return;
            }
            while (!Instructor.getTeachers().containsKey(inputInstructorId)) {
                System.out.println("That instructor ID doesn't exist, try again (Enter \"-1\" to go back to main menu): ");
                inputInstructorId = sc.nextInt();
                if (inputInstructorId == -1) {
                    System.out.println("Going back to main menu.");
                    return;
                }
            }
            Instructor instructor = Instructor.getTeachers().get(inputInstructorId);
            Course newCourse = new Course(newCourseId, newCourseName, instructor);
            System.out.println("Course: [" + newCourse.getCourseId() + "] " + newCourse.getName() + " has been created");

        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            newCourse();
        }

    }

    public static void deleteCourse() {
        try {
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
                //remove course
                Course.getCourses().remove(inputCourseId);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer value.");
            deleteCourse();
        }

    }

    //for viewCourses(), viewStudents(), viewGrades(), etc
    public static String goBack_Sort_orPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           ----------------------------------------------------
                           Enter "b" to go back, enter "s" to sort, or enter "p" to print the page: 
                           """);
        String choice = sc.next();
        String back = "b";
        String print = "p";
        String sort = "s";
        while (!choice.equalsIgnoreCase(back) && !choice.equalsIgnoreCase(sort) && !choice.equalsIgnoreCase(print)) {
            System.out.println("Invalid, enter \"b\" to go back, or enter \"s\" to sort, or enter \"p\" to print the page: ");
            choice = sc.next();
        }
        if (choice.equalsIgnoreCase(back)) {
            return "b";
        } else if (choice.equalsIgnoreCase(print)) {
            return "p";
        } else {
            return "s";
        }

    }

    //for viewFeedback() and viewClassFeedback() since they don't need sorting
    public static boolean goBack_orPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           ----------------------------------------------------
                           Enter "b" to go back or enter "p" to print the page: 
                           """);
        String choice = sc.next();
        String back = "b";
        String print = "p";
        while (!choice.equalsIgnoreCase(back) && !choice.equalsIgnoreCase(print)) {
            System.out.println("Invalid, enter \"b\" to go back or enter \"p\" to print the page: ");
            choice = sc.next();
        }
        if (choice.equalsIgnoreCase(back)) {
            return true;
        } else {
            return false;
        }

    }

    public static void newPassword() {
        boolean exit;
        int inputId;
        Scanner sc;
        while (true) {
            try {
                sc = new Scanner(System.in);
                exit = false;
                System.out.println("Enter your ID (Enter \"-1\" to go back to main menu): ");
                inputId = sc.nextInt();
                if (inputId == -1) {
                    return;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer value.");
            }
        }

        while (!Student.getDatabase().keySet().contains(inputId) && !Instructor.getDatabase().keySet().contains(inputId)) {
            System.out.println("That ID does not exist, try again (Enter \"-1\" to go back to main menu): ");
            inputId = sc.nextInt();
            if (inputId == -1) {
                System.out.println("Going back to main menu.");
                return;

            }
        }
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
            System.out.println("Account has been initialized");
            if (Student.getDatabase().keySet().contains(inputId)) {
                Student.getDatabase().put(inputId, newPassword);
                Student.getStudents().get(inputId).setPassword(newPassword);
            } else {
                Instructor.getDatabase().put(inputId, newPassword);
                Instructor.getTeachers().get(inputId).setPassword(newPassword);
            }
        }
        System.out.println("Going back to main menu.");
    }

    public static Course getCourse() {
        Scanner sc;
        int inputId;

        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the id of the course you want to find (Enter \"-1\" to go back to main menu): ");
                inputId = sc.nextInt();
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer value.");
            }
        }

        return Course.getCourses().get(inputId);

    }

    public static Student getStudent() {
        Scanner sc;
        int inputId;

        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the id of the student you want to find (Enter \"-1\" to go back to main menu): ");
                inputId = sc.nextInt();
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer value.");
            }
        }

        return Student.getStudents().get(inputId);
    }

    public static int getGrade() {
        Scanner sc;
        int grade;
        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the grade you wish to assign the student (Enter \"-1\" to go back to main menu):");
                grade = sc.nextInt();
                while (grade < -1 || grade > 100) {
                    System.out.println("Please enter a number between 0 and 100 (Enter \"-1\" to go back to main menu):");
                    grade = sc.nextInt();
                }
                if (grade == -1) {
                    System.out.println("Going back to main menu.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer value");
            }
        }

        return grade;
    }

    public static void sortCourses(List<Course> courses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           How do you want to sort the page?
                           [1]  Alphabetically
                           [2]  Reverse Alphabetically
                           
                           [3]  Average (Ascending)
                           [4]  Average (Descending)
                           
                           [5]  Teacher's last name (Alphabetically)
                           [6]  Teacher's last name (Reverse Alphabetically)
                           
                           [7]  Amount of Students (Ascending)
                           [8]  Amount of Students (Descending)
                           
                           [9]  Back
                           """);

        boolean exit = false;
        while (!exit) {
            String choice = sc.next();
            switch (choice) {
                case "1": //alphabetically
                    Collections.sort(courses, ((c1, c2) -> c1.getName().compareTo(c2.getName())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "2": //reverse alphabetically
                    Collections.sort(courses, ((c1, c2) -> c2.getName().compareTo(c1.getName())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "3": //average ascending
                    Collections.sort(courses, (c1, c2) -> (Double.compare(c1.getAverage(), c2.getAverage())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "4": //average descending
                    Collections.sort(courses, (c1, c2) -> (Double.compare(c2.getAverage(), c1.getAverage())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "5": //Teacher lname alphabetically
                    Collections.sort(courses, ((c1, c2) -> c1.getTeacher().getLastName().compareTo(c2.getTeacher().getLastName())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "6": //Teacher lname reverse alphabetically
                    Collections.sort(courses, ((c1, c2) -> c2.getTeacher().getLastName().compareTo(c1.getTeacher().getLastName())));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "7": //amount of students ascending
                    Collections.sort(courses, ((c1, c2) -> c1.getStudents().size() - c2.getStudents().size()));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "8": //amount of students descending
                    Collections.sort(courses, ((c1, c2) -> c2.getStudents().size() - c1.getStudents().size()));
                    System.out.println("All courses taught: ");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    exit = true;
                    break;
                case "9":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Enter an integer value between 1-9.");
                    break;
            }
        }
    }

    public static void sortStudents(List<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           How do you want to sort the page?
                           
                           [1]  Student's last name (Alphabetically)
                           [2]  Student's last name (Reverse Alphabetically)
                           
                           [3]  Back
                           """);

        boolean exit = false;
        while (!exit) {
            String choice = sc.next();
            switch (choice) {
                case "1": //last name alphabetiaclly
                    Collections.sort(students, ((s1, s2) -> s1.getLastName().compareTo(s2.getLastName())));
                    System.out.println("All students:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    exit = true;
                    break;
                case "2": //last name reverese alphabetically
                    Collections.sort(students, ((s1, s2) -> s2.getLastName().compareTo(s1.getLastName())));
                    System.out.println("All students:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    exit = true;
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Enter an integer value between 1-3.");
                    break;
            }
        }

    }

    public static void sortInstructors(List<Instructor> teachers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           How do you want to sort the page (Enter "-1" to go back to main menu)?
                           
                           [1]  Instructor's last name (Alphabetically)
                           [2]  Instructor's last name (Reverse Alphabetically)
                           
                           [3]  Back
                           """);

        boolean exit = false;
        while (!exit) {
            String choice = sc.next();
            switch (choice) {
                case "1": //last name alphabetiaclly
                    Collections.sort(teachers, ((s1, s2) -> s1.getLastName().compareTo(s2.getLastName())));
                    System.out.println("All students:");
                    for (Instructor i : teachers) {
                        System.out.println(i);
                    }
                    exit = true;
                    break;
                case "2": //last name reverese alphabetically
                    Collections.sort(teachers, ((s1, s2) -> s2.getLastName().compareTo(s1.getLastName())));
                    System.out.println("All students:");
                    for (Instructor i : teachers) {
                        System.out.println(i);
                    }
                    exit = true;
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Enter an integer value between 1-3.");
                    break;
            }
        }
    }

    public static void sortGrades(List<Course> courses, Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           How do you want to sort the page (Enter "-1" to go back to main menu)?
                           
                           [1]  Grades (Ascending)
                           [2]  Grades (Descending)
                           
                           [3]  Average (Ascending)
                           [4]  Average (Descending)
                           
                           [5]  Back
                           """);

        boolean exit = false;
        while (!exit) {
            String choice = sc.next();
            switch (choice) {
                case "1": //grades ascending
                    Collections.sort(courses, ((c1, c2) -> c1.getGrades().get(student) - c2.getGrades().get(student)));
                    System.out.println("Grades:");
                    for (Course c : courses) {
                        System.out.println(c.getName() + ": " + c.getGrades().get(student) + "%, Average: " + c.getAverage() + "%");
                    }
                    exit = true;
                    break;
                case "2": //grades descending

                    Collections.sort(courses, ((c1, c2) -> c2.getGrades().get(student) - c1.getGrades().get(student)));
                    System.out.println("Grades:");
                    for (Course c : courses) {
                        System.out.println(c.getName() + ": " + c.getGrades().get(student) + "%, Average: " + c.getAverage() + "%");
                    }
                    exit = true;
                    break;
                case "3": //average ascending
                    Collections.sort(courses, ((c1, c2) -> Double.compare(c1.getAverage(), c2.getAverage())));
                    System.out.println("Grades:");
                    for (Course c : courses) {
                        System.out.println(c.getName() + ": " + c.getGrades().get(student) + "%, Average: " + c.getAverage() + "%");
                    }
                    exit = true;
                    break;
                case "4": //average descending
                    Collections.sort(courses, ((c1, c2) -> Double.compare(c2.getAverage(), c1.getAverage())));
                    System.out.println("Grades:");
                    for (Course c : courses) {
                        System.out.println(c.getName() + ": " + c.getGrades().get(student) + "%, Average: " + c.getAverage() + "%");
                    }
                    exit = true;
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Enter an integer value between 1-9.");
                    break;
            }
        }
    }
}
