//listening for the logout button to be clicked
document.getElementById("logout-button").addEventListener("click", logout);

//This function is called if the user clicks the Logout button
function Logout() {
    //remove the current-user stored in the local storage
    localStorage.removeItem("current-user");
    //redirect to the Login page
    window.location.href ="../login/login.html";
}

//Listening for the form submission
document.getElementById("submit-form").addEventListener("submit", attemptSubmit);

//this function will call when the submit button is pressed
function attemptSubmit(event){
    //This prevents the browser from refreshing
    event.preventDefault();
}

    //storing the values of the form into Local variables
    const type = document.getElementById("typeInput").value; //fields
    const description = document.getElementById("description").value; //fields
    const amount = document.getElementById("amount").value;  //fields

    //getting the current user ID from the Local storage
    const userId = localStorage.getItem("current-user");

    //checking to make sure the user is signed in
    if (!userId) {
        //redirect to Login if the user ID is not found in Local storage
        window.Location.href = "../login/login.html"
    } else if (description == "") {
        // staring the HTML div DOM object in a local variable
        const messageDiv = document.getElementById("message");
        //un-hiding the DOM element
        messageDiv.hidden = false;
        //Setting the failure text within the div
        //Again, using innerText instead of innerHTML to a alleviate security risks (specifically injection/cross-site scripting)
        messageDiv.innerText = "Please make sure you specify the amount you need reimbursed";
    } else 
        //creating a reimbursement object for the payload (this is what the controller endpoint is expecting)
        const reimbursement = {id:0, author:userId, description:description, type:type, amount:amount};
        //we must stringify the object for object parsing on the server to be successful
        const payload = JSON.stringify(reimbursement);
        // calling the global AJAX method in the 'server-request.js' file
        sendAjaxRequest("POST", "http://localhost:whatever server/reimbursements", payload, submitSuccessful, submitFailed, userId);
    }
}

//This function is the successCallback for the AJAX request
//will only be called if the AJAX request is sucessful
function submitSuccessful(xhr) {
    // staring the HTML div DOM object in a local variable
    const messageDiv = document.getElementById("message");
    // un-hiding the DOM element
    messageDiv.hidden = false;
    // Setting the new text within the div
    // Again, using the innerText instead of innerHTML to alleviate security risks(specifically injection/cross-site scripting)
    messageDiv.innerText = 'Reimburse #${xhr.responseText} has been submitted.';
}

//This function will only call if the submission AJAX request fails
function submitFailed() {
    // storing the HTML div DOM object in a local variable
    const messageDiv = document.getElementById("message");
    // un-hiding the DOM element
    messageDiv.hidden = false;
    // Setting the failure text within the div
    // Again, using innerText instead of innerHTML to alleviate security risks (specifically injection/cross-site scripting)
    messageDiv.innerText = "Sorry, Reimbursement Submission has Failed.";
}
