package com.julio.proregister.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "os")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordemid")
    private Integer id;

    @Column(name = "dataagenda")
    private LocalDate dataAgenda;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @Column(name = "datarealizada")
    private LocalDate dataRealizada;

    @Column(name = "total", precision = 18, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servico")
    private Servico servico;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
