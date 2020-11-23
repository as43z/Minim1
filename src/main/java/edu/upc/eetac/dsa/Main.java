package edu.upc.eetac.dsa;

//imports
import io.swagger.jaxrs.config.BeanConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
//endimports

public class Main {
    static final Logger logger = Logger.getLogger(Main.class);
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/minim1/";
    static final String path = "edu.upc.eetac.dsa";


    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages(path + ".services");

        rc.register(io.swagger.jaxrs.listing.ApiListingResource.class);
        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/minim1");
        beanConfig.setContact("albert.saez.nunez@estudiantat.upc.edu");
        beanConfig.setDescription("REST API for Covid Manager by Marc Xapelli");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        beanConfig.setResourcePackage(path + ".services");
        beanConfig.setTermsOfServiceUrl("http://www.example.com/resources/eula");
        beanConfig.setTitle("REST API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setScan(true);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args - Argument
     * @throws IOException -Throws IOException
     */
    public static void main(String[] args) throws IOException {
        //Log4j initialization with proper configuration
        //PropertiesConfigurator is used to configure logger from properties file
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.debug("Debug Test Message!");

        // Server Initialization Code
        final HttpServer server = startServer();

        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");

        //Formatting BASE_URI FOR SWAGGER
        System.out.println(String.format("RestApi Started at " + "%s", BASE_URI));

        String swagger_uri = BASE_URI;
        String target = "minim1";
        String replacement = "swagger";

        swagger_uri = swagger_uri.replace(target, replacement);
        System.out.println(String.format("Swagger link: " + "%s\nHit enter to stop it...", swagger_uri));

        System.in.read();
        server.shutdownNow();
    }
}
