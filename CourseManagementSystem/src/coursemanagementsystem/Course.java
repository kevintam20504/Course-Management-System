
package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;




public class Course {
    private int courseId;
    private String name;
    private Instructor teacher;
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Student,Integer> grades = new HashMap<>();
    
    public void viewStudents(){
    }
}
