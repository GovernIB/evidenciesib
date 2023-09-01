<%@page import="es.caib.evidenciesib.front.controller.EvidenciaLoginController"%>
<%@page import="es.caib.evidenciesib.model.fields.EvidenciaFields"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>
<c:set var="currentLang" value="${pageContext.response.locale.language}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="${currentLang}" lang="${pageContext.response.locale.language}">
<%@include file="/WEB-INF/views/pages/head.jsp"%>
<body>
<br/>
<br/>
<br/>
<center><img src="<%=request.getContextPath()%>/images/spinner_40.gif" /></center>

<form id="locationForm" action="<%=request.getContextPath()%><%=EvidenciaLoginController.MAPPING_PUBLIC_SET_LOCATION_POST%>/${evidenciaID}" method="post">
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOIP.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOIP.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLATITUD.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLATITUD.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOPAIS.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOPAIS.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOREGIO.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOREGIO.javaName%>" />
        
        <!--  <input type="submit" value="Continuar ..." />  --> 
</form>

<script type="text/javascript">


$(document).ready(function() {

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "https://ipapi.co/json/", true);
    xhttp.responseType = 'json';
    xhttp.onload = function() {
        var status = xhttp.status;
        var loc = xhttp.response;
        if (status === 200) {
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>', loc.city);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>', loc.postal);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOIP.javaName%>', loc.ip);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOLATITUD.javaName%>', loc.latitude);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>', loc.longitude);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOPAIS.javaName%>', loc.country);
            setValorLoc('<%=EvidenciaFields.LOCALITZACIOREGIO.javaName%>', loc.region_code);
        } else {
          alert("Error recolling informació de localització: " + loc);
        }

        document.getElementById("locationForm").submit(); 
    };
    xhttp.send();
    
    

});

function setValorLoc(camp, valor) {
    if (valor != undefined && valor != null && valor != '') {
      var obj = document.getElementById('<%=EvidenciaFields._TABLE_MODEL%>' + '.' + camp);
            if (obj == null) {
                console.error("El camp ]" + camp + "[ val null");
            } else {
<%-- console.log("Camp ]" + camp + "[ OK"); --%>
                obj.value = valor;
                obj.readOnly = true;
            }
        }
    }


</script>

</body>
</html>