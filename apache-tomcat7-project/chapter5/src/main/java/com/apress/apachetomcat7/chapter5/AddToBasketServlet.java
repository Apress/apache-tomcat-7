package com.apress.apachetomcat7.chapter5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author aleksav
 */

@WebServlet(urlPatterns={"/addToBasket.html"})
public class AddToBasketServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post request processing...");

        HttpSession session = request.getSession(true);
        HttpShoppingBasket basket = (HttpShoppingBasket) session.getAttribute("SHOPPING_BASKET");
        if(basket == null){
            basket = new HttpShoppingBasket();
        }

        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));

        Item item = new Item(productName, price);
        basket.addToBasket(item);

        session.setAttribute("SHOPPING_BASKET", basket);
        response.sendRedirect("/chapter5/jsps/products.jsp");
    }
}
