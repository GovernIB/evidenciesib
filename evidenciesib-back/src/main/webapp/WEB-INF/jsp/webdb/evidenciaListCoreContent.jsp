<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EvidenciaFields" className="es.caib.evidenciesib.model.fields.EvidenciaFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[evidencia.evidenciaID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.EVIDENCIAID)}">
          <td>
          ${evidencia.evidenciaID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.NOM)}">
          <td>
          ${evidencia.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANOM)}">
          <td>
          ${evidencia.personaNom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE1)}">
          <td>
          ${evidencia.personaLlinatge1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONALLINATGE2)}">
          <td>
          ${evidencia.personaLlinatge2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONANIF)}">
          <td>
          ${evidencia.personaNif}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAEMAIL)}">
          <td>
          ${evidencia.personaEmail}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.PERSONAMOBIL)}">
          <td>
          ${evidencia.personaMobil}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTHASH)}">
          <td>
          ${evidencia.documentHash}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTFITXERID)}">
          <td>
            <c:if test="${not empty evidencia.documentFitxer}">
              <a target="_blank" href="<c:url value="${evi:fileUrl(evidencia.documentFitxer)}"/>">${evidencia.documentFitxer.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DOCUMENTMIDA)}">
          <td>
          ${evidencia.documentMida}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DATAINICI)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${evidencia.dataInici}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.DATAFI)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${evidencia.dataFi}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.USUARIAPLICACIO)}">
          <td>
          ${evidencia.usuariAplicacio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.USUARIPERSONA)}">
          <td>
          ${evidencia.usuariPersona}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATCODI)}">
          <td>
          <c:set var="tmp">${evidencia.estatCodi}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForEstatCodi[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATERROR)}">
          <td>
          ${evidencia.estatError}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.ESTATEXCEPCIO)}">
          <td>
          ${evidencia.estatExcepcio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINTYPE)}">
          <td>
          <c:set var="tmp">${evidencia.loginType}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForLoginType[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINID)}">
          <td>
          ${evidencia.loginId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOGINDATA)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${evidencia.loginData}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOIP)}">
          <td>
          ${evidencia.localitzacioIp}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
          <td>
          ${evidencia.localitzacioCodiPostal}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOLONGITUD)}">
          <td>
          ${evidencia.localitzacioLongitud}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOLATITUD)}">
          <td>
          ${evidencia.localitzacioLatitud}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOCIUTAT)}">
          <td>
          ${evidencia.localitzacioCiutat}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOREGIO)}">
          <td>
          ${evidencia.localitzacioRegio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EvidenciaFields.LOCALITZACIOPAIS)}">
          <td>
          ${evidencia.localitzacioPais}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[evidencia.evidenciaID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


