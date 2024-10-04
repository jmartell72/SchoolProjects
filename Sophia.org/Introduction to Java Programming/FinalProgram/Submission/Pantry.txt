import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public class Pantry{
	// Starts pantry has a hashmap for fast querying
	private HashMap<String, Ingredient> pantry;

	//default constructor
	public Pantry() {
		// selects the new pantry file that will be located in the jar root directory
		File p = new File("pantry.xmnd");
		// makes sure the pantry exists
		if (p.isFile()) {
			// if the pantry exists, sets its size and then initializes the new pantry to fill
			long size = p.length();
			pantry = new HashMap<>();
			// makes sure that the pantry file has contents
			if (size != 0) {
				try {
					// starts a new file reader
					BufferedReader br = new BufferedReader(new FileReader(p));
					String line;
					// sets the line to the next line in the file that is not null
					while ((line = br.readLine()) != null) {
						//splits the file up into individual HashMap Key-Value pairs
						String[] split = line.split(";");
						// loops through the Key-Value pairs
						for (String string: split){
							//further splits the Key-Value pairs down into individual values
							String[] split2 = string.split(",");
							//Adds the new values in the format required of the pantry HashMap<String, Ingredient>
							pantry.put(split2[0], new Ingredient(split2[0], split2[1], Integer.parseInt(split2[2]), Integer.parseInt(split2[3])));
						}
					}
					// after empty, will close the reader
					br.close();
					// if above fails, will catch the exception
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// Code does not work without this
		} else {
			pantry = new HashMap<>();
		}
	}

	// Adds an ingredient to the pantry
	public void addIngredients(Ingredient ingredient){
		pantry.put(ingredient.getName(), ingredient);
		savePantry();
	}

	// Removes an ingredient from the pantry
	public void removeIngredient(String name){
		//makes sure that the name provided will match to a name (if it exists) in the pantry
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		//runs the remove conditions
		if (pantry.containsKey(name)) {
			this.pantry.remove(name);
		}
	}

	// Updates the quantity of an ingredient in the pantry
	public void updateQuantity(String name, int quantity){
		//makes sure that the name provided will match to a name (if it exists) in the pantry
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		//runs the update conditions
		if (pantry.containsKey(name)) {
			pantry.get(name).updateQuantity(quantity);
		}
		// saves the pantry afterwards
		savePantry();
	}

	// returns the pantry's values (individual ingredients)
	public ArrayList<Ingredient> getPantry(){
		return new ArrayList<>(this.pantry.values());
	}

	// Checks the pantry to see if an ingredient is inside
	public boolean checkPantry(String name){
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		return pantry.containsKey(name);
	}

	// Gets the quantity of the ingredient requested
	public int getQuantity(String name){
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		return pantry.get(name).getQuantity();
	}

	// Gets the name of the ingredient requested
	public String getName(String name){
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		return pantry.get(name).getName();
	}

	// Sets what will be displayed when the pantry is requested to be outputted to console
	@Override
	public String toString(){
		String returnString = "";
		// loops through each ingredient in the pantry
		for (Ingredient ingredient: pantry.values()){
			// Sets the string for each ingredient in the pantry
			returnString += "Ingredient name: " + ingredient.getName() + "; Ingredient Size: " + ingredient.getSize() + "; Ingredient Quantity on Hand: " + ingredient.getQuantity() + "; Required Amount to be in Stock: " + ingredient.getRequiredAmount() +"\n";
		}
		// Returns the entire pantry in String form.
		return returnString;
	}

	// Saves the pantry - used so the write to file is hidden
	public void savePantry(){
		writeToFile();
	}

	// The write to file function for the pantry
	private void writeToFile() {
			try {
				// sets the location of the new pantry
				File pantryFile = new File("pantry.xmnd");
				//will loop through the pantry for output
				String mapAsString = pantry.keySet().stream()
						//maps out the keys
						.map(key -> pantry.get(key))
						// maps out the values for the pantry so they can be inserted into the file
						.map(value -> value.getName() + "," + value.getSize() + "," + value.getRequiredAmount() + "," + value.getQuantity())
						// joins all of the values map together
						.collect(Collectors.joining(";"));
				// Writes the new formed string of concats to the file
				Files.writeString(pantryFile.toPath(), mapAsString, StandardOpenOption.CREATE);
				// catches any exceptions
			} catch (IOException e){
				System.out.println("Error occurred: " + e.getMessage());
			}
	}
}