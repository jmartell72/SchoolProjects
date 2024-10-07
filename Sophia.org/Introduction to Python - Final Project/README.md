<h1>Introduction to Python - Final Project</h1>

<h2>- Memory Game</h2>

<!-- This is used for my webpage which you can check out at: https://jmartell72.github.io/-->
<div id="carouselHolder"></div>

<h3>Created with Python3</h3>
<h4>About this Project</h4>

<h5 id="intro">Introduction</h5>
<p class="introP">This was a very fun project to code. I just had a feeling while coding this project that everything just seemed to <b><i>click</i></b>. I had a pretty unlimited boundary in coding this project and wanted to create a program that is both logically smart and also usable every day. There are still mistakes and places to correct the code, but let me explain it first.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="explanation">Code Explanation</h5>
 
<p class="explanationP">
 
 In the beginning of the code, I start creating the systems that will be used to generate the board for the user based on the settings chosen in the program. The `createNewBoard` is dependent on the `buildNumberSystem` function and is the basis of the board used. 

The `buildNumberSystem` takes the amount of cards that are saved in settings, duplicates that value, and then inserts it into a list to create pairs. The `createNewBoard` takes the `numberSystem` built and creates a set number of rows based on those values (only 10 cards per row). It then takes the newly created board and inserts 'Row' into the first index of every list and '|' into the second index for formatting. `createNewboard` then creates a brand new Column list and another list that contains '--' for formatting. It takes the two newly created lists and stacks them onto the top of the board for a fully formatted program.

`obscureBoard` takes a list of foundCards, the board that was built (could be already obscured or not), and a copyBoard that contains a hard copy of all the values of the board. The function will search copyBoard for the next value in the foundCard list and changes its board value to '..' if found. It then returns the board once it has iterrated through all of the foundCards values.

`revealedCards` takes a new obscuredBoard, the actual board being used, and the two cards selected by the user. It then searches the board for the two coordinates selected and shows the values for that card. It then compares `card1BoardValue` to `card2BoardValue` and returns if the match is true or not.</p>

<hr width="70%" border="1px solid black">
<img id="main" src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Python%20-%20Final%20Project/imgs/Memory_Game_Main_Menu.png?raw=true" alt="Main Menu screen" height="250">

<p class="explanationP">
 
Moving down into the `game()`, there are values that are set as function global variables for the entire program to use. The `mainMenu()` contains the, you guessed it, Main Menu. If Settings was somehow bypassed, it will just greet the user as defaultUser and then requests them to select a menu option. Based on the user's choice, it will run the appropriate function of the program.

`reloadSettings()` is a function that will open the settings file and then update the global variables based on the files contents. If the settings file is formatted improperly or is not found, it will re-run the setup function.

`setup()` is a function that updates the global variables and settings files based on prompts from the user. It has logic to make sure that the cards selected are within the parameters of less than 100 cards and the card value chosen is a multiple of 10. Based on the number of cards chosen, it will calculate a difficulty value (ex. `easyCalc`) and then ask the user for either: 'Easy', 'Medium', or 'Hard'; it sets the `difficultyValue` based on these values. Finally, it will open the settings.data file (create if it does not exist) and then writes the settings and returns to the mainMenu.<p>

<hr width="70%" border="1px solid black" class="partialBorder"> 
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Python%20-%20Final%20Project/imgs/Memory_Game_Main.png?raw=true" alt="Main Game screen" height="250">

<p class="explanationP">
 
 `newGame()` is the meat and bones of this program and is where the real magic happens. It sets a `consoleClear()` at the top of the program that checks which OS the user is using and will run the appropriate `clear()` to clear the console for that specific OS when the function is called. The next portion of the code sets some inbuilt values based off of the global variables for easier use. 

`newGame()` uses a while statement to continuously run the program until all the lives are exhausted. The top of the loop will print an `obscureBoard` and then sets a variable, which will be used as a verification based on the board size to make sure columns that the user selects are within bounds. The `formatter()` local function will format any coordinates passed into it into a universal format and then returns those coordinates to the variable assigned.</p>

<hr width="70%" border="1px solid black" class="partialBorder">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Python%20-%20Final%20Project/imgs/Memory_Game_Errors.png?raw=true" alt="Errors screen" height="250">

<p class="explanationP">
 
 The program moves into another `while` loop in order to make sure the coordinates the user entered are within bounds, `card2` is not a duplicate of `card1`, and if a string is entered that cannot be formatted, it will request that the card's coordinates be re-entered. This loop will also catch a `sys.exit()` and then exit the program.

The program then sets a variable `obscure` to be an obscured board and then runs `revealedCards()` and prints out the new obscured board. It evaluates if match is true; if true, it will notify the user and request the user to enter any key to move on. Once moved on, it will clear the console and check to see if foundCards matches all card values. If it does match, it will break the while loop and run the win script below. If match is false, it will deduct a life, request the user enter any key to continue, and then continue the program.</p>

<hr width="70%" border="1px solid black">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Python%20-%20Final%20Project/imgs/Memory_Game_Lose.png?raw=true" alt="Lose screen" height="70">

<p class="explanationP">The encompassing while loop evaluating lives will exit if lives is less than 1 or if it is broken by winning. The final portions of the program will evaluate if win is equal to True. If it is, it will notify the user of how many lives are left and that they won; if not, it will notify the user they lost. It enters another while loop to determine if the user would like to return to the mainMenu or exit.

The bottom of the `game()` function contains code used to start the program. It calls its local `reloadSettings()` function to update the global variables and then starts the main menu. The very bottom of the script starts the game function with `game()`.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="reflection">Reflection</h5>
<p class="reflectionP">I feel like this program is pretty well formatted for an Introduction class. If I had to change something, I would move the functions called at the top of the program that are used to create a new board into its own script in order to better structure this program for Object-Oriented Programming. I did very well on this project and received an <b>A</b> on it. The game's difficulty would most likely need to be revised in order to be more fair, but it would require a couple of users for testing, which I did not have access to.</p>
