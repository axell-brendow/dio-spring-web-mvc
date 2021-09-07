package br.com.axellbrendow.springwebmvc.controller;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JediController {
    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        final var luke = new Jedi("Luke", "Skywalker");
        modelAndView.addObject("allJedi", List.of(luke));
        return modelAndView;
    }
}
