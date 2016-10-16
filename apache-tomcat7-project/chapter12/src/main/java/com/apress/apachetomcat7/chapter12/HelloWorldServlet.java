package com.apress.apachetomcat7.chapter12;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Aleksa Vukotic
 */
@WebServlet(name = "helloWorldServlet", urlPatterns = "/hello.html")
public class HelloWorldServlet extends HttpServlet {
    Logger logger = Logger.getLogger("com.apress.apachetomcat7.chapter12");
    Logger logger2 = Logger.getLogger("unknwon.logger");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.warning("test message");
        logger2.info("This message will go to the console output");
        response.sendRedirect("/chapter12/jsps/index.jsp");

    }
}
