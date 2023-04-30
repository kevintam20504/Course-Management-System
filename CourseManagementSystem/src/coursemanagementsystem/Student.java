package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    static HashMap<Integer, Student> students = new HashMap<>();
    static HashMap<Integer, String> database = new HashMap<>();

    public Student(int id, String password) {
        this.id = id;
        this.password = password;
        Student.database.put(id, password);
        Student.students.put(id, this);
    }

    void viewCourses() {
    }

    @Override
    public String toString() {
        //testing to see if login is giving correct student
        return "Student{" + "id: " + this.id + " password: " + this.password + '}';
    }

}
