/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_gytis;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gytis
 */
public class CA1_Gytis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // reading info from file with Scanner
        try {
            Scanner input = new Scanner(new FileReader("students.txt"));

            String[] array = new String[3];
            
            String firstName, lastName, classes, studentNum;
            
            for (int i = 1; input.hasNextLine(); i++) {

                System.out.println("\nStudent no: " + i);
                System.out.println("-------------------------");

                for (int j = 0; j <= 2; j++) {
                    
                    array[j] = input.nextLine();
                    
                    if (j == 2){
                    
                    String[] name = array[0].split(" ");
                    firstName = name[0];
                    lastName = name[1];
                    classes = array[1];
                    studentNum = array[2];
                    
                    System.out.println("First name: " + firstName);
                    System.out.println("Last name: " + lastName);
                    System.out.println("Classes: " + classes);
                    System.out.println("Student number: " + studentNum);
                    
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
