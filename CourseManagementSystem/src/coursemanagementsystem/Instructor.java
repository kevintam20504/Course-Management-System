
package coursemanagementsystem;




public class Instructor extends Account {

    public Instructor(int id, String password) {
        this.id = id;
        this.password = password;
        Admin.database.put(id, password);
        Admin.teachers.put(id, this);
    }
    
    public void viewCourses(){
    }
    
    public void postGrade(){
    }

    @Override
    public String toString() {
        //testing to see if login is giving correct instructor
        return "Instructor{" + "id: " + this.id + " password: " + this.password + '}';
    }
    
    
    
}
