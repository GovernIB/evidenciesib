package es.caib.evidenciesib.back.controller.admin;

import java.util.List;

import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.evidenciesib.back.utils.Tab;
import es.caib.evidenciesib.commons.utils.Constants;

/**
 * 
 * @author anadal (u80067)
 * 29 may 2026 11:05:39
 */
@MenuOption(
        labelCode = "=Gràfiques de consultes a EvidènciesIB",
        order = 100,
        group = Tab.MENU_ADMIN,
        baseLink = "/admin/estadisticagraficapeticions/",        
        relativeLink = "/",
        addSeparatorBefore = true)

@Controller
@RequestMapping(value = "/admin/estadisticagraficapeticions")
public class EstadisticaGraficaPeticionsController extends AbstractEstadisticaGraficaAdenController {

    @Override
    public int getCategoria() {
        return CATEGORIA_PETICIONS_EVIDENCIES;
    }

    @Override
    public String getCategoriaTitol() {
        return "Peticions a EvidenciesIB";
    }

    @Override
    public boolean isSupportedCancelStatus() {
        return false;
    }

    @Override
    public String getErrorLabel() {
        return "Peticions amb Error";
    }

    @Override
    public String getCreateLabel() {
        return "Peticions En Procés";
    }

    @Override
    public String getOkLabel() {
        return "Peticions Finalitzades";
    }

    @Override
    public List<Integer> getCreateEstadistiques() {
        return List.of(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO, // Create
                Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN, // Create
                Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA // Create
        );
    }

}
