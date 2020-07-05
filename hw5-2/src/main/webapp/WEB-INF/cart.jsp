<%@ page import="model.Product" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <%
        double total = 0;
        HashMap<String, Product> cart = (HashMap<String, Product>)request.getSession().getAttribute("userCart");
    %>
    <form action="updateCart" method="post">
        <ul>
            <%
                for (String key : cart.keySet()) {
                    Product curr = cart.get(key);
                    total += Double.parseDouble(curr.amountGet()) * Double.parseDouble(curr.getPrice());
                    out.print("<li><input type=\"text\" name=\""+key+"\" value=\""+ curr.amountGet() +"\"/><a>"+curr.getName()+", "+curr.getPrice()+"</a></li>");
                }
            %>
        </ul>
        <a>Total: $<%= total%> </a>
        <button>Update Cart</button>
    </form>
    <a href="/">Continue Shopping</a>
</body>
</html>
