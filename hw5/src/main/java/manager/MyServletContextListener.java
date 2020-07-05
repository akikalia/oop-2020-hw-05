package manager;

import manager.AccountManager;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
@WebListener()
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        String whatType = sc.getInitParameter("typeSelected");
        AccountManager manager = new AccountManager();
        sc.setAttribute("manager", manager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
