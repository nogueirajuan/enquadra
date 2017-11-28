/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.controller.login;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author victorluni
 */
@ControllerAdvice
@Controller
public class LoginController {
       
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String authMethodShowLoginForm (HttpSession session){
        
        if (session != null 
                && session.getAttribute("user") != null 
                && !session.getAttribute("user").toString().isEmpty()) {
            return "index";
        }
        
        return "login/loginForm";
    }
    
}
