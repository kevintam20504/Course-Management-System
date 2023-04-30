
package coursemanagementsystem;
import java.util.HashMap;




public class Admin extends Account {
    static HashMap<Integer,Student> students = new HashMap<>();
    static HashMap<Integer,Instructor> teachers = new HashMap<>();
    static HashMap<Integer,String> database = new HashMap<>();
    

    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
    }
    
}
