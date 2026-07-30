package es.caib.evidenciesib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class EvidenciaLogicaEJB extends EvidenciaEJB implements EvidenciaLogicaService {



    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(Long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public Evidencia update(Evidencia instance) throws I18NException {
        return super.update(instance);
    }


    

    /**
     * 
     * @param pdf
     * @throws I18NException
     */
    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    @Override
    public void validatePdfForEvidencies(byte[] pdf) throws I18NException {
        try {
            PdfReader reader = new PdfReader(pdf);
            AcroFields fields = reader.getAcroFields();
            if (fields.getSignatureNames().size() != 0) {
                throw new I18NException("error.validate.pdf.withsignatures");
            }

        } catch (I18NException i18ne) {
            throw i18ne;
        } catch (Throwable e) {

            log.error("Error desconegut intentant obtenir numero de firmes d'un PDF: " + e.getMessage(), e);

            throw new I18NException("error.validate.pdf.unknown", e.getMessage());
        }
    }

}
