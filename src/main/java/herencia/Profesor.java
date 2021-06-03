/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author imad
 */
public abstract class Profesor extends Persona {

    private String idProfesor;

    public Profesor() {
        // Implícitamente está llamando a super();

    }

    public Profesor(String idProfesor, String nombre, String apellido, String direccion, int edad) {
        super(nombre, apellido, direccion, edad);
        this.idProfesor = idProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        //sobrescribe este método usando el método toString de Persona
        return super.toString() + " Id profesor: " + idProfesor;
    }

    //método abstracto llamado importeNomina(double sueldoBase) que devuelve un double.
    public abstract double importeNomina(double sueldoBase);
}
