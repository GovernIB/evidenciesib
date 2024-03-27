<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EvidenciaFields" className="es.caib.evidenciesib.model.fields.EvidenciaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${evi:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.EVIDENCIAID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.EVIDENCIAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.NOM)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANIF)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONANIF)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAUSERNAME)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONAUSERNAME)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANOM)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONANOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE1)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONALLINATGE1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE2)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONALLINATGE2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAEMAIL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONAEMAIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAMOBIL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONAMOBIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DATAINICI)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DATAINICI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DATAFI)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DATAFI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.USUARIAPLICACIO)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.USUARIAPLICACIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.USUARIPERSONA)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.USUARIPERSONA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATCODI)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.ESTATCODI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATERROR)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.ESTATERROR)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATEXCEPCIO)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.ESTATEXCEPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINTYPE)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINTYPE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINSUBTYPE)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINSUBTYPE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINAUTHMETHOD)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINAUTHMETHOD)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINQAA)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINQAA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINDATA)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINDATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINADDITIONALPROPERTIES)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINADDITIONALPROPERTIES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINPROPERTIESSHA256)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINPROPERTIESSHA256)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOIP)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOIP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOLATITUD)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOLATITUD)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOLONGITUD)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOLONGITUD)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOREGIO)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOREGIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCIUTAT)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOCIUTAT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOPAIS)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOPAIS)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DEVICEPROPERTIES)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DEVICEPROPERTIES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.CLICKPROPERTIES)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.CLICKPROPERTIES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FIRMAREASON)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FIRMAREASON)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FIRMAIDIOMADOCUMENT)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FIRMAIDIOMADOCUMENT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FITXERORIGINALID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FITXERORIGINALID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FITXERADAPTATID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FITXERADAPTATID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.FITXERSIGNATID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.FITXERSIGNATID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.CALLBACKURL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.CALLBACKURL)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${evi:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

