<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
    <h5>
        <fmt:message key="menu.admin" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">
    
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/evidencia/list"/>">
        <span style="${(fn:contains(url, '/admin/evidencia'))? "font-weight: bold;" : ""}"><fmt:message key="evidencia.evidencia.plural" /></span>
      </a>
    </li>

    </ul>
</div>

