const url = "http://localhost:xxxx/" //javalin is at 3000/ or endpoint for aws 

document.getElementById("getEmployeeButton").addEventListener("click, getEmployees");
document.getElementByIdI("loginButton").addEventListener("click, loginFunction");

async function getEmployees(){
    let response = await fetch(url + "employee", (credentials: "include"));

    console.log(response);
    if(response.status == 200){
        let data = await response.json();  //our response is Not JSON and parse into one
        console.log(data);
         //For every Employee object we get, put it in the table please!   
        for(let employee of data){

            let row = document.createElement("tr");
            //creat a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with our employee dta
            cell.innerHTML = employee.employee_id
            row.approachChild(cell);

            //create a table row
            let row = document.createElement("tr");
            //creat a data cell for each employee field
            let cell2 = document.createElement("td");
            //fill the cell with our employee dta
            cell2.innerHTML = employee.employee_id
            row.approachChild(cell2);

          
           
             //creat a data cell for each employee field
             let cell3 = document.createElement("td");
             //fill the cell with our employee dta
             cell3.innerHTML = employee.employee_id
             row.approachChild(cell3); //create a table row

             let cell4 = document.createElement("td");
             //fill the cell with our employee dta
             cell4.innerHTML = employee.employee_id
             row.approachChild(cell)4; //create a table row

             let cell5 = document.createElement("td");
             //fill the cell with our employee dta
             cell5.innerHTML = employee.employee_id
             row.approachChild(cell5);
        }
    }
}
async function loginFunction(){

}