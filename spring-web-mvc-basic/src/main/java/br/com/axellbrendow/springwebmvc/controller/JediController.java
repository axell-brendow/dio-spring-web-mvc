package br.com.axellbrendow.springwebmvc.controller;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import br.com.axellbrendow.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class JediController {
    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", repository.getAllJedi());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(
            @Valid @ModelAttribute Jedi jedi,
            BindingResult result,
            RedirectAttributes attributes
    ) {
        if (result.hasErrors()) return "new-jedi";
        repository.add(jedi);
        attributes.addFlashAttribute("message", "Cadastrado com sucesso!");
        return "redirect:jedi";
    }
}
