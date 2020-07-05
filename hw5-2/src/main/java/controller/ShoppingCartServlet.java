package controller;


import manager.ProductDao;
import model.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class ShoppingCartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req,res);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        HashMap<String, Product> cart = (HashMap<String, Product>)req.getSession().getAttribute("userCart");
        System.out.println(cart);

        ServletContext sc = req.getServletContext();
        ProductDao dao = (ProductDao)sc.getAttribute("dao");

        if (!cart.containsKey(id)){
            Product product = dao.getProduct(id);
            cart.put(id, product);
        }
        cart.get(id).amountInc();
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req,res);
    }


}
