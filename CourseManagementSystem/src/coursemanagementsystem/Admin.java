package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Admin extends Account {

    private static HashMap<Integer, String> database = new HashMap<>();
    private static HashMap<Integer, Admin> admin = new HashMap<>();

    public Admin(int id, String password) {
        super(id, password);
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

    public Account addAccount() {
        return null;
    }

    public void deleteAccount() {

    }

    public Course addCourse() {
        return null;
    }

    public void deleteCourse() {

    }

    public static void viewStudents() {
        List<Student> list = new ArrayList<>(Student.getStudents().values());
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void viewInstructors() {
        List<Instructor> list = new ArrayList<>(Instructor.getTeachers().values());
        for (Instructor i : list) {
            System.out.println(i);
        }
    }

    public void viewCourses() {
        System.out.println("All avaiblable courses at Vanier:\n");
        List<Course> list = new ArrayList<>(Course.getCourses().values());
        for (Course c : list) {
            System.out.println(c);
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
                    break;
                case 8://view instructors
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
