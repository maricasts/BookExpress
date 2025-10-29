package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.LivroService;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;
    private final LivroService livroService;
    private final UsuarioRepository usuarioRepo;

    public EmprestimoController(EmprestimoService emprestimoService, LivroService livroService, UsuarioRepository usuarioRepo) {
        this.emprestimoService = emprestimoService;
        this.livroService = livroService;
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable Integer id, @RequestParam(defaultValue = "7") int days, HttpSession session, Model model) {
        Object o = session.getAttribute("user");
        if (o == null) { model.addAttribute("error","Faça login para emprestar"); return "login"; }
        Usuario u = (Usuario) o;
        Optional<Livro> opt = livroService.findById(id);
        if (opt.isEmpty()) { model.addAttribute("error","Livro não encontrado"); return "books"; }
        Livro l = opt.get();
        var res = emprestimoService.borrow(u, l, days);
        if (res.isEmpty()) {
            model.addAttribute("error","Livro indisponível");
            return "books";
        }
        return "redirect:/";
    }

    @PostMapping("/return/{id}")
    public String devolver(@PathVariable Integer id) {
        emprestimoService.devolver(id);
        return "redirect:/admin/loans";
    }
}
