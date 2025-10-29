package com.example.biblioteca.service;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepo;
    private final LivroRepository livroRepo;

    public EmprestimoService(EmprestimoRepository emprestimoRepo, LivroRepository livroRepo) {
        this.emprestimoRepo = emprestimoRepo;
        this.livroRepo = livroRepo;
    }

    @Transactional
    public Optional<Emprestimo> borrow(Usuario user, Livro livro, int days) {
        if (livro.getQuantidade_disponivel() <= 0) return Optional.empty();
        livro.setQuantidade_disponivel(livro.getQuantidade_disponivel() - 1);
        livroRepo.save(livro);

        Emprestimo e = new Emprestimo();
        e.setUsuario(user);
        e.setLivro(livro);
        e.setData_emprestimo(LocalDate.now());
        e.setData_devolucao_prevista(LocalDate.now().plusDays(days));
        e.setStatus(Emprestimo.Status.EM_ANDAMENTO);
        return Optional.of(emprestimoRepo.save(e));
    }

    @Transactional
    public boolean devolver(Integer emprestimoId) {
        Optional<Emprestimo> opt = emprestimoRepo.findById(emprestimoId);
        if (opt.isEmpty()) return false;
        Emprestimo e = opt.get();
        if (e.getStatus() == Emprestimo.Status.DEVOLVIDO) return false;
        Livro l = e.getLivro();
        l.setQuantidade_disponivel(l.getQuantidade_disponivel() + 1);
        livroRepo.save(l);
        e.setData_devolucao_real(LocalDate.now());
        e.setStatus(Emprestimo.Status.DEVOLVIDO);
        emprestimoRepo.save(e);
        return true;
    }

    public List<Emprestimo> listByStatus(Emprestimo.Status status) {
        return emprestimoRepo.findByStatus(status);
    }

    public List<Emprestimo> byUsuario(Integer idUsuario) {
        return emprestimoRepo.findByUsuario_Id_usuario(idUsuario);
    }
}
