package com.example.biblioteca.repository;

import com.example.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    List<Emprestimo> findByStatus(Emprestimo.Status status);
    List<Emprestimo> findByUsuario_Id_usuario(Integer idUsuario);
}
