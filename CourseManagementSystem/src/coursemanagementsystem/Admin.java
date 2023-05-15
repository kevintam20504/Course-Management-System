package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin extends Account {

    private static HashMap<Integer, String> database = new HashMap<>();
    private static HashMap<Integer, Admin> admin = new HashMap<>();

    public Admin(int id, String password) {
        super(id, password);
        firstName = "Admin";
        lastName = " ";
        Admin.database.put(id, password);
        Admin.admin.put(id, this);
    }

    public static HashMap<Integer, String> getDatabase() {
        return database;
    }

    public static void setDatabase(HashMap<Integer, String> database) {
        Admin.database = database;
    }

    public static HashMap<Integer, Admin> getAdmin() {
        return admin;
    }

    public static void setAdmin(HashMap<Integer, Admin> admin) {
        Admin.admin = admin;
    }

    public static void viewStudents() {
        System.out.println("All Students at Vanier: ");
        ArrayList<Student> list = new ArrayList<>(Student.getStudents().values());
        for (Student s : list) {
            System.out.println(s);
        }

        while (true) {
            String choice = UserInputManager.goBack_Sort_orPrint();
            if (choice.equals("s")) {
                UserInputManager.sortStudents(list);
            } else if (choice.equals("p")) {
                PrintList.printTxt("All Students at Vanier", list);
            } else {
                break;
            }
        }
    }

    public static void viewInstructors() {
        System.out.println("All Teachers at Vanier: ");
        ArrayList<Instructor> list = new ArrayList<>(Instructor.getTeachers().values());
        for (Instructor i : Instructor.getTeachers().values()) {
            System.out.println(i);
        }

        while (true) {
            String choice = UserInputManager.goBack_Sort_orPrint();
            if (choice.equals("s")) {
                UserInputManager.sortInstructors(list);
            } else if (choice.equals("p")) {
                PrintList.printTxt("All Teachers at Vanier", list);
            } else {
                break;
            }
        }
    }

    public static void viewCourses() {
        System.out.println("All available courses at Vanier:\n");
        ArrayList<Course> list = new ArrayList<>(Course.getCourses().values());
        for (Course c : list) {
            System.out.println(c);
        }

        while (true) {
            String choice = UserInputManager.goBack_Sort_orPrint();
            if (choice.equals("s")) {
                UserInputManager.sortCourses(list);
            } else if (choice.equals("p")) {
                PrintList.printTxt("All Courses at Vanier", list);
            } else {
                break;
            }
        }
    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.adminMenu()) {
                case 1://create course
                    UserInputManager.newCourse();
                    break;
                case 2://delete course
                    UserInputManager.deleteCourse();
                    break;
                case 3://create account
                    UserInputManager.newAccount();
                    break;
                case 4://delete account
                    UserInputManager.deleteAccount();
                    break;
                case 5://assign course to student
                    UserInputManager.assignCourse();
                    break;
                case 6://view courses
                    viewCourses();
                    break;
                case 7://view students
                    viewStudents();
                    break;
                case 8://view instructors
                    viewInstructors();
                    break;
                case 9://logout
                    exitCondition = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

    }

}
