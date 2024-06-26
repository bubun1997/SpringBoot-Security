<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
  .btn{
     cursor: pointer;
  }
</style>
</head>
<body>

<center>

 <h2>
    **** please enter your details below ******
 </h2>
    
    <form method="post" action="register">
    
       <input type="text" name="customerName" placeholder="Enter your Name...." /><br><br>
       <input type="text" name="customerEmail" placeholder="Enter your email..."><br><br>
       <input type="password" name="password" placeholder="Enter your password..." /><br><br>
       <input type="text" name="address" placeholder="Enter your address..." /><br><br>
       
       
       <button  class="btn"  type="submit">Register</button>
       
    </form> <br><br>
    
     <a href="home">
       <button class="btn">Back To Home</button>
     </a>


</center>

</body>
</html>