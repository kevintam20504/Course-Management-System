package coursemanagementsystem;

public abstract class Account {

    protected String firstName;
    protected String lastName;
    protected int id;
    protected static int counter = 0;
    protected String password;

    public Account(String password) {
        this.id = counter++;
        this.password = password;
    }

    public Account(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = counter++;
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
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

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Account.counter = counter;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void performAction();
    
    public static void viewAccounts(){
        
    }

}
