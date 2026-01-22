package es.caib.evidenciesib.back.controller.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.RunAs;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.FileDownloadController;
import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE)
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
@RunAs(Constants.EVI_WS)
public class EvidenciaAppController extends EvidenciaUserController {

    /**
     * Aquí entram de forma no autenticada, d'aqui que el mètode findByPrimaryKey() sigui PermitAll.
     */
    @Override
    public EvidenciaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long evidenciaID) throws I18NException {
        return (EvidenciaJPA) evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);
    }

    @Override
    public boolean isActiveList() {
        return false;
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return false;
    }

    @RequestMapping(value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION + "{encriptedEvidenciaID}")
    public ModelAndView showBasicInfo(@PathVariable("encriptedEvidenciaID")
    String encriptedEvidenciaID, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            Long evidenciaID = HibernateFileUtil.decryptFileID(encriptedEvidenciaID);

            log.info("Mostrant la informació bàsica de l'evidència amb ID : " + evidenciaID);

            if (evidenciaID == null || evidenciaID.longValue() == 0L) {

                HtmlUtils.saveMessageError(request,
                        "La clau " + encriptedEvidenciaID + " no és vàlida i no correspon a cap evidència.");

                log.warn("Informació de l'evidència sol·licitada amb clau " + encriptedEvidenciaID + " no vàlida: \n"
                        + buildHttpRequestInfo(request));

                return new ModelAndView("errorSimple");
            } else {

                EvidenciaJPA evidencia = findByPrimaryKey(request, evidenciaID);

                if (evidencia == null) {

                    //I18NException i18nException = new I18NException("error.notfound", String.valueOf(evidenciaID));
                    //throw i18nException;
                    createMessageError(request, "error.notfound", evidenciaID);
                    return new ModelAndView("errorSimple");
                    //new ModelAndView(new RedirectView(getRedirectWhenCancel(request, evidenciaID), true));
                    //return llistatPaginat(request, response, 1);
                } else {
                    final boolean __isView = true;
                    ModelAndView mav = new ModelAndView(getTileForm());
                    EvidenciaForm evidenciaForm = getEvidenciaForm(evidencia, __isView, request, mav);
                    evidenciaForm.setView(__isView);
                    if (__isView) {
                        evidenciaForm.setAllFieldsReadOnly(ALL_EVIDENCIA_FIELDS);
                        evidenciaForm.setSaveButtonVisible(false);
                        evidenciaForm.setDeleteButtonVisible(false);
                    }
                    fillReferencesForForm(evidenciaForm, request, mav);
                    mav.addObject("evidenciaForm", evidenciaForm);
                    return mav;
                }
            }
        } catch (Throwable e) {
            log.error("Error mostrant la informació bàsica de l'evidència", e);
            createMessageError(request, "error.general", e.getMessage());
            return new ModelAndView("errorSimple");
        }
    }

    @Override
    public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EvidenciaForm evidenciaForm = super.getEvidenciaForm(_jpa, __isView, request, mav);

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(Arrays.asList(EvidenciaFields.ALL_EVIDENCIA_FIELDS));

        hiddenFields.remove(EvidenciaFields.EVIDENCIAID);
        hiddenFields.remove(EvidenciaFields.NOM);
        hiddenFields.remove(EvidenciaFields.PERSONANIF);
        hiddenFields.remove(EvidenciaFields.PERSONAUSERNAME);
        hiddenFields.remove(EvidenciaFields.PERSONANOM);
        hiddenFields.remove(EvidenciaFields.PERSONALLINATGE1);
        hiddenFields.remove(EvidenciaFields.PERSONALLINATGE2);
        hiddenFields.remove(EvidenciaFields.DATAINICI);
        hiddenFields.remove(EvidenciaFields.DATAFI);
        hiddenFields.remove(EvidenciaFields.LOGINSUBTYPE);
        hiddenFields.remove(EvidenciaFields.LOGINQAA);
        hiddenFields.remove(EvidenciaFields.LOGINDATA);
        hiddenFields.remove(EvidenciaFields.LOGINID);
        hiddenFields.remove(EvidenciaFields.LOGINAUTHMETHOD);
        hiddenFields.remove(EvidenciaFields.LOGINADDITIONALPROPERTIES);
        
        Evidencia evi = evidenciaForm.getEvidencia();
        if (evi.getLocalitzacioIp() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOIP);
        }
        if (evi.getLocalitzacioCodiPostal() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOCODIPOSTAL);
        }
        if (evi.getLocalitzacioLatitud() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOLATITUD);
        }        
        if (evi.getLocalitzacioLongitud() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOLONGITUD);
        }        
        if (evi.getLocalitzacioRegio() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOREGIO);
        }        
        if (evi.getLocalitzacioCiutat() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOCIUTAT);
        }        
        if (evi.getLocalitzacioPais() != null) {
            hiddenFields.remove(EvidenciaFields.LOCALITZACIOPAIS);
        }        
        hiddenFields.remove(EvidenciaFields.FIRMAREASON);
        hiddenFields.remove(EvidenciaFields.FIRMAIDIOMADOCUMENT);
        hiddenFields.remove(EvidenciaFields.FIRMATIPUSDOCUMENTAL);
        hiddenFields.remove(EvidenciaFields.FITXERSIGNATID);

        evidenciaForm.setHiddenFields(hiddenFields);

        evidenciaForm.setCancelButtonVisible(false);

        // Això fa que les URLs de descàrrega d'arxius usin el context web públic del front
        FileDownloadController.usarContextWebPublicDelFront.set(Boolean.TRUE);

        return evidenciaForm;
    }

    @Override
    public String getTileForm() {
        return "evidenciaFormApp";
    }

    public String fileUrl(Fitxer arxiu) {
        return FileDownloadController.fileUrl(arxiu);
    }

    private String buildHttpRequestInfo(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("========== HTTP REQUEST INFO ==========\n");

        // Información básica
        if (request.getMethod() != null) {
            sb.append("Method: ").append(request.getMethod()).append("\n");
        }
        if (request.getRequestURI() != null) {
            sb.append("Request URI: ").append(request.getRequestURI()).append("\n");
        }
        if (request.getQueryString() != null) {
            sb.append("Query String: ").append(request.getQueryString()).append("\n");
        }
        if (request.getRemoteAddr() != null) {
            sb.append("Remote Addr: ").append(request.getRemoteAddr()).append("\n");
        }
        if (request.getRemoteHost() != null) {
            sb.append("Remote Host: ").append(request.getRemoteHost()).append("\n");
        }

        // Headers relevantes
        sb.append("---------- HEADERS ----------\n");
        String[] relevantHeaders = { "user-agent", "referer", "x-forwarded-for", "authorization", "content-type" };
        for (String headerName : relevantHeaders) {
            String headerValue = request.getHeader(headerName);
            if (headerValue != null) {
                sb.append(headerName).append(": ").append(headerValue).append("\n");
            }
        }

        // Parameters
        sb.append("---------- PARAMETERS ----------\n");
        java.util.Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues != null) {
                sb.append(paramName).append(": ").append(java.util.Arrays.toString(paramValues)).append("\n");
            }
        }

        // Session (solo ID y usuario si existe)
        sb.append("---------- SESSION ----------\n");
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null) {
            sb.append("Session ID: ").append(session.getId()).append("\n");
            Object userAttr = session.getAttribute("user");
            if (userAttr != null) {
                sb.append("User: ").append(userAttr).append("\n");
            }
        } else {
            sb.append("No session available\n");
        }

        sb.append("=======================================");
        return sb.toString();
    }

}
