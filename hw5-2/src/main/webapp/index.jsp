<%@ page import="manager.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Student Store</title>
</head>

    <h1>Student Store</h1>
    <br/>
    <a>Items available:</a>
    <br/>
    <ul>
        <%
            ServletContext sc = request.getServletContext();
            ProductDao dao = (ProductDao)sc.getAttribute("dao");
            List<Product> products = dao.getProductList();
            int size = products.size();
            for (int i = 0; i < size; i++){
                Product temp = products.get(i);
                out.print("<li><a href=\"/show-product.jsp?id="+temp.getProduct_id()+"\">"+ temp.getName() +"</a></li>");
            }
        %>
    </ul>
</body>
</html>
