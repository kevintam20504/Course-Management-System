
package coursemanagementsystem;

import java.util.HashMap;
import java.util.Scanner;




public class UserInputManager {
    
    public static int mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         ---------------------------------------------
                         Welcome to Course Management System for Vanier
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]Login
                         [2]Quit
                         ---------------------------------------------
                         """);
        int userOption = sc.nextInt();
        
        return userOption;
    }
    
    public static Object login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         Select one of the following options.
                         ---------------------------------------------
                         [1]Student
                         [2]Instructor
                         [3]Admin
                         ---------------------------------------------
                         """);
        int userOption = sc.nextInt();
        if (userOption <1 || userOption > 3) {
            System.out.println("Invalid input. Please try again");
            return null;
        }
        HashMap database = Admin.database;
        
        System.out.println("Enter your ID:");
        int id = sc.nextInt();
        System.out.println("Enter password");
        String password = sc.next();
        
        if (database.containsKey(id) && database.get(id).equals(password)) {
            if (userOption == 1) {
                return Admin.students.get(id);
            }
            else if (userOption == 2) {
                return Admin.teachers.get(id);
            }
            else if (userOption == 3) {
                //return admin
            }
        }else{
            System.out.println("Wrong id or password. Please try again.");
        }
        return null;
    }
    
    public static void displayActions(Object accountType){
        if (accountType != null) {
            if (accountType.getClass() == Student.class) {
            studentMenu();
            }
            else if (accountType.getClass() == Instructor.class) {
                instructorMenu();
            }
            else{
                adminMenu();
            }
        }
    }
    
    public static int adminMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Admin Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]admin
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        
        return userOption;
    }
    
    public static int studentMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Student Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]student
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        
        return userOption;
    }
    
    public static int instructorMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                         _____________________________________________
                         Instructor Menu(needs to be finished)
                         ---------------------------------------------
                         Please select one of the following options: 
                         [1]instructor
                         _____________________________________________
                         """);
        int userOption = sc.nextInt();
        
        return userOption;
    }
}
