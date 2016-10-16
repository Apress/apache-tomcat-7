package com.apress.apachetomcat7.chapter9;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Context;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.core.AprLifecycleListener;
import org.junit.*;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;


import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.TextPage;


/**
 * @author aleksav
 */
public class SimpleServletTest {
    private Tomcat tomcat;

    @Before
    public void startTomcat() throws ServletException, LifecycleException {

        this.tomcat = new Tomcat();
        this.tomcat.setPort(8080);
        String tmpDirPath = System.getProperty("java.io.tmpdir");
        Context ctxt = tomcat.addContext("/sqrt", tmpDirPath);
        this.tomcat.addServlet(ctxt, "simpleServlet", new SimpleServlet());
        ctxt.addServletMapping("/", "simpleServlet");
        this.tomcat.start();
    }

    @Test
    public void testSuccess() throws IOException, SAXException {
        final WebClient webClient = new WebClient();
        final TextPage page = webClient.getPage("http://localhost:8080/sqrt/?number=49");
        String responseText = page.getContent();
        Assert.assertEquals("Incorrect result", "The result is 7.0", responseText);
    }



    @After
    public void stopTomcat() throws LifecycleException, InterruptedException {
        this.tomcat.stop();
        this.tomcat.stop();

    }
}



