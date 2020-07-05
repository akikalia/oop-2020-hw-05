package controller;

import manager.AccountManager;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/register.jsp").forward(req,res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        AccountManager manager = (AccountManager) getServletContext().getAttribute("manager");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (manager.accountExists(username)){
            req.getRequestDispatcher("WEB-INF/usernameInUse.jsp").forward(req,res);
        }
        else {
            manager.addAccount(username, password);
//            req.getRequestDispatcher("WEB-INF/welcomeUser.jsp").forward(req,res);

            req.getRequestDispatcher("/").forward(req,res);
            //res.sendRedirect("/");
        }
    }

}