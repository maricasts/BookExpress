package com.example.biblioteca.controller;

import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LivroService livroService;
    public HomeController(LivroService livroService) { this.livroService = livroService; }

    @GetMapping({"/","/books"})
    public String books(Model model) {
        model.addAttribute("livros", livroService.findAll());
        return "books";
    }
}
