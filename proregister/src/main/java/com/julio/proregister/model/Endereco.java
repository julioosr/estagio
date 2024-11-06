package com.julio.proregister.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enderecoid")
    private Integer id;

    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "rua", length = 30, nullable = false)
    private String rua;

    @Column(name = "complemento", length = 30)
    private String complemento;

    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;

    @Column(name = "numero", length = 8, nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false) // Use o nome da coluna que referenciará o cliente
    private Cliente cliente; // Mude para a entidade Cliente

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    @Column(name = "municipio")
    private Integer municipio; // Considerando que municipio pode ser uma string ou outra entidade

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
