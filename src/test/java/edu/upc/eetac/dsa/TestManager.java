package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Laboratorio;
import edu.upc.eetac.dsa.models.Muestra;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import edu.upc.eetac.dsa.models.Persona;
import org.junit.*;

import java.util.LinkedList;
import java.util.List;

public class TestManager {
    private Covid19Manager cManager;
    private static Logger logger = Logger.getLogger(TestManager.class);

    @Before
    public void SetUp(){
        this.cManager = Covid19ManagerImpl.getInstance();
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @After
    public void TearDown(){
        this.cManager.tearDown();
    }

    @Test
    public void TestAddPersonas(){
        Persona albert = new Persona("aaS", "albert", "saez nunez",
                "14-06-2000", "A");
        this.cManager.addPersona(albert);
        Assert.assertEquals("albert", this.cManager.getMapPersonas().get(albert.getIdPersona()).getNombre());
    }

    @Test
    public void TestAddMuestra(){
        Persona albert = new Persona("aaS", "albert", "saez nunez",
                "14-06-2000", "A");
        Laboratorio lab = new Laboratorio("lab1", "TestLab 1");
        Muestra muestra = new Muestra(albert.getIdPersona(), lab.getIdLaboratorio(),
                "23-11-2020");

        this.cManager.addPersona(albert);
        this.cManager.addLaboratorio(lab);
        this.cManager.addMuestraToLab(muestra, lab.getIdLaboratorio());

        Muestra muestra_proc = this.cManager.procesarMuestra(lab.getIdLaboratorio());

        Assert.assertEquals(muestra_proc.getIdMuestra(), this.cManager.getMuestrasProcesadas(albert.getIdPersona()).get(0).getIdMuestra());
    }
    @Test
    public void TestAssMuestra2(){
        Persona albert = new Persona("aaS", "albert", "saez nunez",
                "14-06-2000", "A");
        Laboratorio lab = new Laboratorio("lab1", "TestLab 1");
        Muestra muestra1 = new Muestra(albert.getIdPersona(), lab.getIdLaboratorio(),
                "23-11-2020");
        Muestra muestra2 = new Muestra(albert.getIdPersona(), lab.getIdLaboratorio(),
                "23-11-2020");

        this.cManager.addPersona(albert);
        this.cManager.addLaboratorio(lab);
        this.cManager.addMuestraToLab(muestra1, lab.getIdLaboratorio());
        this.cManager.addMuestraToLab(muestra2, lab.getIdLaboratorio());

        Assert.assertEquals(2, this.cManager.getLaboratorios().get(0).getMuestras().size());

        /*
        List<Muestra> muestras = new LinkedList<>();
        muestras.add(this.cManager.procesarMuestra(lab.getIdLaboratorio()));
        muestras.add(this.cManager.procesarMuestra(lab.getIdLaboratorio()));

        Assert.assertEquals(muestras, this.cManager.getMapPersonas().get(albert.getIdPersona()).getMuestrasRealizadas());
        */
    }
}
