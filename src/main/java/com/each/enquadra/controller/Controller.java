/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author juan_
 */
@org.springframework.stereotype.Controller
public class Controller {

    private static final Logger log = Logger.getLogger(Controller.class.getName());

    @RequestMapping("/")
    public String home() {
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[INDEX]");
        return "index";
    }

    @RequestMapping("/home")
    public String homePage() {
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[INDEX]");
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[ABOUT]");
        return "about";
    }

    @RequestMapping("/contact")
    public String contact() {
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[CONTACT]");
        return "contact";
    }

    @RequestMapping("/login")
    public String login() {
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[LOGIN]");
        return "login/loginForm";
    }
}
