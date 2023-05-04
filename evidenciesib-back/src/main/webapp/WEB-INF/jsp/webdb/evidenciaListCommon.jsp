<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${evidenciaFilterForm.contexte}"/>
  <c:set var="formName" value="evidencia" />
  <c:set var="__theFilterForm" value="${evidenciaFilterForm}" />
  <c:if test="${empty evidenciaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="evidencia.evidencia"/>
  </c:if>
  <c:if test="${not empty evidenciaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${evidenciaFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty evidenciaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="evidencia.evidencia"/>
  </c:if>
  <c:if test="${not empty evidenciaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${evidenciaFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.evidencia.submit();  
  }
</script>
