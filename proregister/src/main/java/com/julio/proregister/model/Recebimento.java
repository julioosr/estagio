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

    @ManyToOne
    @JoinColumn(name = "os")
    private OrdemServico os;

    @ManyToOne
    @JoinColumn(name = "formapgto")
    private FormaPgto formaPgto;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public BigDecimal getValor_em_aberto() {
        return valor_em_aberto;
    }

    public void setValor_em_aberto(BigDecimal valor_em_aberto) {
        this.valor_em_aberto = valor_em_aberto;
    }

    @Column(name = "valor_em_aberto")
    private BigDecimal valor_em_aberto;

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

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
