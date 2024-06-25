package org.eazybyte.com.eazybyteschool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home", ""})
    public String home() {
        return "home.html";
    }
}
