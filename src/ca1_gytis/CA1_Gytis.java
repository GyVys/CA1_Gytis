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
        
        int i = 1;
        int j = 1;
        String readLine;
        
        // reading info from file
        try {
            Scanner input = new Scanner(new FileReader("students.txt"));
            
        while (input.hasNextLine()) {
            
            
            
            String line = "Line" + i + " ";
            
            readLine = input.nextLine();
            System.out.println(line + readLine);
            i++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
