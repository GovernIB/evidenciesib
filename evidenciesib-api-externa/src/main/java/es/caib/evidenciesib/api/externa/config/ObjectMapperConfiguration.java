package es.caib.evidenciesib.api.externa.config;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import org.fundaciobit.pluginsib.utils.rest.ISO8601DateTimeSerializer;
import org.fundaciobit.pluginsib.utils.rest.ISO8601TimestampSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import es.caib.evidenciesib.model.bean.EvidenciaBean;
import es.caib.evidenciesib.model.bean.FitxerBean;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.persistence.FitxerJPA;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
@Provider
@Produces("application/json")
public class ObjectMapperConfiguration extends JacksonJaxbJsonProvider {

    protected static Logger log = Logger.getLogger(ObjectMapperConfiguration.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {

        SimpleModule modul = new SimpleModule();
        modul.addSerializer(Timestamp.class, new ISO8601TimestampSerializer());
        modul.addSerializer(Date.class, new ISO8601DateTimeSerializer());
        MAPPER.registerModule(modul);

        // allow only non-null fields to be serialized
        MAPPER.setSerializationInclusion(Include.NON_NULL);

        MAPPER.addMixIn(FitxerBean.class, FitxerBeanWithIgnores.class);

        MAPPER.addMixIn(FitxerJPA.class, FitxerBeanWithIgnores.class);
        
        MAPPER.addMixIn(EvidenciaBean.class, EvidenciaSwaggerDoc.class);
        
        MAPPER.addMixIn(EvidenciaJPA.class, EvidenciaSwaggerDoc.class);
        
        MAPPER.addMixIn(Evidencia.class, EvidenciaSwaggerDoc.class);

    }

    public ObjectMapperConfiguration() {
        super.setMapper(MAPPER);
    }

    public static abstract class FitxerBeanWithIgnores {
        @JsonIgnore
        public abstract javax.activation.DataHandler getData(); 

        @JsonIgnore
        public abstract Set<EvidenciaJPA> getEvidencia_fitxeradaptatids();

        @JsonIgnore
        public abstract Set<EvidenciaJPA> getEvidencia_fitxeroriginalids();

        @JsonIgnore
        public abstract Set<EvidenciaJPA> getEvidencia_fitxersignatids();
    }
    
    // XYZ ZZZ Eliminar
    public static abstract class EvidenciaSwaggerDoc {
        
        @Schema(description = "Nom descriptiu de l'evidència.")
        java.lang.String nom;
        
        @Schema(description = "Estat en que ha finalitzat l'evidència. Posibles estats:\r\n EVIDENCIA_ESTAT_CODI_ERROR = -1;\r\n"
                + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO = 1;\r\n"
                + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN = 2;\r\n"
                + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA = 3;\r\n"
                + "    public static final int EVIDENCIA_ESTAT_CODI_SIGNAT = 10;")
        public abstract int getEstatCodi();

        @Schema(description = "Nom de la persona ")
        public abstract String getPersonaNom();
    }

}

