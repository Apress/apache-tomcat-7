package com.apress.apachetomcat7.chapter9;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.LifecycleException;
import javax.servlet.ServletException;

public class EmbeddedTomcat {

    private Tomcat tomcat;

    private void startTomcat() throws ServletException, LifecycleException {

        this.tomcat = new Tomcat();
        this.tomcat.setPort(8080);
        this.tomcat.setBaseDir(".");

        // Add AprLifecycleListener
        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);

        String contextPath = "/myapp";
        String appBase = "/opt/tomcat7/webapps/examples";
        this.tomcat.addWebapp(contextPath, appBase);

        this.tomcat.start();

//        this.tomcat.getServer().await();
    }

    private void stopTomcat() throws LifecycleException {
        this.tomcat.stop();
    }

    public static void main(String args[]) {
        try {
            EmbeddedTomcat tomcat = new EmbeddedTomcat();
            tomcat.startTomcat();
            Thread.sleep(5000);
            tomcat.stopTomcat();
            System.exit(0);
        } catch (Exception e) {
        }
    }


}
