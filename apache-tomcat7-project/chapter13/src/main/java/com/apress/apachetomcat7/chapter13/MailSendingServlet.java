package com.apress.apachetomcat7.chapter13;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author aleksav
 */
@WebServlet(urlPatterns = {"/sendemail.html"})
public class MailSendingServlet extends HttpServlet {
    private Session session;
    @Override
    public void init() throws ServletException {
        try {
//            Properties props = System.getProperties();
//            props.put("mail.smtp.host", "mailserver.mycompany.com");
//            props.put("username", "emailAdmin");
//            props.put("password", "Sw4nLake!389");
//            Session session = Session.getDefaultInstance(props, null);
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            this.session = (Session)envContext.lookup("jdbc/testMailSession");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailRecipeint = request.getParameter("sendTo");
        try {
//            Properties props = System.getProperties();
//            props.put("mail.smtp.host", "mailserver.mycompany.com");
//            props.put("username", "emailAdmin");
//            props.put("password", "Sw4nLake!389");
//            Session session = Session.getDefaultInstance(props, null);
            Message msg = new MimeMessage(this.session);
            msg.setFrom(new InternetAddress("no-reply@tomcat7.apress.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipeint, false));
            msg.setSubject("Test email");
            msg.setText("Hello and welcome to apress mailing list!");
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent OK.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
