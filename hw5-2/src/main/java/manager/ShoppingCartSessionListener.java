package manager;

import model.Product;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

@WebListener
public class ShoppingCartSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("userCart", new HashMap<String, Product>());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}