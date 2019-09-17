<%@page import="com.bv.handler.ProductDBHandler"%>
<%@page import="com.bv.model.Products"%>
<%
  String p = request.getParameter("pId");
  int Id = Integer.parseInt(p);
  Products u = ProductDBHandler.getProductById(Id);
 	
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile Shop</title>
</head>
<body>
<form action="update.jsp" method="post" >
		<table align="center" style="width:300px; height:150px;background-color: gray;color: #ffffff" >
			<tr>
				<td><label>Product Name:</label></td>
				<td><input type="text" name="productname" value="<%=u.getProductname() %>" ></td>
			</tr>
			<tr>
			<td><input type="hidden" name="id" value="<%=u.getId() %>" ></td>
			</tr>
			<tr>
				<td><label>Manufacturer Name:</label></td> 
				<td>
					<select name="manufacturername" style="width:150px">
						<option >Oppo</option>
						<option >Vivo</option>
						<option >Samsung</option>
						<option >MI</option>
						<option >Iphone</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Price:</label></td>
				<td><input type="number" name="price" value="<%=u.getPrice() %>" ></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="update Product" ></td>
			</tr>
			
		</table>
	</form>
</body>
</html>