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
        Course course = UserInputManager.getCourse();

        while (!this.courses.contains(course)) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }
        Student student = UserInputManager.getStudent();

        while (!course.getStudents().contains(student)) {//checks if student is in this course
            System.out.println("This student is not in this course.");
            student = UserInputManager.getStudent();
        }
        int grade = UserInputManager.getGrade();
        course.getGrades().put(student, grade);
        System.out.println("Posted grade for " + student.firstName + " in " + course.getName() + ".");

    }

    public void viewStudents() {
        Course course = UserInputManager.getCourse();
        while (!this.courses.contains(course)) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }
        for (Student s : course.getStudents()) {
            System.out.println(s);
        }

    }

    public void postClassFeedBack() {
        Course course = UserInputManager.getCourse();
        while (!this.courses.contains(course)) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }
        String feedback = UserInputManager.enterFeedback();
        
        course.getClassFeedback().add(feedback);
        System.out.println("Posted class feedback to " + course.getName() + ".");

    }

    public void postStudentFeedBack() {
        Course course = UserInputManager.getCourse();

        while (!this.courses.contains(course)) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }
        Student student = UserInputManager.getStudent();

        while (!course.getStudents().contains(student)) {
            System.out.println("This student is not in this course.");
            student = UserInputManager.getStudent();
        }
        String feedback = UserInputManager.enterFeedback();
        ArrayList<String> feedbackList = student.getFeedbackList();
        feedbackList.add(feedback);
        student.getStudentFeedback().put(course, feedbackList);
    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.instructorMenu()) {
                case 1://view courses
                    viewCourses();
                    UserInputManager.goBack();
                    break;
                case 2://submit grades
                    postGrade();
                    break;
                case 3://view students in a course
                    viewStudents();
                    UserInputManager.goBack();
                    break;
                case 4://class feedback
                    postClassFeedBack();
                    break;
                case 5: //student feedback
                    postStudentFeedBack();
                    break;
                case 6:
                    //logout
                    exitCondition = true;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + this.id + "] " + this.lastName + " " + this.firstName;
    }

}
