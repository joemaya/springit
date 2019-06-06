package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

//    @GetMapping("/")
//    @RequestMapping(path="/", method=RequestMethod.GET)
    @RequestMapping(value="/", method=RequestMethod.GET, consumes="application/json", produces = "application/json")
    public String home() {
        return "Hello, Spring Boot 2!!!!";
    }

    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("message", "Hello world");
        return "index";
    }

}
