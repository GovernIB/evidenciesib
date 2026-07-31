package es.caib.evidenciesib.logic;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.UpdateItemValue;
import org.fundaciobit.genapp.common.query.Where;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
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

    @Override
    public int tancarPeticionsObertes(Integer dies) throws I18NException {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DATE, -1 * dies.intValue());

        log.info("Passant a error les peticions obertes amb data de creació anteriors a "
                + new Timestamp(cal.getTimeInMillis()));

        Where where = Where.AND(EvidenciaFields.ESTATCODI.equal(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO),
                EvidenciaFields.DATAINICI.lessThan(new Timestamp(cal.getTimeInMillis())));

        int count = this.update(where,
                new UpdateItemValue<Integer>(EvidenciaFields.ESTATCODI, Constants.EVIDENCIA_ESTAT_CODI_ERROR),
                new UpdateItemValue<String>(EvidenciaFields.ESTATERROR, 
                        "Aquesta petició feia més de " + dies + " dies que estava oberta i s'ha passat a error automàticament"));

        log.info("Tancades " + count + " peticions  amb data inferior a " + new Timestamp(cal.getTimeInMillis()));
        
        return count;
    }

}
