/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Operations {
    
    public static void operationAuto() {

        try {
            // Defining a file to read from
            FileReader fileRead = new FileReader("students.txt");
            Scanner input = new Scanner(fileRead);
            
            // Defining a file to write to
            FileWriter fileWrite = new FileWriter("status.txt");
            BufferedWriter bw = new BufferedWriter(fileWrite);

            // Create array for 3 lines of student data
            String[] array = new String[3];

            String firstName, lastName, studentNumber;
            int classes;
            String workload = null;
            int numberAfterLetters = 0;

            // first loop is for checking for the number of students
            for (int i = 1; input.hasNextLine(); i++) {

                System.out.println("\nStudent no: " + i);
                System.out.println("-------------------------");

                // second loop is for reading data for each student
                for (int j = 0; j <= 2; j++) {

                    array[j] = input.nextLine(); // read student data into array

                    if (j == 2) {

                        String[] name = array[0].split(" ");  // split First name and Last name with a space
                        firstName = name[0];
                        lastName = name[1];
                        classes = Integer.parseInt(array[1]);
                        studentNumber = array[2].trim();

                        // extract up to three digits after the letters from the Student Number
                        if (studentNumber.length() > 5) {
                            switch (studentNumber.length()) {
                                case 6:
                                    if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                                    }
                                    else {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(4));
                                    }
                                    break;
                                case 7:
                                    if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                                    }
                                    else {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(4));
                                    }
                                    break;
                                case 8:
                                    if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                                    }
                                    else {
                                        numberAfterLetters = Integer.parseInt(studentNumber.substring(4, 7));
                                    }
                                    break;
                               
                            }
                        }

                        // Assign a Workload by the number of classes
                        switch (classes) {
                            case 1:
                                workload = "Very Light";
                                break;
                            case 2:
                                workload = "Light";
                                break;
                            case 3:
                                workload = "Part Time";
                                break;
                            case 4:
                                workload = "Part Time";
                                break;
                            case 5:
                                workload = "Part Time";
                                break;
                            case 6:
                                workload = "Full Time";
                                break;
                            case 7:
                                workload = "Full Time";
                                break;
                            case 8:
                                workload = "Full Time";
                        }

                        // First name must be letters only
                        if (!firstName.matches("[a-zA-Z]+")) {
                            System.out.println("First name must contain letters only!");
                        }

                        // Second name must be letters and/or numbers
                        else if (!lastName.matches("[a-zA-Z0-9]+")) {
                            System.out.println("Second name must contain letters and/or numbers only!");
                        }

                        // Number of classes must be between 1 and 8 (inclusive)
                        else if (!(1 <= classes && classes <= 8)) {
                            System.out.println("Number of classes must be between 1 and 8 (inclusive)!");
                        }

                        // Student number must be a minimum of 6 characters
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

                        // If there are two letters only
                        // Check if everything after the last letter character is a number
                        else if (!studentNumber.substring(3, 4).matches("[a-zA-Z]") && !studentNumber.substring(4).matches("[0-9]+")) {
                            System.out.println("Everything after the last letter character must be a number!");
                        }

                        // FOR DISTINCTION.

                        // The first 2 characters must be numbers bigger than 20 (at least year 2020 or higher)
                        else if (!((Integer.parseInt(studentNumber.substring(0, 2))) >= 20)) {
                            System.out.println("The student number year must be 2020 or higher!");
                        }

                        // The number after the letters must be between 1 and 200
                        else if (!(numberAfterLetters >= 1 && numberAfterLetters <= 200)) {
                            System.out.println("The number after the letters must be reasonable (between 1 and 200)!");
                        } 
                        else {
                            try {
                                // writing data to a file
                                bw.write(studentNumber + " - " + lastName + "\n" + workload + "\n");
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                            // if all validation passed print a success message
                            System.out.println("Student details were successfully written to a file.");

//                                 these are just for testing purposes
//                            System.out.println("First name: " + firstName);
//                            System.out.println("Last name: " + lastName);
//                            System.out.println("Classes: " + classes);
//                            System.out.println("Student number: " + studentNumber);
//                            System.out.println("Student number first 2: " + studentNumber.substring(0, 2));
//                            System.out.println("Student number next 2: " + studentNumber.substring(2, 4));
//                            System.out.println("Student number 5th character: " + studentNumber.substring(4, 5));
//                            System.out.println("Student number after 5th: " + studentNumber.substring(5));
//                            System.out.println("Workload is: " + workload);
//                            System.out.println("Number after letters is: " + numberAfterLetters);
                        }
                    }
                }
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void operationManual() {

        try {
            // Defining a file to write to
            FileWriter fileWrite = new FileWriter("status.txt");
            BufferedWriter bw = new BufferedWriter(fileWrite);

            String workload = null;
            int numberAfterLetters = 0;
            
            Scanner input = new Scanner(System.in);

            System.out.println("How many students?");
            int numberOfStudents = input.nextInt();

            // this loop is for every number of students that user selects
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.println("\nStudent no: " + i);
                System.out.println("-------------------------");

                System.out.println("Enter student's name:");
                String firstName = input.next();

                System.out.println("Enter student's surname:");
                String lastName = input.next();

                System.out.println("Enter student's number of classes:");
                int classes = input.nextInt();

                System.out.println("Enter student number:");
                String studentNumber = input.next();

                // extract up to three digits after the letters from the Student Number
                if (studentNumber.length() > 5) {
                    switch (studentNumber.length()) {
                        case 6:
                            if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                            } 
                            else {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(4));
                            }
                            break;
                        case 7:
                            if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                            } 
                            else {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(4));
                            }
                            break;
                        case 8:
                            if (studentNumber.substring(4, 5).matches("[a-zA-Z]")) {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(5));
                            } 
                            else {
                                numberAfterLetters = Integer.parseInt(studentNumber.substring(4, 7));
                            }
                            break;
                        
                    }
                }

                // Assign a Workload by the number of classes
                switch (classes) {
                    case 1:
                        workload = "Very Light";
                        break;
                    case 2:
                        workload = "Light";
                        break;
                    case 3:
                        workload = "Part Time";
                        break;
                    case 4:
                        workload = "Part Time";
                        break;
                    case 5:
                        workload = "Part Time";
                        break;
                    case 6:
                        workload = "Full Time";
                        break;
                    case 7:
                        workload = "Full Time";
                        break;
                    case 8:
                        workload = "Full Time";
                }

                // First name must be letters only
                if (!firstName.matches("[a-zA-Z]+")) {
                    System.out.println("First name must contain letters only!");
                }

                // Second name must be letters and/or numbers
                else if (!lastName.matches("[a-zA-Z0-9]+")) {
                    System.out.println("Second name must contain letters and/or numbers only!");
                }

                // Number of classes must be between 1 and 8 (inclusive)
                else if (!(1 <= classes && classes <= 8)) {
                    System.out.println("Number of classes must be between 1 and 8 (inclusive)!");
                }

                // Student number must be a minimum of 6 characters
                else if (!(5 < studentNumber.length())) {
                    System.out.println("A student “number” must be at least 6 characters!");
                }

                // The first 2 characters must be numbers
                else if (!studentNumber.substring(0, 2).matches("[0-9]+")) {
                    System.out.println("The first 2 characters must be numbers!");
                }

                // The 3rd and 4th characters must be letters
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

                // If there are two letters only
                // Check if everything after the last letter character is a number
                else if (!studentNumber.substring(3, 4).matches("[a-zA-Z]") && !studentNumber.substring(4).matches("[0-9]+")) {
                    System.out.println("Everything after the last letter character must be a number!");
                }

                // FOR DISTINCTION.

                // The first 2 characters must be numbers bigger than 20 (at least year 2020 or higher)
                else if (!((Integer.parseInt(studentNumber.substring(0, 2))) >= 20)) {
                    System.out.println("The student number year must be 2020 or higher!");
                }

                // The number after the letters must be between 1 and 200
                else if (!(numberAfterLetters >= 1 && numberAfterLetters <= 200)) {
                    System.out.println("The number after the letters must be reasonable (between 1 and 200)!");
                } 
                else {
                    try {
                        // writing data to a file
                        bw.write(studentNumber + " - " + lastName + "\n" + workload + "\n");
                    } 
                    catch (Exception e) {
                        System.out.println(e);
                    }

                    // if all validation passed print a success message
                    System.out.println("Student details were successfully written to a file.");

//                        these are just for testing purposes
//                    System.out.println("First name: " + firstName);
//                    System.out.println("Last name: " + lastName);
//                    System.out.println("Classes: " + classes);
//                    System.out.println("Student number: " + studentNumber);
//                    System.out.println("Student number first 2: " + studentNumber.substring(0, 2));
//                    System.out.println("Student number next 2: " + studentNumber.substring(2, 4));
//                    System.out.println("Student number 5th character: " + studentNumber.substring(4, 5));
//                    System.out.println("Student number after 5th: " + studentNumber.substring(5));
//                    System.out.println("Workload is: " + workload);
//                    System.out.println("Number after letters is: " + numberAfterLetters);
                }
            }
            bw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
