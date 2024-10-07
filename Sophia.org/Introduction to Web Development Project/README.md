<h1>Web Devlopment Final Project</h1>

<h2>- Book Haven Website</h2>

<!-- This is used for my webpage which you can check out at: -->
<div id="carouselHolder"></div>

<h3>Created with HTML, CSS, and JavaScript</h3>
<h4>About this Project</h4>

<h5 id="intro">Introduction</h5>
<p class="introP">This was a website that was desgined for a client name Book Haven Bookstore.  This was a fairly straight forward project but Sophia did have a lot of functionality they wanted baked into the website.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="explanation">Code Explanation</h5>
 
<p class="explanationP">This website is built to be a static webpage since it was a class for beginners. For a beginning website, it functions decentely and worked out well for the class. The webpage requirements were that it needed to have 4 pages: a Homepage (`index.html`), a Gallery Page for a shopping cart (`Gallery.html`), an About Us Page (`AboutUs.html`), and a custom webpage for the company called Community (`Community.html`). I received an A+ on this website and the only thing missing was additional accessibility items.</p>

<hr width="70%" border="1px solid black">
<img id="main" src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/HomePage.png?raw=true" alt="HomePage" height="250">

<p class="explanationP">The `HomePage`  program starts off by defining a new `shoppingCart` function that will add any ingredient that has a quantity that is less than the desired quantity. Moving into the `main` function, we see the pantry get initialized and the `shoppingCart` function is next called so every start up you can see the items you are low on. 

The main menu then starts and requests the user to enter a option. It will check logically if an appropriate action was chosen through a switch/case statement. The default option is to just output that the input was invalid and restarts the statement.<p>

<hr width="70%" border="1px solid black" class="partialBorder"> 
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Java%20Programming/FinalProgram/imgs/Option_1.png?raw=true" alt="Option 1" height="250">

<p class="explanationP">
Once Option 1 is chosen, the first case is started. It sets variables that will be used in the case statement as placeholders. It then starts a 

`while(true)`  loop to allow for unlimited ingreients to be added. It requests the ingredients name and then accepts the next input from the user.

It then runs a logical check to make sure the item does not exist. If it does exist, it return the quantity of the item via `pantry.getQuantity(name)`.  `HomePage` The pantry class implements the ingredient class so this function will call the pantry's `getQuantity()` function that will in turn use the item itself's class function to return its quantity. With this return, it will also ask if the user wants to update the ingredients quantity or not. If the user chooses yes, they will be allowed to update the ingredient's quantity.

If the name is not empty, it will then move on to the other inputs. It will ask for the new quantity, new required stock amount, and ingredients size, in order. Finally it will use the pantry's class again to `addIngredients(new Ingredient(name, size, required, quantity))`. If the user enters a <i>blank</i> stroke, it will return to the main menu.</p>

<hr width="70%" border="1px solid black" class="partialBorder">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Java%20Programming/FinalProgram/imgs/Option_2.png?raw=true" alt="Option 2" height="250">

<p class="explanationP">This is Option/Case 2 and it uses another `while(true)` loop. It then asks for the name of the ingredient that should be updated. If the name is blank, the loop will keep requesting a real name be entered. 

The program will then request if the ingredients name is real by running `pantry.checkPantry(newName)` which will return true if the ingredient does exist. It runs a quick syntax check to allow for the next questions to be more dynamic. It runs the next prompt querying the user what the new quantity should be. Once and input is entered, the statement runs `pantry.updateQuantity(newName, newQuantity)` which will in turn use the ingredient class to update its quantity.</p>

<hr width="70%" border="1px solid black">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Java%20Programming/FinalProgram/imgs/Option_3.png?raw=true" alt="Option 3" height="250">

<p class="explanationP">Option/Case 3 uses another `while(true)` loop to make sure the code executes appropriately. Like the previous case, it requests the user enter a name and uses the `pantry.checkPantry(newName)` function to make sure that the ingredient exists. It it exists, the script queries the user a second time to make sure that they wish to delete the ingredient. 

If the user enters a "Y", the pantry removes the ingredient with the `pantry.removeIngredient(newName)`. It then asks the user if they would like to save the pantry or not. If the user again selects "y", the pantry will save with the `pantry.savePantry()` function. No matter the outcome of the users second input, the program will then `break`.

If the name of the ingredient the user is equal to a <b>x</b>, the program will immediately break. And then finally, if the name does not match an ingriedent and is not a sole <b>x</b>, the program will ask for a valid name and return to the start of the case.</p>

<hr width="70%" border="1px solid black">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Java%20Programming/FinalProgram/imgs/Option_6.png?raw=true" alt="Option 6" height="250">

<p>Option/Case 4 will run the function `pantry.savePantry()`. If you look inside Pantry.java, you will find the `savePantry()` and `writeToFile()` functions. The `savePantry()` function is a public wrapper for the `writeToFile()`; this allows the save function to be secure. 

Inside of the `writeToFile()` function, there is the code that will save the program to a file for recall at later use. The function uses a try catch in case any issue occurs during the saving process. The file being written to ends in <b>.xmnd</b> which will be a more secure file. 

The program uses `stream()` to output the object eaiser. The `stream()` gather up all of the values in the key and appends them together with a <b>,</b>. The reader function uses this <b>,</b> to determine the differences in the values. The program then uses files to push the newly created string into the file.
  
The final 2 Option/Case statements are pretty similar in function. Case 5 just runs the shopping cart on the pantry to make sure it gets an up-to-date version of the pantry. Case 6 will print out the pantry item itself.

If an <b>x</b> is entered on the main menu, it will run Case x. This thanks the user for visiting the pantry and queries if the user wants to save. If the user wishes to save and enters <b>y</b> the program runs the `panty.savePantry()` to save the pantry and then exits.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="reflection">Reflection</h5>
<p class="reflectionP">I feel this program suits its purposes adequately, but there are places for strengthening the program. There are a few spelling and syntax mistakes that would provide a better product for the user. The addition loop could benefit for a more simplified interface. Finally, I would also revise this to include an option to manually upload a pantry. Overall, I am please with my work and am glad for the experiences building this program gave me.</p>
