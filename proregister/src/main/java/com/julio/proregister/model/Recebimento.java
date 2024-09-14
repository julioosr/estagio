package com.julio.proregister.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "recebimento")
public class Recebimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recebimentoid")
    private Integer recebimentoID;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "desconto")
    private BigDecimal desconto;

    @Column(name = "os")
    private Integer os;

    @Column(name = "formapgto")
    private Integer formaPgto;

    @Column(name = "usuario")
    private Integer usuario;

    // Getters and Setters

    public Integer getRecebimentoID() {
        return recebimentoID;
    }

    public void setRecebimentoID(Integer recebimentoID) {
        this.recebimentoID = recebimentoID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }

    public Integer getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(Integer formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
