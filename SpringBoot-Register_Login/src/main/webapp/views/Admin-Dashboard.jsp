<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>

</head>
<body>

<jsp:include page="Main.jsp"></jsp:include>

<center>

    <h2>
  		This is a admin page
	</h2>  <br>
	
	<a href="../products">
	   <button class="btn">
	      Add Product
	   </button>
	
	</a> &nbsp; 
	
	<a href="../users">
	   <button class="btn">
	      view Users
	   </button>
	
	</a> &nbsp;
	
	
	<a href="/logout">
     <button class="btn">Logout</button>
    </a>
	

</center>



</body>
</html>