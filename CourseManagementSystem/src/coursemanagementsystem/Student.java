package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Student> students = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();

    public Student(String fName, String lName, int id, String password) {
        super(fName, lName, id, password);
        Student.database.put(id, password);
        Student.students.put(id, this);
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public static HashMap<Integer, Student> getStudents() {
        return students;
    }

    public static void setStudents(HashMap<Integer, Student> students) {
        Student.students = students;
    }

    public static HashMap<Integer, String> getDatabase() {
        return database;
    }

    public static void setDatabase(HashMap<Integer, String> database) {
        Student.database = database;
    }

    public void viewCourses() {
    }

    public void viewclassFeedback(Course course) {

    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.adminMenu()) {
                case 1://view courses
                    break;
                case 2://view grades
                    break;
                case 3://view class feedback
                    break;
                case 4://view individual feedback
                    break;
                case 5://logout
                    exitCondition = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + this.lastName + " " + this.firstName;
    }

}
