package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class Persona {
    private String idPersona;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nivelSalud; //(A, B, C, D)
    private List<Muestra> muestrasRealizadas;

    public Persona(String idPersona, String nombre, String apellidos,
                   String fechaNacimiento, String nivelSalud){

        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelSalud = nivelSalud;
        this.muestrasRealizadas = new LinkedList<>();
    }

    public Persona(String nombre, String apellidos,
                   String fechaNacimiento, String nivelSalud){

        this.idPersona = RandomUtils.getId(); //randomID()
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelSalud = nivelSalud;
        this.muestrasRealizadas = new LinkedList<>();
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelSalud() {
        return nivelSalud;
    }

    public void setNivelSalud(String nivelSalud) {
        this.nivelSalud = nivelSalud;
    }

    public List<Muestra> getMuestrasRealizadas() {
        return muestrasRealizadas;
    }

    public void setMuestrasRealizadas(List<Muestra> muestrasRealizadas) {
        this.muestrasRealizadas = muestrasRealizadas;
    }

    public void addMuestraRealizada(Muestra muestra){
        this.muestrasRealizadas.add(muestra);
    }
}
