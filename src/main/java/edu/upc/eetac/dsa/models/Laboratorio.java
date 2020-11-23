package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.EmptyQueueException;
import edu.upc.eetac.dsa.FullQueueException;
import edu.upc.eetac.dsa.QueueImpl;
import edu.upc.eetac.dsa.utils.RandomUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Laboratorio {
    private QueueImpl<Muestra> muestras;
    private int nMuestras;
    private String idLaboratorio;
    private String nombreLab;

    private static Logger logger = Logger.getLogger(Laboratorio.class);

    public Laboratorio(String idLaboratorio, String nombreLab){
        this.idLaboratorio = idLaboratorio;
        this.nombreLab = nombreLab;
        this.muestras = new QueueImpl<Muestra>(10); //10 muestras
        this.nMuestras = 0;
    }

    public Laboratorio(QueueImpl<Muestra> muestras, String nombreLab){
        this.idLaboratorio = RandomUtils.getId();//Random
        this.nombreLab = nombreLab;
        this.muestras = muestras;
        this.nMuestras = muestras.size();
    }

    public QueueImpl<Muestra> getMuestras() {
        logger.info(this.muestras.toString());
        return muestras;
    }

    public void setMuestras(QueueImpl<Muestra> muestras) {
        this.muestras = muestras;
    }

    public int getnMuestras() {
        return nMuestras;
    }

    public void setnMuestras(int nMuestras) {
        this.nMuestras = nMuestras;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }

    public int añadirMuestra(Muestra muestra) {
        try {
            this.muestras.push(muestra);
            this.nMuestras++;
            return 0;
        } catch (FullQueueException e) {
            return -1;
        }
    }

    public Muestra procesarMuestra() {
        try {
            this.nMuestras--;
            return this.muestras.pop();
        } catch (EmptyQueueException e) {
            return null;
        }
    }
}
