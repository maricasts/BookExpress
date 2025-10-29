package com.example.biblioteca.service;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    public Usuario register(Usuario u, String rawPassword) {
        u.setSenha_hash(BCrypt.hashpw(rawPassword, BCrypt.gensalt()));
        u.setData_criacao(LocalDateTime.now());
        return repo.save(u);
    }

    public Optional<Usuario> authenticate(String email, String rawPassword) {
        Optional<Usuario> opt = repo.findByEmail(email);
        if (opt.isPresent()) {
            Usuario u = opt.get();
            if (BCrypt.checkpw(rawPassword, u.getSenha_hash())) return Optional.of(u);
        }
        return Optional.empty();
    }
}
