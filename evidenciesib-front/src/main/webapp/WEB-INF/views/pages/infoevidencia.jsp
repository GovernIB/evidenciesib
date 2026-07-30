
<%@page import="es.caib.evidenciesib.model.fields.EvidenciaFields"%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>
<c:set var="currentLang" value="${pageContext.response.locale.language}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="${currentLang}" lang="${currentLang}">
<%@include file="/WEB-INF/views/pages/head.jsp"%>
<body>

    <%-- Capçalera d'entitat (opcional, es mostra si headerEnabled) --%>
    <c:if test="${headerEnabled}">
        <%-- Afegir de forma estàtica la pàgina entityheader.jsp --%>
        <%@include file="/WEB-INF/views/pages/entityheader.jsp" %>
    </c:if>



    <div class="container" style="margin-top: 20px;">

        <center>
            <h2>
                <fmt:message key="infoevidencia.titol" />
            </h2>
        </center>
        <br />

        <table class="table table-striped table-bordered">
            <tbody>
                <%-- Identificador de l'evidència --%>
                <tr>
                    <th style="width: 30%; text-align: right;"><fmt:message key="evidencia.evidenciaID" /></th>
                    <td>${evidencia.evidenciaID}</td>
                </tr>
                <%-- Nom de l'evidència --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.nom" /></th>
                    <td>${evidencia.nom}</td>
                </tr>
                <%-- NIF de la persona --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.personaNif" /></th>
                    <td>${evidencia.personaNif}</td>
                </tr>
                <%-- Nom d'usuari de la persona --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.personaUsername" /></th>
                    <td>${evidencia.personaUsername}</td>
                </tr>
                <%-- Nom de la persona --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.personaNom" /></th>
                    <td>${evidencia.personaNom}</td>
                </tr>
                <%-- Primer llinatge --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.personaLlinatge1" /></th>
                    <td>${evidencia.personaLlinatge1}</td>
                </tr>
                <%-- Segon llinatge --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.personaLlinatge2" /></th>
                    <td>${evidencia.personaLlinatge2}</td>
                </tr>
                <%-- Data d'inici --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.dataInici" /></th>
                    <td>${evidencia.dataInici}</td>
                </tr>
                <%-- Data de fi --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.dataFi" /></th>
                    <td>${evidencia.dataFi}</td>
                </tr>
                <%-- Subtipus de login --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginSubtype" /></th>
                    <td>${evidencia.loginSubtype}</td>
                </tr>
                <%-- QAA del login --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginQaa" /></th>
                    <td>${evidencia.loginQaa}</td>
                </tr>
                <%-- Data del login --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginData" /></th>
                    <td>${evidencia.loginData}</td>
                </tr>
                <%-- Identificador del login --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginId" /></th>
                    <td>${evidencia.loginId}</td>
                </tr>
                <%-- Mètode d'autenticació --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginAuthMethod" /></th>
                    <td>${evidencia.loginAuthMethod}</td>
                </tr>
                <%-- Propietats addicionals del login --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.loginAdditionalProperties" /></th>
                    <td><textarea readonly rows="8" style="width: 100%; font-family: 'Courier New', Courier, monospace;">${evidencia.loginAdditionalProperties}</textarea></td>
                </tr>
                <%-- Localització - IP --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioIp" /></th>
                    <td>${evidencia.localitzacioIp}</td>
                </tr>
                <%-- Localització - Codi Postal --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioCodiPostal" /></th>
                    <td>${evidencia.localitzacioCodiPostal}</td>
                </tr>
                <%-- Localització - Latitud --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioLatitud" /></th>
                    <td>${evidencia.localitzacioLatitud}</td>
                </tr>
                <%-- Localització - Longitud --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioLongitud" /></th>
                    <td>${evidencia.localitzacioLongitud}</td>
                </tr>
                <%-- Localització - Regió --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioRegio" /></th>
                    <td>${evidencia.localitzacioRegio}</td>
                </tr>
                <%-- Localització - Ciutat --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioCiutat" /></th>
                    <td>${evidencia.localitzacioCiutat}</td>
                </tr>
                <%-- Localització - País --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.localitzacioPais" /></th>
                    <td>${evidencia.localitzacioPais}</td>
                </tr>
                <%-- Firma - Raó de la firma --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.firmaReason" /></th>
                    <td>${evidencia.firmaReason}</td>
                </tr>
                <%-- Firma - Idioma Document --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.firmaIdiomaDocument" /></th>
                    <td>${evidencia.firmaIdiomaDocument}</td>
                </tr>
                <%-- Firma - Tipus documental --%>
                <tr>
                    <th style="text-align: right;"><fmt:message key="evidencia.firmaTipusDocumental" /></th>
                    <td>${evidencia.firmaTipusDocumental}</td>
                </tr>

                <tr id="evidencia_fitxerSignatID_rowid">
                    <th style="text-align: right;"><label><fmt:message key="evidencia.fitxerSignatID" /></label></th>
                    <td id="evidencia_fitxerSignatID_columnvalueid"><a target="_blank" href="${urlSignedFile}">${signedFileName}</a></td>
                </tr>

            </tbody>
        </table>

    </div>

</body>
</html>
