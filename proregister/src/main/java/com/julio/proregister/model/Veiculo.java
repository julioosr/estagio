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

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    // Relacionamento ManyToOne com a marca
    @ManyToOne
    @JoinColumn(name = "marca", nullable = false) // nome da coluna que armazena o ID da marca
    private Marca marca; // Objeto Marca em vez de um Integer

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
