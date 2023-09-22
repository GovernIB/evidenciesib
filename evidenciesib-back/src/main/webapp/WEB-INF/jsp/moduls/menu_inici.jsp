<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5><fmt:message key="menuinici" /></h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">
  


    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/common/principal.html"/>">
        <span style="${(fn:contains(url, 'principal'))? "font-weight: bold;" : ""}">Pàgina Inicial</span>
      </a>
    </li>


  </ul>
</div>

