console.log("============================(DOM Selection/Manipulation)")
let divElements = document.getElementsByClassName("domClass");  //get usage is handy to make it dynamic
//we will select the class name associated to domClass 

console.log(divElements); //This prints the array of our div elements with the class name of "domClass"

let firstDiv = divElements[0];
console.log(firstDiv);

//play with the attributes of our html page. This is what is called DOM Manipulation
firstDiv.setAttribute("style","background-color:yellow;")







console.log("============================(Events)")

//let's grab our button
let myButton = document.getElementById("b1");

myButton.onclick = someFunc;

document.getElementById("h1").addEventListener("mouseover", hoverFunc);
document.getElementById("h1").addEventListener("mouseover", leaveFunc);

let x = 0;

//Lets make our function
function clickfunc() {
console.log("clickFunc is running!")
document.getElementById("b1").textContent ="You have clicked me";
document.getElementById("p3").textContent ="I saw you click the button :)";
x++;
if (x>=10){
    document.getElementById("b1").textContent = "You have clicked me";
    document.getElementById("p3").textContent = "Stop it, you are hurting them!";
}
if (x>=20){
    document.getElementById("b1").textContent = "That's enough clicking";
    document.getElementById("p3").textContent = "Stop it you are hurting them!"
}
}
function hoverFunc(){
    console.log("hoverFunc is running! So you better go catch it!");
    document.getElementById("h1").textContent = "Don't touch me mortal!";

}
function leaveFunc(){
    console.log("leaveFunc is running!")
    document.getElementById("h1").textContent ="byeeeeeeeeeeeee";
}