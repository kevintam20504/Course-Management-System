/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author Gary
 */
public class TestDriver {
    public static void main(String[] args) {
        //just testing login
        Student s1 = new Student(1, "password1");
        Student s2 = new Student(2, "password2");
        Student s3 = new Student(3, "password3");
        
        Instructor i1 = new Instructor(4, "password4");
        
        System.out.println("returned: " + UserInputManager.login());
   }
}
