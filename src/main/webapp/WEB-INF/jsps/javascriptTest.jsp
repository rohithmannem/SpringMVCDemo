<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<h2>What Can JavaScript Do?</h2>

<p id="demo">JavaScript can change HTML content.</p>

<form action="/action_page.php" onsubmit="return validateForm();">
  First name: <input type="text" name="fname" id="fname" class=""> 
  <p id="fNameError" style="color:red;"></p>
  
  <br>
  Last name: <input type="text" name="lname" id="lname"><br>
  
  <input type="submit" value="Submit">
  <button type="button" onclick='document.getElementById("demo").innerHTML = "Hello JavaScript!"'>Click Me!</button>
</form>


<script>

function validateForm(){
   
   var fname = document.getElementById("fname").value;
   alert("First name you entered is : " + fname);
   
   if ( fname ==null || fname == "" || fname.length <5 ) {
       document.getElementById("fNameError").innerHTML = "Please Enter a valid fname";
       return false;
   } else {
   		return true;
   }
  
}

</script>


</body>
</html>