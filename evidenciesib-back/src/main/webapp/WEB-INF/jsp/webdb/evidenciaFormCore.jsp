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
        <tr id="evidencia_personanom_rowid">
          <td id="evidencia_personanom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONANOM])?'evidencia.personanom':__theForm.labels[EvidenciaFields.PERSONANOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONANOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONANOM]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personanom_columnvalueid">
            <form:errors path="evidencia.personanom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personanom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONALLINATGE1)}">
        <tr id="evidencia_personallinatge1_rowid">
          <td id="evidencia_personallinatge1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONALLINATGE1])?'evidencia.personallinatge1':__theForm.labels[EvidenciaFields.PERSONALLINATGE1]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONALLINATGE1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONALLINATGE1]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personallinatge1_columnvalueid">
            <form:errors path="evidencia.personallinatge1" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE1)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE1)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personallinatge1"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONALLINATGE2)}">
        <tr id="evidencia_personallinatge2_rowid">
          <td id="evidencia_personallinatge2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONALLINATGE2])?'evidencia.personallinatge2':__theForm.labels[EvidenciaFields.PERSONALLINATGE2]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONALLINATGE2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONALLINATGE2]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personallinatge2_columnvalueid">
            <form:errors path="evidencia.personallinatge2" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE2)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONALLINATGE2)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personallinatge2"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONANIF)}">
        <tr id="evidencia_personanif_rowid">
          <td id="evidencia_personanif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONANIF])?'evidencia.personanif':__theForm.labels[EvidenciaFields.PERSONANIF]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONANIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONANIF]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personanif_columnvalueid">
            <form:errors path="evidencia.personanif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANIF)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONANIF)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.personanif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DOCUMENTHASH)}">
        <tr id="evidencia_documenthash_rowid">
          <td id="evidencia_documenthash_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DOCUMENTHASH])?'evidencia.documenthash':__theForm.labels[EvidenciaFields.DOCUMENTHASH]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DOCUMENTHASH]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DOCUMENTHASH]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_documenthash_columnvalueid">
            <form:errors path="evidencia.documenthash" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTHASH)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTHASH)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.documenthash"   />

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
        <tr id="evidencia_documentmida_rowid">
          <td id="evidencia_documentmida_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DOCUMENTMIDA])?'evidencia.documentmida':__theForm.labels[EvidenciaFields.DOCUMENTMIDA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DOCUMENTMIDA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DOCUMENTMIDA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_documentmida_columnvalueid">
            <form:errors path="evidencia.documentmida" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTMIDA)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DOCUMENTMIDA)? ' uneditable-input' : ''}"  style=""  path="evidencia.documentmida"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.DATAINICI)}">
        <tr id="evidencia_datainici_rowid">
          <td id="evidencia_datainici_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DATAINICI])?'evidencia.datainici':__theForm.labels[EvidenciaFields.DATAINICI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DATAINICI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DATAINICI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_datainici_columnvalueid">
    <form:errors path="evidencia.datainici" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_datainici" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAINICI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_datainici" path="evidencia.datainici" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAINICI)}" >
                    <div class="input-group-append"  data-target="#evidencia_datainici"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_datainici').datetimepicker({
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
        <tr id="evidencia_datafi_rowid">
          <td id="evidencia_datafi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.DATAFI])?'evidencia.datafi':__theForm.labels[EvidenciaFields.DATAFI]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.DATAFI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.DATAFI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_datafi_columnvalueid">
    <form:errors path="evidencia.datafi" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_datafi" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAFI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_datafi" path="evidencia.datafi" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.DATAFI)}" >
                    <div class="input-group-append"  data-target="#evidencia_datafi"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_datafi').datetimepicker({
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
        <tr id="evidencia_usuariaplicacio_rowid">
          <td id="evidencia_usuariaplicacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.USUARIAPLICACIO])?'evidencia.usuariaplicacio':__theForm.labels[EvidenciaFields.USUARIAPLICACIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.USUARIAPLICACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.USUARIAPLICACIO]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_usuariaplicacio_columnvalueid">
              <form:errors path="evidencia.usuariaplicacio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIAPLICACIO)? 'true' : 'false'}" path="evidencia.usuariaplicacio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_usuariaplicacio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_usuariaplicacio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.usuariaplicacio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.usuariaplicacio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.usuariaplicacio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_usuariaplicacio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_usuariaplicacio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_usuariaplicacio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.USUARIPERSONA)}">
        <tr id="evidencia_usuaripersona_rowid">
          <td id="evidencia_usuaripersona_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.USUARIPERSONA])?'evidencia.usuaripersona':__theForm.labels[EvidenciaFields.USUARIPERSONA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.USUARIPERSONA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.USUARIPERSONA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_usuaripersona_columnvalueid">
            <form:errors path="evidencia.usuaripersona" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIPERSONA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.USUARIPERSONA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.usuaripersona"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATCODI)}">
        <tr id="evidencia_estatcodi_rowid">
          <td id="evidencia_estatcodi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATCODI])?'evidencia.estatcodi':__theForm.labels[EvidenciaFields.ESTATCODI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATCODI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATCODI]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estatcodi_columnvalueid">
            <form:errors path="evidencia.estatcodi" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATCODI)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATCODI)? ' uneditable-input' : ''}"  style=""  path="evidencia.estatcodi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATERROR)}">
        <tr id="evidencia_estaterror_rowid">
          <td id="evidencia_estaterror_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATERROR])?'evidencia.estaterror':__theForm.labels[EvidenciaFields.ESTATERROR]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATERROR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATERROR]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estaterror_columnvalueid">
            <form:errors path="evidencia.estaterror" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATERROR)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATERROR)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.estaterror"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.ESTATEXCEPCIO)}">
        <tr id="evidencia_estatexcepcio_rowid">
          <td id="evidencia_estatexcepcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.ESTATEXCEPCIO])?'evidencia.estatexcepcio':__theForm.labels[EvidenciaFields.ESTATEXCEPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.ESTATEXCEPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.ESTATEXCEPCIO]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_estatexcepcio_columnvalueid">
              <form:errors path="evidencia.estatexcepcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.ESTATEXCEPCIO)? 'true' : 'false'}" path="evidencia.estatexcepcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_estatexcepcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_estatexcepcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatexcepcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatexcepcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.estatexcepcio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_estatexcepcio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_estatexcepcio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_estatexcepcio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONAMOBIL)}">
        <tr id="evidencia_personamobil_rowid">
          <td id="evidencia_personamobil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONAMOBIL])?'evidencia.personamobil':__theForm.labels[EvidenciaFields.PERSONAMOBIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONAMOBIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONAMOBIL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personamobil_columnvalueid">
            <form:errors path="evidencia.personamobil" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAMOBIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAMOBIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.personamobil"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINTYPE)}">
        <tr id="evidencia_logintype_rowid">
          <td id="evidencia_logintype_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINTYPE])?'evidencia.logintype':__theForm.labels[EvidenciaFields.LOGINTYPE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINTYPE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINTYPE]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_logintype_columnvalueid">
            <form:errors path="evidencia.logintype" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINTYPE)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINTYPE)? ' uneditable-input' : ''}"  style=""  path="evidencia.logintype"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINID)}">
        <tr id="evidencia_loginid_rowid">
          <td id="evidencia_loginid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINID])?'evidencia.loginid':__theForm.labels[EvidenciaFields.LOGINID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginid_columnvalueid">
              <form:errors path="evidencia.loginid" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINID)? 'true' : 'false'}" path="evidencia.loginid"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_loginid" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_loginid" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginid'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginid'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginid'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_loginid').on('click', function(){
					var valor = ($('#dropdownMenuContainer_loginid').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_loginid').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINDATA)}">
        <tr id="evidencia_logindata_rowid">
          <td id="evidencia_logindata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINDATA])?'evidencia.logindata':__theForm.labels[EvidenciaFields.LOGINDATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINDATA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_logindata_columnvalueid">
    <form:errors path="evidencia.logindata" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="evidencia_logindata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#evidencia_logindata" path="evidencia.logindata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINDATA)}" >
                    <div class="input-group-append"  data-target="#evidencia_logindata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#evidencia_logindata').datetimepicker({
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
        <tr id="evidencia_localitzacioip_rowid">
          <td id="evidencia_localitzacioip_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOIP])?'evidencia.localitzacioip':__theForm.labels[EvidenciaFields.LOCALITZACIOIP]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOIP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOIP]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzacioip_columnvalueid">
            <form:errors path="evidencia.localitzacioip" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOIP)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOIP)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzacioip"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOCODIPOSTAL)}">
        <tr id="evidencia_localitzaciocodipostal_rowid">
          <td id="evidencia_localitzaciocodipostal_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOCODIPOSTAL])?'evidencia.localitzaciocodipostal':__theForm.labels[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOCODIPOSTAL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzaciocodipostal_columnvalueid">
            <form:errors path="evidencia.localitzaciocodipostal" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCODIPOSTAL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="evidencia.localitzaciocodipostal"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOCALITZACIOCOORDENADES)}">
        <tr id="evidencia_localitzaciocoordenades_rowid">
          <td id="evidencia_localitzaciocoordenades_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOCALITZACIOCOORDENADES])?'evidencia.localitzaciocoordenades':__theForm.labels[EvidenciaFields.LOCALITZACIOCOORDENADES]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOCALITZACIOCOORDENADES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOCALITZACIOCOORDENADES]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_localitzaciocoordenades_columnvalueid">
            <form:errors path="evidencia.localitzaciocoordenades" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCOORDENADES)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOCALITZACIOCOORDENADES)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.localitzaciocoordenades"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.PERSONAEMAIL)}">
        <tr id="evidencia_personaemail_rowid">
          <td id="evidencia_personaemail_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.PERSONAEMAIL])?'evidencia.personaemail':__theForm.labels[EvidenciaFields.PERSONAEMAIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.PERSONAEMAIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.PERSONAEMAIL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_personaemail_columnvalueid">
            <form:errors path="evidencia.personaemail" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAEMAIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.PERSONAEMAIL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.personaemail"   />

           </td>
        </tr>
        </c:if>
        
