// items that will be used throughout scripts
const submit = document.getElementById('submit');
let required = [0, 0, 0];
const names = ['Name', 'Email', 'Feedback'];
let notify = "";
let items = ""

// Adds an eventListner to the submit button on the Feedback Form
submit.addEventListener('click', function(e){
    // Runs functions below to make sure that they are filled out
    checkName();
    checkEmail();
    checkFeedback();
    // Runs a loop and returns items that are incomplete
    for (let i = 0; i < required.length; i++){
        if (required[i] >= 1){
            items += names[i];
            if (i == required.length - 1){
                items += "!"
            } else {
                 items += ", "
            }
        } 
    }
    // Builds and runs the notify for incomplete items
    notify += notify.concat("Please fill out the required boxes: ", items)
    if ((notify.includes("Name")) || notify.includes("Email") ||                             notify.includes("Feedback")){
        alert(notify);
        notify = "";
        items = "";
        required = [0, 0, 0];
        // Prevents the submit from submitting
        e.preventDefault();
    } else {
        // Builds values for all form items
        const name = document.getElementById('name').value;
        const email = document.getElementById('email2').value;
        const phone = document.getElementById("phonenumber").value;
        const feedback = document.getElementById('feedback').value;

        // Appends values into an object
        const customerFeedback = {
            name, email, phone, feedback
        };

        // Sets the values into the local storage using the name as the key
        const keyValue = name;
        localStorage.setItem(keyValue, JSON.stringify(customerFeedback));

        // Sends an alert to the user that the feedback was submitted
        alert('We will be in touch shortly ' + name + '!');
    }
});
// Starting functions used
// This function will make sure the name is filled out
function checkName(){
    const namebox = document.getElementById('name');
    if (!(namebox.value.length > 0)){
        required[0] = 1
    }
};
// This function will make sure the email is filled out
function checkEmail(){
    const emailbox = document.getElementById('email2');
    if (!(emailbox.value.length > 0)){
        required[1] = 1
    }
}
// This function will make sure the feedback is filled out
function checkFeedback(){
    const Feedback = document.getElementById('feedback').value;
    if (feedback.value == ""){
        required[2] = 1;
    }
}