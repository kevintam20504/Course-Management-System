package coursemanagementsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Instructor extends Account {

    static HashMap<Integer, Instructor> teachers = new HashMap<>();
    static HashMap<Integer, String> database = new HashMap<>();

    public Instructor(int id, String password) {
        this.id = id;
        this.password = password;
        Instructor.database.put(id, password);
        Instructor.teachers.put(id, this);
    }

    public void viewCourses() {
    }

    public void postGrade() {
    }
    
    public void postClassFeedBack(String feedback) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = myDateObj.format(myFormatObj);

        Course.getClassFeedback().put(formattedDate, feedback);
    }
    
    public void postStudentFeedBack(){
        
    }

    @Override
    public String toString() {
        //testing to see if login is giving correct instructor
        return "Instructor{" + "id: " + this.id + " password: " + this.password + '}';
    }

}
