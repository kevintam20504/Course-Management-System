package coursemanagementsystem;

import java.util.HashMap;

public class Admin extends Account {

    static HashMap<Integer, String> database = new HashMap<>();
    static HashMap<Integer, Admin> admin = new HashMap<>();

    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
        Admin.database.put(id, password);
        Admin.admin.put(id, this);
    }

}
