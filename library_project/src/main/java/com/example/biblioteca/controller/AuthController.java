package com.example.biblioteca.controller;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    private final UsuarioService usuarioService;
    public AuthController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        var opt = usuarioService.authenticate(email, senha);
        if (opt.isPresent()) {
            session.setAttribute("user", opt.get());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Credenciais inválidas");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerForm() { return "register"; }

    @PostMapping("/register")
    public String register(@RequestParam String nome, @RequestParam String email, @RequestParam String senha, @RequestParam(defaultValue = "REGULAR") String tipo, HttpSession session) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setTipo(Usuario.TipoUsuario.valueOf(tipo));
        usuarioService.register(u, senha);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
