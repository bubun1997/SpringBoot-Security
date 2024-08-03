<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>

</head>
<body>
<jsp:include page="Main.jsp"></jsp:include>

<center>
       <table style="width:70%">
      <tr>
	    <th>Product Name</th>
	    <th>Product price</th>
	    <th>Quantity</th>
	    <th></th>
	    
 	 </tr>
 	 
 	 <c:forEach items="${products}" var="product">
 	 
 	    <tr>
 	       <td>
 	         <c:out value="${product.productName}"></c:out>
 	       </td>
 	       <td>
 	         <c:out value="${product.productPrice}"></c:out>
 	       </td>
 	       <td>
 	       	 <c:out value="${product.productQuantity}"></c:out>
 	       </td>
 	       <td>
 	         <a href="delete/${product.productId}">
 	            <button class="btn">Delete</button>
 	         </a>
 	       </td>
 	    
 	    </tr>
 	 
 	 
 	 </c:forEach>
  
  
  </table>
  
  <br>
  
<hr>
  
	<h2>Add Your Products Here</h2>
    
    <form action="products" method="post">
      <input type="text" name="productName" placeholder="Enter product name...."><br><br>
      <input type="text" name="productPrice" placeholder="Enter product price...."><br><br>
      <input type="text" name="productQuantity" placeholder="Enter product quantity...."><br><br>
      
      <button class="btn" type="submit">Add Product</button>
      
    
    
    </form><br><br>
    
 <a href="admin/dashboard">
   <button class="btn">Back To Dashboard</button>
 </a>
 
 &nbsp;&nbsp;
 <a href="/logout">
   <button class="btn">Logout</button>
 </a>
 
</center>
</center>

</body>
</html>