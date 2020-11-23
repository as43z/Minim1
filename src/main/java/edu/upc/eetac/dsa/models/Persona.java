package edu.upc.eetac.dsa.models;

public class Persona {
    private String idPersona;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nivelSalud; //(A, B, C, D)

    public Persona(String idPersona, String nombre, String apellidos,
                   String fechaNacimiento, String nivelSalud){

        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelSalud = nivelSalud;
    }

    public Persona(String nombre, String apellidos,
                   String fechaNacimiento, String nivelSalud){

        this.idPersona = ""; //randomID()
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelSalud = nivelSalud;
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
}
