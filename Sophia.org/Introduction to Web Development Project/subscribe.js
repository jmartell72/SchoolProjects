// function to check if the email box is blank or not
function subscribing(){
    if(document.getElementById("email").value === ""){
        alert("Please enter your email");
        return;
    }

    alert("Thank you for subscribing!")
}