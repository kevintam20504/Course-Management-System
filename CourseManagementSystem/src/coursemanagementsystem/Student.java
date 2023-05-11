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

    public boolean viewCourses() {
        System.out.println("All courses: ");
        if (!this.courses.isEmpty()) {
            for (Course c : this.courses) {
                System.out.println(c);
            }
            UserInputManager.printList("All courses of " + this.firstName + " " + this.lastName, courses);
            return true;
        } else {
            System.out.println("You are not in any course.");
            return false;
        }
    }

    public boolean viewGrades() {
        System.out.println("Grades: ");
        if (!this.courses.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            for (Course c : this.courses) {
                list.add(c.getName() + ": " + c.getGrades().get(this));
                System.out.println(c.getName() + ": " + c.getGrades().get(this));
            }
            UserInputManager.printList("Grades of " + this.firstName + " " + this.lastName, list);
            return true;
        } else {
            System.out.println("You are not in any course.");
            return false;
        }
    }

    public boolean viewClassFeedback() {
        Course course = UserInputManager.getCourse();
        if (course != null) {
            if (this.courses.contains(course)) {
                System.out.println("Class feedback for " + course.getName() + ": ");
                ArrayList<String> feedbackList = course.getClassFeedback();
                for (String feedback : feedbackList) {
                    System.out.println(feedback);
                }
                return true;
            } else {
                System.out.println("This student is not in this course.");
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean viewFeedback() {
        Course course = UserInputManager.getCourse();
        if (course != null) {
            if (this.courses.contains(course)) {
                System.out.println("Individual feedback for " + course.getName() + ": ");
                if (course.getStudentFeedback().get(course) == null) {
                    course.getStudentFeedback().put(course, new HashMap<>());
                }
                if (course.getStudentFeedback().get(course).get(this) == null) {
                    course.getStudentFeedback().get(course).put(this, new ArrayList<>());
                }
                ArrayList<String> feedbackList = course.getStudentFeedback().get(course).get(this);
                for (String feedback : feedbackList) {
                    System.out.println(feedback);
                }
                return true;
            } else {
                System.out.println("This student is not in this course.");
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.studentMenu()) {
                case 1://view courses
                    boolean viewedCourses = viewCourses();
                    if (viewedCourses == true) {
                        UserInputManager.goBack();
                    }
                    break;
                case 2://view grades
                    boolean viewedGrades = viewGrades();
                    if (viewedGrades == true) {
                        UserInputManager.goBack();
                    }
                    break;
                case 3://view class feedback
                    boolean viewedClassFeedback = viewClassFeedback();
                    if (viewedClassFeedback == true) {
                        UserInputManager.goBack();
                    }
                    break;
                case 4://view individual feedback
                    boolean viewedFeedback = viewFeedback();
                    if (viewedFeedback == true) {
                        UserInputManager.goBack();
                    }
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
