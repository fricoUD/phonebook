<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.header {
  padding: 10px;
  text-align: center;
  font-size: larger;
  background-image: url("/myLittleDiary.com/images/mobile-phone-evolution.jpg");
  background-size: contain;
}

.add {
	  text-align: center;
	  padding-top: 30px;	
}

.foot{
 color: #0008ff;
 text-align:center;
 background-color: #ffe8f8;

}

.table {
text-align:center;

}

h1 {
  color: black;
  -webkit-text-fill-color: white; 
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: black;
}

h3 {
  color: black;
  -webkit-text-fill-color: white;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: black;
}

table, th, td {
  border: 1px solid black;
   margin-left: auto;
  margin-right: auto;
}

</style>
<body>

<%
String txt = " ";

String post = request.getParameter("text");
if (post != null) txt = post;
%>

<!--  Header -->
<div class="header" style="
    font-family: system-ui;
">
  <h1>PHONEBOOK</h1>
  <h3><br><br><br><br><br><br></br>Add your numbers here!</h3>
</div>

<div class = "add">
	<form action="Logic">
	<input type="submit" value="Add" name="pressed">
	</form>
</div>

<div class="table">

<table>
	<th>Name</th>
	<th>Surname</th>
	<th>Number</th>
	<th>Sex</th>
	
<c:forEach items="${table.getTable()}" var="current">
        <tr>
          <td><c:out value="${current.name}" /></td>
          <td><c:out value="${current.surname}" /></td>
          <td><c:out value="${current.number}" /></td>
          <td><c:out value="${current.sex}" /></td>
        </tr>
      </c:forEach>

<br>

</table>
</div>

<div class="foot">
<p> FOO(figh)TER </p>
</div>

</body>
</html>