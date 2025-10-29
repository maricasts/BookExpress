package com.example.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha_hash;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo = TipoUsuario.REGULAR;

    private LocalDateTime data_criacao;

    public enum TipoUsuario { REGULAR, BIBLIOTECARIO }

    // getters and setters

    public Integer getId_usuario() { return id_usuario; }
    public void setId_usuario(Integer id_usuario) { this.id_usuario = id_usuario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha_hash() { return senha_hash; }
    public void setSenha_hash(String senha_hash) { this.senha_hash = senha_hash; }
    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
    public LocalDateTime getData_criacao() { return data_criacao; }
    public void setData_criacao(LocalDateTime data_criacao) { this.data_criacao = data_criacao; }
}
