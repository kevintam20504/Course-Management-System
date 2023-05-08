package coursemanagementsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Course {

    private int courseId;
    private String name;
    private Instructor teacher;
    private static HashMap<Integer, Course> courses = new HashMap<>();
    private HashMap<Student, Integer> grades = new HashMap<>();
    private static final int MAX_STUDENTS = 30;
    private static final int MAX_TEACHERS = 1;
    private HashMap<Course, String> classFeedback = new HashMap<>();
    private HashMap<Student, String> feedback = new HashMap<>();

    public Course(int courseId, String name, Instructor teacher) {
        this.courseId = courseId;
        this.name = name;
        this.teacher = teacher;
        this.courses.put(courseId, this);
        teacher.getCourses().add(this);
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
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

    public HashMap<Course, String> getClassFeedback() {
        return this.classFeedback;
    }

    public void setClassFeedback(HashMap<Course, String> classFeedback) {
        this.classFeedback = classFeedback;
    }

    public HashMap<Student, String> getFeedback() {
        return this.feedback;
    }

    public void setFeedback(HashMap<Student, String> feedback) {
        this.feedback = feedback;
    }

    public void viewStudents() {

    }

    public void viewGrades() {

    }
    
    @Override
    public String toString() {
        return name + " (" + courseId + ")" + ", " + teacher.getFirstName() + " " + teacher.getLastName() + ", " + students.size() + "/30 students";
    }

}
