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
        if (!this.courses.isEmpty()) {
            for (Course c : this.courses) {
                System.out.println(c);
            }
            while (true) {
                String choice = UserInputManager.listOptions();
                if (choice.equals("s")) {
                    System.out.println("do sorting stuff here");
                } else if (choice.equals("p")) {
                    PrintList.printTxt("All courses of " + this.firstName + " " + this.lastName, courses);
                } else {
                    break;
                }
            }

        } else {
            System.out.println("You are not in any course.");
        }
    }

    public void viewGrades() {
        System.out.println("Grades: ");
        if (!this.courses.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            for (Course c : this.courses) {
                list.add(c.getName() + ": " + c.getGrades().get(this));
                System.out.println(c.getName() + ": " + c.getGrades().get(this));
            }

            while (true) {
                String choice = UserInputManager.listOptions();
                if (choice.equals("s")) {
                    System.out.println("do sorting stuff here");
                } else if (choice.equals("p")) {
                    PrintList.printTxt("Grades of " + this.firstName + " " + this.lastName, list);
                } else {
                    break;
                }
            }

        } else {
            System.out.println("You are not in any course.");
        }
    }

    public void viewClassFeedback() {
        Course course = UserInputManager.getCourse();
        if (course != null && !course.getClassFeedback().isEmpty()) {
            if (this.courses.contains(course)) {
                System.out.println("Class feedback for " + course.getName() + ": ");
                ArrayList<String> feedbackList = course.getClassFeedback();
                for (String feedback : feedbackList) {
                    System.out.println(feedback);
                }

                while (true) {
                    String choice = UserInputManager.listOptions();
                    if (choice.equals("s")) {
                        System.out.println("do sorting stuff here");
                    } else if (choice.equals("p")) {
                        PrintList.printTxt("Class feedback for " + course.getName(), feedbackList);
                    } else {
                        break;
                    }
                }

            } else {
                System.out.println("This student is not in this course.");
            }
        } else {
            System.out.println("There is no feedback posted.");
        }

    }

    public void viewFeedback() {
        Course course = UserInputManager.getCourse();
        if (course.getStudentFeedback().get(course) == null) {
            course.getStudentFeedback().put(course, new HashMap<>());
        }
        if (course.getStudentFeedback().get(course).get(this) == null) {
            course.getStudentFeedback().get(course).put(this, new ArrayList<>());
        }
        
        ArrayList<String> feedbackList = course.getStudentFeedback().get(course).get(this);
        
        if (!feedbackList.isEmpty()) {
            if (this.courses.contains(course)) {
                System.out.println("Individual feedback for " + course.getName() + ": ");

                for (String feedback : feedbackList) {
                    System.out.println(feedback);
                }

                while (true) {
                    String choice = UserInputManager.listOptions();
                    if (choice.equals("s")) {
                        System.out.println("do sorting stuff here");
                    } else if (choice.equals("p")) {
                        PrintList.printTxt("Feedback for " + this.firstName + " " + this.lastName, feedbackList);
                    } else {
                        break;
                    }
                }

            } else {
                System.out.println("This student is not in this course.");
            }
        } else {
            System.out.println("There is no feedback posted.");
        }

    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.studentMenu()) {
                case 1://view courses
                    viewCourses();
                    break;
                case 2://view grades
                    viewGrades();
                    break;
                case 3://view class feedback
                    viewClassFeedback();
                    break;
                case 4://view individual feedback
                    viewFeedback();
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
