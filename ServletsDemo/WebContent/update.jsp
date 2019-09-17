  
<%@page import="com.bv.model.Products"%>
<%@page import="com.bv.handler.*"%>
 <jsp:useBean id="product" class="com.bv.model.Products" ></jsp:useBean>
<jsp:setProperty property="*" name="product"/> 

<%
	
	ProductDBHandler.updateProducts(product);
	response.sendRedirect("productlist.jsp");
%>