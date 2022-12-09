package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("login") != null ){
            session.removeAttribute("login");
        }
        return "redirect:/login/login";
    }
}
