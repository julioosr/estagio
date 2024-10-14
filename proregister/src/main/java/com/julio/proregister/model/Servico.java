package com.julio.proregister.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicoid")
    private Integer servicoID;

    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    @Column(name = "preco", precision = 8, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "nome", length = 50)
    private String nome;

    // Getters and Setters

    public Integer getServicoID() {
        return servicoID;
    }

    public void setServicoID(Integer servicoID) {
        this.servicoID = servicoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
