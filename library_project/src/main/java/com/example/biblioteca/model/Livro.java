package com.example.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_livro;

    private String titulo;
    private String autor;
    private Integer ano_publicacao;
    @Column(unique = true)
    private String isbn;
    private Integer quantidade_total = 1;
    private Integer quantidade_disponivel = 1;
    private LocalDateTime data_adicao;

    // getters and setters
    public Integer getId_livro() { return id_livro; }
    public void setId_livro(Integer id_livro) { this.id_livro = id_livro; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAno_publicacao() { return ano_publicacao; }
    public void setAno_publicacao(Integer ano_publicacao) { this.ano_publicacao = ano_publicacao; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Integer getQuantidade_total() { return quantidade_total; }
    public void setQuantidade_total(Integer quantidade_total) { this.quantidade_total = quantidade_total; }
    public Integer getQuantidade_disponivel() { return quantidade_disponivel; }
    public void setQuantidade_disponivel(Integer quantidade_disponivel) { this.quantidade_disponivel = quantidade_disponivel; }
    public LocalDateTime getData_adicao() { return data_adicao; }
    public void setData_adicao(LocalDateTime data_adicao) { this.data_adicao = data_adicao; }
}
