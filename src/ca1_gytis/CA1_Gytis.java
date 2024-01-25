/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_gytis;

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
        
        System.out.println("Hello, \nplease select from two options:\n");
        System.out.println("Press 1 for standard (auto) operation");
        System.out.println("Press 2 for manual enter of student data");

        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()) {
            case 1:
                Operations.operationAuto();
                break;
            case 2:
                Operations.operationManual();
                break;
        }
    }
}