


var myVar = "global"; // Declare a global variable
window.onload = function checkscope( ) {
 var myVar = "Local"; // Declare a local variable
 document.write(myVar);
}