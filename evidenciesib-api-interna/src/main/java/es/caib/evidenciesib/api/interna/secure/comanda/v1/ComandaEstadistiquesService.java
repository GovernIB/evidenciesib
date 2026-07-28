package es.caib.evidenciesib.api.interna.secure.comanda.v1;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.SelectDistinct;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.comanda.api.server.monitoring.ComandaAppEstadistiquesApi;
import es.caib.comanda.model.server.monitoring.Dimensio;
import es.caib.comanda.model.server.monitoring.DimensioDesc;
import es.caib.comanda.model.server.monitoring.EstadistiquesInfo;
import es.caib.comanda.model.server.monitoring.Fet;
import es.caib.comanda.model.server.monitoring.Format;
import es.caib.comanda.model.server.monitoring.IndicadorDesc;
import es.caib.comanda.model.server.monitoring.RegistreEstadistic;
import es.caib.comanda.model.server.monitoring.RegistresEstadistics;
import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.EvidenciaLogicaService;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * 
 * @author anadal (u80067)
 * 29 may 2026 11:35:57
 */
@Path("/secure")
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ComandaServerUtils.SECURITY_NAME, scheme = "basic")
@RolesAllowed({ Constants.EVI_WS })
@SecurityRequirement(name = ComandaEstadistiquesService.SECURITY_NAME)
public class ComandaEstadistiquesService extends RestUtils implements ComandaAppEstadistiquesApi {
    
    
    public static final Map<String, List<Integer>> tipus = Map.of(
            //
            "EVIDENCIA_OK", List.of(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT),
            //
            "EVIDENCIA_ERROR", List.of(Constants.EVIDENCIA_ESTAT_CODI_ERROR),
            //
            "EVIDENCIA_EN_PROCES",
            List.of(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO,
                    Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN,
                    Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA)

    );

    private static final String DIMENSIO_APPLICACIO = "APP";

    protected static final String SECURITY_NAME = "BasicAuth";

    @EJB(mappedName = EvidenciaLogicaService.JNDI_NAME)
    protected EvidenciaLogicaService evidenciaLogicaEjb;

    /**
     * Obtenir informació de &#39;estructura de les estadístiques
     *
     * Retorna el codi de l&#39;app i el catàleg de dimensions i indicadors disponibles.
     *
     */
    @GET
    @Path("/estadistiques/v1/info")
    @Produces({ "application/json" })
    @ApiOperation(
            value = "Obtenir informació de 'estructura de les estadístiques",
            tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = { @ApiResponse(code = 200, message = "successful operation", response = EstadistiquesInfo.class) })

    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public EstadistiquesInfo estadistiquesInfo() {

        EstadistiquesInfo info = new EstadistiquesInfo();

        info.setCodi("EVI_ESTADISTIQUES_PETICIONS");
        info.setData(OffsetDateTime.now());

        // ==============   DIMENSIONS (EIXOS)

        /*
        List<String> valorsEntitat;
        try {
            valorsEntitat = evidenciaLogicaEjb.executeQuery(new SelectDistinct<String>(EvidenciaFields.ENTITATID));
        } catch (I18NException e) {
            throw new InternalServerErrorException("Error obtenint les entitats disponibles per les estadístiques: "
                    + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage())), e);
        }
        
        DimensioDesc dimDesc1 = new DimensioDesc();
        dimDesc1.setCodi(DIMENSIO_ENTITAT);
        dimDesc1.setDescripcio("Entitat");
        dimDesc1.setNom("Entitat");
        dimDesc1.setValors(valorsEntitat);
        */

        List<String> valorsAplicacio;
        try {
            valorsAplicacio = evidenciaLogicaEjb
                    .executeQuery(new SelectDistinct<String>(EvidenciaFields.USUARIAPLICACIO));
        } catch (I18NException e) {
            throw new InternalServerErrorException("Error obtenint les aplicacions disponibles per les estadístiques: "
                    + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage())), e);
        }

        DimensioDesc dimDesc2 = new DimensioDesc();
        dimDesc2.setCodi(DIMENSIO_APPLICACIO);
        dimDesc2.setDescripcio("Aplicació que ha fet la cridada");
        dimDesc2.setNom("Usuari Aplicació");
        dimDesc2.setValors(valorsAplicacio);

        info.setDimensions(List.of(dimDesc2));

        // ==============   INDICADORS (FETS, VALORS DE CADA CASELLA)

        // ESTADISTICA_TIPUS_EVIDENCIA_OK
        IndicadorDesc indDesc1 = new IndicadorDesc();
        indDesc1.setCodi("EVIDENCIA_OK");
        indDesc1.setDescripcio("Evidències finalitzades correctament");
        indDesc1.setNom("Evidències OK");
        indDesc1.setFormat(Format.LONG);

        // ESTADISTICA_TIPUS_EVIDENCIA_ERROR
        IndicadorDesc indDesc2 = new IndicadorDesc();
        indDesc2.setCodi("EVIDENCIA_ERROR");
        indDesc2.setDescripcio("Evidències finalitzades amb error");
        indDesc2.setNom("Evidències Error");
        indDesc2.setFormat(Format.LONG);

        // ESTADISTICA_TIPUS_EVIDENCIA_ENPROCES
        IndicadorDesc indDesc3 = new IndicadorDesc();
        indDesc3.setCodi("EVIDENCIA_EN_PROCES");
        indDesc3.setDescripcio("Evidències en procés de creació, login o firma");
        indDesc3.setNom("Evidències en procés");
        indDesc3.setFormat(Format.LONG);

        info.setIndicadors(List.of(indDesc1, indDesc2, indDesc3));

        info.setVersio("1.0");

        return info;
    }

    @GET
    @Path("/estadistiques/v1")
    @Produces({ "application/json" })
    @ApiOperation(
            value = "Obtenir darreres estadístiques diàries disponibles",
            tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful operation", response = RegistresEstadistics.class) })

    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    public RegistresEstadistics estadistiques() {

        Timestamp dataConsulta = new Timestamp(System.currentTimeMillis());

        return estadistiquesPerUnDia(dataConsulta);

    }

    /**
     * Obtenir estadístiques d&#39;una data concreta
     *
     * Retorna les estadístiques corresponents a la data indicada amb format dd-MM-yyyy.
     *
     */
    @GET
    @Path("/estadistiques/v1/of/{data}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir estadístiques d'una data concreta", tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful operation", response = RegistresEstadistics.class) })

    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public RegistresEstadistics estadistiquesPerData(@PathParam("data")
    String data) {

        Timestamp dataConsulta = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(data);

        return estadistiquesPerUnDia(dataConsulta);

    }

    /**
     * Obtenir les estadístiques d&#39;un interval donat
     *
     * Retorna llista d&#39;estadístiques de tots els dies entre la dataInici i la dataFi (en format dd-MM-yyyy), ambdues incloses.
     *  La resposta contindrà un objecte de tipus RegistresEstadistics per a cada dia inclòs en l'interval.
     *
     */
    @GET
    @Path("/estadistiques/v1/from/{dataInici}/to/{dataFi}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir les estadístiques d'un interval donat", tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = { @ApiResponse(
                    code = 200,
                    message = "successful operation",
                    response = RegistresEstadistics.class,
                    responseContainer = "List") })
    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public List<RegistresEstadistics> estadistiquesPerRang(@PathParam("dataInici")
    String dataInici, @PathParam("dataFi")
    String dataFi) {

        Timestamp dataIniciTs = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(dataInici);
        Timestamp dataFiTs = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(dataFi);

        // Ara es fa un bucle per cada dia entre dataInici i dataFi i es crida al metode estadistiquesPerUnDia per cada dia
        // TODO  Si fos necessari es podria optimitzar fent una consulta que agafes les dades de tot l'interval i després agrupant-les per dia, però com el volum de dades no es preveu que sigui molt gran, es fa d'una manera més senzilla.
        List<RegistresEstadistics> results = new ArrayList<>();

        Timestamp currentDate = dataIniciTs;

        while (!currentDate.after(dataFiTs)) {
            RegistresEstadistics re = estadistiquesPerUnDia(currentDate);

            if (re.getFets() != null && !re.getFets().isEmpty()) {
                results.add(re);
            }

            // Incrementar currentDate en un dia
            currentDate = new Timestamp(currentDate.getTime() + 24 * 60 * 60 * 1000);
        }

        return results;

    }

    // ----------------------------------------------------------------
    // -------------------- METODE UTILITATS ---------------------
    // ----------------------------------------------------------------

    protected RegistresEstadistics estadistiquesPerUnDia(Timestamp dataConsulta) {
        List<RegistreEstadistic> registres = new ArrayList<>();
        try {

            Timestamp[] startAndEndOfDay = ComandaServerUtils.getStartAndEndOfDay(dataConsulta);

            Where wFromTo = EvidenciaFields.DATAINICI.between(startAndEndOfDay[0], startAndEndOfDay[1]);

           

            // Llegim les aplicacions que han fet peticions en aquesta dates
            List<String> aplicacions = evidenciaLogicaEjb
                    .executeQuery(new SelectDistinct<String>(EvidenciaFields.USUARIAPLICACIO), wFromTo);

            for (String aplicacio : aplicacions) {

                Dimensio dimDesc1 = new Dimensio();
                dimDesc1.setCodi(DIMENSIO_APPLICACIO);
                dimDesc1.setValor(aplicacio);

                Where wAplic = EvidenciaFields.USUARIAPLICACIO.equal(aplicacio);

                List<Fet> fets = new ArrayList<>();
                for (Map.Entry<String, List<Integer>> e : tipus.entrySet()) {

                    Where wTipus = Where.AND(wAplic, EvidenciaFields.ESTATCODI.in(e.getValue()), wFromTo);

                    Long valorObj = evidenciaLogicaEjb.count(wTipus);

                    if (valorObj == null || valorObj.doubleValue() == 0D) {
                        continue; // Si no hi ha dades per aquest tipus, no afegim el fet
                    }

                    Fet fet = new Fet();
                    fet.setCodi(e.getKey());
                    fet.setValor(valorObj.doubleValue());

                    fets.add(fet);

                }

                RegistreEstadistic registre = new RegistreEstadistic();
                registre.setDimensions(List.of(dimDesc1));
                registre.setFets(fets);

                registres.add(registre);

            }

        } catch (Throwable th) {
            String msg;
            if (th instanceof I18NException) {
                I18NException e = (I18NException) th;
                msg = I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage()));
            } else {
                msg = th.getMessage();
            }

            throw new InternalServerErrorException("Error construint la consulta per obtenir les estadístiques: " + msg,
                    th);
        }

        RegistresEstadistics re = new RegistresEstadistics();
        re.setFets(registres);

        //Temps temps = ComandaServerUtils.createTempsFromDate(dataConsulta);

        // Crear un offsetdatetime a partir de dataConsulta
        OffsetDateTime temps = dataConsulta.toInstant().atOffset(OffsetDateTime.now().getOffset());

        re.setTemps(temps);

        return re;
    }

}
