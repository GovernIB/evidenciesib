<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/pages/taglib.jsp"%>

<c:if test="${headerEnabled}">

    <style>
    
    .franja-inferior {
        background-color: #ffffff;
    }
    
    .contenedor-central {
        font-family: sans-serif;
        font-weight: bold;
        min-width: 200px;
        background-color: #ffffff; /* Un fondo claro para el contenedor */
        border-radius: 10px; /* Bordes redondeados */
        padding: 10px;
        margin: -4px;
        text-align: center;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Sombra suave opcional */
    }
    
    .contenedor-central img {
        max-width: 150px; /* Ajusta el tamaño máximo de la imagen */
        height: auto;
        display: block; /* Evita espacio extra debajo de la imagen */
        margin: 0 auto 10px; /* Centra la imagen y añade espacio debajo */
    }
    
    .contenedor-central p {
        margin-top: 0;
        font-size: 1em;
        color: #333; /* Color del texto */
        margin: 0px;
    }
    </style>

    <table style="position: absolute; left: -10px; width: calc(100% + 10px);" border=0 cellpadding=0 cellspacing=0>
        <tr style="background-color: ${backgroundColor};">
            <td style="height: 10%; width: 40%;">&nbsp;</td>
            <td style="width: auto">&nbsp;</td>
            <td style="width: 40%">&nbsp;</td>
        </tr>

        <tr style="background-color: ${backgroundColor};">
            <td  style="height: 30%; width: 50%;">&nbsp;</td>
            <td style="width: auto;" rowspan=2>
                <div class="contenedor-central">
                    <img src="<c:url value="${logoUrl}"/>" alt="Logo Entitat" style="border: none !important; outline: none !important;">
                    <c:if test="${not empty text}">
                        <p>${text}</p>
                    </c:if>
                </div>
            </td>
            <td style="width: 50%;">&nbsp;</td>
        </tr>

        <tr>
            <td style="height: 40%; width: 50%;">&nbsp;</td>
            <td style="width: 50%;">&nbsp;</td>
        </tr>

        <tr>
            <td style="height: 10%; width: 50%:">&nbsp;</td>
            <td style="width: auto;">&nbsp;</td>
            <td style="width: 50%">&nbsp;</td>
        </tr>
    </table>
    <div style="height: ${headerHeight}px;">&nbsp;</div>
    <%-- FINAL DE CAPÇALERA --%>
</c:if>