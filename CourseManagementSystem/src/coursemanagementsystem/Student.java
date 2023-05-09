package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Student> students = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();
    private ArrayList<String> feedbackList = new ArrayList<>();
    private HashMap<Course, ArrayList<String>> studentFeedback = new HashMap<>();

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

    public ArrayList<String> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(ArrayList<String> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public HashMap<Course, ArrayList<String>> getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(HashMap<Course, ArrayList<String>> studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public void viewCourses() {
        System.out.println("All courses: ");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void viewGrades() {
        System.out.println("Grades: ");
        for (Course c : courses) {
            System.out.println(c.getName() + ": " + c.getGrades().get(this));
        }
    }

    public void viewClassFeedback() {
        Course course = UserInputManager.getCourse();

        while (!this.courses.contains(course)) {
            System.out.println("This student is not in this course.");
        }
        System.out.println("Class feedback for " + course.getName() + ": ");
        for (String feedback : course.getClassFeedback()) {
            System.out.println(feedback);
        }
    }

    public void viewFeedback() {
        Course course = UserInputManager.getCourse();

        while (!this.courses.contains(course)) {
            System.out.println("This student is not in this course.");
        }
        System.out.println("Individual feedback for " + course.getName() + ": ");
        for (String feedback : this.getStudentFeedback().get(course)) {
            System.out.println(feedback);
        }
    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.studentMenu()) {
                case 1://view courses
                    viewCourses();
                    UserInputManager.goBack();
                    break;
                case 2://view grades
                    viewGrades();
                    UserInputManager.goBack();
                    break;
                case 3://view class feedback
                    viewClassFeedback();
                    UserInputManager.goBack();
                    break;
                case 4://view individual feedback
                    viewFeedback();
                    UserInputManager.goBack();
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
        return "[" + this.id + "] " + this.lastName + " " + this.firstName;
    }

}
