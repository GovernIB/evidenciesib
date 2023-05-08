package es.caib.evidenciesib.back.controller.webdb;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.utils.Utils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.validation.ValidationWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import es.caib.evidenciesib.back.form.webdb.*;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;

import es.caib.evidenciesib.back.validator.webdb.EvidenciaWebValidator;

import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.model.fields.*;

/**
 * Controller per gestionar un Evidencia
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/evidencia")
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
public class EvidenciaController
    extends es.caib.evidenciesib.back.controller.EvidenciesIBFilesBaseController<Evidencia, java.lang.Long, EvidenciaForm> implements EvidenciaFields {

  @EJB(mappedName = es.caib.evidenciesib.ejb.EvidenciaService.JNDI_NAME)
  protected es.caib.evidenciesib.ejb.EvidenciaService evidenciaEjb;

  @Autowired
  private EvidenciaWebValidator evidenciaWebValidator;

  @Autowired
  protected EvidenciaRefList evidenciaRefList;

  /**
   * Llistat de totes Evidencia
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EvidenciaFilterForm ff;
    ff = (EvidenciaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Evidencia de forma paginada
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.GET)
  public ModelAndView llistatPaginat(HttpServletRequest request,
    HttpServletResponse response, @PathVariable Integer pagina)
      throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileList());
    llistat(mav, request, getEvidenciaFilterForm(pagina, mav, request));
    return mav;
  }

  public EvidenciaFilterForm getEvidenciaFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EvidenciaFilterForm evidenciaFilterForm;
    evidenciaFilterForm = (EvidenciaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(evidenciaFilterForm == null) {
      evidenciaFilterForm = new EvidenciaFilterForm();
      evidenciaFilterForm.setContexte(getContextWeb());
      evidenciaFilterForm.setEntityNameCode(getEntityNameCode());
      evidenciaFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      evidenciaFilterForm.setNou(true);
    } else {
      evidenciaFilterForm.setNou(false);
    }
    evidenciaFilterForm.setPage(pagina == null ? 1 : pagina);
    return evidenciaFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Evidencia de forma paginada
   * 
   * @param request
   * @param pagina
   * @param filterForm
   * @return
   * @throws I18NException
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.POST)
  public ModelAndView llistatPaginat(HttpServletRequest request,
      HttpServletResponse response,@PathVariable Integer pagina,
      @ModelAttribute EvidenciaFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEvidenciaFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Evidencia de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Evidencia> llistat(ModelAndView mav, HttpServletRequest request,
     EvidenciaFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Evidencia> evidencia = processarLlistat(evidenciaEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("evidenciaItems", evidencia);

    mav.addObject("evidenciaFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, evidencia, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, evidencia);

    return evidencia;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EvidenciaFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Evidencia> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field estatCodi
    {
      _listSKV = getReferenceListForEstatCodi(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForEstatCodi(_tmp);
      if (filterForm.getGroupByFields().contains(ESTATCODI)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ESTATCODI, false);
      };
    }

    // Field loginType
    {
      _listSKV = getReferenceListForLoginType(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForLoginType(_tmp);
      if (filterForm.getGroupByFields().contains(LOGINTYPE)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, LOGINTYPE, false);
      };
    }

    // Field firmaTipusDocumental
    {
      _listSKV = getReferenceListForFirmaTipusDocumental(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForFirmaTipusDocumental(_tmp);
      if (filterForm.getGroupByFields().contains(FIRMATIPUSDOCUMENTAL)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, FIRMATIPUSDOCUMENTAL, false);
      };
    }

    // Field firmaIdiomaDocument
    {
      _listSKV = getReferenceListForFirmaIdiomaDocument(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForFirmaIdiomaDocument(_tmp);
      if (filterForm.getGroupByFields().contains(FIRMAIDIOMADOCUMENT)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, FIRMAIDIOMADOCUMENT, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    EvidenciaFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Evidencia> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_EVIDENCIA_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ESTATCODI, filterForm.getMapOfValuesForEstatCodi());
    __mapping.put(LOGINTYPE, filterForm.getMapOfValuesForLoginType());
    __mapping.put(FIRMATIPUSDOCUMENTAL, filterForm.getMapOfValuesForFirmaTipusDocumental());
    __mapping.put(FIRMAIDIOMADOCUMENT, filterForm.getMapOfValuesForFirmaIdiomaDocument());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Evidencia
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEvidenciaGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EvidenciaForm evidenciaForm = getEvidenciaForm(null, false, request, mav);
    mav.addObject("evidenciaForm" ,evidenciaForm);
    fillReferencesForForm(evidenciaForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EvidenciaForm evidenciaForm;
    if(_jpa == null) {
      evidenciaForm = new EvidenciaForm(new EvidenciaJPA(), true);
    } else {
      evidenciaForm = new EvidenciaForm(_jpa, false);
      evidenciaForm.setView(__isView);
    }
    evidenciaForm.setContexte(getContextWeb());
    evidenciaForm.setEntityNameCode(getEntityNameCode());
    evidenciaForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return evidenciaForm;
  }

  public void fillReferencesForForm(EvidenciaForm evidenciaForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (evidenciaForm.getListOfValuesForEstatCodi() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForEstatCodi(request, mav, evidenciaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      evidenciaForm.setListOfValuesForEstatCodi(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (evidenciaForm.getListOfValuesForLoginType() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForLoginType(request, mav, evidenciaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      evidenciaForm.setListOfValuesForLoginType(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (evidenciaForm.getListOfValuesForFirmaTipusDocumental() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForFirmaTipusDocumental(request, mav, evidenciaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      evidenciaForm.setListOfValuesForFirmaTipusDocumental(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (evidenciaForm.getListOfValuesForFirmaIdiomaDocument() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForFirmaIdiomaDocument(request, mav, evidenciaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      evidenciaForm.setListOfValuesForFirmaIdiomaDocument(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Evidencia
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEvidenciaPost(@ModelAttribute EvidenciaForm evidenciaForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EvidenciaJPA evidencia = evidenciaForm.getEvidencia();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, evidencia, evidenciaForm); // FILE
      preValidate(request, evidenciaForm, result);
      getWebValidator().validate(evidenciaForm, result);
      postValidate(request,evidenciaForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        evidencia = create(request, evidencia);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", evidencia.getEvidenciaID());
        evidenciaForm.setEvidencia(evidencia);
        return getRedirectWhenCreated(request, evidenciaForm);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{evidenciaID}", method = RequestMethod.GET)
  public ModelAndView veureEvidenciaGet(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEvidenciaGet(evidenciaID,
        request, response, true);
  }


  protected ModelAndView editAndViewEvidenciaGet(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
      HttpServletRequest request,
      HttpServletResponse response, boolean __isView) throws I18NException {
    if((!__isView) && !isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      if(__isView && !isActiveFormView()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
      }
    }
    EvidenciaJPA evidencia = findByPrimaryKey(request, evidenciaID);

    if (evidencia == null) {
      createMessageWarning(request, "error.notfound", evidenciaID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, evidenciaID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EvidenciaForm evidenciaForm = getEvidenciaForm(evidencia, __isView, request, mav);
      evidenciaForm.setView(__isView);
      if(__isView) {
        evidenciaForm.setAllFieldsReadOnly(ALL_EVIDENCIA_FIELDS);
        evidenciaForm.setSaveButtonVisible(false);
        evidenciaForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(evidenciaForm, request, mav);
      mav.addObject("evidenciaForm", evidenciaForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Evidencia existent
   */
  @RequestMapping(value = "/{evidenciaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEvidenciaGet(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEvidenciaGet(evidenciaID,
        request, response, false);
  }



  /**
   * Editar un Evidencia existent
   */
  @RequestMapping(value = "/{evidenciaID}/edit", method = RequestMethod.POST)
  public String editarEvidenciaPost(@ModelAttribute EvidenciaForm evidenciaForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EvidenciaJPA evidencia = evidenciaForm.getEvidencia();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, evidencia, evidenciaForm); // FILE
      preValidate(request, evidenciaForm, result);
      getWebValidator().validate(evidenciaForm, result);
      postValidate(request, evidenciaForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        evidencia = update(request, evidencia);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", evidencia.getEvidenciaID());
        status.setComplete();
        return getRedirectWhenModified(request, evidenciaForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          evidencia.getEvidenciaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, evidenciaForm, __e);
    }

  }


  /**
   * Eliminar un Evidencia existent
   */
  @RequestMapping(value = "/{evidenciaID}/delete")
  public String eliminarEvidencia(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Evidencia evidencia = this.findByPrimaryKey(request, evidenciaID);
      if (evidencia == null) {
        String __msg = createMessageError(request, "error.notfound", evidenciaID);
        return getRedirectWhenDelete(request, evidenciaID, new Exception(__msg));
      } else {
        delete(request, evidencia);
        createMessageSuccess(request, "success.deleted", evidenciaID);
        return getRedirectWhenDelete(request, evidenciaID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", evidenciaID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, evidenciaID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute EvidenciaFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEvidencia(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return java.lang.Long.parseLong(value, 10);
}

  @Override
  public String[] getArgumentsMissatge(Object __evidenciaID, Throwable e) {
    java.lang.Long evidenciaID = (java.lang.Long)__evidenciaID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (evidenciaID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(evidenciaID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "evidencia.evidencia";
  }

  public String getEntityNameCodePlural() {
    return "evidencia.evidencia.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("evidencia.evidenciaID");
  }

  @InitBinder("evidenciaFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("evidenciaForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "evidencia.evidenciaID");
  }

  public EvidenciaWebValidator getWebValidator() {
    return evidenciaWebValidator;
  }


  public void setWebValidator(EvidenciaWebValidator __val) {
    if (__val != null) {
      this.evidenciaWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Evidencia
   */
  @RequestMapping(value = "/{evidenciaID}/cancel")
  public String cancelEvidencia(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, evidenciaID);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, Evidencia evidencia,
      EvidenciaForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxerOriginalID(), form.isFitxerOriginalIDDelete(),
        form.isNou()? null : evidencia.getFitxerOriginal());
    ((EvidenciaJPA)evidencia).setFitxerOriginal(f);
    if (f != null) { 
      evidencia.setFitxerOriginalID(f.getFitxerID());
    } else {
      evidencia.setFitxerOriginalID(0);
    }

    f = (FitxerJPA)afm.preProcessFile(form.getFitxerAdaptatID(), form.isFitxerAdaptatIDDelete(),
        form.isNou()? null : evidencia.getFitxerAdaptat());
    ((EvidenciaJPA)evidencia).setFitxerAdaptat(f);
    if (f != null) { 
      evidencia.setFitxerAdaptatID(f.getFitxerID());
    } else {
      evidencia.setFitxerAdaptatID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxerSignatID(), form.isFitxerSignatIDDelete(),
        form.isNou()? null : evidencia.getFitxerSignat());
    ((EvidenciaJPA)evidencia).setFitxerSignat(f);
    if (f != null) { 
      evidencia.setFitxerSignatID(f.getFitxerID());
    } else {
      evidencia.setFitxerSignatID(null);
    }


  }

  // FILE
  @Override
  public void deleteFiles(Evidencia evidencia) {
    deleteFile(evidencia.getFitxerOriginalID());
    deleteFile(evidencia.getFitxerAdaptatID());
    deleteFile(evidencia.getFitxerSignatID());
  }
  // Mètodes a sobreescriure 

  public boolean isActiveList() {
    return true;
  }


  public boolean isActiveFormNew() {
    return true;
  }


  public boolean isActiveFormEdit() {
    return true;
  }


  public boolean isActiveDelete() {
    return true;
  }


  public boolean isActiveFormView() {
    return isActiveFormEdit();
  }


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, EvidenciaForm evidenciaForm, Where where)  throws I18NException {
    if (evidenciaForm.isHiddenField(ESTATCODI)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForEstatCodi(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, EvidenciaFilterForm evidenciaFilterForm,
       List<Evidencia> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (evidenciaFilterForm.isHiddenField(ESTATCODI)
       && !evidenciaFilterForm.isGroupByField(ESTATCODI)
       && !evidenciaFilterForm.isFilterByField(ESTATCODI)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForEstatCodi(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("-1" , "-1"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    __tmp.add(new StringKeyValue("4" , "4"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForLoginType(HttpServletRequest request,
       ModelAndView mav, EvidenciaForm evidenciaForm, Where where)  throws I18NException {
    if (evidenciaForm.isHiddenField(LOGINTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForLoginType(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForLoginType(HttpServletRequest request,
       ModelAndView mav, EvidenciaFilterForm evidenciaFilterForm,
       List<Evidencia> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (evidenciaFilterForm.isHiddenField(LOGINTYPE)
       && !evidenciaFilterForm.isGroupByField(LOGINTYPE)
       && !evidenciaFilterForm.isFilterByField(LOGINTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForLoginType(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForLoginType(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForFirmaTipusDocumental(HttpServletRequest request,
       ModelAndView mav, EvidenciaForm evidenciaForm, Where where)  throws I18NException {
    if (evidenciaForm.isHiddenField(FIRMATIPUSDOCUMENTAL)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForFirmaTipusDocumental(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForFirmaTipusDocumental(HttpServletRequest request,
       ModelAndView mav, EvidenciaFilterForm evidenciaFilterForm,
       List<Evidencia> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (evidenciaFilterForm.isHiddenField(FIRMATIPUSDOCUMENTAL)
       && !evidenciaFilterForm.isGroupByField(FIRMATIPUSDOCUMENTAL)
       && !evidenciaFilterForm.isFilterByField(FIRMATIPUSDOCUMENTAL)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForFirmaTipusDocumental(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForFirmaTipusDocumental(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    __tmp.add(new StringKeyValue("4" , "4"));
    __tmp.add(new StringKeyValue("5" , "5"));
    __tmp.add(new StringKeyValue("6" , "6"));
    __tmp.add(new StringKeyValue("7" , "7"));
    __tmp.add(new StringKeyValue("8" , "8"));
    __tmp.add(new StringKeyValue("9" , "9"));
    __tmp.add(new StringKeyValue("10" , "10"));
    __tmp.add(new StringKeyValue("11" , "11"));
    __tmp.add(new StringKeyValue("12" , "12"));
    __tmp.add(new StringKeyValue("13" , "13"));
    __tmp.add(new StringKeyValue("14" , "14"));
    __tmp.add(new StringKeyValue("15" , "15"));
    __tmp.add(new StringKeyValue("16" , "16"));
    __tmp.add(new StringKeyValue("17" , "17"));
    __tmp.add(new StringKeyValue("18" , "18"));
    __tmp.add(new StringKeyValue("19" , "19"));
    __tmp.add(new StringKeyValue("20" , "20"));
    __tmp.add(new StringKeyValue("51" , "51"));
    __tmp.add(new StringKeyValue("52" , "52"));
    __tmp.add(new StringKeyValue("53" , "53"));
    __tmp.add(new StringKeyValue("54" , "54"));
    __tmp.add(new StringKeyValue("55" , "55"));
    __tmp.add(new StringKeyValue("56" , "56"));
    __tmp.add(new StringKeyValue("57" , "57"));
    __tmp.add(new StringKeyValue("58" , "58"));
    __tmp.add(new StringKeyValue("59" , "59"));
    __tmp.add(new StringKeyValue("60" , "60"));
    __tmp.add(new StringKeyValue("61" , "61"));
    __tmp.add(new StringKeyValue("62" , "62"));
    __tmp.add(new StringKeyValue("63" , "63"));
    __tmp.add(new StringKeyValue("64" , "64"));
    __tmp.add(new StringKeyValue("65" , "65"));
    __tmp.add(new StringKeyValue("66" , "66"));
    __tmp.add(new StringKeyValue("67" , "67"));
    __tmp.add(new StringKeyValue("68" , "68"));
    __tmp.add(new StringKeyValue("69" , "69"));
    __tmp.add(new StringKeyValue("99" , "99"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForFirmaIdiomaDocument(HttpServletRequest request,
       ModelAndView mav, EvidenciaForm evidenciaForm, Where where)  throws I18NException {
    if (evidenciaForm.isHiddenField(FIRMAIDIOMADOCUMENT)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForFirmaIdiomaDocument(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForFirmaIdiomaDocument(HttpServletRequest request,
       ModelAndView mav, EvidenciaFilterForm evidenciaFilterForm,
       List<Evidencia> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (evidenciaFilterForm.isHiddenField(FIRMAIDIOMADOCUMENT)
       && !evidenciaFilterForm.isGroupByField(FIRMAIDIOMADOCUMENT)
       && !evidenciaFilterForm.isFilterByField(FIRMAIDIOMADOCUMENT)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForFirmaIdiomaDocument(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForFirmaIdiomaDocument(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("es" , "es"));
    __tmp.add(new StringKeyValue("ca" , "ca"));
    __tmp.add(new StringKeyValue("ga" , "ga"));
    __tmp.add(new StringKeyValue("eu" , "eu"));
    return __tmp;
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,EvidenciaForm evidenciaForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EvidenciaForm evidenciaForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EvidenciaFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EvidenciaFilterForm filterForm,  List<Evidencia> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EvidenciaForm evidenciaForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EvidenciaForm evidenciaForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long evidenciaID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long evidenciaID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "evidenciaFormWebDB";
  }

  public String getTileList() {
    return "evidenciaListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "EvidenciaWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EvidenciaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long evidenciaID) throws I18NException {
    return (EvidenciaJPA) evidenciaEjb.findByPrimaryKey(evidenciaID);
  }


  public EvidenciaJPA create(HttpServletRequest request, EvidenciaJPA evidencia)
    throws I18NException, I18NValidationException {
    return (EvidenciaJPA) evidenciaEjb.create(evidencia);
  }


  public EvidenciaJPA update(HttpServletRequest request, EvidenciaJPA evidencia)
    throws I18NException, I18NValidationException {
    return (EvidenciaJPA) evidenciaEjb.update(evidencia);
  }


  public void delete(HttpServletRequest request, Evidencia evidencia) throws I18NException {
    evidenciaEjb.delete(evidencia);
  }

} // Final de Classe

