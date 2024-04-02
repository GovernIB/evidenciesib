<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/pages/head.jsp"%>
<body>
    <script type="text/javascript">
       function gotoPage() {
          window.location.href = "<%=request.getContextPath()%>/frontpostloginend/${evidenciaID}";
       }
    </script>


    <%--  Elemento centrado horizonalmente y verticalmente --%>
    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
        <center>
            <h4>EvidènciesIB</h4>
        </center>
        <img src="<%=request.getContextPath()%>/images/spinner_40.gif" /><br />
        <center>
            <fmt:message key="espera" />
        </center>
    </div>
    <%-- Enviar página a /loginpostend utilizando javascript --%>
    <script type="text/javascript">
          setTimeout(() => {gotoPage()}, 250);
    </script>
</body>
</html>
