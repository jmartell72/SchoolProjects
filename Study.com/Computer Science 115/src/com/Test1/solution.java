package com.Test1;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        System.out.println("Welcome! Please select an option:\n1. Print out code for assignment for review\n2. Enter into program\n3. Exit Program");
        while (true) {
            Scanner welcome = new Scanner(System.in);
            int welcomeOpt = welcome.nextInt();
            if (welcomeOpt == 1) {
                printCode.main(null);
            } else if (welcomeOpt == 2) {
                program.main(null);
            } else if (welcomeOpt == -1) {
                System.out.println("Exiting Program");
                System.exit(0);
            }
            System.out.println("Invalid input. \nYou can only enter between 1 and 3. Try again");
        }
    }
}