package controller;

import manager.AccountManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //AccountManager manager = (AccountManager) getServletContext().getAttribute("manager");
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,res);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        AccountManager manager = (AccountManager) getServletContext().getAttribute("manager");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (manager.accountExists(username)){
            if (manager.accountCorrect(username , password)){
                req.getRequestDispatcher("WEB-INF/welcomeUser.jsp").forward(req,res);
            }else{
                req.getRequestDispatcher("WEB-INF/incorrectLogin.jsp").forward(req,res);
            }
        }
        else{
            req.getRequestDispatcher("WEB-INF/incorrectLogin.jsp").forward(req,res);
        }
    }


}
