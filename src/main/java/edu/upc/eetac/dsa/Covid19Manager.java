package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Laboratorio;
import edu.upc.eetac.dsa.models.Muestra;
import edu.upc.eetac.dsa.models.Persona;

import java.util.HashMap;
import java.util.List;

public interface Covid19Manager {
    //persona
    Persona addPersona(Persona persona);

    //muestra
    int addMuestraToLab(Muestra muestra, String idLab);

    //procesar una muestra de un lab
    Muestra procesarMuestra(String idLab);

    //get muestras procesadas
    List<Muestra> getMuestrasProcesadas(String idPersona);

    //añadir lab
    void addLaboratorio(Laboratorio lab);

    void tearDown();

    HashMap<String, Persona> getMapPersonas();

    List<Laboratorio> getLaboratorios();

    List<Persona> getPersonas();
}
