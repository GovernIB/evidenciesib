<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EvidenciaFields" className="es.caib.evidenciesib.model.fields.EvidenciaFields"/>

  <%-- HIDDEN PARAMS: FILTER BY --%> 
  <form:hidden path="visibleFilterBy"/>

  <%-- FILTRAR PER - INICI --%>
  
  <c:set var="displayFilterDiv" value="${__theFilterForm.visibleFilterBy?'':'display:none;'}" />  
  
  <div id="FilterDiv" class="wellgroupfilter formbox" style="${displayFilterDiv} margin-bottom:3px; margin-left: 1px; padding:3px;">

      <div class="page-header">
        <fmt:message key="genapp.form.filterby"/>
        
        <div class="float-right">

           <a class="float-right" style="margin-left:10px" href="#"> <i title="<fmt:message key="genapp.form.hidefilter"/>" onclick="document.getElementById('FilterDiv').style.display='none'; document.getElementById('FilterButton').style.display='inline';" class="far fa-window-close"></i></a>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="button" onclick="clear_form_elements(this.form)" value="<fmt:message key="genapp.form.clean"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="reset" value="<fmt:message key="genapp.form.reset"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-primary float-right" type="submit" value="<fmt:message key="genapp.form.search"/>"/>

        </div>
      </div>
      <div class="form-inline">
      
      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key < 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.EVIDENCIAID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="evidencia.evidenciaID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="evidenciaIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="evidenciaIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.NOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.nom" var="nom" />
              <fmt:message key="genapp.form.searchby" var="cercapernom" >                
                 <fmt:param value="${nom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${nom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernom}" path="nom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONANOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personanom" var="personanom" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonanom" >                
                 <fmt:param value="${personanom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personanom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonanom}" path="personanom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONALLINATGE1)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personallinatge1" var="personallinatge1" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonallinatge1" >                
                 <fmt:param value="${personallinatge1}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personallinatge1}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonallinatge1}" path="personallinatge1" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONALLINATGE2)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personallinatge2" var="personallinatge2" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonallinatge2" >                
                 <fmt:param value="${personallinatge2}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personallinatge2}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonallinatge2}" path="personallinatge2" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONANIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personanif" var="personanif" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonanif" >                
                 <fmt:param value="${personanif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personanif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonanif}" path="personanif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.DOCUMENTHASH)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.documenthash" var="documenthash" />
              <fmt:message key="genapp.form.searchby" var="cercaperdocumenthash" >                
                 <fmt:param value="${documenthash}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${documenthash}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperdocumenthash}" path="documenthash" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.DOCUMENTMIDA)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="evidencia.documentmida" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="documentmidaDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="documentmidaFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.DATAINICI)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="evidencia.datainici" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group">
                <div class="input-group date" id="datainiciDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#datainiciDesde" path="datainiciDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#datainiciDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#datainiciDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group">
                <div class="input-group date" id="datainiciFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#datainiciFins" path="datainiciFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#datainiciFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#datainiciFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.DATAFI)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="evidencia.datafi" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group">
                <div class="input-group date" id="datafiDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#datafiDesde" path="datafiDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#datafiDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#datafiDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group">
                <div class="input-group date" id="datafiFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#datafiFins" path="datafiFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#datafiFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#datafiFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.USUARIAPLICACIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.usuariaplicacio" var="usuariaplicacio" />
              <fmt:message key="genapp.form.searchby" var="cercaperusuariaplicacio" >                
                 <fmt:param value="${usuariaplicacio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${usuariaplicacio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperusuariaplicacio}" path="usuariaplicacio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.USUARIPERSONA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.usuaripersona" var="usuaripersona" />
              <fmt:message key="genapp.form.searchby" var="cercaperusuaripersona" >                
                 <fmt:param value="${usuaripersona}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${usuaripersona}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperusuaripersona}" path="usuaripersona" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATCODI)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="evidencia.estatcodi" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="estatcodiDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="estatcodiFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATERROR)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.estaterror" var="estaterror" />
              <fmt:message key="genapp.form.searchby" var="cercaperestaterror" >                
                 <fmt:param value="${estaterror}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estaterror}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestaterror}" path="estaterror" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATEXCEPCIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.estatexcepcio" var="estatexcepcio" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatexcepcio" >                
                 <fmt:param value="${estatexcepcio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatexcepcio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatexcepcio}" path="estatexcepcio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONAMOBIL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personamobil" var="personamobil" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonamobil" >                
                 <fmt:param value="${personamobil}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personamobil}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonamobil}" path="personamobil" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINTYPE)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="evidencia.logintype" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="logintypeDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="logintypeFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginid" var="loginid" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginid" >                
                 <fmt:param value="${loginid}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginid}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginid}" path="loginid" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINDATA)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="evidencia.logindata" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group">
                <div class="input-group date" id="logindataDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#logindataDesde" path="logindataDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#logindataDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#logindataDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group">
                <div class="input-group date" id="logindataFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#logindataFins" path="logindataFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#logindataFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#logindataFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOIP)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioip" var="localitzacioip" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioip" >                
                 <fmt:param value="${localitzacioip}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioip}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioip}" path="localitzacioip" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzaciocodipostal" var="localitzaciocodipostal" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzaciocodipostal" >                
                 <fmt:param value="${localitzaciocodipostal}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzaciocodipostal}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzaciocodipostal}" path="localitzaciocodipostal" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOCOORDENADES)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzaciocoordenades" var="localitzaciocoordenades" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzaciocoordenades" >                
                 <fmt:param value="${localitzaciocoordenades}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzaciocoordenades}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzaciocoordenades}" path="localitzaciocoordenades" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONAEMAIL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaemail" var="personaemail" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaemail" >                
                 <fmt:param value="${personaemail}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaemail}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaemail}" path="personaemail" />
            </div>


        </c:if>

      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key >= 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>
      </div>
    </div>



    <%-- FILTRAR PER - FINAL --%>
  
