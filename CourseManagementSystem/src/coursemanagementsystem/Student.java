
package coursemanagementsystem;

import java.util.ArrayList;




public class Student extends Account{
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(int id, String password) {
        this.id = id;
        this.password = password;
        Admin.database.put(id, password);
        Admin.students.put(id, this);
    }
    
    void viewCourses(){
    }

    @Override
    public String toString() {
        //testing to see if login is giving correct student
        return "Student{" + "id: " + this.id + " password: " + this.password + '}';
    }
    
    
    
}
