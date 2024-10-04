drinkDetails = ""
drink = input(
    'What type of drink would you like to order?\nWater\nCoffee\nTea\nEnter your choice: ')
if drink == "Water":
    drinkDetails = drink
    temperature = input("How would you like your water? Hot or Cold: ")
    if temperature == "Hot":
        drinkDetails += ", " + temperature
    elif temperature == "Cold":
        drinkDetails += ", " + temperature
        ice = input("Would you like ice? Yes or No: ")
        if ice == "Yes":
            drinkDetails += ", Ice"
    else:
        drinkDetails += ", unknown temperature entered."
elif drink == "Coffee":
    drinkDetails = drink
    decaf = input("Would you like decaf? Yes or No: ")
    if decaf == "Yes":
        drinkDetails += ", Decaf"
    milkCream = input("Would you like Milk, Cream or None: ")
    if milkCream == "Milk":
        drinkDetails += ", Milk"
    elif milkCream == "Cream":
        drinkDetails += ", Cream"
    sugar = input("Would you like sugar? Yes or No: ")
    if sugar == "Yes":
        drinkDetails += ", Sugar"
elif drink == "Tea":
    drinkDetails = drink
    teaType = input("What type of tea would you like? Black or Green: ")
    if teaType == "Black":
        drinkDetails += ", " + teaType
    elif teaType == "Green":
        drinkDetails += ", " + teaType
else:
    print("Sorry, we did not have that drink available for you.")
print("Your drink selection: ", drinkDetails)
