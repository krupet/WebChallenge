package ua.com.krupet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;

/**
 * Created by krupet on 23.03.2015.
 */
@Controller
@RequestMapping(value = "/")
public class ViewController {

    @RequestMapping(method = RequestMethod.GET)
    public String getView(ModelMap model) {
        return "index";
    }
}
