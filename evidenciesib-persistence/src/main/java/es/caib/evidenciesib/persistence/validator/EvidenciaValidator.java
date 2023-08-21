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

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAINICI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAINICI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ESTATCODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATCODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,LOGINTYPE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINTYPE)));

    __vr.rejectIfEmptyOrWhitespace(__target__,FIRMAREASON, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FIRMAREASON)));

    __vr.rejectIfEmptyOrWhitespace(__target__,FIRMATIPUSDOCUMENTAL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FIRMATIPUSDOCUMENTAL)));

    __vr.rejectIfEmptyOrWhitespace(__target__,CALLBACKURL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CALLBACKURL)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONANOM) == 0) {
      java.lang.String __personanom = __target__.getPersonaNom();
      if (__personanom!= null && __personanom.length() > 255) {
        __vr.rejectValue(PERSONANOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONALLINATGE1) == 0) {
      java.lang.String __personallinatge1 = __target__.getPersonaLlinatge1();
      if (__personallinatge1!= null && __personallinatge1.length() > 255) {
        __vr.rejectValue(PERSONALLINATGE1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONALLINATGE1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONALLINATGE2) == 0) {
      java.lang.String __personallinatge2 = __target__.getPersonaLlinatge2();
      if (__personallinatge2!= null && __personallinatge2.length() > 255) {
        __vr.rejectValue(PERSONALLINATGE2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONALLINATGE2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONANIF) == 0) {
      java.lang.String __personanif = __target__.getPersonaNif();
      if (__personanif!= null && __personanif.length() > 100) {
        __vr.rejectValue(PERSONANIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONANIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONAEMAIL) == 0) {
      java.lang.String __personaemail = __target__.getPersonaEmail();
      if (__personaemail!= null && __personaemail.length() > 255) {
        __vr.rejectValue(PERSONAEMAIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONAEMAIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PERSONAMOBIL) == 0) {
      java.lang.String __personamobil = __target__.getPersonaMobil();
      if (__personamobil!= null && __personamobil.length() > 100) {
        __vr.rejectValue(PERSONAMOBIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERSONAMOBIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(USUARIAPLICACIO) == 0) {
      java.lang.String __usuariaplicacio = __target__.getUsuariAplicacio();
      if (__usuariaplicacio!= null && __usuariaplicacio.length() > 255) {
        __vr.rejectValue(USUARIAPLICACIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIAPLICACIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(USUARIPERSONA) == 0) {
      java.lang.String __usuaripersona = __target__.getUsuariPersona();
      if (__usuaripersona!= null && __usuaripersona.length() > 100) {
        __vr.rejectValue(USUARIPERSONA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIPERSONA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATERROR) == 0) {
      java.lang.String __estaterror = __target__.getEstatError();
      if (__estaterror!= null && __estaterror.length() > 255) {
        __vr.rejectValue(ESTATERROR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATERROR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATEXCEPCIO) == 0) {
      java.lang.String __estatexcepcio = __target__.getEstatExcepcio();
      if (__estatexcepcio!= null && __estatexcepcio.length() > 2147483647) {
        __vr.rejectValue(ESTATEXCEPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATEXCEPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINSUBTYPE) == 0) {
      java.lang.String __loginsubtype = __target__.getLoginSubtype();
      if (__loginsubtype!= null && __loginsubtype.length() > 255) {
        __vr.rejectValue(LOGINSUBTYPE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINSUBTYPE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINQAA) == 0) {
      java.lang.String __loginqaa = __target__.getLoginQaa();
      if (__loginqaa!= null && __loginqaa.length() > 255) {
        __vr.rejectValue(LOGINQAA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINQAA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINID) == 0) {
      java.lang.String __loginid = __target__.getLoginId();
      if (__loginid!= null && __loginid.length() > 255) {
        __vr.rejectValue(LOGINID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINAUTHMETHOD) == 0) {
      java.lang.String __loginauthmethod = __target__.getLoginAuthMethod();
      if (__loginauthmethod!= null && __loginauthmethod.length() > 255) {
        __vr.rejectValue(LOGINAUTHMETHOD, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINAUTHMETHOD)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOGINADDITIONALPROPERTIES) == 0) {
      java.lang.String __loginadditionalproperties = __target__.getLoginAdditionalProperties();
      if (__loginadditionalproperties!= null && __loginadditionalproperties.length() > 2147483647) {
        __vr.rejectValue(LOGINADDITIONALPROPERTIES, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGINADDITIONALPROPERTIES)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOIP) == 0) {
      java.lang.String __localitzacioip = __target__.getLocalitzacioIp();
      if (__localitzacioip!= null && __localitzacioip.length() > 100) {
        __vr.rejectValue(LOCALITZACIOIP, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOIP)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOCODIPOSTAL) == 0) {
      java.lang.String __localitzaciocodipostal = __target__.getLocalitzacioCodiPostal();
      if (__localitzaciocodipostal!= null && __localitzaciocodipostal.length() > 100) {
        __vr.rejectValue(LOCALITZACIOCODIPOSTAL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOCODIPOSTAL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOLATITUD) == 0) {
      java.lang.String __localitzaciolatitud = __target__.getLocalitzacioLatitud();
      if (__localitzaciolatitud!= null && __localitzaciolatitud.length() > 100) {
        __vr.rejectValue(LOCALITZACIOLATITUD, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOLATITUD)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOLONGITUD) == 0) {
      java.lang.String __localitzaciolongitud = __target__.getLocalitzacioLongitud();
      if (__localitzaciolongitud!= null && __localitzaciolongitud.length() > 100) {
        __vr.rejectValue(LOCALITZACIOLONGITUD, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOLONGITUD)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOCIUTAT) == 0) {
      java.lang.String __localitzaciociutat = __target__.getLocalitzacioCiutat();
      if (__localitzaciociutat!= null && __localitzaciociutat.length() > 255) {
        __vr.rejectValue(LOCALITZACIOCIUTAT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOCIUTAT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOREGIO) == 0) {
      java.lang.String __localitzacioregio = __target__.getLocalitzacioRegio();
      if (__localitzacioregio!= null && __localitzacioregio.length() > 100) {
        __vr.rejectValue(LOCALITZACIOREGIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOREGIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LOCALITZACIOPAIS) == 0) {
      java.lang.String __localitzaciopais = __target__.getLocalitzacioPais();
      if (__localitzaciopais!= null && __localitzaciopais.length() > 100) {
        __vr.rejectValue(LOCALITZACIOPAIS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOCALITZACIOPAIS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(FIRMAREASON) == 0) {
      java.lang.String __firmareason = __target__.getFirmaReason();
      if (__firmareason!= null && __firmareason.length() > 255) {
        __vr.rejectValue(FIRMAREASON, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FIRMAREASON)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(FIRMAIDIOMADOCUMENT) == 0) {
      java.lang.String __firmaidiomadocument = __target__.getFirmaIdiomaDocument();
      if (__firmaidiomadocument!= null && __firmaidiomadocument.length() > 100) {
        __vr.rejectValue(FIRMAIDIOMADOCUMENT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FIRMAIDIOMADOCUMENT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(CALLBACKURL) == 0) {
      java.lang.String __callbackurl = __target__.getCallBackUrl();
      if (__callbackurl!= null && __callbackurl.length() > 255) {
        __vr.rejectValue(CALLBACKURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CALLBACKURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
    if (__vr.getFieldErrorCount(FITXERORIGINALID) == 0) { // FITXER
      Object __value = __vr.getFieldValue(__target__,FITXERORIGINALID);
      if (__value == null || String.valueOf(__value).trim().length() == 0 || String.valueOf(__value).trim().equals("0") ) {
          __vr.rejectValue(FITXERORIGINALID, "genapp.validation.required",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FITXERORIGINALID)));
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