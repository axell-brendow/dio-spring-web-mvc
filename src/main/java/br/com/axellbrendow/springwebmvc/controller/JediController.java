package br.com.axellbrendow.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JediController {
    @GetMapping("/jedi")
    public String jedi() {
        return "jedi"; // same name as resources/templates/jedi.html
    }
}
