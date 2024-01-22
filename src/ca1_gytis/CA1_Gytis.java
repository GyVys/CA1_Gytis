/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_gytis;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        
        try {
            
            // Defining a file to read from
            FileReader fileRead = new FileReader("students.txt");
        
            // Defining a file to write to
            FileWriter fileWrite = new FileWriter("status.txt");
            
            Scanner input = new Scanner(fileRead);
            
            BufferedWriter bw = new BufferedWriter(fileWrite);

            // Create array for 3 lines of student data
            String[] array = new String[3];
            
            String firstName, lastName, studentNumber;
            String workload = null;
            int  classes;
            
            // first loop is for checking if there are more than one student
            for (int i = 1; input.hasNextLine(); i++) {

                System.out.println("\nStudent no: " + i);
                System.out.println("-------------------------");

                // second loop is for reading data for each student
                for (int j = 0; j <= 2; j++) {
                    
                    array[j] = input.nextLine(); // read data into array
                    
                    if (j == 2){
                    
                    String[] name = array[0].split(" ");
                    firstName = name[0];
                    lastName = name[1];
                    classes = Integer.parseInt(array[1]);
                    studentNumber = array[2];
                    
                    // Assign a Workload by the number of classes
                    switch(classes) {
                        case 1: workload = "Very Light";
                        break;
                        case 2: workload = "Light";
                        break;
                        case 3: workload = "Part Time";
                        break;
                        case 4: workload = "Part Time";
                        break;
                        case 5: workload = "Part Time";
                        break;
                        case 6: workload = "Full Time";
                        break;
                        case 7: workload = "Full Time";
                        break;
                        case 8: workload = "Full Time";
                    }
                    
                    // First name must be letters only
                    if (!firstName.matches("[a-zA-Z]+")){
                        System.out.println("First name must contain letters only!");
                    }
                    
                    // Second name must be letters and/or numbers
                    else if (!lastName.matches("[a-zA-Z_0-9]+")){
                        System.out.println("Second name must contain letters and/or numbers only!");
                    }
                    
                    // Number of classes must be between 1 and 8 (inclusive)
                    else if (!(1 <= classes && classes <= 8 )){
                        System.out.println("Number of classes must be between 1 and 8 (inclusive)!");
                    }
                    
                    // Student “number” must be a minimum of 6 characters
                    else if (!(5 < studentNumber.length())) {
                        System.out.println("A student “number” must be at least 6 characters!");
                    }
                    
                    // The first 2 characters must be numbers
                    else if (!studentNumber.substring(0, 2).matches("[0-9]+")) {
                        System.out.println("The first 2 characters must be numbers!");
                    }
                    
                    // The 3rd  and 4th characters must be letters
                    else if (!studentNumber.substring(2, 4).matches("[a-zA-Z]+")) {
                        System.out.println("The 3rd and 4th characters must be letters!");
                    }
                    
                    // Check if the 5th character is a letter
                    // and everything after the last letter character is a number
                    else if (!studentNumber.substring(4, 5).matches("[a-zA-Z]") && !studentNumber.substring(5).matches("[0-9]+")) {
                            System.out.println("Everything after the last letter character must be a number!");
                        }
                    
                    // Check if the 5th character is a number
                    // and everything after the last letter character is a number
                    else if (!studentNumber.substring(4, 5).matches("[0-9]") && !studentNumber.substring(5).matches("[0-9]+")) {
                            System.out.println("Everything after the last letter character must be a number!");
                        }
                        
                    // Check if everything after the last letter character is a number
                    else if (!studentNumber.substring(3, 4).matches("[a-zA-Z]") && !studentNumber.substring(4).matches("[0-9]+")) {
                            System.out.println("Everything after the last letter character must be a number!");
                        }
                    
                    else {
                        try {
                            bw.write(studentNumber + " - " + lastName + "\n" + workload + "\n");
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                        
                        // these are just for testing purposes
                        System.out.println("First name: " + firstName);
                        System.out.println("Last name: " + lastName);
                        System.out.println("Classes: " + classes);
                        System.out.println("Student number: " + studentNumber);
//                        System.out.println("Student number first 2: " + studentNumber.substring(0, 2));
//                        System.out.println("Student number next 2: " + studentNumber.substring(2, 4));
//                        System.out.println("Student number 5th character: " + studentNumber.substring(4, 5));
//                        System.out.println("Student number after 5th: " + studentNumber.substring(5));
//                        System.out.println("Workload is : " + workload);
                        }
                    }
                }
            }
            bw.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
