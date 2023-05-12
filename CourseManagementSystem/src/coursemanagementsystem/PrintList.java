package coursemanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintList {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("e");
        arr.add("f");
        arr.add("fag");
        printTxt("hi", arr);
        arr.add("added");
        printTxt("hi", arr);
    }

    static File file = new File("");
    static String fileDir = "";

    public static <E> void printTxt(String title, ArrayList<E> arr) {
        file = new File(fileDir, "\\" + title + ".txt");
        FileWriter fw;
        BufferedWriter bw;

        if (file.exists()) {
            try {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                
                bw.write(Time.getTime() + "\n" + title + "\n\n");
                for (E element : arr) {
                    bw.write(element + "\n");
                }
                System.out.println("Txt file " + title + ".txt was updated.");
                
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (!file.exists()) {
            try {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);

                bw.write(Time.getTime() + "\n\n" + title + "\n\n");
                for (E element : arr) {
                    bw.write(element + "\n");
                }
                System.out.println("Txt file " + title + ".txt created.");

                bw.close();

            } catch (IOException e) {
                System.out.println("File path not found.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the file path (Enter \"-1\" to go back to previous menu): ");
                fileDir = sc.next();

                if (fileDir.equals("-1")) {
                    System.out.println("Going back to main menu.");
                    break;
                }

                file = new File(fileDir, "\\" + title + ".txt");
            }

        }
    }
}
