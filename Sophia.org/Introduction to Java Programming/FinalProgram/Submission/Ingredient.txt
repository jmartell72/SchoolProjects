public class Ingredient {
	// Placeholders for all elements of the Ingredient
	private final String name;
	private final String size;
	private final int requiredAmount;
	private int quantity;

	// Constructor that will upper case the first letter of the ingredient
	public Ingredient(String name, String size, int requiredAmount, int quantity){
		String u1 = name.substring(0, 1).toUpperCase();
		this.name = u1 + name.substring(1);
		this.size = size;
		this.requiredAmount = requiredAmount;
		this.quantity = quantity;
	}

	// Retrieves that ingredients name
	public String getName(){
		return this.name;
	}

	// Retrieves that ingredients size
	public String getSize(){
		return this.size;
	}

	// Retrieves that ingredients quantity
	public int getQuantity(){
		return this.quantity;
	}

	// Retrieves that ingredients Require amount
	public int getRequiredAmount() {
		return this.requiredAmount;
	}

	// Updates the ingredients quantity
	public void updateQuantity(int num){
		this.quantity = num;
	}

	// Overwrites how an item is displayed when outputted.
	@Override
	public String toString(){
		return name + ": Amount in stock: " + quantity + ", Amount Required: " + requiredAmount + ", Size: " + size;
	}
}