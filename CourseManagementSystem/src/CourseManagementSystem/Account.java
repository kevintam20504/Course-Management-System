
import java.util.HashMap;

public abstract class Account {

    String firstName;
    String lastName;
    int id;
    String password;
    //database with all IDs and passwords
    static HashMap<Integer, String> database = new HashMap<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void displayActions();

    public abstract void viewCourses();

    //method to seperate different methods
    public static void printSeperation() {
        System.out.println("-----------------------------------------------------------------");
    }

}
