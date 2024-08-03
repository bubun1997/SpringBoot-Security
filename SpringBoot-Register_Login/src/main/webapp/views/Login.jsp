<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

</head>
<body>
<jsp:include page="Main.jsp"></jsp:include>

<center>

  <h2>Login here</h2>
  
  <form action="/userLogin" method="post">
  
      <input type="text" name="username" placeholder="Enter username...."/><br><br>
      <input type="password" name="password" placeholder="Enter password...."/><br><br>
      
      <button class="btn" type="submit">Login</button>
          
  
  </form><br><br>
  
  <a href="home">
   <button class="btn">Back To Home</button>
 </a>
  
</center>

</body>
</html>