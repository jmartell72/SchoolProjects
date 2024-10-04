// Sets up all buttons to be able to used later
const addToCart = document.getElementsByClassName("Addtocart");
const clearCart = document.getElementById("ClearCart");
const viewCart = document.getElementById("ViewCart");
const processOrder = document.getElementById("ProcessOrder");
const closeCart = document.getElementById("closeCart");
const cartItems = document.getElementById("itemsInCart");
//
// Label that will be used later
const products = "images/products/Client3_";
// Sets up the initial object of arrays for the cart to be able to respond to
var itemsInCart = {
    Book1: [products + "Book1.png", 0, "Brie Mine 4Ever"],
    Book2: [products + "Book2.png", 0, "Glory Riders"],
    Book3: [products + "Book3.png", 0, "Sorcerer's Shadowed Chronicles"],
    Magazine1: [products + "Magazine1.png", 0, "Ball Magazine"],
    Magazine2: [products + "Magazine2.png", 0, "Travel Magazine"],
    Magazine3: [products + "Magazine3.png", 0, "Eat Magazine"],
    Notebook: [products + "Notebook.png", 0, "Notebook"],
    Stickers: [products + "Stickers.png", 0, "Stickers"],
    ToteBag: [products + "ToteBag.png", 0, "ToteBag"]
};

// Sets the sessionStorage cart to either be the sessionStored cart or the basic blank cart object
let totalCart = JSON.parse(sessionStorage.getItem("totalCart")) || itemsInCart;
// Makes sure that if there was a saved sessionCart, totalCart is overridden.
itemsInCart = totalCart;

// Sets the listener for each add to cart button and adds an alert
Array.from(addToCart).forEach(function(cartItem) {
    cartItem.addEventListener('click', function() {
        alert("Item added to the cart");
    })
})

//Sets the listner for clear cart button to be clicked
clearCart.addEventListener('click', function() {
    // checks to see if cart contains any items or not. easiest way is to check html but could also be done with js
    if (cartItems.innerHTML.includes('<h2 style="font-size: 20px">Cart is Empty</h2>')) {
        alert('No items to clear');
    } else {
        // runs the destroy cart function to remove the html inside and set defaults to 0
        destroyCart();
        //alerts user that cart has been cleared
        alert('Cart cleared');
    }
});

// adds a listner to the process order button
processOrder.addEventListener('click', function() {
    // checks to see if cart contains any items or not. easiest way is to check html but could also be done with js
    if (cartItems.innerHTML.includes('<h2 style="font-size: 20px">Cart is Empty</h2>')) {
        alert('Cart is empty');
    } else {
        // lets the user know the item was placed
        alert('Thank you for your order');
        // php would be added here in order to process the order 
        // runs the destroy cart function to remove the html inside and set defaults to 0
        destroyCart();
    }
});

// adds a listener to the view cart button
viewCart.addEventListener('click', function() {
    // obscures the html in the background
    document.getElementById("everything").classList.add("bg-image");
    //unhides the cart and brings it into focus
    document.getElementById("cart").classList.remove("hidden");
    // builds the cart based on itemsInCart quantities
    for (let i = 0; i < Object.keys(itemsInCart).length; i++) {
        const item = Object.keys(itemsInCart)[i];
        if (itemsInCart[item][1] > 0) {
            createCartItem(item);
        }
    }
});

// adds a listener to the close cart button
closeCart.addEventListener('click', function() {
    // hides the cart again
    document.getElementById("cart").classList.add("hidden");
    // unobscures the html in the background
    document.getElementById("everything").classList.remove("bg-image");
    // sets the cart html back to the default
    cartItems.innerHTML = '<h2 style="font-size: 20px">Cart is Empty</h2>';
})

// starting script functions
//function for adding items to cart
function addItemToCart(itemName) {
    //updates the items quantity
    itemsInCart[itemName][1]++;
    // updates the sessionStorage cart
    totalCart = itemsInCart;
    sessionStorage.setItem("totalCart", JSON.stringify(totalCart));
}


// function to create the html for the cart item
function createCartItem(item) {
    // sets variables for forming the string
    const name = itemsInCart[item][2]
    const quantity = itemsInCart[item][1]
    const picFile = itemsInCart[item][0]
    // forms the html string
    const concat = ('<div class="cartItem"><img src="' + picFile + '"id="' + item + '" ><div class="desc"><h3>' + name + '</h3><p>Quantity: ' + quantity + '</p></div> ')
    // sets the inner html to blank if empty cart is being displayed
    if (cartItems.innerHTML.includes('<h2 style="font-size: 20px">Cart is Empty</h2>')){
    cartItems.innerHTML="";
    }
    // adds the new cart item on the end
    cartItems.insertAdjacentHTML("beforeend", concat);
}

// function to destroy the cart
function destroyCart(){
    cartItems.innerHTML = '<h2 style="font-size: 20px">Cart is Empty</h2>';
    // loops through the itemsInCart object and sets all quantities back to 0
    for (let i = 0; i < Object.keys(itemsInCart).length; i++) {
        const item = Object.keys(itemsInCart)[i];
        if (itemsInCart[item][1] > 0) {
            itemsInCart[item][1] = 0;
        }
    }
    // sets the sessionStorage cart back to default and makes sure to update the sessionStorage
    totalCart = itemsInCart;
    sessionStorage.setItem("totalCart", JSON.stringify(totalCart));
}

