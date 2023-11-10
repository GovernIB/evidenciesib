<%@page import="es.caib.evidenciesib.front.controller.EvidenciaLoginController"%>
<%@page import="es.caib.evidenciesib.model.fields.EvidenciaFields"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>
<c:set var="currentLang" value="${pageContext.response.locale.language}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="${currentLang}" lang="${pageContext.response.locale.language}">
<%@include file="/WEB-INF/views/pages/head.jsp"%>
<body onload="initValues()">
    <br />
    <br />
    <br />
    <center>
        <h1><fmt:message key="norepudi.titol" /></h1>
        <h3>-- <fmt:message key="norepudi.subtitol" /> --</h3>
    </center>
    <br/>
    <br/>

    <form name="norepudiForm" id="norepudiForm" action="${action}" onsubmit="return validateForm()" method="post">

        <div class="container">

            <div class="row">
                <div class="col-sm" style="text-align: right;">
                    <a href="${download}" target="_blank">
                    <img id="waitMessage" src="<c:url value="/images/spinner_40.gif"/>" />
                    <img id="thumbnail" style="display:none;" src="${thumbnail}"
                        alt="Thumbnail PDF" onload="imageLoaded();" />
                    </a>
                </div>
                <div class="col-sm" style>
                    <br/><br/>
                    <div class="form-check">
                        <input id="checkNoRepudi" name="checkNoRepudi" type="checkbox" style="transform: scale(2)"
                            class="form-check-input"> <label class="form-check-label" for="checkNoRepudi">
                            &nbsp;&nbsp;
                            <fmt:message key="norepudi.casella" />
                        </label>
                    </div>
                    <br />
                    <center>
                        <input id="submitAccept" name="submitAccept" class="btn btn-primary btn-lg"
                           type="submit"  value="<fmt:message key="norepudi.acceptar" />" />
                            &nbsp;&nbsp;
                             <input id="submitCancel" name="submitCancel" class="btn btn-secondary btn-lg"
                             onclick="clickedButton='cancel'"
                            type="submit" value="<fmt:message key="norepudi.cancelar" />" />
                    </center>
                </div>
            </div>
        </div>
        
        <input type="hidden" name="clickInfo" id="clickInfo" value=""/>
        
        <input type="hidden" name="deviceInfo" id="deviceInfo" value=""/>
        
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCIUTAT.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOIP.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOIP.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLATITUD.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLATITUD.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOLONGITUD.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOPAIS.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOPAIS.javaName%>" />
        <input type="hidden" id="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOREGIO.javaName%>" name="<%=EvidenciaFields._TABLE_MODEL + "." +EvidenciaFields.LOCALITZACIOREGIO.javaName%>" />
        
        
    </form>

    <script type="text/javascript">
    
    
        $("#submitAccept").click(function(evt){
            
            clickedButton='accept';
            
            var dt = new Date();
    
            var clickInfo =
                "date.ms="  + dt.getTime() + "\n"
                + "date.iso="  + dt.toISOString() + "\n"
                + "click.clientX="  + evt.clientX + "\n"
                + "click.clientY=" + evt.clientY + "\n"
                + "click.pageX=" + evt.pageX + "\n"
                + "click.pageY=" + evt.pageY + "\n"
                + "click.screenX=" + evt.screenX + "\n"
                + "click.screenY=" + evt.screenY;
            
            var element = document.getElementById('clickInfo');
            element.value = clickInfo;
            
         });
    
    
        var clickedButton;
    
        function imageLoaded() {
            var element = document.getElementById('waitMessage');
            element.style.cssText = 'display:none;';
            var thumbnail = document.getElementById('thumbnail');
            thumbnail.style.cssText = 'border:2px solid #000; padding: 2px;display:;';
        }

        function validateForm() {
            //alert("Entra a validateForm ...");
            if (clickedButton == 'accept') {
                var element = document.getElementById('checkNoRepudi');
                //alert("Element: " + element);
                //alert("Checked: " + element.checked);
                if (!element.checked) {
                    alert("<fmt:message key="norepudi.nomarcat" />");
                    return false;
                }
            }
            document.body.style.cursor = 'wait';
        }
        
        function initValues() {
            initDeviceInfo();
            initLocation();
        }
            
            
        function initDeviceInfo() {
            var deviceinfo = "platform.name=" +platform.name + "\n"
            + "platform.version=" +platform.version + "\n"
            + "platform.product=" +platform.product + "\n"
            + "platform.manufacturer=" +platform.manufacturer + "\n"
            + "platform.layout=" +platform.layout + "\n"
            + "platform.prerelease =" +platform.prerelease + "\n"
            + "platform.description =" +platform.description + "\n"
            + "platform.ua =" +platform.ua  + "\n"
            + "platform.os=" +platform.os + "\n"
            + "platform.os.architecture=" +platform.os.architecture + "\n"
            + "platform.os.family=" +platform.os.family + "\n"
            + "platform.os.version=" +platform.os.version;

            
            var element = document.getElementById('deviceInfo');
            
            element.value = deviceinfo;
        }
        

        function initLocation() {

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
            };
            xhttp.send();

        };

        function setValorLoc(camp, valor) {
            if (valor != undefined && valor != null && valor != '') {
                var obj = document.getElementById('<%=EvidenciaFields._TABLE_MODEL%>' + '.' + camp);
                if (obj == null) {
                    console.error("El camp ]" + camp + "[ val null");
                } else {
                    obj.value = valor;
                    obj.readOnly = true;
                }
            }
        }
        
    </script>

</body>
</html>