package com.julio.proregister.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;

@Entity
@Table(name = "os")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordemid")
    private Integer ordemID;

    @Column(name = "dataagenda")
    private LocalDate dataAgenda;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "datarealizada")
    private LocalDate dataRealizada;

    @Column(name = "total", precision = 18, scale = 2)
    private BigDecimal total;

    @Column(name = "cliente")
    private Integer cliente;

    @Column(name = "veiculo")
    private Integer veiculo;

    @Column(name = "usuario")
    private Integer usuario;

    // Getters e Setters
    public Integer getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(Integer ordemID) {
        this.ordemID = ordemID;
    }

    public LocalDate getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(LocalDate dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalDate getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(LocalDate dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Integer veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
