package es.caib.evidenciesib.back.controller.all;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.evidenciesib.back.controller.FileDownloadController;
import es.caib.evidenciesib.commons.utils.Constants;

/**
 * @autor anadal
 * 
 */
@Controller
@RequestMapping(value = Constants.MAPPING_PUBLIC_ARXIU)
public class FileDownloadPublicController extends FileDownloadController {

    

}
