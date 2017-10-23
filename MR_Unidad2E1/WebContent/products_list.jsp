<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="ProductController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Units in Stock</th>
			 <th>Unit Price</th>
			  <th>Type</th>
			  
			
		</tr>
		
		<c:forEach var="product" items="${products}">
		
		<tr>
			<td>
				<form action= "ProductController">
					<input type = "hidden" name = "id" value= "${product.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${product.id}</td>
			<td> ${product.name}</td>
			<td> ${product.unitInStock}</td>
			<td> ${product.unitPrice}</td>
			<td> ${product.type}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>


</body>
</html>