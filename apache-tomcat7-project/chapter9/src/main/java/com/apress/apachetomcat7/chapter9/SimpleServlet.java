package com.apress.apachetomcat7.chapter9;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author aleksav
 */
public class SimpleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double input = Double.parseDouble(request.getParameter("number"));

        double result = Math.sqrt(input);
        String message = "The result is " + result;
        response.getOutputStream().write(message.getBytes());
    }
}
