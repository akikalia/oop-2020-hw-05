package controller;


import model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class UpdateCartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req,res);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HashMap<String, Product> cart = (HashMap<String, Product>)req.getSession().getAttribute("userCart");
        List<String> list = Collections.list(req.getParameterNames());
        for (String name : list) {
            int newAmount = Integer.parseInt(req.getParameter(name));
            if (newAmount < 1)
                cart.remove(name);
            else
                cart.get(name).amountSet(newAmount);
        }
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req,res);
    }


}
