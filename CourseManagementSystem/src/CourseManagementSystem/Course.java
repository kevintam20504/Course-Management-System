/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 2289679
 */
public class Course {
    private int courseId;
    private String name;
    private Instructor teacher;
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Student,Integer> grades = new HashMap<>();
    
    public void viewStudents(){
        
    }
}
