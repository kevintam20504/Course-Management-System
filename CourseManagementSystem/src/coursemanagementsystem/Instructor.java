package coursemanagementsystem;

import java.util.HashMap;

public class Instructor extends Account {

    static HashMap<Integer, Instructor> teachers = new HashMap<>();
    static HashMap<Integer, String> database = new HashMap<>();

    public Instructor(int id, String password) {
        this.id = id;
        this.password = password;
        Instructor.database.put(id, password);
        Instructor.teachers.put(id, this);
    }

    public void viewCourses() {
    }

    public void postGrade() {
    }

    @Override
    public String toString() {
        //testing to see if login is giving correct instructor
        return "Instructor{" + "id: " + this.id + " password: " + this.password + '}';
    }

}
