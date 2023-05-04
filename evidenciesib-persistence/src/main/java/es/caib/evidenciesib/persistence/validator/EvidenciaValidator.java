package es.caib.evidenciesib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.evidenciesib.model.entity.Evidencia;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.evidenciesib.model.fields.EvidenciaFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EvidenciaValidator<I extends Evidencia>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements EvidenciaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public EvidenciaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.evidenciesib.model.dao.IEvidenciaManager __evidenciaManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERSONANOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERSONALLINATGE1, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONALLINATGE1)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERSONANIF, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANIF)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DOCUMENTHASH, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DOCUMENTHASH)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DOCUMENTMIDA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DOCUMENTMIDA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAINICI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAINICI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ESTATCODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATCODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,LOGINTYPE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINTYPE)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONANOM) == 0) {
      java.lang.String __personanom = __target__.getPersonanom();
      if (__personanom!= null && __personanom.length() > 255) {
        __vr.rejectValue(PERSONANOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONALLINATGE1) == 0) {
      java.lang.String __personallinatge1 = __target__.getPersonallinatge1();
      if (__personallinatge1!= null && __personallinatge1.length() > 255) {
        __vr.rejectValue(PERSONALLINATGE1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONALLINATGE1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONALLINATGE2) == 0) {
      java.lang.String __personallinatge2 = __target__.getPersonallinatge2();
      if (__personallinatge2!= null && __personallinatge2.length() > 255) {
        __vr.rejectValue(PERSONALLINATGE2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONALLINATGE2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONANIF) == 0) {
      java.lang.String __personanif = __target__.getPersonanif();
      if (__personanif!= null && __personanif.length() > 100) {
        __vr.rejectValue(PERSONANIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(DOCUMENTHASH) == 0) {
      java.lang.String __documenthash = __target__.getDocumenthash();
      if (__documenthash!= null && __documenthash.length() > 255) {
        __vr.rejectValue(DOCUMENTHASH, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DOCUMENTHASH)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(USUARIAPLICACIO) == 0) {
      java.lang.String __usuariaplicacio = __target__.getUsuariaplicacio();
      if (__usuariaplicacio!= null && __usuariaplicacio.length() > 255) {
        __vr.rejectValue(USUARIAPLICACIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIAPLICACIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(USUARIPERSONA) == 0) {
      java.lang.String __usuaripersona = __target__.getUsuaripersona();
      if (__usuaripersona!= null && __usuaripersona.length() > 100) {
        __vr.rejectValue(USUARIPERSONA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIPERSONA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATERROR) == 0) {
      java.lang.String __estaterror = __target__.getEstaterror();
      if (__estaterror!= null && __estaterror.length() > 255) {
        __vr.rejectValue(ESTATERROR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATERROR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATEXCEPCIO) == 0) {
      java.lang.String __estatexcepcio = __target__.getEstatexcepcio();
      if (__estatexcepcio!= null && __estatexcepcio.length() > 2147483647) {
        __vr.rejectValue(ESTATEXCEPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATEXCEPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONAMOBIL) == 0) {
      java.lang.String __personamobil = __target__.getPersonamobil();
      if (__personamobil!= null && __personamobil.length() > 100) {
        __vr.rejectValue(PERSONAMOBIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONAMOBIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINID) == 0) {
      java.lang.String __loginid = __target__.getLoginid();
      if (__loginid!= null && __loginid.length() > 255) {
        __vr.rejectValue(LOGINID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOIP) == 0) {
      java.lang.String __localitzacioip = __target__.getLocalitzacioip();
      if (__localitzacioip!= null && __localitzacioip.length() > 100) {
        __vr.rejectValue(LOCALITZACIOIP, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOIP)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOCODIPOSTAL) == 0) {
      java.lang.String __localitzaciocodipostal = __target__.getLocalitzaciocodipostal();
      if (__localitzaciocodipostal!= null && __localitzaciocodipostal.length() > 100) {
        __vr.rejectValue(LOCALITZACIOCODIPOSTAL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOCODIPOSTAL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOCOORDENADES) == 0) {
      java.lang.String __localitzaciocoordenades = __target__.getLocalitzaciocoordenades();
      if (__localitzaciocoordenades!= null && __localitzaciocoordenades.length() > 255) {
        __vr.rejectValue(LOCALITZACIOCOORDENADES, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOCOORDENADES)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONAEMAIL) == 0) {
      java.lang.String __personaemail = __target__.getPersonaemail();
      if (__personaemail!= null && __personaemail.length() > 255) {
        __vr.rejectValue(PERSONAEMAIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONAEMAIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
    if (__vr.getFieldErrorCount(DOCUMENTFITXERID) == 0) { // FITXER
      Object __value = __vr.getFieldValue(__target__,DOCUMENTFITXERID);
      if (__value == null || String.valueOf(__value).trim().length() == 0 || String.valueOf(__value).trim().equals("0") ) {
          __vr.rejectValue(DOCUMENTFITXERID, "genapp.validation.required",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DOCUMENTFITXERID)));
      }
    }

      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}