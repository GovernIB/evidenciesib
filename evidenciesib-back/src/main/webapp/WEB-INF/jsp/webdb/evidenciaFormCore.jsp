<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EvidenciaFields" className="es.caib.evidenciesib.model.fields.EvidenciaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.NOM)}">
        <tr id="evidencia_nom_rowid">
          <td id="evidencia_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.NOM])?'evidencia.nom':__theForm.labels[EvidenciaFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_nom_columnvalueid">
            <form:errors path="evidencia.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONANOM)}">
        <tr id="evidencia_personaNom_rowid">
          <td id="evidencia_personaNom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONANOM])?'evidencia.personaNom':__theForm.labels[EvidenciaFields.PERSONANOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONANOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONANOM]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaNom_columnvalueid">
            <form:errors path="evidencia.personaNom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personaNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONALLINATGE1)}">
        <tr id="evidencia_personaLlinatge1_rowid">
          <td id="evidencia_personaLlinatge1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONALLINATGE1])?'evidencia.personaLlinatge1':__theForm.labels[EvidenciaFields.PERSONALLINATGE1]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONALLINATGE1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONALLINATGE1]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaLlinatge1_columnvalueid">
            <form:errors path="evidencia.personaLlinatge1" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE1)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE1)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personaLlinatge1"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONALLINATGE2)}">
        <tr id="evidencia_personaLlinatge2_rowid">
          <td id="evidencia_personaLlinatge2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONALLINATGE2])?'evidencia.personaLlinatge2':__theForm.labels[EvidenciaFields.PERSONALLINATGE2]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONALLINATGE2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONALLINATGE2]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaLlinatge2_columnvalueid">
            <form:errors path="evidencia.personaLlinatge2" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE2)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE2)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personaLlinatge2"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONANIF)}">
        <tr id="evidencia_personaNif_rowid">
          <td id="evidencia_personaNif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONANIF])?'evidencia.personaNif':__theForm.labels[EvidenciaFields.PERSONANIF]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONANIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONANIF]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaNif_columnvalueid">
            <form:errors path="evidencia.personaNif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANIF)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANIF)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.personaNif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONAEMAIL)}">
        <tr id="evidencia_personaEmail_rowid">
          <td id="evidencia_personaEmail_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONAEMAIL])?'evidencia.personaEmail':__theForm.labels[EvidenciaFields.PERSONAEMAIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONAEMAIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONAEMAIL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaEmail_columnvalueid">
            <form:errors path="evidencia.personaEmail" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAEMAIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAEMAIL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personaEmail"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONAMOBIL)}">
        <tr id="evidencia_personaMobil_rowid">
          <td id="evidencia_personaMobil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONAMOBIL])?'evidencia.personaMobil':__theForm.labels[EvidenciaFields.PERSONAMOBIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONAMOBIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONAMOBIL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaMobil_columnvalueid">
            <form:errors path="evidencia.personaMobil" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAMOBIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAMOBIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.personaMobil"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DOCUMENTHASH)}">
        <tr id="evidencia_documentHash_rowid">
          <td id="evidencia_documentHash_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DOCUMENTHASH])?'evidencia.documentHash':__theForm.labels[EvidenciaFields.DOCUMENTHASH]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DOCUMENTHASH]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DOCUMENTHASH]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_documentHash_columnvalueid">
            <form:errors path="evidencia.documentHash" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTHASH)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTHASH)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.documentHash"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DOCUMENTFITXERID)}">
        <tr id="evidencia_documentFitxerID_rowid">
          <td id="evidencia_documentFitxerID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DOCUMENTFITXERID])?'evidencia.documentFitxerID':__theForm.labels[EvidenciaFields.DOCUMENTFITXERID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DOCUMENTFITXERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DOCUMENTFITXERID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_documentFitxerID_columnvalueid">
              <form:errors path="evidencia.documentFitxerID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTFITXERID)}" >
              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.documentFitxer)}"/>">${__theForm.evidencia.documentFitxer.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTFITXERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTFITXERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTFITXERID)? ' uneditable-input' : ''}"   path="documentFitxerID" type="file" />
                  <label class="custom-file-label" for="documentFitxerID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.evidencia.documentFitxer}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.documentFitxer)}"/>">${__theForm.evidencia.documentFitxer.nom}</a>
</small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="documentFitxerID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#documentFitxerID').on('change', function(){
						var ruta = $('#documentFitxerID').val(); 
						var rutaArray = ruta.split('\\');
						$('#documentFitxerID-custom-file-label').css('display','block');
						$('#documentFitxerID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DOCUMENTMIDA)}">
        <tr id="evidencia_documentMida_rowid">
          <td id="evidencia_documentMida_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DOCUMENTMIDA])?'evidencia.documentMida':__theForm.labels[EvidenciaFields.DOCUMENTMIDA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DOCUMENTMIDA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DOCUMENTMIDA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_documentMida_columnvalueid">
            <form:errors path="evidencia.documentMida" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTMIDA)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTMIDA)? ' uneditable-input' : ''}"  style=""  path="evidencia.documentMida"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DATAINICI)}">
        <tr id="evidencia_dataInici_rowid">
          <td id="evidencia_dataInici_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DATAINICI])?'evidencia.dataInici':__theForm.labels[EvidenciaFields.DATAINICI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DATAINICI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DATAINICI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_dataInici_columnvalueid">
    <form:errors path="evidencia.dataInici" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_dataInici" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAINICI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_dataInici" path="evidencia.dataInici" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAINICI)}" >
                    <div class="input-group-append"  data-target="#evidencia_dataInici"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_dataInici').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DATAFI)}">
        <tr id="evidencia_dataFi_rowid">
          <td id="evidencia_dataFi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DATAFI])?'evidencia.dataFi':__theForm.labels[EvidenciaFields.DATAFI]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DATAFI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DATAFI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_dataFi_columnvalueid">
    <form:errors path="evidencia.dataFi" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_dataFi" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAFI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_dataFi" path="evidencia.dataFi" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAFI)}" >
                    <div class="input-group-append"  data-target="#evidencia_dataFi"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_dataFi').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.USUARIAPLICACIO)}">
        <tr id="evidencia_usuariAplicacio_rowid">
          <td id="evidencia_usuariAplicacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.USUARIAPLICACIO])?'evidencia.usuariAplicacio':__theForm.labels[EvidenciaFields.USUARIAPLICACIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.USUARIAPLICACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.USUARIAPLICACIO]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_usuariAplicacio_columnvalueid">
            <form:errors path="evidencia.usuariAplicacio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIAPLICACIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIAPLICACIO)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.usuariAplicacio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.USUARIPERSONA)}">
        <tr id="evidencia_usuariPersona_rowid">
          <td id="evidencia_usuariPersona_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.USUARIPERSONA])?'evidencia.usuariPersona':__theForm.labels[EvidenciaFields.USUARIPERSONA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.USUARIPERSONA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.USUARIPERSONA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_usuariPersona_columnvalueid">
            <form:errors path="evidencia.usuariPersona" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIPERSONA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIPERSONA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.usuariPersona"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATCODI)}">
        <tr id="evidencia_estatCodi_rowid">
          <td id="evidencia_estatCodi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATCODI])?'evidencia.estatCodi':__theForm.labels[EvidenciaFields.ESTATCODI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATCODI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATCODI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estatCodi_columnvalueid">
          <form:errors path="evidencia.estatCodi" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATCODI)}" >
          <form:hidden path="evidencia.estatCodi"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.evidencia.estatCodi,__theForm.listOfValuesForEstatCodi)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATCODI)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="evidencia_estatCodi"  onchange="if(typeof onChangeEstatCodi == 'function') {  onChangeEstatCodi(this); };"  cssClass="form-control col-md-9-optional" path="evidencia.estatCodi">
            <c:forEach items="${__theForm.listOfValuesForEstatCodi}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATERROR)}">
        <tr id="evidencia_estatError_rowid">
          <td id="evidencia_estatError_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATERROR])?'evidencia.estatError':__theForm.labels[EvidenciaFields.ESTATERROR]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATERROR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATERROR]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estatError_columnvalueid">
            <form:errors path="evidencia.estatError" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATERROR)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATERROR)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.estatError"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATEXCEPCIO)}">
        <tr id="evidencia_estatExcepcio_rowid">
          <td id="evidencia_estatExcepcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATEXCEPCIO])?'evidencia.estatExcepcio':__theForm.labels[EvidenciaFields.ESTATEXCEPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATEXCEPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATEXCEPCIO]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estatExcepcio_columnvalueid">
              <form:errors path="evidencia.estatExcepcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATEXCEPCIO)? 'true' : 'false'}" path="evidencia.estatExcepcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_estatExcepcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_estatExcepcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatExcepcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatExcepcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatExcepcio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_estatExcepcio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_estatExcepcio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_estatExcepcio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINTYPE)}">
        <tr id="evidencia_loginType_rowid">
          <td id="evidencia_loginType_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINTYPE])?'evidencia.loginType':__theForm.labels[EvidenciaFields.LOGINTYPE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINTYPE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINTYPE]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginType_columnvalueid">
          <form:errors path="evidencia.loginType" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINTYPE)}" >
          <form:hidden path="evidencia.loginType"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.evidencia.loginType,__theForm.listOfValuesForLoginType)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINTYPE)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="evidencia_loginType"  onchange="if(typeof onChangeLoginType == 'function') {  onChangeLoginType(this); };"  cssClass="form-control col-md-9-optional" path="evidencia.loginType">
            <c:forEach items="${__theForm.listOfValuesForLoginType}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINID)}">
        <tr id="evidencia_loginId_rowid">
          <td id="evidencia_loginId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINID])?'evidencia.loginId':__theForm.labels[EvidenciaFields.LOGINID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginId_columnvalueid">
              <form:errors path="evidencia.loginId" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINID)? 'true' : 'false'}" path="evidencia.loginId"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_loginId" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_loginId" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginId'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginId'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginId'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_loginId').on('click', function(){
					var valor = ($('#dropdownMenuContainer_loginId').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_loginId').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINDATA)}">
        <tr id="evidencia_loginData_rowid">
          <td id="evidencia_loginData_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINDATA])?'evidencia.loginData':__theForm.labels[EvidenciaFields.LOGINDATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINDATA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginData_columnvalueid">
    <form:errors path="evidencia.loginData" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_loginData" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_loginData" path="evidencia.loginData" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINDATA)}" >
                    <div class="input-group-append"  data-target="#evidencia_loginData"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_loginData').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOIP)}">
        <tr id="evidencia_localitzacioIp_rowid">
          <td id="evidencia_localitzacioIp_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOIP])?'evidencia.localitzacioIp':__theForm.labels[EvidenciaFields.LOCALITZACIOIP]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOIP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOIP]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioIp_columnvalueid">
            <form:errors path="evidencia.localitzacioIp" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOIP)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOIP)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioIp"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
        <tr id="evidencia_localitzacioCodiPostal_rowid">
          <td id="evidencia_localitzacioCodiPostal_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOCODIPOSTAL])?'evidencia.localitzacioCodiPostal':__theForm.labels[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioCodiPostal_columnvalueid">
            <form:errors path="evidencia.localitzacioCodiPostal" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioCodiPostal"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOLONGITUD)}">
        <tr id="evidencia_localitzacioLongitud_rowid">
          <td id="evidencia_localitzacioLongitud_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOLONGITUD])?'evidencia.localitzacioLongitud':__theForm.labels[EvidenciaFields.LOCALITZACIOLONGITUD]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOLONGITUD]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOLONGITUD]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioLongitud_columnvalueid">
            <form:errors path="evidencia.localitzacioLongitud" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOLONGITUD)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOLONGITUD)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioLongitud"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOLATITUD)}">
        <tr id="evidencia_localitzacioLatitud_rowid">
          <td id="evidencia_localitzacioLatitud_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOLATITUD])?'evidencia.localitzacioLatitud':__theForm.labels[EvidenciaFields.LOCALITZACIOLATITUD]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOLATITUD]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOLATITUD]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioLatitud_columnvalueid">
            <form:errors path="evidencia.localitzacioLatitud" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOLATITUD)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOLATITUD)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioLatitud"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOCIUTAT)}">
        <tr id="evidencia_localitzacioCiutat_rowid">
          <td id="evidencia_localitzacioCiutat_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOCIUTAT])?'evidencia.localitzacioCiutat':__theForm.labels[EvidenciaFields.LOCALITZACIOCIUTAT]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOCIUTAT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOCIUTAT]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioCiutat_columnvalueid">
            <form:errors path="evidencia.localitzacioCiutat" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCIUTAT)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCIUTAT)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.localitzacioCiutat"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOREGIO)}">
        <tr id="evidencia_localitzacioRegio_rowid">
          <td id="evidencia_localitzacioRegio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOREGIO])?'evidencia.localitzacioRegio':__theForm.labels[EvidenciaFields.LOCALITZACIOREGIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOREGIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOREGIO]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioRegio_columnvalueid">
            <form:errors path="evidencia.localitzacioRegio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOREGIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOREGIO)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioRegio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOPAIS)}">
        <tr id="evidencia_localitzacioPais_rowid">
          <td id="evidencia_localitzacioPais_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOPAIS])?'evidencia.localitzacioPais':__theForm.labels[EvidenciaFields.LOCALITZACIOPAIS]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOPAIS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOPAIS]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioPais_columnvalueid">
            <form:errors path="evidencia.localitzacioPais" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOPAIS)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOPAIS)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioPais"   />

           </td>
        </tr>
        </c:if>
        
