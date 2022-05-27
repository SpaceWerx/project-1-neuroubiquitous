//listening for the logout button to be clicked
document.getElementById("logout-button").addEventListener("click", logout);
//this function is called if the user clicks the logout button
function logout() {
    //remove the current-user stored in the local storage
    localStorage.removeItem("current-user");
    //redirect to the login page
    window.location.href = "../login/login.html";

}
//Retrieving the current user ID from local storage
const authHeader = localStorage.getItem("current-user");
//checking if the user is logged in
if(authHeader) {
    //calling an AJAX request to the server to get all reimbursement submitted by the current user
    sendAjaxRequest("GET", 'http://localhost:whatever/reimbursement?author=${authHeader}', null, tableRenderSuccess, tableRenderFailed, authHeader)

} else {
    //redirect to login if the user ID is missing
    window.Location.href = "../login/login/html";
}
//This is the successCallback for the AJAX request to get all reimbursements by author
//only called if the AJAX request is successful
function tableRenderSuccess(xhr) {

    //parsing the list of reimbursement objects returned from the server
    const reimbursements = JSON.parse(xhr.responseText);

    //unhiding the table when the data has been retrieved
    document.getElementById("display-table").hidden = false;
    // storing the table body as a local variable to dynamically update information
    const tableBody = document.getElementById("display-table-body");

    //enhanced for loop to iterate over the list and create a new table row with each reimbursement
    for (let reimbursement of reimbursements) {
        //storing a new DOM element (table row) as a local variable
        let newRow = document.createElement("tr");

        //storing a new DOM element (table data) as a local variable
        let idColumn = document.createElement("td");
        // using the reimbursement data to fill the ID column fo this row
        idColumn.innerText = reimbursement.id;
        //appending the table data to the table row
        newRow.appendChild(idColumn);
        
        // storing a new DOM element (table data) as a local variable
        let typeColumn = document.createElement("td");
        //using the reimbursement data to fill the description column of this row
        typeColumn.innerText = reimbursement.type;
        // appending the table data to the table row
        newRow.appendChild(typeColumn);

        // storing a new DOM element (table data) as a local variable
        let descriptionColumn = document.createElement("td");
        descriptionColumn.innerText = reimbursement.description;
        //appending the table data to the table row
        newRow.appendChild(descriptionColumn);
        
        //storing a new DOM element (table data) as a local variable
        let amountColumn = document.createElement("td");
        // using the reimbursement data to fill the amount column of this row
        amountColumn.innerText = reimbursement.amount;
        //appending the table data to the table row
        newRow.appendChild(amountColumn);

        //storing a new DOM element (table data) as a local variable
        let statusColumn = document.createElement("td");
        //using the reimbursement data to fill the status column of this row
        statusColumn.innerText = reimbursement.status;
        // appending the table data to the table row
        newRow.appendChild(statusColumn);

        // append the row to the table body once all respective data has been added to the row (this will repeat for every reimbursement record)
        tableBody.appendChild(newRow);

    }
}
// This is the successfulCallback for the AJAX request to get all reimbursements by author
// only called if the AJAX request is successful

function tableRenderFailed(xhr) {
    //staring the HTML div DOM element in a local variable
    const messageDiv = document.getElementById("message");
    // un-hiding the DOM element
    messageDiv.hidden = false;
    // Letting the user know what the specific issue is (response body exception text from the server)
    // Again, using innerText instead of innerHTML to alleviate security risks (specifically injecton/Cross-site Scripting)
    messageDiv.innerText = xhr.responseText;
}