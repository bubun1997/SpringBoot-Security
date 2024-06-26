<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>users-list</title>
<style type="text/css">
.btn{
     cursor: pointer;
  }
  table, th, td {
  border:1px solid black;
}

</style>
</head>
<body>

<center>

    <table style="width:50%">
      <tr>
	    <th>User Id</th>
	    <th>User Email</th>
 	 </tr>
 	 
 	 <c:forEach items="${users}" var="user">
 	 
 	    <tr>
 	       <td>
 	         <c:out value="${user.userId}"></c:out>
 	       </td>
 	       <td>
 	         <c:out value="${user.userName}"></c:out>
 	       </td>
 	    </tr>
 	 
 	 
 	 </c:forEach>
  
  
  </table>
  
  <br><br>
 
 <a href="admin/dashboard">
   <button class="btn">Back To Dashboard</button>
 </a>
 
 &nbsp;&nbsp;
 <a href="/logout">
   <button class="btn">Logout</button>
 </a>
 
</center>



</body>
</html>