package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Instructor extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Instructor> teachers = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();

    public Instructor(int id, String password, String fName, String lName) {
        super(id, password);
        this.firstName = fName;
        this.lastName = lName;
        Instructor.database.put(id, password);
        Instructor.teachers.put(id, this);
    }

    public static HashMap<Integer, Instructor> getTeachers() {
        return teachers;
    }

    public static void setTeachers(HashMap<Integer, Instructor> teachers) {
        Instructor.teachers = teachers;
    }

    public static HashMap<Integer, String> getDatabase() {
        return database;
    }

    public static void setDatabase(HashMap<Integer, String> database) {
        Instructor.database = database;
    }

    public void viewCourses() {
    }

    public void postGrade() {
    }

    public void postClassFeedBack(Course course, String feedback) {
        course.getClassFeedback().put(course, feedback);
    }

    public void postStudentFeedBack() {

    }

    @Override
    public void performAction(int userOption) {
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + this.lastName + " " + this.firstName;
    }

}
