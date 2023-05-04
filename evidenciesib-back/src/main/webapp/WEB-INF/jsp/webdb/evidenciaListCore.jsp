  <c:if test="${empty evidenciaItems}">
     <%@include file="evidenciaListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty evidenciaItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="evidenciaListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="evidenciaListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="evidenciaListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="evidencia" items="${evidenciaItems}">

        <tr id="evidencia_rowid_${evidencia.evidenciaID}">
          <%@include file="evidenciaListCoreMultipleSelect.jsp" %>

          <%@include file="evidenciaListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="evidenciaListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
