<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>

<style type="text/css">
	  .btn{
	     cursor: pointer;
	  }
	 
</style>

</head>
<body>

	<center>
	    <h2>***** Confirm Your Order *****</h2>
	    
	    Product Name : <c:out value="${product.productName}"></c:out> <br><br>
	    Product Price : <c:out value="${product.productPrice}"></c:out> <br><br>
	    Quantity :      <c:out value="${product.productQuantity}"></c:out> <br><br>
	                 
	                 <form action="../../checkout/${customer.customerId}/${product.productId}" method="get">
	                 
	                    <input type="text" name="quantity" placeholder="Enter product quantity"/><br><br>
	                    <button type="submit" class="btn">
	                      Buy
	                    </button>
	                 </form> <br><br>
	                 
					 
					 <a href="../../dashboard">
   						<button class="btn">Back To Dashboard</button>
 					 </a> &nbsp;
 					 
 					 <a href="/logout">
   						<button class="btn">Logout</button>
					 </a> 
	
	</center>
</body>
</html>