package com.appress.apachetomcat7.chapter7;

import org.apache.tomcat.util.net.SSLSessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author aleksav
 */
public class InvalideSessionServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        // invalidate standard HTTP session
        session.invalidate();

        // Invalidate the SSL session
        SSLSessionManager mgr =
            (SSLSessionManager)
            request.getAttribute("javax.servlet.request.ssl_session_mgr");
        mgr.invalidateSession();

        // Close the conection
        response.setHeader("Connection", "close");
    }
}
