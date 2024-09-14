package com.julio.proregister.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ositem")
@IdClass(OSItemId.class)
public class OSItem {

    @Id
    @Column(name = "servico")
    private Integer servico;

    @Id
    @Column(name = "os")
    private Integer os;

    @Id
    @Column(name = "usuario")
    private Integer usuario;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    // Getters and Setters

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}