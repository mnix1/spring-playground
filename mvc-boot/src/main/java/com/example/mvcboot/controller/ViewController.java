package com.example.mvcboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/view")
class ViewController {
    @GetMapping("/string")
    public String string(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello-view";
    }

    @GetMapping("/model-and-view")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("hello-view");
        modelAndView.addObject("message", "Hello Spring MVC Framework!");
        return modelAndView;
    }

    @GetMapping("io-exception")
    void throwIOException() throws IOException {
        throw new IOException("io");
    }

    @GetMapping("duplicate")
    void throwDuplicateException() {
        throw new MixedController.DuplicateException();
    }

}