package coursemanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Instructor extends Account {

    private ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Integer, Instructor> teachers = new HashMap<>();
    private static HashMap<Integer, String> database = new HashMap<>();

    public Instructor(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
        Instructor.database.put(id, password);
        Instructor.teachers.put(id, this);
        
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public static HashMap<Integer, Instructor> getTeachers() {
        return teachers;
    }

    public static void setTeachers(HashMap<Integer, Instructor> teachers) {
        Instructor.teachers = teachers;
    }

    public static HashMap<Integer, String> getDatabase() {
        return database;
    }

    public static void setDatabase(HashMap<Integer, String> database) {
        Instructor.database = database;
    }

    public void viewCourses() {
        System.out.println("All courses taught: ");
        if (!this.courses.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            for (Course course : this.courses) {
                list.add(course.toString();
                System.out.println(course.toString());
            }
            
            while(true){
                String choice = UserInputManager.goBack_Sort_orPrint();
                if (choice.equals("s")) {
                    UserInputManager.sortCourses(this.courses);
                }
                else if (choice.equals("p")) {
                    PrintList.printTxt("All courses taught by " + this.firstName + " " + this.lastName, list);
                }
                else{
                    break;
                }
            }
            
        } else {
            System.out.println("You are not teaching any courses.");
        }

    }

    public void postGrade() {
        Course course = UserInputManager.getCourse();
        boolean exit = false;
        if (course != null) {
            while (!this.courses.contains(course)) {//checks if teacher teaches this course
                System.out.println("This teacher does not teach this course.");
                course = UserInputManager.getCourse();
                if (course == null) {
                    exit = true;
                    break;
                }
            }
            if (exit == false) {
                Student student = UserInputManager.getStudent();
                if (student != null) {
                    while (!course.getStudents().contains(student)) {//checks if student is in this course
                        System.out.println("This student is not in this course.");
                        student = UserInputManager.getStudent();
                        if (student == null) {
                            exit = true;
                            break;
                        }
                    }
                    if (exit == false) {
                        int grade = UserInputManager.getGrade();
                        if (grade == -1) {
                            exit = true;
                        }
                        if (exit == false) {
                            course.getGrades().put(student, grade);
                            System.out.println("Posted grade for " + student.firstName + " in " + course.getName() + ".");
                        }
                    }
                }
            }
        }
    }

    public void viewStudents() {
        Course course = UserInputManager.getCourse();
        while (!this.courses.contains(course) && course != null) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }

        if (course != null && !course.getStudents().isEmpty()) {
            System.out.println("All students in " + course.getName() + ": ");
            for (Student s : course.getStudents()) {
                System.out.println(s);
            }
            
            while(true){
                String choice = UserInputManager.goBack_Sort_orPrint();
                if (choice.equals("s")) {
                    UserInputManager.sortStudents(course.getStudents());
                }
                else if (choice.equals("p")) {
                    PrintList.printTxt("All students in " + course.getName(), course.getStudents());
                }
                else{
                    break;
                }
            }
            
        }else{
            System.out.println("This course has no students.");
        }

    }

    public void postClassFeedBack() {
        Course course = UserInputManager.getCourse();
        if (course != null) {
            while (!this.courses.contains(course) && course != null) {//checks if teacher teaches this course
                System.out.println("This teacher does not teach this course.");
                course = UserInputManager.getCourse();
            }
            if (course != null) {

                String feedback = UserInputManager.enterFeedback();

                course.getClassFeedback().add(feedback);
                System.out.println("Posted class feedback to " + course.getName() + ".");
            }

        }
    }

    public void postStudentFeedBack() {
        Course course = UserInputManager.getCourse();
        while (!this.courses.contains(course) && course != null) {//checks if teacher teaches this course
            System.out.println("This teacher does not teach this course.");
            course = UserInputManager.getCourse();
        }
        if (course != null) {
            Student student = UserInputManager.getStudent();
            while (!course.getStudents().contains(student) && student != null) {
                System.out.println("This student is not in this course.");
                student = UserInputManager.getStudent();
            }
            if (student != null) {
                String feedback = UserInputManager.enterFeedback();
                if (course.getStudentFeedback().get(course) == null) {
                    course.getStudentFeedback().put(course, new HashMap<>());
                }
                if (course.getStudentFeedback().get(course).get(student) == null) {
                    course.getStudentFeedback().get(course).put(student, new ArrayList<>());
                }
                course.getStudentFeedback().get(course).get(student).add(feedback);
                System.out.println("Feedback has been sent to " + student.getFirstName());
            }
        }

    }

    @Override
    public void performAction() {
        boolean exitCondition = false;
        while (!exitCondition) {
            switch (UserInputManager.instructorMenu()) {
                case 1://view courses
                    viewCourses();
                    break;
                case 2://submit grades
                    postGrade();
                    break;
                case 3://view students in a course
                    viewStudents();
                    break;
                case 4://class feedback
                    postClassFeedBack();
                    break;
                case 5: //student feedback
                    postStudentFeedBack();
                    break;
                case 6:
                    //logout
                    exitCondition = true;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + this.id + "] " + this.lastName + ", " + this.firstName;
    }

}
