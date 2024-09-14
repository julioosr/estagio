package com.julio.proregister.model;

import java.io.Serializable;
import java.util.Objects;

public class OSItemId implements Serializable {
    private Integer servico;
    private Integer os;
    private Integer usuario;

    public OSItemId() {}

    public OSItemId(Integer servico, Integer os, Integer usuario) {
        this.servico = servico;
        this.os = os;
        this.usuario = usuario;
    }

    // Getters, Setters, equals, and hashCode

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OSItemId osItemId = (OSItemId) o;
        return Objects.equals(servico, osItemId.servico) &&
                Objects.equals(os, osItemId.os) &&
                Objects.equals(usuario, osItemId.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servico, os, usuario);
    }
}
