package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Muestra {
    private String idMuestra;
    private String idPersona;
    private String idClinico;
    private String idLaboratorio;
    private String fechaExtraccion;
    private boolean isProcesada;
    private String sPosNeg;
    private String descripcion;

    public Muestra(String idMuestra, String idPersona, String idLaboratorio,
                   String fechaExtraccion){
        this.idMuestra = idMuestra;
        this.idPersona = idPersona;
        this.idClinico = RandomUtils.getId();
        this.idLaboratorio = idLaboratorio;
        this.fechaExtraccion = fechaExtraccion;
        this.isProcesada = false;
    }

    public Muestra(String idPersona, String idLaboratorio,
                   String fechaExtraccion){
        this.idMuestra = RandomUtils.getId(); //Random
        this.idPersona = idPersona;
        this.idClinico = RandomUtils.getId();
        this.idLaboratorio = idLaboratorio;
        this.fechaExtraccion = fechaExtraccion;
        this.isProcesada = false;
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

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public boolean isProcesada() {
        return isProcesada;
    }

    public void setProcesada(boolean procesada) {
        isProcesada = procesada;
    }

    public String getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(String fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public void procesarMuestra(String sPosNeg, String descripcion){
        this.isProcesada = true;
        this.sPosNeg = sPosNeg;
        this.descripcion = descripcion;
    }
}
