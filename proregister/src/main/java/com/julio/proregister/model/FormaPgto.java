package com.julio.proregister.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formapgto")
public class FormaPgto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pgtoid")
    private Integer id;

    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
