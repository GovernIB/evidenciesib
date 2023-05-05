<%@page import="es.caib.evidenciesib.model.fields.EvidenciaFields"%>


<script type="text/javascript">


$(document).ready(function() {

var xhttp = new XMLHttpRequest();
xhttp.open("GET", "http://ip-api.com/json/?lang=es", true);
xhttp.responseType = 'json';
xhttp.onload = function() {
    var status = xhttp.status;
    var loc = xhttp.response;
    if (status === 200) {
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>', loc.city);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>', loc.zip);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOIP.javaName%>', loc.query);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOLATITUD.javaName%>', loc.lat);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>', loc.lon);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOPAIS.javaName%>', loc.countryCode);
        setValorLoc('<%=EvidenciaFields.LOCALITZACIOREGIO.javaName%>', loc.region);
    } else {
      alert("Error recolling informació de localització: " + loc);
    }
  };
  xhttp.send();

});

function setValorLoc(camp, valor) {
    if (valor != undefined && valor != null && valor != '') {
      var obj = document.getElementById('<%=EvidenciaFields._TABLE_MODEL%>.' + camp);
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