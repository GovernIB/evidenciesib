
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="evidenciaForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="evidenciaFormTitle.jsp" %>
 
  <c:set var="contexte" value="${evidenciaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="evidenciaFormCorePre.jsp" %>

  <%@include file="evidenciaFormCore.jsp" %>

  <%@include file="evidenciaFormCorePost.jsp" %>

  <%@include file="evidenciaFormButtons.jsp" %>

  <c:if test="${not empty evidenciaForm.sections}">
     <c:set var="__basename" value="evidencia" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${evidenciaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/evidenciaFormModificable.jsp" %>
  </c:if>

</form:form>


