package com.julio.proregister.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculoid")
    private Integer id;

    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;

    @Column(name = "ano_de_fabricacao", length = 4, nullable = false)
    private String anoDeFabricacao;

    @Column(name = "cor", length = 15)
    private String cor;

    @Column(name = "placa", length = 10, unique = true, nullable = false)
    private String placa;

    @Column(name = "renavam", length = 11, unique = true, nullable = false)
    private String renavam;

    @Column(name = "cliente", nullable = false)
    private Integer cliente;

    @Column(name = "marca", nullable = false)
    private Integer marca;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(String anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }
}
