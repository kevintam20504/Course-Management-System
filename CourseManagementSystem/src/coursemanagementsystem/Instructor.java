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

    public void viewCourses(Instructor instructor) {
        System.out.println("All courses taught:\n ");
        for (Course courses : instructor.getCourses()) {
            System.out.print("\n" + courses + ", Average: ");
            courses.getGrades().values().stream().mapToInt(n -> n).average().ifPresent(System.out::print);
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
    public void performAction(int userOption, Instructor instructor) {
        switch (userOption) {
            case 1:
                instructor.viewCourses(instructor);
                Instructor.performAction(UserInputManager.instructorMenu(), instructor);
                break;
            case 2:
                instructor.postGrade();
                Instructor.performAction(UserInputManager.instructorMenu(), instructor);
                break;
            case 3:
                instructor.postClassFeedBack(UserInputManager.enterFeedback());
                Instructor.performAction(UserInputManager.instructorMenu(), instructor);
                break;
            case 4:
                //student feedback
                break;
            case 5:
                //logout
                break;
        }
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + this.lastName + " " + this.firstName;
    }

}
