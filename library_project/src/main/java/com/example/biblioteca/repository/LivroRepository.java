package com.example.biblioteca.repository;

import com.example.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByQuantidade_disponivelGreaterThan(int q);
}
