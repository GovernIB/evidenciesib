package es.caib.evidenciesib.api.externa.secure.evidencies;

import java.util.ArrayList;
import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.RestPagination;

import es.caib.evidenciesib.model.entity.Evidencia;

/**
 * 
 * @author anadal
 *
 */
public class EvidenciaWsPaginacio extends RestPagination<EvidenciaWs> {

    public EvidenciaWsPaginacio() {
        super();
    }

   
    public EvidenciaWsPaginacio(RestPagination<Evidencia> other, String language) {
        super(other.getPagesize(), other.getPage(), other.getTotalpages(), other.getTotalcount(), convert(other.getData(), language));
    }

    protected static List<EvidenciaWs> convert(List<Evidencia> list, String language) {

        if (list == null) {
            return null;
        }

        List<EvidenciaWs> evidenciesWsList = new ArrayList<EvidenciaWs>(list.size());

        for (Evidencia evidenciaBBDD : list) {

            evidenciesWsList.add(new EvidenciaWs(evidenciaBBDD, language));

        }

        return evidenciesWsList;

    }

}
