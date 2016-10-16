package com.apress.apachetomcat7.chapter9;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Aleksa Vukotic
 */
public class SimpleServletErrorTest {
    private Tomcat tomcat;

    @Before
    public void startTomcat() throws ServletException, LifecycleException {

        this.tomcat = new Tomcat();
        this.tomcat.setPort(8082);
        String tmpDirPath = System.getProperty("java.io.tmpdir");
        Context ctxt = tomcat.addContext("/sqrt", tmpDirPath);
        this.tomcat.addServlet(ctxt, "simpleServlet", new SimpleServlet());
        ctxt.addServletMapping("/", "simpleServlet");
        this.tomcat.start();
    }

    @Test
    public void testError() throws IOException, SAXException {
        final WebClient webClient = new WebClient();
        try {
            final HtmlPage page = webClient.getPage("http://localhost:8082/sqrt/?number=thisisnotanumber");

        } catch (FailingHttpStatusCodeException ex) {
            int statusCode = ex.getStatusCode();
            Assert.assertEquals("Incorrect status code", 500, statusCode);
        }

    }


    @After
    public void stopTomcat() throws LifecycleException, InterruptedException {
        this.tomcat.stop();

    }
}



