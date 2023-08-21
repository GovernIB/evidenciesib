package es.caib.evidenciesib.api.externa.secure.evidencies;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.IGenAppEntity;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.ITableManager;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestPagination;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.ejb.EvidenciaService;
import es.caib.evidenciesib.ejb.FitxerService;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.logic.utils.I18NLogicUtils;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.persistence.FitxerJPA;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

/**
 * 
 * @author anadal
 *
 */
@Path("/secure/evidencies")
@OpenAPIDefinition(
        tags = { @Tag(name = EvidenciesRestService.TAG_NAME, description = "Realització d'Evidències via API REST"), })
@SecurityScheme(type = SecuritySchemeType.HTTP, name = EvidenciesRestService.SECURITY_NAME, scheme = "basic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvidenciesRestService extends RestUtils {

    // No modificar !!!
    protected static final String TAG_NAME = "Evidencies";

    protected static final String SECURITY_NAME = "BasicAuth";

    protected static Logger log = Logger.getLogger(EvidenciesRestService.class);

    @EJB(mappedName = es.caib.evidenciesib.ejb.EvidenciaService.JNDI_NAME)
    protected EvidenciaService evidenciaEjb;

    @EJB(mappedName = FitxerService.JNDI_NAME)
    protected FitxerService fitxerEjb;

    @Path("/start")
    @POST
    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Operation(
            tags = { TAG_NAME },
            operationId = "start",
            requestBody = @RequestBody(
                    description = "Estructura de dades inicials per iniciar un procés d'evidències",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "evidenciaStartRequest",
                                    required = true,
                                    implementation = EvidenciaStartRequest.class))),
            summary = "Primera cridada a realitzar per iniciar un procés d'evidències")

    @ApiResponses({
            @ApiResponse(
                    responseCode = "400",
                    description = "Paràmetres incorrectes",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "401",
                    description = "No Autenticat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "403",
                    description = "No Autoritzat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error no controlat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "200",
                    description = "Procés de recolecció d'evidències inciaciat correctament",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = EvidenciaStartResponse.class)) }) })
    public EvidenciaStartResponse start(@RequestBody EvidenciaStartRequest evidenciaStartRequest,
            @Parameter(hidden = true) @Context HttpServletRequest request) {

        log.info(" Entra a EvidenciaStart ...[" + request.getRemoteUser() + "]");

        String language = evidenciaStartRequest.getLanguageUI();

        // Check de language
        language = checkLanguage(language);

        // Check username aplication
        // XYZ ZZZ TODO 

        try {

            // XYZ ZZZ Això s'ha de moure a EJB !!!!

            // Crear fitxer en BBDD
            byte[] fileToSignBytes = evidenciaStartRequest.getDocumentASignar();

            FitxerJPA fitxer = new FitxerJPA();
            fitxer.setDescripcio(null);
            fitxer.setMime(evidenciaStartRequest.getDocumentASignarMime());
            fitxer.setNom(evidenciaStartRequest.getDocumentASignarNom());
            fitxer.setTamany(fileToSignBytes.length);

            fitxerEjb.create(fitxer);

            // Guardar fitxer físic en Disc Dur
            FileSystemManager.crearFitxer(new ByteArrayInputStream(fileToSignBytes), fitxer.getFitxerID());

            // Crear Evidència
            EvidenciaJPA evi = new EvidenciaJPA();

            evi.setCallBackUrl(evidenciaStartRequest.getCallBackUrl());

            evi.setLoginType(Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN);

            evi.setNom(evidenciaStartRequest.getTitolEvidencia());

            // XYZ ZZZ TODO 
            evi.setFirmaIdiomaDocument(evidenciaStartRequest.getLanguageDocument());

            evi.setDataInici(new Timestamp(System.currentTimeMillis()));
            evi.setUsuariPersona(null);
            evi.setUsuariAplicacio(request.getRemoteUser());
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO);

            evi.setFitxerOriginalID(fitxer.getFitxerID());
            evi.setFirmaIdiomaDocument(evidenciaStartRequest.getLanguageDocument());

            evi.setPersonaLlinatge1(evidenciaStartRequest.getPersonaLlinatge1());
            evi.setPersonaLlinatge2(evidenciaStartRequest.getPersonaLlinatge2());
            evi.setPersonaNom(evidenciaStartRequest.getPersonaNom());
            evi.setPersonaEmail(evidenciaStartRequest.getPersonaEmail());

            evi.setPersonaNif(evidenciaStartRequest.getPersonaNif());
            evi.setFirmaReason(evidenciaStartRequest.getRaoDeLaFirma());
            evi.setNom(evidenciaStartRequest.getTitolEvidencia());

            evidenciaEjb.create(evi);

            log.info("Creada evidencia amb ID " + evi.getEvidenciaID());

            EvidenciaStartResponse response = new EvidenciaStartResponse();

            response.setEvidenciaID(evi.getEvidenciaID());
            {
                // Hem d'anar a FRONT per autenticació Cl@ve o Mock            

                // XYZ ZZZ ZZZ
                final String urlfront = Configuracio.getFrontUrl();

                // XYZ ZZZ TODO Falta un HASH per evitar que gent es connecti directament al FRONT ...
                final String url = urlfront + Constants.MAPPING_FRONT_LOGIN_START + "/" + evi.getEvidenciaID();

                response.setEvidenciaUrlRedirect(url);
            }

            return response;

        } catch (RestException oae) {
            log.error("Error en evidenciaStart: " + oae.getMessage(), oae);
            throw oae;
        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                msg = I18NLogicUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }

            log.error("Error en evidenciaStart: " + msg, th);
            throw new RestException(msg, th, Status.BAD_REQUEST);
        }

    }

    // obtenir evidencia
    @Path("/get/{evidenciaID}")
    @GET
    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Operation(
            tags = { TAG_NAME },
            operationId = "get",
            summary = "Retorna informació d'una evidència a partir del seu id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "400",
                    description = "Paràmetres incorrectes",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "401",
                    description = "No Autenticat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "403",
                    description = "No Autoritzat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error no controlat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "200",
                    description = "Retornada correctament la informació de l'evidència",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = Evidencia.class)) }) })
    public Evidencia get(

            @Parameter(
                    name = "evidenciaID",
                    description = "Identificador de l'evidència de la que volem informació",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(implementation = Long.class)) @PathParam("evidenciaID") Long evidenciaID,
            @Parameter(
                    name = "language",
                    description = "Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "ca",
                    examples = { @ExampleObject(name = "Català", value = "ca"),
                            @ExampleObject(name = "Castellano", value = "es") },
                    schema = @Schema(implementation = String.class)) @QueryParam("language") String language,
            @Parameter(hidden = true) @Context HttpServletRequest request) {

        log.info("Entra a get  ...[" + request.getRemoteUser() + "]");

        // Check de language
        language = checkLanguage(language);

        // Check Evidència 
        if (evidenciaID == null || evidenciaID <= 0) {

            // XYZ ZZZ Segons idioma
            throw new RestException("El paràmetre evidenciaID té un valor incorrecte: " + evidenciaID,
                    Status.BAD_REQUEST);
        }

        try {

            Evidencia evi = evidenciaEjb.findByPrimaryKey(evidenciaID);

            // Check username aplication
            if (!request.getRemoteUser().equals(evi.getUsuariAplicacio())) {
                // XYZ ZZZ Segons idioma
                throw new RestException("L'aplicació " + request.getRemoteUser()
                        + " no és la propietària de l'evidència amb ID " + evidenciaID, Status.BAD_REQUEST);
            }

            evi.getFitxerOriginal().setEncryptedFileID(HibernateFileUtil.encryptFileID(evi.getFitxerOriginalID()));

            if (evi.getFitxerAdaptatID() != null) {
                evi.getFitxerAdaptat().setEncryptedFileID(HibernateFileUtil.encryptFileID(evi.getFitxerAdaptatID()));
            }

            if (evi.getFitxerSignatID() != null) {
                evi.getFitxerSignat().setEncryptedFileID(HibernateFileUtil.encryptFileID(evi.getFitxerSignatID()));
            }

            return evi;

        } catch (RestException oae) {
            log.error("Error obtenint evidència: " + oae.getMessage(), oae);
            throw oae;
        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                msg = I18NLogicUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }

            // XYZ ZZZ Segons idioma
            msg = "Error obtenint evidència " + msg;

            log.error(msg, th);
            throw new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

    }

    // obtenir llista d'evidències filtre per nom, aplicacio i dates

    @Path("/list")
    @GET
    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Produces({ RestUtils.MIME_APPLICATION_JSON })
    @Consumes({ RestUtils.MIME_APPLICATION_JSON })
    @Operation(tags = { TAG_NAME }, operationId = "list", summary = "Retorna un llistat de les evidencies ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "400",
                    description = "EFIB: Paràmetres incorrectes",
                    content = { @Content(
                            mediaType = RestUtils.MIME_APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "401",
                    description = "EFIB: No Autenticat",
                    content = { @Content(
                            mediaType = RestUtils.MIME_APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "403",
                    description = "EFIB: No Autoritzat",
                    content = { @Content(
                            mediaType = RestUtils.MIME_APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "500",
                    description = "EFIB: Error durant la consulta de les dades obertes",
                    content = { @Content(
                            mediaType = RestUtils.MIME_APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "200",
                    description = "EFIB: Retornades dades obertes correctament",
                    content = { @Content(
                            mediaType = RestUtils.MIME_APPLICATION_JSON,
                            schema = @Schema(implementation = EvidenciesPaginacio.class)) }) })
    public EvidenciesPaginacio list(@Parameter(
            description = "Data d'inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades",
            in = ParameterIn.QUERY,
            required = false,
            example = "2022-08-29",
            schema = @Schema(implementation = String.class)) @QueryParam("inici") final String dataIniciRequest,
            @Parameter(
                    description = "Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "2023-12-31",
                    schema = @Schema(implementation = String.class)) @QueryParam("fi") final String dataFiRequest,
            @Parameter(
                    description = "Pàgina de la que es volen obtenir les dades",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "1") @QueryParam("page") Integer page,
            @Parameter(
                    description = "Quantitat d'elements a retornar",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "10") @QueryParam("pagesize") Integer pagesize,
            @Parameter(
                    name = "language",
                    description = "Idioma en que s'han de retornar les dades(Només suportat 'ca' o 'es')",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "ca",
                    examples = { @ExampleObject(name = "Català", value = "ca"),
                            @ExampleObject(name = "Castellano", value = "es") },
                    schema = @Schema(implementation = String.class)) @QueryParam("language") String language,
            @Parameter(hidden = true) @Context HttpServletRequest request,
            @Parameter(hidden = true) @Context SecurityContext security) throws RestException {

        log.info(" Entra a list()" + page + " " + pagesize + "...[" + request.getRemoteUser() + "]");

        // Check de page i pagesize
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pagesize == null || pagesize < 1) {
            pagesize = 10;
        }

        // Check de language
        language = RestUtils.checkLanguage(language);

        // Convertir Data en format dd/MM/yyyy a tipus Date
        // i check de dates

        final String dataIniciRequestLabel = "inici";
        final String dataFiRequestLabel = "fi";

        final Date[] dates = checkRangeOfOnlyDates(dataIniciRequest, dataIniciRequestLabel, dataFiRequest,
                dataFiRequestLabel);

        Date dateStart = dates[0];
        Date dateEnd = dates[1];

        // Realitzar Consulta
        try {

            final Timestamp from = new Timestamp(atStartOfDay(dateStart).getTime());
            final Timestamp to = new Timestamp(atEndOfDay(dateEnd).getTime());
            final Where w1 = EvidenciaFields.DATAINICI.between(from, to);
            final Where w2 = EvidenciaFields.USUARIAPLICACIO.equal(request.getRemoteUser());

            final Where w = Where.AND(w1, w2);
            final OrderBy orderBy = new OrderBy(EvidenciaFields.DATAINICI, OrderType.DESC);

            EvidenciesPaginacio paginacio = createRestPagination(EvidenciesPaginacio.class, this.evidenciaEjb, page,
                    pagesize, w, orderBy);

            /*
            final int firstResult = (page - 1) * pagesize;
            final int maxResults = pagesize;
            final List<Evidencia> llistatOrig = this.evidenciaEjb.select(w, null, firstResult, maxResults, orderBy);
            
            long countTotal = this.evidenciaEjb.count(w);
            
            // PAGINACIO
            final int pageSizeOutput = pagesize;
            final int pageOutput = page;
            final int totalPages = (int) (countTotal / pagesize) + ((countTotal % pagesize == 0) ? 0 : 1);
            
            
            EvidenciesPaginacio paginacio = new EvidenciesPaginacio();
            paginacio.setPage(pageSizeOutput);
            paginacio.setPage(pageOutput);
            paginacio.setTotalpages(totalPages);
            paginacio.setTotalcount((int) countTotal);
            paginacio.setData(llistatOrig);
            
            */

            //llistat, countTotal, pageSizeOutput, pageOutput, totalPages);
            log.info("NEteja dates i strings ");
            log.info("Resultat => paginacio " + paginacio);
            log.info("Resultat => getTotalcount " + paginacio.getTotalcount());
            log.info("Resultat => getTotalpages " + paginacio.getTotalpages());

            return paginacio;

        } catch (RestException oae) {
            log.error("Llistant evidències: " + oae.getMessage(), oae);
            throw oae;
        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                msg = I18NCommonUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }
            msg = "Error desconegut llistant evidències: " + msg;
            log.error(msg, th);
            throw new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

    }

    protected static <D extends IGenAppEntity, P extends RestPagination<D>> P createRestPagination(Class<P> classe,
            ITableManager<D, Long> ejb, int page, int pagesize, Where w, OrderBy orderBy
    /* final List<D> llistat, long countTotal, final int pageSizeOutput,
    final int pageOutput, final int totalPages */) throws Exception {

        /*
        final int firstResult = (page - 1) * pagesize;
        final int maxResults = pagesize;
        final List<Evidencia> llistat = this.evidenciaEjb.select(w, null, firstResult, maxResults, orderBy);
        
        long countTotal = this.evidenciaEjb.count(w);
        
        // PAGINACIO
        final int pageSizeOutput = pagesize;
        final int pageOutput = page;
        final int totalPages = (int) (countTotal / pagesize) + ((countTotal % pagesize == 0) ? 0 : 1);
        
        
        EvidenciesPaginacio paginacio = new EvidenciesPaginacio();
        paginacio.setPage(pageSizeOutput);
        paginacio.setPage(pageOutput);
        paginacio.setTotalpages(totalPages);
        paginacio.setTotalcount((int) countTotal);
        paginacio.setData(llistat);
        */

        final int firstResult = (page - 1) * pagesize;
        final int maxResults = pagesize;
        final List<D> llistat = ejb.select(w, null, firstResult, maxResults, orderBy);

        long countTotal = ejb.count(w);

        // PAGINACIO
        final int pageSizeOutput = pagesize;
        final int pageOutput = page;
        final int totalPages = (int) (countTotal / pagesize) + ((countTotal % pagesize == 0) ? 0 : 1);

        P paginacio = classe.getConstructor().newInstance();
        paginacio.setPage(pageSizeOutput);
        paginacio.setPage(pageOutput);
        paginacio.setTotalpages(totalPages);
        paginacio.setTotalcount((int) countTotal);
        paginacio.setData(llistat);
        return paginacio;
    }

    //  obtenir fitxers

    // obtenir fitxer de evidencia
    @Path("/getfile/{evidenciaID}/{encryptedFileID}")
    @GET
    @RolesAllowed({ Constants.EVI_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Operation(
            tags = { TAG_NAME },
            operationId = "getfile",
            summary = "Retorna informació d'una evidència a partir del seu id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "400",
                    description = "Paràmetres incorrectes",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "401",
                    description = "No Autenticat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "403",
                    description = "No Autoritzat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error no controlat",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(
                    responseCode = "200",
                    description = "Retornada correctament la informació de l'evidència",
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = EvidenciaFile.class)) }) })
    public EvidenciaFile getFile(

            @Parameter(
                    name = "evidenciaID",
                    description = "Identificador de l'evidència de la que volem informació",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(implementation = Long.class)) @PathParam("evidenciaID") Long evidenciaID,

            @Parameter(
                    name = "encryptedFileID",
                    description = "Identificador encriptat del fitxer que volem descarregar.",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(
                            implementation = String.class)) @PathParam("encryptedFileID") String encryptedFileID,

            @Parameter(
                    name = "language",
                    description = "Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "ca",
                    examples = { @ExampleObject(name = "Català", value = "ca"),
                            @ExampleObject(name = "Castellano", value = "es") },
                    schema = @Schema(implementation = String.class)) @QueryParam("language") String language,
            @Parameter(hidden = true) @Context HttpServletRequest request) {

        log.info("Entra a getFile ...[" + request.getRemoteUser() + "]");

        Evidencia evi = get(evidenciaID, language, request);

        try {

            Long fileID = HibernateFileUtil.decryptFileID(encryptedFileID);

            Fitxer file;

            if (fileID.equals(evi.getFitxerOriginalID())) {
                file = evi.getFitxerOriginal();
            } else if (fileID.equals(evi.getFitxerAdaptatID())) {
                file = evi.getFitxerAdaptat();
            } else if (fileID.equals(evi.getFitxerSignatID())) {
                file = evi.getFitxerSignat();
            } else {
                final String msg = "El fitxer amb encryptedFileID igual a " + encryptedFileID
                        + " no es troba en l'evidència amb ID " + evidenciaID;
                throw new RestException(msg, Status.BAD_REQUEST);
            }

            EvidenciaFile ef = new EvidenciaFile();

            File f = FileSystemManager.getFile(fileID);
            ef.setDocument(FileSystemManager.readFileToByteArray(f));

            ef.setNom(file.getNom());
            ef.setDescripcio(file.getDescripcio());
            ef.setMime(file.getMime());
            ef.setTamany(f.length());

            return ef;

        } catch (RestException oae) {
            log.error("Obtenint fitxer: " + oae.getMessage(), oae);
            throw oae;
        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                msg = I18NCommonUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }
            msg = "Error desconegut obtenint fitxers: " + msg;
            log.error(msg, th);
            throw new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

    }

}
