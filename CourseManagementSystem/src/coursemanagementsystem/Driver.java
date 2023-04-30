
package coursemanagementsystem;




public class Driver {
    public static void main(String[] args) {
        Student s1 = new Student(0, "password1");
        Student s2 = new Student(1, "password2");
        Student s3 = new Student(2, "password3");
        
        boolean exitCondition = false;
        
        while(!exitCondition){
            switch(UserInputManager.mainMenu()){
                case 1:
                    Object e = UserInputManager.login();
                    UserInputManager.displayActions(e);
                    break;
                    
                case 2:
                    System.out.println("See you again!");
                    exitCondition = true;
                    break;
                    
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        
    }
}
