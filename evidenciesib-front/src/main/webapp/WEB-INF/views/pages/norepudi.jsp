<%@page import="es.caib.evidenciesib.front.controller.EvidenciaLoginController"%>
<%@page import="es.caib.evidenciesib.model.fields.EvidenciaFields"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>
<c:set var="currentLang" value="${pageContext.response.locale.language}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="${currentLang}" lang="${pageContext.response.locale.language}">
<%@include file="/WEB-INF/views/pages/head.jsp"%>
<body>
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
                    <img id="thumbnail" style="height: 300px; border: 1px solid #000; padding: 2px; display:none;" src="${thumbnail}"
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
                        onclick="clickedButton='accept';"
                           type="submit"  value="<fmt:message key="norepudi.acceptar" />" />
                            &nbsp;&nbsp;
                             <input id="submitCancel" name="submitCancel" class="btn btn-secondary btn-lg"
                             onclick="clickedButton='cancel';"
                            type="submit" value="<fmt:message key="norepudi.cancelar" />" />
                    </center>
                </div>
            </div>
        </div>
    </form>

    <script type="text/javascript">
    
        var clickedButton;
    
        function imageLoaded() {
            var element = document.getElementById('waitMessage');
            element.style.cssText = 'display:none;';
            var thumbnail = document.getElementById('thumbnail');
            thumbnail.style.cssText = 'display:;';
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
    </script>

</body>
</html>