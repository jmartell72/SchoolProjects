package com.Test1;

import java.util.Arrays;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {
        //        Setting initial variables for easier recall later
        int sum = 0;
        int amountOfGrades;
        int i;
        String letterGrade = "";

//  Starting Program here

//      This is to update how many grades are going to be inputted by the User and then sets the new array size
        System.out.println("How many grades do you want to enter? (To exit enter 999 or -1 to restart the program)");

        while (true) {
            Scanner input = new Scanner(System.in);
            amountOfGrades = input.nextInt();
            if (amountOfGrades <= 10 && amountOfGrades > 0) {
                break;
            } else if (amountOfGrades == 999) {
                System.exit(0);
            } else if (amountOfGrades == -1) {
                System.out.println("Restarting Program");
                main(null);
            }
            System.out.println("Invalid input. \nYou can only enter up to 10 grades. Try again: ");
        }
        int[] grades = new int[amountOfGrades];

//      This performs the intake on the grades
        for (i = 0; i < amountOfGrades; i++) {
            System.out.println("Please enter Grade " + (i + 1) + " : (To exit enter 999 or enter -1 to restart the program)");
            while (true) {
                Scanner in1 = new Scanner(System.in);
                int holdGrade = in1.nextInt();
                if (holdGrade <= 100 && holdGrade > -1) {
                    grades[i] = holdGrade;
                    sum += holdGrade;
                    break;
                } else if (holdGrade == 999) {
                    System.exit(0);
                } else if (holdGrade == -1) {
                    System.out.println("Restarting Program");
                    main(null);
                }

                System.out.println("Invalid input. \nYou can only enter a score between 1 and 100 - Try again:");
            }
        }

//  Verifying the data is intact prior to crunching the numbers
        System.out.println("Please confirm these grades are correct:\n" + Arrays.toString(grades) + "\nAre they correct? (Y/N)");
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            String holdYN = keyboard.nextLine();
            System.out.println(holdYN);
            if (holdYN.equals("Y") || holdYN.equals("y")) {
                break;
            } else if (holdYN.equals("N") || holdYN.equals("n")) {
                System.out.println("Please enter the proper grades.");
                main(null);
            }
            System.out.println("Invalid input. \nTry Y or N.");
        }

//        Printing out the average grade
        int average = sum / amountOfGrades;
        System.out.println("------------------------------------------");
        System.out.println("Your average quiz grade is: " + average);
        System.out.println("------------------------------------------");

//        Evaluate the letter grade
        if (90 <= average && average <= 100) {
            letterGrade = "A";
        } else if (80 <= average && average <= 89) {
            letterGrade = "B";
        } else if (70 <= average && average <= 79) {
            letterGrade = "C";
        } else if (60 <= average && average <= 69) {
            letterGrade = "D";
        } else if (0 <= average && average <= 59) {
            letterGrade = "F";
        }

        //    Output letter grade
        System.out.println("Your letter grade is: " + letterGrade);
        System.out.println("------------------------------------------");
        System.out.println("Return to Main Menu (1) or Exit Program (2)");
        while(true){
        Scanner exit = new Scanner(System.in);
        int holdEnd = exit.nextInt();
        if (holdEnd == 1) {
            solution.main(null);
        } else if (holdEnd == 2) {
            System.exit(0);
        }
        System.out.println("Invalid input. \nYou can only enter 1 or 2! ");
        }
    }
}

