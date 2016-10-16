package com.appress.apachetomcat7.chapter7;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;

/**
 * @author aleksav
 */
public class SSLSessionTrackingContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event) {
        // NOOP
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        EnumSet<SessionTrackingMode> modes = EnumSet.of(SessionTrackingMode.SSL);
        context.setSessionTrackingModes(modes);
    }

}

