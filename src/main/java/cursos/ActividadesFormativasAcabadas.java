/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author imad
 */
public class ActividadesFormativasAcabadas {

    private String titulo;
 //Anotaciones json para que al leer los mismo salga el correcto formato
    //no me hacen falta las clases serializadora y deserializadora ya que los
    //importo a traves de las dependencias en el pom.xml y el jsonformat
    //le da la forma correcta y el patron para que funcione
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
 //   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaFin;

    public ActividadesFormativasAcabadas() {
    }

    public ActividadesFormativasAcabadas(String titulo, LocalDate fechaFin) {
        this.titulo = titulo;
        this.fechaFin = fechaFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.titulo);
        hash = 73 * hash + Objects.hashCode(this.fechaFin);
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
        final ActividadesFormativasAcabadas other = (ActividadesFormativasAcabadas) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo + ";" + fechaFin;
    }

}
