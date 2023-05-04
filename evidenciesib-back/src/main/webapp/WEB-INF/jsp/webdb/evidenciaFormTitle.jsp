<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(evidenciaForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(evidenciaForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty evidenciaForm.titleCode}">
    <fmt:message key="${evidenciaForm.titleCode}" >
      <fmt:param value="${evidenciaForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty evidenciaForm.entityNameCode}">
      <fmt:message var="entityname" key="evidencia.evidencia"/>
    </c:if>
    <c:if test="${not empty evidenciaForm.entityNameCode}">
      <fmt:message var="entityname" key="${evidenciaForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${evidenciaForm.nou?'genapp.createtitle':(evidenciaForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty evidenciaForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(evidenciaForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(evidenciaForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${evidenciaForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>