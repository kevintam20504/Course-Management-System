package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Student extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Student> students = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();

    public Student(int id, String password, String fName, String lName) {
        super(id, password);
        this.firstName = fName;
        this.lastName = lName;
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
    public void performAction(int userOption) {
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + this.lastName + " " + this.firstName;
    }

}
