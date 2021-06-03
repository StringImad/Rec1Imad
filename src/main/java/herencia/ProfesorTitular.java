/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;

/**
 *
 * @author imad
 */
public class ProfesorTitular extends Profesor {

    private LocalDate fechaTomaPosicion;

    public ProfesorTitular() {
    }

    public ProfesorTitular(LocalDate fechaTomaPosicion, String idProfesor, String nombre, String apellido, String direccion, int edad) {
        super(idProfesor, nombre, apellido, direccion, edad);
        this.fechaTomaPosicion = fechaTomaPosicion;
    }

    @Override
    public double importeNomina(double sueldoBase) {
        double sueldoTotal = (sueldoBase * 0.3) + sueldoBase;

        return sueldoTotal; 
    }

    public LocalDate getFechaTomaPosicion() {
        return fechaTomaPosicion;
    }

    public void setFechaTomaPosicion(LocalDate fechaTomaPosicion) {
        this.fechaTomaPosicion = fechaTomaPosicion;
    }

    @Override
    public String toString() {
        return super.toString()+" FechaTomaPoscion: "+ fechaTomaPosicion + '}';
    }

}
