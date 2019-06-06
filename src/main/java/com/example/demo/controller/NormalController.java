package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NormalController {

    @RequestMapping("/controller-example")
    public String sample() {
        return "index";         // for a controller, whatever is returned by this method,
                                // it is treated as a template by the spring, at a certain path
    }

    @GetMapping("/get-mapping")
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("message", "Hello world");
        return "index";
    }
}
