/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author imad
 */
public class ActividadesFormativas implements Comparable <ActividadesFormativas>{
    private String centro;
    private String codigo;
    private String titulo;
    private String modalidad;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String dirigidoA;

    public ActividadesFormativas(String centro, String codigo,String titulo, String modalidad, String estado, LocalDate fechaInicio, LocalDate fechaFin, String dirigidoA) {
        this.centro = centro;
        this.codigo = codigo;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dirigidoA = dirigidoA;
    }

    ActividadesFormativas() {
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return  centro + ";" + codigo + ";" + titulo+";"+modalidad + ";" + estado + ";" + fechaInicio + ";" + fechaFin + ";" + dirigidoA;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.centro);
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.modalidad);
        hash = 97 * hash + Objects.hashCode(this.estado);
        hash = 97 * hash + Objects.hashCode(this.fechaInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaFin);
        hash = 97 * hash + Objects.hashCode(this.dirigidoA);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadesFormativas other = (ActividadesFormativas) obj;
        if (!Objects.equals(this.centro, other.centro)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.modalidad, other.modalidad)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.dirigidoA, other.dirigidoA)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ActividadesFormativas t) {
        return this.getFechaInicio().compareTo(t.getFechaInicio());
    }
    
            
}
