package com.example.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_emprestimo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;

    private LocalDate data_emprestimo;
    private LocalDate data_devolucao_prevista;
    private LocalDate data_devolucao_real;

    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_ANDAMENTO;

    public enum Status { EM_ANDAMENTO, DEVOLVIDO, ATRASADO }

    // getters and setters
    public Integer getId_emprestimo() { return id_emprestimo; }
    public void setId_emprestimo(Integer id_emprestimo) { this.id_emprestimo = id_emprestimo; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public LocalDate getData_emprestimo() { return data_emprestimo; }
    public void setData_emprestimo(LocalDate data_emprestimo) { this.data_emprestimo = data_emprestimo; }
    public LocalDate getData_devolucao_prevista() { return data_devolucao_prevista; }
    public void setData_devolucao_prevista(LocalDate data_devolucao_prevista) { this.data_devolucao_prevista = data_devolucao_prevista; }
    public LocalDate getData_devolucao_real() { return data_devolucao_real; }
    public void setData_devolucao_real(LocalDate data_devolucao_real) { this.data_devolucao_real = data_devolucao_real; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
