<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
    <h5>
        <fmt:message key="menu.admin" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">
    <%-- 
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    --%>
        <li style="list-style-type: disc; list-style-position: inside;"><a
            href="<c:url value="/admin/pluginfirmaenservidor/list"/>"> <span
                style="${(fn:contains(url, '/admin/pluginfirmaenservidor'))? " font-weight:bold;" : ""}"><fmt:message
                        key="menu.pluginfirma" /> </span>
        </a></li>
    </ul>
</div>

