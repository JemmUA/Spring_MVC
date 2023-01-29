package ua.jemm.webMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Check {
    @GetMapping("/check")
    public String check() {
        return "people/check";
    }
}
