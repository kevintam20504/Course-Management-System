package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {

    private int courseId;
    private String name;
    private Instructor teacher;
    private ArrayList<Student> students = new ArrayList<>();
    private static HashMap<Integer, Course> courses = new HashMap<>();
    private HashMap<Student, Integer> grades = new HashMap<>();
    private ArrayList<String> classFeedback = new ArrayList<>();
    private ArrayList<String> feedbackList = new ArrayList<>();
    private HashMap<Student, ArrayList<String>> studentFeedback = new HashMap<>();
    private static final int MAX_STUDENTS = 30;
    private static final int MAX_TEACHERS = 1;

    public Course(int courseId, String name, Instructor teacher) {
        this.courseId = courseId;
        this.name = name;
        this.teacher = teacher;
        Course.courses.put(courseId, this);
        teacher.getCourses().add(this);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getTeacher() {
        return teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public static HashMap<Integer, Course> getCourses() {
        return courses;
    }

    public static void setCourses(HashMap<Integer, Course> courses) {
        Course.courses = courses;
    }

    public HashMap<Student, Integer> getGrades() {
        return this.grades;
    }

    public void setGrades(HashMap<Student, Integer> grades) {
        this.grades = grades;
    }

    public ArrayList<String> getClassFeedback() {
        return classFeedback;
    }

    public void setClassFeedback(ArrayList<String> classFeedback) {
        this.classFeedback = classFeedback;
    }

    public ArrayList<String> getFeedback() {
        return feedbackList;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedbackList = feedback;
    }

    public HashMap<Student, ArrayList<String>> getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(HashMap<Student, ArrayList<String>> studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public static int getMAX_STUDENTS() {
        return MAX_STUDENTS;
    }

    public static int getMAX_TEACHERS() {
        return MAX_TEACHERS;
    }

    public void viewStudents() {
        System.out.println("All Students in this class");
        for (Student s : students) {
            System.out.println(s);
        }

    }

    public void viewGrades() {
        for (Student s : students) {
            System.out.println(s.getFirstName() + " " + s.getLastName() + ": " + grades.get(Student.getStudents().get(s.getId())));
        }
    }

    @Override
    public String toString() {
        return "[" + this.courseId + "] " + name + ", " + teacher.getFirstName() + " " + teacher.getLastName() + ", " + students.size() + "/30 students";
    }

}
