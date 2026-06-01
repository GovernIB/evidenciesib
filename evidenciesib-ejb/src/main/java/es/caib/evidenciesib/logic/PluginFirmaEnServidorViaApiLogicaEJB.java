package es.caib.evidenciesib.logic;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.firmaviaapi.IPluginFirmaEnServidorViaApi;

import javax.ejb.Stateless;


/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 12:29:42
 */
@Stateless
public class PluginFirmaEnServidorViaApiLogicaEJB extends AbstractPluginLogicaEJB<IPluginFirmaEnServidorViaApi>
        implements PluginFirmaEnServidorViaApiLogicaService {

    @Override
    public int getTipus() {
        return Constants.PLUGINSIB_TIPUS_FIRMA_EN_SERVIDOR;
    }

    @Override
    public String getName() {
        return "Plugin de Firma en Servidor via WS";
    };

}
