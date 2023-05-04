<%@ page contentType="text/html;charset=UTF-8" language="java"%>
 <%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 <c:set var="url" value="${urlActual}" />
 <div>
 <h5>WebDatabase</h5>
 <ul class="tree" style="margin:3px; padding:0px;">
 <%-- ==== GENAPP MARK START --%>


    <%-- Evidencia --%>
       <fmt:message var="entityname" key="evidencia.evidencia.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/evidencia/list/1"/>" ><span style="${(fn:contains(url, 'evidencia/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Fitxer --%>
       <fmt:message var="entityname" key="fitxer.fitxer.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/fitxer/list/1"/>" ><span style="${(fn:contains(url, 'fitxer/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Idioma --%>
       <fmt:message var="entityname" key="idioma.idioma.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/idioma/list/1"/>" ><span style="${(fn:contains(url, 'idioma/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Plugin --%>
       <fmt:message var="entityname" key="plugin.plugin.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/plugin/list/1"/>" ><span style="${(fn:contains(url, 'plugin/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Traduccio --%>
       <fmt:message var="entityname" key="traduccio.traduccio.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/traduccio/list/1"/>" ><span style="${(fn:contains(url, 'traduccio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>
<%-- ==== GENAPP MARK END --%>
 </ul>
 </div>
