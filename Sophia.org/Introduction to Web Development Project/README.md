<h1>Web Devlopment Final Project</h1>

<h2>- Book Haven Website</h2>

<!-- This is used for my webpage which you can check out at: https://jmartell72.github.io/-->
<div id="carouselHolder"></div>

<h3>Created with HTML, CSS, and JavaScript</h3>
<h4>About this Project</h4>

<h5 id="intro">Introduction</h5>
<p class="introP">This was a website that was designed for a client named Book Haven Bookstore. This was a fairly straight-forward project, but Sophia did have a lot of functionality they wanted baked into the website.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="explanation">Code Explanation</h5>
 
<p class="explanationP">
 
This website is built to be a static webpage since it was a class for beginners but does have some responsiveness in its styles to make it more functional. For a beginning website, it functions decentely and worked out well for the class. The webpage requirements were that it needed to have 4 pages: a Homepage (`index.html`), a Gallery Page for a shopping cart (`Gallery.html`), an About Us Page (`AboutUs.html`), and a custom webpage for the company called Community (`Community.html`). I received an A+ on this website and the only thing missing was additional accessibility items.</p>

<hr width="70%" border="1px solid black">
<img id="main" src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/HomePage.png?raw=true" alt="HomePage" height="250">

<p class="explanationP">
 
The `HomePage` is the entrance to my clients webpage and includes a soft opening at the bottom for customers. It includes 4 `promobox`s at the top of the page that the client can modify to display new items that are featured every month. These `promobox`s are setup with Flexbox, so they are responsive to the webpage sizing changes. Each `individualbox` is also setup with Flexbox in order to properly format the images and then the text. The `img` is included inside of an `a` link that will take the customer to the proper item on the `Gallery` webpage. Finally, at the bottom of the `HomePage`, there is a `softIntro` that is a small section of the `AboutUs` and contains a redirect to the About Us webpage.<p>

<hr width="70%" border="1px solid black" class="partialBorder"> 
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/Gallery.png?raw=true" alt="Gallery Page" height="250">

<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/shoppingCart.png?raw=true" alt="Shopping Cart Page" height="350">


<p class="explanationP">

This webpage is the `Gallery` webpage and is the storefront for the customer. Like the `HomePage`, the items in this page use Flexbox in order to be responsive. The inside of each `individualbox` is very similar to the `Homepage`s contents, but these boxes list the image at the top of the flexbox. The `button` is inside of the div with an id of `addtocart`; it has an `onclick` listener that runs the function `addItemToCard` that is listed in `gallery.js`. 
 
This `gallery.js` script contains a variable `itemsInCart` that contains a listing of each item on the webpage. This will have to be manually updated every time a new item is added to the store. The `addItemToCard` function will query this variable and adds the item to the cart variable `totalCart`. Finally, it also sets the sessionStorage to contain this item, so if the webpage is closed and reopened, the cart will still be populated.

The meat and bones of the `Gallery` webpage lie in the cart functioning and is the most complex aspect of this website. In the HTML for this webpage, you can see that the `cart` is hidden from the start. The `gallery.js` script adds a listener to the `viewCart` button that will add CSS for the main content that will blur it out but still be visible. The cart is then brought into focus by removing the `hidden` class. The listener finally creates the cart by running the function `createCartItem`. 

The `createCartItem` function creates the cart itself. It takes every item in the `totalCart` variable and adds a new div that pulls in the image, the item name, and the quantity of the item. The `addEventListener` attached to the `clearCart` button checks to see if the cart is blank or not. If it is, it will alert the customer that there are not items in the cart; if not, it runs the `destroyCart()` function, which sets the cart to state "Cart is Empty" and deletes all of the items in the cart, and then makes sure to set the sessionStorage to be blank also.

The last item of note is the `processOrder` button, which completes the transaction. Once this button is clicked, it first states "Cart is Empty" if the cart is empty. If the cart has items, it thanks the customer for their order and then runs the aforementioned `destroyCart()` function. I do have a comment in this code where I would revise it to then have a full shopping cart PHP script that would connect to a backend SQL server.</p>

<hr width="70%" border="1px solid black" class="partialBorder">

<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/AboutUs.png?raw=true" alt="About Us" height="250">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/Customer_Feedback.png?raw=true" alt="Customer Feedback" height="250">

<p class="explanationP">

The `AboutUs` webpage contains the information regarding the shop itself. The top text is just a placeholder but would be where I would recommend adding 4 or 5 paragraphs about the book store. I would also include the address and contact information for the store in this section.

The next section down is the Books of the Month section and would contain the owner's or manager's recommended books for that month. This uses a simple table to hold the few items, and the items themselves contain links to the respective `Gallery` page.

Below the Books of the Month, there is a section for customer feedback. This was required by the project guidelines and has strict requirements. All fields are required to be filled out; HTML is the verifier for this, and the form must use `post` to issue the form. There is an event listener added to the `submit` button that is listed in `aboutus.js` and will validate the information the user submits via JavaScript. If any of the information does not meet parameters, JavaScript will `alert` the customer as to what information is missing. It builds this `alert` dynamically based on the requirement(s) that was not met.

If all of the form boxes were correct, it will take all of the values and save them in a localStorage item. This was a requirement from the class, and I would not recommend saving this information to a customer's computer.</p>

<hr width="70%" border="1px solid black">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/Community%20Page.png?raw=true" alt="Community Page" height="250">

<p class="explanationP">

The `community` page is a very simplistic page. It contains a `div` at the top that holds the contents for the header box. This box is being used currently to announce the next month's book. The image links to the proper gallery page so the customers can order the correct book. Below the image, there is room for the owner/manager to talk about discussion points on the new book that will be brought up next month. 

Below the header `div`, there is another `div` that contains all the information related to the book club discussion. At the top of the Book Club Discussion `div`, we see another box similar to the header box. The difference is that this information pertains to the current book. Below that is a statically generated list with placeholders for Book Club patron's reviews. 

Once this website was OK'd for its layout, I would use a combination of JQuery using AJAX, PHP on the server, and then a SQL server to hold the comments inserted by the user.</p>

<hr width="70%" border="1px solid black">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/nav%20footer.png?raw=true" alt="Nav and Footer" height="250">
<img src="https://github.com/jmartell72/SchoolProjects/blob/main/Sophia.org/Introduction%20to%20Web%20Development%20Project/imgs/mobilenav.png?raw=true" alt="Mobile Nav" height="250">

<p>

The final topic of interest is on the navbar and footers. The navbar is very responsive and shrinks into a hamburger menu using CSS that is listed in `header,nav,footer.css`. The bottom of the script includes the appropriate `@media all and (min-width: 655px)` which will make the mobile menu vanish and set the proper styling for the full menu.

When the hamburger icon is hovered over on mobile displays, it will display the `mobilemenu`. This consists of an unordered list that moves all of the navigation links from horizontal to vertical on mobile display. 

The footer is a static container that uses Flex in order to better layout all 3 tiers that it contains. The footer first contains all of the social media links related to the Book Store. It also contains the newsletter signup that was required by the project. The project also required the `subscribe` button to use JavaScript, so there is a separate script just for this functioning listed as `subscribe.js`. Finally, there is a LEGAL link that can be expanded out, or like the other options shown, it can just link to a different website.</p>

<hr style="width:100%;border:1px solid black" class="partialBorder">

<h5 id="reflection">Reflection</h5>
<p class="reflectionP">This project was just a beginning project, so there is lots of room to expand that I can identify. The functioning on the Mobile Menu is not proper and would need to be tweaked. I would move the nav and footers to their own separate HTML and generate them dynamically (like my <a href="https://jmartell72.github.io/">resume website</a>). Furthermore, I have identified places where static content does suit the purposes it is designed for and would need to have dynamic content. Overall, my design skills improved by working on this project, and I did learn how to properly use <a href="Figma.com">Figma.com</a>.</p>
