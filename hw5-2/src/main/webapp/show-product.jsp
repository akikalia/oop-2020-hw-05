<%@ page import="manager.ProductDao" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<%
    ServletContext sc = request.getServletContext();
    ProductDao dao = (ProductDao)sc.getAttribute("dao");
    Product curr = (Product)dao.getProduct((String)request.getParameter("id"));

%>
<head>
    <title><%= curr.getName() %></title>
</head>
<body>
    <h1><%= curr.getName() %></h1><br/>
    <img src="<%="/store-images/" + curr.getImage()%>" /><br/>
    <form action="cart" method="POST">
        <a><%= curr.getPrice() %>$</a>
        <button type="submit">Add To Cart</button>
        <input name="id" type="hidden" value="<%=curr.getProduct_id()%>"/>
    </form>
</body>
</html>
