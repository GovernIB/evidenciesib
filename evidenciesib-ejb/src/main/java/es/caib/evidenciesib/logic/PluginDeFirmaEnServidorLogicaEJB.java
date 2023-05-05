package es.caib.evidenciesib.logic;

import es.caib.evidenciesib.commons.utils.Constants;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class PluginDeFirmaEnServidorLogicaEJB extends AbstractPluginLogicaEJB<ISignatureServerPlugin>
        implements PluginDeFirmaEnServidorLogicaService {

    @Override
    protected String getName() {
        return "Plugin de Firma en Servidor";
    }

    @Override
    protected Where getWhereTipusDePlugin() {
        return Where.OR(TIPUS.equal(Constants.PLUGIN_TIPUS_FIRMA_EN_SERVIDOR));
    }

}
