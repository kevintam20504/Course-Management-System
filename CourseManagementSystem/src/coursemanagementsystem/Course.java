package coursemanagementsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Course {

    private int courseId;
    private String name;
    private Instructor teacher;
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Student, Integer> grades = new HashMap<>();
    private static final int MAX_STUDENTS = 30;
    private static final int MAX_TEACHERS = 1;
    private static HashMap<Object, String> classFeedback = new HashMap<>();
    private HashMap<Student, String> feedback = new HashMap<>();

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

    public HashMap<Student, Integer> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<Student, Integer> grades) {
        this.grades = grades;
    }

    public static HashMap<Object, String> getClassFeedback() {
        return classFeedback;
    }

    public static void setClassFeedback(HashMap<Object, String> classFeedback) {
        Course.classFeedback = classFeedback;
    }

    public HashMap<Student, String> getFeedback() {
        return feedback;
    }

    public void setFeedback(HashMap<Student, String> feedback) {
        this.feedback = feedback;
    }

    public void viewStudents() {

    }

    public void viewGrades() {

    }

    public void postClassFeedBack(String feedback) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = myDateObj.format(myFormatObj);

        classFeedback.put(formattedDate, feedback);
    }
    
    public void postStudentFeedBack(){
        
    }

}
