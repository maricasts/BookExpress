package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class LibrarianController {
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;
    public LibrarianController(LivroService livroService, EmprestimoService emprestimoService) {
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/add-book")
    public String addBookForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "add_book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Livro livro) {
        livroService.add(livro);
        return "redirect:/";
    }

    @GetMapping("/loans")
    public String loans(Model model) {
        model.addAttribute("emprestimos", emprestimoService.listByStatus(com.example.biblioteca.model.Emprestimo.Status.EM_ANDAMENTO));
        return "loans";
    }
}
