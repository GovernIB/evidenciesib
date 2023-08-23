package es.caib.evidenciesib.api.externa.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.log4j.Logger;

/**
 * 
 * @author anadal
 *
 */
@OpenAPIDefinition(

        info = @Info(

                title = "API REST EXTERNA de EvidenciesIB",
                description = "Conjunt de Serveis REST de EvidenciesIB per ser accedits des de l'exterior",
                version = "1.0.0",
                license = @License(name = "License Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(
                        name = "Departament de Govern Digital a la Fundació Bit",
                        email = "governdigital@fundaciobit.org",
                        url = "http://governdigital.fundaciobit.org")

        ),
        servers = { @Server(url = "/evidenciesibapi/externa"),
                @Server(url = "http://localhost:8080/evidenciesibapi/externa"),
                @Server(url = "https://dev.caib.es/evidenciesibapi/externa"),
                @Server(url = "https://proves.caib.es/evidenciesibapi/externa"),
                @Server(url = "https://se.caib.es/evidenciesibapi/externa"),
                @Server(url = "https://www.caib.es/evidenciesibapi/externa") },

        externalDocs = @ExternalDocumentation(
                description = "Java Client (GovernIB Github)",
                url = "https://github.com/GovernIB/evidenciesib/tree/evidenciesib-1.0/evidenciesib-api-externa-client")

)
@ApplicationPath("/")
public class JAXRSConfiguration extends Application {

    protected Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    /**
     * Les aplicacions JAX-RS necessiten un constructor buid.
     */
    public JAXRSConfiguration() {
    }

    /**
     * Podem introduir tasques a realitzar per la inicialització de l'API REST.
     */
    @PostConstruct
    private void init() {
        log.info("Iniciant API REST EXTERNA de EvidenciesIB");
    }

    /* XYZ ZZZ 
    
    @Bean
    public OpenAPI customOpenAPI() {
        Schema newUserSchema = new Schema<Map<String, Object>>()
                .addProperties("name",new StringSchema().example("John123"))
                .addProperties("password",new StringSchema().example("P4SSW0RD"))
                .addProperties("image",new StringSchema().example("https://robohash.org/John123.png"));
    
        return new OpenAPI()
                //.servers(servers)
                .info(new Info()
                        .title("Your app title")
                        .description("App description")
                        .version("1.0")
                        .license(new License().name("GNU/GPL").url("https://www.gnu.org/licenses/gpl-3.0.html"))
                )
                .components(new Components()
                        .addSchemas("NewUserBody" , newUserSchema)
                );
    }
    */

}
