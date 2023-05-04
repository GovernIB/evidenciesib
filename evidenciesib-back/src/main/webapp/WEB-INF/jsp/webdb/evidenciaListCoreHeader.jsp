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
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANOM)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONANOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE1)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONALLINATGE1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE2)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONALLINATGE2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANIF)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONANIF)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTHASH)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DOCUMENTHASH)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTFITXERID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DOCUMENTFITXERID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTMIDA)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.DOCUMENTMIDA)}</th>
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
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAMOBIL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONAMOBIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINTYPE)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINTYPE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINID)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINDATA)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOGINDATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOIP)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOIP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCOORDENADES)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.LOCALITZACIOCOORDENADES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAEMAIL)}">
        <th>${evi:getSortIcons(__theFilterForm,EvidenciaFields.PERSONAEMAIL)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${evi:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

