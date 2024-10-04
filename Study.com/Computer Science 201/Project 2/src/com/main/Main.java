package com.main;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Call the MainMenu upon startup for easier split ups
		MainMenu();
	}

	public static void MainMenu() {
		// Global options for easy editing and access later on
		Scanner input = new Scanner(System.in);
		char[] states = "Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina, North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina, South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia, Wisconsin, Wyoming". toLowerCase().toCharArray();
		// Initial input menu that will be called upon each restart of the program
		System.out.println("Select an option!\n1.Display the text\n2.Search\n3.Exit Program");
		// Capturing the menu option
		int userInt = input.nextInt();
		input.nextLine(); // Consumes the newline character

		// First choice to list all the states
		if (userInt == 1) {
			System.out.println("Welcome! Here are the states !\n"+ new String(states));
			MainMenu();
			// Second option that will run the search
		} else if (userInt == 2) {
			System.out.print("Please input a portion of the name of the state: ");
			// Input catcher and conversion to lowercase
			String userInput = input.nextLine().toLowerCase();
			// Creates a char array from the user input
			char[] inputChar = userInput.toCharArray();
			// Runs the search on the string
			Search.search(states, inputChar);
			MainMenu();
			// 3rd option to exit the program
		} else if (userInt == 3) {
			System.exit(0);
			// return to the main menu in case an incorrect option was chosen
		} else {
			System.out.println("Whoops, that was not a valid choice - try again !");
			MainMenu();
		}
	}
}