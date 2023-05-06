/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gary
 */
public class TestDriver {

    public static void main(String[] args) throws InterruptedException {
        //for testing stuff
        System.out.println(Time.getTime());
        Instructor i = new Instructor(1, "p","fName","lName");
        Course c = new Course(0, "name", i);
        i.postClassFeedBack(c, "feedback");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Time.getTime());
        i.postClassFeedBack(c, "feedback2");
        System.out.println(c.getClassFeedback());
    }
}
