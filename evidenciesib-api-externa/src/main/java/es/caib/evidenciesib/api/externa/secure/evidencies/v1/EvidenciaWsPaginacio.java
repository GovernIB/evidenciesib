package es.caib.evidenciesib.api.externa.secure.evidencies.v1;


import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.RestPagination;


/**
 * 
 * @author anadal
 *
 */
public class EvidenciaWsPaginacio extends RestPagination<EvidenciaWs> {

    public EvidenciaWsPaginacio() {
        super();
    }

    public EvidenciaWsPaginacio(int pagesize, int page, int totalpages, int totalcount, List<EvidenciaWs> data) {
        super(pagesize, page, totalpages, totalcount, data);
    }

   
}
