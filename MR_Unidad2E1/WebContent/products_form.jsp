<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductController">

		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${product.name}" /><br>
		<label>Units in stock:</label><br>
		<input type = "text" name= "units" value = "${product.unitInStock}" /><br>
		
		<label>Unit price:</label><br>
		<input type = "text" name= "price" value = "${product.unitPrice}" /><br>
		
		<label>Type:</label><br>
		<input type = "text" name= "type" value = "${product.type}" /><br>
		
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>

</body>
</html>