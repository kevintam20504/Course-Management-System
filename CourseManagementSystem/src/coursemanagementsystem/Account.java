package coursemanagementsystem;

public abstract class Account {

    protected String firstName;
    protected String lastName;
    protected int id;
    protected String password;

    public Account(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account(String firstName, String lastName, int id, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void performAction();

}
