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
    public static void performAction(int userOption) {
        switch (userOption) {
            case 1:
                viewCourses();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 2:
                UserInputManager.newCourse();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 3:
                UserInputManager.deleteCourse();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 4:
                UserInputManager.newAccount();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 5:
                UserInputManager.deleteAccount();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 6:
                UserInputManager.assignCourse();
                Admin.performAction(UserInputManager.adminMenu());
                break;
            case 7:
            //logout
                break;
        }

    }

}
