package edu.upc.eetac.dsa.models;

public class Muestra {
    private String idMuestra;
    private String idPersona;
    private String idClinico;
    private String sPosNeg;
    private String descripcion;

    public Muestra(String idMuestra, String idPersona, String idClinico){
        this.idMuestra = idMuestra;
        this.idPersona = idPersona;
        this.idClinico = idClinico;
    }

    public Muestra(String idPersona, String idClinico){
        this.idMuestra = ""; //Random
        this.idPersona = idPersona;
        this.idClinico = idClinico;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getsPosNeg() {
        return sPosNeg;
    }

    public void setsPosNeg(String sPosNeg) {
        this.sPosNeg = sPosNeg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
