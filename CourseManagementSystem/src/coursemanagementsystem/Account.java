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
        System.out.println("All courses: ");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void viewGrades() {
        System.out.println("Grades: ");
        for (Course c : courses) {
            System.out.println(c.getName() + ": " + c.getGrades().get(this) + "%, Average: " + c.getAverage() + "%");
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
        boolean back = false;
        String letterChoice;
        while (!exitCondition) {
            switch (UserInputManager.studentMenu()) {
                case 1://view courses
                    viewCourses();
                    letterChoice = UserInputManager.goBack_Sort_orPrint();
                    if (letterChoice.equalsIgnoreCase("s")) {
                        UserInputManager.sortCourses(this.courses);
                    } else if (letterChoice.equalsIgnoreCase("p")) {
                        //prints
                        System.out.println("print...");
                    }
                    System.out.println("Going back to main menu.");
                    break;
                case 2://view grades
                    viewGrades();
                    letterChoice = UserInputManager.goBack_Sort_orPrint();
                    if (letterChoice.equalsIgnoreCase("s")) {
                        UserInputManager.sortGrades(this.courses,this);
                    } else if (letterChoice.equalsIgnoreCase("p")) {
                        //prints
                        System.out.println("print...");
                    }
                    System.out.println("Going back to main menu.");
                    break;
                case 3://view class feedback
                    boolean viewedClassFeedback = viewClassFeedback();
                    if (viewedClassFeedback == true) {
                        back = UserInputManager.goBack_orPrint();
                        if (back == false) {
                            //print
                            System.out.println("print...");
                        }
                    }
                    break;
                case 4://view individual feedback
                    boolean viewedFeedback = viewFeedback();
                    if (viewedFeedback == true) {
                        back = UserInputManager.goBack_orPrint();
                        if (back == false) {
                            //print
                            System.out.println("print...");
                        }
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
