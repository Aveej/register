package com.example.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService userservice;

//whn u call the req it opens the login form
    @GetMapping("/login")

    public ModelAndView login(){
        ModelAndView reg = new ModelAndView("login");
        reg.addObject("user", new Login());
        return reg;
    }

    @GetMapping("/signup")

    public String singnup(){
        return "signup";
    }

//
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user){

        Login oauthUser = userservice.login(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/";
        }
        else
        {
        return "redirect:/login";
        }
    }

    @RequestMapping(value = {"logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/log";
    }
}





