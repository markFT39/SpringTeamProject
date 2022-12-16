package com.example;

import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserServiceImpl service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "login/signup";
    }

    @RequestMapping(value="/loginOk", method=RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo){
        String returnURL = "";
        if (session.getAttribute("login") != null ){
            session.removeAttribute("login");
        }

        UserVO loginvo = service.getUser(vo);
        if (loginvo != null ){ // 로그인 성공
            System.out.println("로그인 성공!");
            session.setAttribute("login", loginvo);
            returnURL = "redirect:/Calendar/list";
        }else { // 로그인 실패
            System.out.println("로그인 실패!");
            returnURL = "redirect:/login/login";
        }
        return returnURL;
    }

    @RequestMapping(value="/signupOk", method=RequestMethod.POST)
    public String signupCheck(HttpSession session, UserVO vo){
        String returnURL = "";
        if (session.getAttribute("signup") != null ){
            session.removeAttribute("signup");
        }

        System.out.println("id 췍");
        UserVO signinvo = service.useridCheck(vo);
        if (signinvo == null){ // 회원가입 성공
            System.out.println("id 등록 실행");
            service.addUser(vo);
            System.out.println("회원가입 성공!");
            returnURL = "redirect:/login/login";
        }else { // 회원가입 실패
            System.out.println("회원가입 실패!");
            returnURL = "redirect:/login/signup";
        }
        return returnURL;
    }

    // 로그아웃 하는 부분
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login/login";
    }
}
