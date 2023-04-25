/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseManagementSystem;

import java.util.HashMap;

/**
 *
 * @author 2289679
 */

public abstract class Account {

    private String firstName;
    private String lastName;
    private int id;
    private String password;
    private HashMap<Integer, String> userInfo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public HashMap<Integer, String> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(HashMap<Integer, String> userInfo) {
        this.userInfo = userInfo;
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

    public static void login() {
        
    }

    public static void logout() {
        
    }
    
    public static void mainMenu(){
        
    }
}