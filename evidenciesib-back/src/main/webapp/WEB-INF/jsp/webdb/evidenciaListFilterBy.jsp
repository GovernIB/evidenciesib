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
              <fmt:message key="evidencia.personaNom" var="personaNom" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaNom" >                
                 <fmt:param value="${personaNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaNom}" path="personaNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONALLINATGE1)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaLlinatge1" var="personaLlinatge1" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaLlinatge1" >                
                 <fmt:param value="${personaLlinatge1}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaLlinatge1}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaLlinatge1}" path="personaLlinatge1" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONALLINATGE2)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaLlinatge2" var="personaLlinatge2" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaLlinatge2" >                
                 <fmt:param value="${personaLlinatge2}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaLlinatge2}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaLlinatge2}" path="personaLlinatge2" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONANIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaNif" var="personaNif" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaNif" >                
                 <fmt:param value="${personaNif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaNif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaNif}" path="personaNif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONAEMAIL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaEmail" var="personaEmail" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaEmail" >                
                 <fmt:param value="${personaEmail}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaEmail}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaEmail}" path="personaEmail" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.PERSONAMOBIL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.personaMobil" var="personaMobil" />
              <fmt:message key="genapp.form.searchby" var="cercaperpersonaMobil" >                
                 <fmt:param value="${personaMobil}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${personaMobil}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperpersonaMobil}" path="personaMobil" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.DATAINICI)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="evidencia.dataInici" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataIniciDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataIniciDesde" path="dataIniciDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataIniciDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataIniciDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataIniciFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataIniciFins" path="dataIniciFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataIniciFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataIniciFins').datetimepicker({
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
              <span class="add-on"><fmt:message key="evidencia.dataFi" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataFiDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataFiDesde" path="dataFiDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataFiDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataFiDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataFiFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataFiFins" path="dataFiFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataFiFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataFiFins').datetimepicker({
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
              <fmt:message key="evidencia.usuariAplicacio" var="usuariAplicacio" />
              <fmt:message key="genapp.form.searchby" var="cercaperusuariAplicacio" >                
                 <fmt:param value="${usuariAplicacio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${usuariAplicacio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperusuariAplicacio}" path="usuariAplicacio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.USUARIPERSONA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.usuariPersona" var="usuariPersona" />
              <fmt:message key="genapp.form.searchby" var="cercaperusuariPersona" >                
                 <fmt:param value="${usuariPersona}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${usuariPersona}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperusuariPersona}" path="usuariPersona" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATCODI)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="evidencia.estatCodi" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="evidencia_estatCodi_select" path="estatCodiSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForEstatCodi}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.estatCodiSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#evidencia_estatCodi_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATERROR)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.estatError" var="estatError" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatError" >                
                 <fmt:param value="${estatError}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatError}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatError}" path="estatError" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.ESTATEXCEPCIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.estatExcepcio" var="estatExcepcio" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatExcepcio" >                
                 <fmt:param value="${estatExcepcio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatExcepcio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatExcepcio}" path="estatExcepcio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINTYPE)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="evidencia.loginType" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="evidencia_loginType_select" path="loginTypeSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForLoginType}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.loginTypeSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#evidencia_loginType_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINSUBTYPE)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginSubtype" var="loginSubtype" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginSubtype" >                
                 <fmt:param value="${loginSubtype}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginSubtype}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginSubtype}" path="loginSubtype" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINQAA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginQaa" var="loginQaa" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginQaa" >                
                 <fmt:param value="${loginQaa}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginQaa}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginQaa}" path="loginQaa" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINDATA)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="evidencia.loginData" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="loginDataDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#loginDataDesde" path="loginDataDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#loginDataDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#loginDataDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="loginDataFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#loginDataFins" path="loginDataFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#loginDataFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#loginDataFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginId" var="loginId" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginId" >                
                 <fmt:param value="${loginId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginId}" path="loginId" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINAUTHMETHOD)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginAuthMethod" var="loginAuthMethod" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginAuthMethod" >                
                 <fmt:param value="${loginAuthMethod}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginAuthMethod}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginAuthMethod}" path="loginAuthMethod" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOGINADDITIONALPROPERTIES)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.loginAdditionalProperties" var="loginAdditionalProperties" />
              <fmt:message key="genapp.form.searchby" var="cercaperloginAdditionalProperties" >                
                 <fmt:param value="${loginAdditionalProperties}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${loginAdditionalProperties}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperloginAdditionalProperties}" path="loginAdditionalProperties" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOIP)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioIp" var="localitzacioIp" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioIp" >                
                 <fmt:param value="${localitzacioIp}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioIp}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioIp}" path="localitzacioIp" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioCodiPostal" var="localitzacioCodiPostal" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioCodiPostal" >                
                 <fmt:param value="${localitzacioCodiPostal}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioCodiPostal}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioCodiPostal}" path="localitzacioCodiPostal" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOLATITUD)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioLatitud" var="localitzacioLatitud" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioLatitud" >                
                 <fmt:param value="${localitzacioLatitud}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioLatitud}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioLatitud}" path="localitzacioLatitud" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOLONGITUD)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioLongitud" var="localitzacioLongitud" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioLongitud" >                
                 <fmt:param value="${localitzacioLongitud}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioLongitud}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioLongitud}" path="localitzacioLongitud" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOCIUTAT)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioCiutat" var="localitzacioCiutat" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioCiutat" >                
                 <fmt:param value="${localitzacioCiutat}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioCiutat}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioCiutat}" path="localitzacioCiutat" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOREGIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioRegio" var="localitzacioRegio" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioRegio" >                
                 <fmt:param value="${localitzacioRegio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioRegio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioRegio}" path="localitzacioRegio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.LOCALITZACIOPAIS)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.localitzacioPais" var="localitzacioPais" />
              <fmt:message key="genapp.form.searchby" var="cercaperlocalitzacioPais" >                
                 <fmt:param value="${localitzacioPais}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${localitzacioPais}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlocalitzacioPais}" path="localitzacioPais" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.FIRMAREASON)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.firmaReason" var="firmaReason" />
              <fmt:message key="genapp.form.searchby" var="cercaperfirmaReason" >                
                 <fmt:param value="${firmaReason}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${firmaReason}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfirmaReason}" path="firmaReason" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.FIRMAIDIOMADOCUMENT)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.firmaIdiomaDocument" var="firmaIdiomaDocument" />
              <fmt:message key="genapp.form.searchby" var="cercaperfirmaIdiomaDocument" >                
                 <fmt:param value="${firmaIdiomaDocument}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${firmaIdiomaDocument}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfirmaIdiomaDocument}" path="firmaIdiomaDocument" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="evidencia.firmaTipusDocumental" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="evidencia_firmaTipusDocumental_select" path="firmaTipusDocumentalSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForFirmaTipusDocumental}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.firmaTipusDocumentalSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#evidencia_firmaTipusDocumental_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,EvidenciaFields.CALLBACKURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="evidencia.callBackUrl" var="callBackUrl" />
              <fmt:message key="genapp.form.searchby" var="cercapercallBackUrl" >                
                 <fmt:param value="${callBackUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${callBackUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapercallBackUrl}" path="callBackUrl" />
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
  
