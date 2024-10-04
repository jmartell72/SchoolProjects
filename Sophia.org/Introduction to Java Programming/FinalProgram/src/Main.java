import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// creates a shopping cart function
	public static String shoppingCart(Pantry pantry){
		// Creates an array list of the pantry's values. ArrayList used to allow for easy iteration
		ArrayList<Ingredient> currentIngredient = pantry.getPantry();
		// Creates a new string builder for the new string
		StringBuilder output = new StringBuilder();
		// loops over the arraylist
		for (Ingredient ingredient: currentIngredient){
			// checks each ingredient to see if it needs to be purchased
			if (ingredient.getQuantity() < ingredient.getRequiredAmount()) {
				String var = ingredient.toString();
				// adds ingredients that are lower than min value to the string
				output.append(var).append("\n");
			}
		}
		// returns the ingredients needed
		return output.toString();
	}

	public static void main(String[] args) {
		// Values that will be used throughout this program
		Pantry pantry = new Pantry();
		Scanner input = new Scanner(System.in);

		// Lists the shopping cart at every start; uses logic to determine if empty or not
		if (shoppingCart(pantry).isEmpty()){
			System.out.println();
			System.out.println("Your Shopping Cart is empty!");
		} else {System.out.println(shoppingCart(pantry));}

		// starts the menu
		while (true){
			System.out.println();
			// main menu header that will be shown during every main screen
			System.out.println("Welcome to the Pantry! How may I help you?\n1. Add new ingredients to your pantry\n2. Update an items quantity\n3. Remove an item from the pantry\n4. Save the Pantry to filesystem\n5. Print the Current Shopping Cart\n6. Print the Entire Pantry\n7. X to exit");

				// makes sure that whatever is entered is lower cased
				String userMenuInput = input.nextLine().toLowerCase();
				switch (userMenuInput){
					//New ingredients
					case "1":
						// Sets variables to be used to hold the new ingredients
							String name = "";
							int quantity = 0;
							int required = 0;
							String size = "";

							// Starts the loop that will add each ingredient until exited
						while(true) {
							System.out.println();
							System.out.println("Please enter your new ingredients name: (Press enter at this time to update your pantry with the new ingredients)");
							// sets the name to the users input
							name = input.nextLine();
							// checks to see if item already exits
							if (!(name.isEmpty()) && pantry.checkPantry(name)) {
								System.out.println();
								// queries if quantity should be updated
								System.out.println("Seems like this item exists in your pantry. It has a quantity of: " + pantry.getQuantity(name) + ". Would you like to update its quantity? Y to update with new quantity or N to disregard (default).");
								try {
									String newUserInput = input.nextLine();
									// if user wants to update the ingredient it will run this
									if (newUserInput.equalsIgnoreCase("Y")) {
										System.out.println("What would you like the new quantity to be?");
										int newUserInput2 = input.nextInt();
										// users next input is then requested to be the new quantity, this will then revert to the top of this while and request another ingredient
										pantry.updateQuantity(name, (newUserInput2));
									}
									// if anything other than y is entered, nothing wil lbe updated
								} catch (Exception e) {
									System.out.println("Disregarding this item!");
								}
								// checks to make sure name is not empty
							} else if (!(name.isEmpty())) {
								// enters the new quantity of the new item
								System.out.println("Please enter your new ingredients quantity in stock currently: (Numbers only!)");
								// verifies that numbers only will be inputted
								while (true) {

									try {
										quantity = input.nextInt();
										break;
									} catch (Exception e) {
										System.out.println("Whoops! Numbers only!");
									}
								}

								// enters the new required amount of the new item
								System.out.println("Please enter your new ingredients required stock amount: (Numbers only!)");
								while (true) {
									try {
										required = input.nextInt();
										break;
									} catch (Exception e) {
										System.out.println("Whoops! Numbers only!");
									}
								}

								//enters the new size of the item
								System.out.println("Please enter your new ingredients size: ");
								input.nextLine();
								size = input.nextLine();
								// makes sure size is not empty
								while (size.isEmpty()){
									System.out.println("Whoops, please enter a size!");
									size = input.nextLine();
								}
								//adds the new ingredient just build to the pantry
								pantry.addIngredients(new Ingredient(name, size, required, quantity));
							// if name is blank, it will exit
							} else {break;}
						}
						// if something crazy happens will still exit
						break;
					//Update Items Quantity
					case "2":
						while(true) {
							// starts this option requesting the name
							System.out.println("Please enter the name of the item you want to update the quantity of: (x to exit)");
							String newName = input.nextLine();
							// if name is blank will loop until it has a value
							while (newName.isEmpty()){
								System.out.println("Please enter a real name: (x to exit)");
								newName= input.nextLine();
							}
							//Checks the pantry against the new name; if valid, will continue
							if (pantry.checkPantry(newName)) {
								// checks the tense of the name for a little bit of dynamic coding
								String tense = "";
								if (pantry.getName(newName).toLowerCase().endsWith("s")) {
									tense = "have";
								} else {
									tense = "has";
								}

								// Outputs the name along with its quantity. requests for a new quantity to be entered
								System.out.println(pantry.getName(newName) + " " + tense + " a quantity of " + pantry.getQuantity(newName) + "! What would you like the new quantity to be?");
								int newQuantity = input.nextInt();
								input.nextLine();
								// updates the item with a new quantity
								pantry.updateQuantity(newName, newQuantity);
								break;
								// If not valid, will see if the input was x, if it is, will exit
							} else if(newName.equalsIgnoreCase("x")){
								break;
								// if the name does not match either condition, will let you know that you have to try again and restarts at the top of the while loop
							} else {
								System.out.println("Whoops that item does not exist! Try again");
							}
						}
						break;

					// Remove an Item from the pantry
					case "3":
						while(true) {
							// requests the name of the item
							System.out.println("Please enter the name of the item you wish to delete: (x to return to main menu)");
							String newName = input.nextLine();

							// if the pantry contains the named item
							if (pantry.checkPantry(newName)) {
								// makes sure the item should be deleted
								System.out.println("Are you sure you wish to delete " + pantry.getName(newName) + "? (Y or N)");
								String confirm = input.nextLine();

								// if it is confirmed
								if (confirm.equalsIgnoreCase("y")) {
									pantry.removeIngredient(newName);
									// queries if the pantry should be saved
									System.out.println("Would you like to save the pantry? (Y or N");
									String confirm1 = input.nextLine();
									// if confirmed, will save
									if (confirm1.equalsIgnoreCase("Y")) {
										pantry.savePantry();
									}
									// if anything other than y entered, will not delete the item
								} else {
									System.out.println("Nothing deleted!");
								}
								// exits
								break;
								// if newName is an x, will exit
							} else if (newName.equalsIgnoreCase("x")) {
								break;
								// if name does not match either condition, will exit
							} else {
								System.out.println("Enter a valid name please!");
							}
						}

					// Manually saves the cart
					case "4":
						System.out.println();
						// lets the user know that the pantry is save
						System.out.println("Pantry Saved!");
						// saves the pantry to file
						pantry.savePantry();
						break;

					// Print Current Shopping Cart
					case "5":
						System.out.println();
						//prints the current shopping cart by calling the function
						System.out.println(shoppingCart(pantry));
						break;

					// Print Entire Pantry
					case "6":
						System.out.println();
						// prints out the entire pantry's contents
						System.out.println(pantry);
						break;

					// Exit
					case "x":
						//confirms if the pantry should be saved prior to exit
						System.out.println("Thanks for visiting the pantry! Would you like to save? (Y to save)");
						String confirm = input.nextLine();
						// checks if confirm is a y
						if (confirm.equalsIgnoreCase("Y")) {
							System.out.println("Pantry Saved!");
							// saves the pantry
							pantry.savePantry();
						}
						// if anything other than y entered, will not save the pantry and exits no matter what
						System.out.println("Goodbye!");
						System.exit(0);

					default:
						System.out.println("That input was invalid! Try again!\n");
				}
		}
	}
}