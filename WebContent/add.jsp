<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
text-align: center;
}

.header {
  padding: 40px;
  text-align: center;
  background: #1abc9c;
  color: #0008ff;
  font-size: larger;
  background-image: url("/myLittleDiary.com/images/mobile-phone-evolution.jpg");
  background-size: contain;
}

h1 {
  color: black;
  -webkit-text-fill-color: white; 
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: black;
}



.foot{
 color: #0008ff;
 text-align:center;
 background-color: #ffe8f8;

}

.txtBox {
 width: 600px;
 height: 600px;
 
}

.box {
 margin-top: 30px;
}
</style>
  
</head>
<body>

<!--  Header -->
<div class="header">
  <h1>Add your numbers here!</h1>
  <br>
</div>

<!-- Posts -->
<div class = "box">
	<form>
	<br>
	<fieldset>
  		<label for="fname">First name:</label>
  		<input type="text" id="fname" name="fname" align="center"><br><br>
  		<label for="lname">Last name:</label>
  		<input type="text" id="lname" name="lname"><br><br>
  		<label for="number">Phone number:</label>
  		<input type="text" id="number" name="number"><br><br>
  		
  		<label for="sex">Sex:</label>
  <select name="sex" id="sex" onchange="if (this.value=='other'){this.form['other'].style.visibility='visible'}else {this.form['other'].style.visibility='hidden'};">
  <option value="">SELECT</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>    

  </select>
  <input type="text" name="other" id="other" style="visibility:hidden;"/>
  <br><br>
  
	<input type="submit" value="Post">
	</form>
	</fieldset>
</div>

<!-- Foot -->
<div class="foot">
<p> FOO[figh]TER </p>
</div>

</body>
</html>