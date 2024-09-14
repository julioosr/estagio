package com.julio.proregister.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid")
    private Integer id;

    @Column(name = "nome", length = 40, nullable = false)
    private String nome;

    @Column(name = "login", length = 12, nullable = false, unique = true)
    private String login;

    @Column(name = "senha", length = 60, nullable = false)
    private String senha;

    @Column(name = "empresa", length = 14, nullable = false)
    private String empresa;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}

