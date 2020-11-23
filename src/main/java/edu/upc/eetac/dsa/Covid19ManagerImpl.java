package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Laboratorio;
import edu.upc.eetac.dsa.models.Muestra;
import edu.upc.eetac.dsa.models.Persona;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Covid19ManagerImpl implements Covid19Manager{
    private HashMap<String, Persona> mapPersonas;
    private List<Laboratorio> laboratorios;
    private List<Muestra> muestras;

    private static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    //singleton
    private static Covid19Manager instance;

    public static Covid19Manager getInstance(){
        if(instance==null)
            instance = new Covid19ManagerImpl();
        return instance;
    }

    private Covid19ManagerImpl(){
        this.mapPersonas = new HashMap<>();
        this.laboratorios = new ArrayList<>();
        this.muestras = new LinkedList<>();
    }
    //end singleton


    public HashMap<String, Persona> getMapPersonas() {
        return this.mapPersonas;
    }

    public void setMapPersonas(HashMap<String, Persona> mapPersonas) {
        this.mapPersonas = mapPersonas;
    }

    @Override
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    @Override
    public Persona addPersona(Persona persona) {
        logger.info("trying to add persona.");
        if(this.mapPersonas.size() == 0) {
            logger.info("this persona doesn't exist, adding.");
            this.mapPersonas.put(persona.getIdPersona(), persona);
            logger.info(persona);
            return this.getPersona(persona.getIdPersona());
        }
        return null;
    }

    @Override
    public int addMuestraToLab(Muestra muestra, String idLab) {
        logger.info("añadiendo muestra " + muestra.getIdMuestra() + "al laboratorio " + idLab);
        for(int i = 0; i < this.laboratorios.size(); i++){
            if(this.laboratorios.get(i).getIdLaboratorio().equals(idLab)) {
                logger.info("laboratorio encontrado " + this.laboratorios.get(i).getNombreLab());
                QueueImpl<Muestra> muestrasLab = this.laboratorios.get(i).getMuestras();
                for (int j = 0; j < muestrasLab.size(); j++) {
                    try {
                        if (muestrasLab.pop().equals(muestra)) {
                            logger.info("la muestra ya existe");
                            return -1;
                        }
                    } catch (EmptyQueueException e) {
                        return -1;
                    }
                }
                logger.info("añadiendo la muestra");
                this.laboratorios.get(i).añadirMuestra(muestra);
                this.muestras.add(muestra);
                return 0;
            }
        }
        return -1;
    }

    @Override
    public Muestra procesarMuestra(String idLab) {
        Muestra muestra = null;

        logger.info("processando muestra de lab: " + idLab);
        for(int i = 0; i < this.laboratorios.size(); i++){
            if(this.laboratorios.get(i).getIdLaboratorio().equals(idLab)) {
                logger.info("lab encontrado " + this.laboratorios.get(i).getNombreLab());

                muestra = this.laboratorios.get(i).procesarMuestra();
                logger.info("muestra " + muestra.getIdMuestra() + " procesada");

                muestra.procesarMuestra("positivo", "ha dado positivo en el test");
                logger.info("guardando muestra en usuario " + muestra.getIdMuestra());

                this.mapPersonas.get(muestra.getIdPersona()).addMuestraRealizada(muestra);
                logger.info("guardada");
            }
        }

        return muestra;
    }

    @Override
    public List<Muestra> getMuestrasProcesadas(String idPersona) {
        return this.mapPersonas.get(idPersona).getMuestrasRealizadas();
    }

    @Override
    public void addLaboratorio(Laboratorio lab) {
        this.laboratorios.add(lab);
    }

    @Override
    public void tearDown(){
        this.mapPersonas.clear();
        this.laboratorios.clear();
        this.mapPersonas.clear();
    }

    public Persona getPersona(String idPersona){
        return this.mapPersonas.get(idPersona);
    }

    public List<Persona> getPersonas(){
        return new LinkedList<>(this.mapPersonas.values());
    }
}
