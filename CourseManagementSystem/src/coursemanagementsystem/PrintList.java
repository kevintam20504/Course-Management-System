package coursemanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintList {

    static File file = new File("");
    static String fileDir = "";

    public static <E> void printList(String title, ArrayList<E> arr) {
        file = new File(fileDir, "\\" + title + ".txt");

        while (!file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(title + "\n\n");
                for (E element : arr) {
                    bw.write(element + "\n");
                }
                bw.close();
                
            } catch (IOException e) {
                System.out.println("File path not found.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the file path (Enter \"-1\" to go back to main menu): ");
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
