package com.apress.apachetomcat7.chapter13;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @author aleksav
 */
@WebServlet(urlPatterns = {"/displayUsers.html"})
public class DisplayUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        StringBuffer sb = new StringBuffer("<HTML><BODY>");
        sb.append("<TABLE>");
        sb.append("<TR><TH>USER NAME</TH></TR>");
        try {
            conn = getDbConnection();
            Statement statement = conn.createStatement();
            ResultSet users = statement.executeQuery("select * from users");
            while (users.next()) {
                sb.append("<TR><TD>");
                String username = users.getString("user_name");
                sb.append(username);
                sb.append("</TD></TR>");
            }
        } catch (Exception e) {
            System.err.println("Error connecting to database server");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                }
                catch (Exception e) {
                    System.err.println("Error closing database connection");
                }
            }
        }
        sb.append("</TABLE>");
        sb.append("</BODY></HTML>");
        response.getOutputStream().write(sb.toString().getBytes());

    }

    private Connection getDbConnectionOld()
            throws SQLException,
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        String userName = "test";
        String password = "test";
        String url = "jdbc:mysql://localhost/tomcatusers";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, userName, password);
    }

    private Connection getDbConnection() throws NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        Connection connection = (Connection) envContext.lookup("jdbc/testDataSource");
        return connection;
    }
}
