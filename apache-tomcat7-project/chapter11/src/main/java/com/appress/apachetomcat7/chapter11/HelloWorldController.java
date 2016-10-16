package com.appress.apachetomcat7.chapter11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aleksav
 */
@Controller
public class HelloWorldController extends HttpServlet{

    @RequestMapping(value = "/helloWorld.html", method = RequestMethod.GET)
    public ModelAndView hello(){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", "Hello, Spring-MVC World");

        return new ModelAndView("index", model);
    }

}
