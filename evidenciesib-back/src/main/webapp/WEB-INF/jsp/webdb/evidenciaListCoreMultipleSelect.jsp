      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${evidencia.evidenciaID}"/>
       &nbsp;
      </td>
      </c:if>

