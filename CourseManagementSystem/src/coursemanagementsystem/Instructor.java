package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Instructor extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Instructor> teachers = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();

    public Instructor(String firstName, String lastName, int id, String password) {
        super(firstName, lastName, id, password);
        Instructor.database.put(id, password);
        Instructor.teachers.put(id, this);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
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
        System.out.println("All courses taught:\n ");
        for (Course course : courses) {
            System.out.print("\n" + courses + ", Average: ");
            course.getGrades().values().stream().mapToInt(n -> n).average().ifPresent(System.out::print);
            System.out.println("");
        }
    }

    public void postGrade() {
    }

    public void postClassFeedBack(Course course, String feedback) {
        course.getClassFeedback().put(course, feedback);
    }

    public void postStudentFeedBack() {

    }

    @Override
    public void performAction() {
        switch (userOption) {
            case 1://view courses
                viewCourses();
                performAction(UserInputManager.instructorMenu());
                break;
            case 2://submit grades
                postGrade();
                performAction(UserInputManager.instructorMenu());
                break;
            case 3://view students
                performAction(UserInputManager.instructorMenu());
                break;
            case 4://class feedback
                break;
            case 5: //student feedback
                break;
            case 6:
                //logout
                break;
        }
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + this.lastName + " " + this.firstName;
    }

}
