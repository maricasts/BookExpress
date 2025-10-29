package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository repo;
    public LivroService(LivroRepository repo) { this.repo = repo; }

    public Livro add(Livro l) { return repo.save(l); }
    public List<Livro> available() { return repo.findByQuantidade_disponivelGreaterThan(0); }
    public Optional<Livro> findById(Integer id) { return repo.findById(id); }
    public List<Livro> findAll() { return repo.findAll(); }
}
