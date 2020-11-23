package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.Covid19Manager;
import edu.upc.eetac.dsa.Covid19ManagerImpl;
import edu.upc.eetac.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//Models or Element Entity
//Swagger Imports
@Api(value = "/CovidManager", description = "Endpoint to User Service")
@Path("/CovidManager")
public class CovidManagerService {
    static final Logger logger = Logger.getLogger(CovidManagerService.class);
    private Covid19Manager cManager;


    public CovidManagerService() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.cManager = Covid19ManagerImpl.getInstance();
        if (this.cManager.getMapPersonas().size() == 0) {
            Persona albert = new Persona("aaS", "albert", "saez nunez",
                    "14-06-2000", "A");
            Laboratorio lab = new Laboratorio("lab1", "TestLab 1");

            Muestra muestra1 = new Muestra(albert.getIdPersona(), lab.getIdLaboratorio(),
                    "23-11-2020");

            this.cManager.addPersona(albert);
            this.cManager.addLaboratorio(lab);
            this.cManager.addMuestraToLab(muestra1, lab.getIdLaboratorio());

        }
    }

    @GET
    @ApiOperation(value = "Get all Personas", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer = "List"),
    })
    @Path("/Personas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<Persona> personas = this.cManager.getPersonas();
        GenericEntity<List<Persona>> entity = new GenericEntity<List<Persona>>(personas) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get all Labs", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Laboratorio.class, responseContainer = "List"),
    })
    @Path("/Laboratorios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabs() {
        List<Laboratorio> labs = this.cManager.getLaboratorios();
        GenericEntity<List<Laboratorio>> entity = new GenericEntity<List<Laboratorio>>(labs) {
        };
        return Response.status(201).entity(entity).build();
    }
}