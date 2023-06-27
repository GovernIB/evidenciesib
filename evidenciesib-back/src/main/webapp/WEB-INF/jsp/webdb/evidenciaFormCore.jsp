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
            <div class="form-group"  style="margin-bottom: 0px;" >
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
            <div class="form-group"  style="margin-bottom: 0px;" >
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINSUBTYPE)}">
        <tr id="evidencia_loginSubtype_rowid">
          <td id="evidencia_loginSubtype_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINSUBTYPE])?'evidencia.loginSubtype':__theForm.labels[EvidenciaFields.LOGINSUBTYPE]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINSUBTYPE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINSUBTYPE]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginSubtype_columnvalueid">
            <form:errors path="evidencia.loginSubtype" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINSUBTYPE)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINSUBTYPE)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.loginSubtype"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINQAA)}">
        <tr id="evidencia_loginQaa_rowid">
          <td id="evidencia_loginQaa_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINQAA])?'evidencia.loginQaa':__theForm.labels[EvidenciaFields.LOGINQAA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINQAA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINQAA]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginQaa_columnvalueid">
            <form:errors path="evidencia.loginQaa" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINQAA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINQAA)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.loginQaa"   />

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
            <div class="form-group"  style="margin-bottom: 0px;" >
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
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINID)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.loginId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINAUTHMETHOD)}">
        <tr id="evidencia_loginAuthMethod_rowid">
          <td id="evidencia_loginAuthMethod_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINAUTHMETHOD])?'evidencia.loginAuthMethod':__theForm.labels[EvidenciaFields.LOGINAUTHMETHOD]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINAUTHMETHOD]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINAUTHMETHOD]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginAuthMethod_columnvalueid">
            <form:errors path="evidencia.loginAuthMethod" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINAUTHMETHOD)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINAUTHMETHOD)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.loginAuthMethod"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.LOGINADDITIONALPROPERTIES)}">
        <tr id="evidencia_loginAdditionalProperties_rowid">
          <td id="evidencia_loginAdditionalProperties_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.LOGINADDITIONALPROPERTIES])?'evidencia.loginAdditionalProperties':__theForm.labels[EvidenciaFields.LOGINADDITIONALPROPERTIES]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.LOGINADDITIONALPROPERTIES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.LOGINADDITIONALPROPERTIES]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_loginAdditionalProperties_columnvalueid">
              <form:errors path="evidencia.loginAdditionalProperties" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.LOGINADDITIONALPROPERTIES)? 'true' : 'false'}" path="evidencia.loginAdditionalProperties"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_loginAdditionalProperties" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_loginAdditionalProperties" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginAdditionalProperties'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginAdditionalProperties'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('evidencia.loginAdditionalProperties'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_loginAdditionalProperties').on('click', function(){
					var valor = ($('#dropdownMenuContainer_loginAdditionalProperties').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_loginAdditionalProperties').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FIRMAREASON)}">
        <tr id="evidencia_firmaReason_rowid">
          <td id="evidencia_firmaReason_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FIRMAREASON])?'evidencia.firmaReason':__theForm.labels[EvidenciaFields.FIRMAREASON]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FIRMAREASON]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FIRMAREASON]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_firmaReason_columnvalueid">
            <form:errors path="evidencia.firmaReason" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMAREASON)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMAREASON)? ' uneditable-input' : ''}"  style="" maxlength="255" path="evidencia.firmaReason"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FIRMAIDIOMADOCUMENT)}">
        <tr id="evidencia_firmaIdiomaDocument_rowid">
          <td id="evidencia_firmaIdiomaDocument_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FIRMAIDIOMADOCUMENT])?'evidencia.firmaIdiomaDocument':__theForm.labels[EvidenciaFields.FIRMAIDIOMADOCUMENT]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FIRMAIDIOMADOCUMENT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FIRMAIDIOMADOCUMENT]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_firmaIdiomaDocument_columnvalueid">
          <form:errors path="evidencia.firmaIdiomaDocument" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMAIDIOMADOCUMENT)}" >
          <form:hidden path="evidencia.firmaIdiomaDocument"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.evidencia.firmaIdiomaDocument,__theForm.listOfValuesForFirmaIdiomaDocument)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMAIDIOMADOCUMENT)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="evidencia_firmaIdiomaDocument"  onchange="if(typeof onChangeFirmaIdiomaDocument == 'function') {  onChangeFirmaIdiomaDocument(this); };"  cssClass="form-control col-md-9-optional" path="evidencia.firmaIdiomaDocument">
            <c:forEach items="${__theForm.listOfValuesForFirmaIdiomaDocument}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.evidencia.firmaIdiomaDocument }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.evidencia.firmaIdiomaDocument }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}">
        <tr id="evidencia_firmaTipusDocumental_rowid">
          <td id="evidencia_firmaTipusDocumental_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FIRMATIPUSDOCUMENTAL])?'evidencia.firmaTipusDocumental':__theForm.labels[EvidenciaFields.FIRMATIPUSDOCUMENTAL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FIRMATIPUSDOCUMENTAL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FIRMATIPUSDOCUMENTAL]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_firmaTipusDocumental_columnvalueid">
          <form:errors path="evidencia.firmaTipusDocumental" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}" >
          <form:hidden path="evidencia.firmaTipusDocumental"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.evidencia.firmaTipusDocumental,__theForm.listOfValuesForFirmaTipusDocumental)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FIRMATIPUSDOCUMENTAL)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="evidencia_firmaTipusDocumental"  onchange="if(typeof onChangeFirmaTipusDocumental == 'function') {  onChangeFirmaTipusDocumental(this); };"  cssClass="form-control col-md-9-optional" path="evidencia.firmaTipusDocumental">
            <c:forEach items="${__theForm.listOfValuesForFirmaTipusDocumental}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FITXERORIGINALID)}">
        <tr id="evidencia_fitxerOriginalID_rowid">
          <td id="evidencia_fitxerOriginalID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FITXERORIGINALID])?'evidencia.fitxerOriginalID':__theForm.labels[EvidenciaFields.FITXERORIGINALID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FITXERORIGINALID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FITXERORIGINALID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_fitxerOriginalID_columnvalueid">
              <form:errors path="evidencia.fitxerOriginalID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERORIGINALID)}" >
              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerOriginal)}"/>">${__theForm.evidencia.fitxerOriginal.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERORIGINALID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERORIGINALID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERORIGINALID)? ' uneditable-input' : ''}"   path="fitxerOriginalID" type="file" />
                  <label class="custom-file-label" for="fitxerOriginalID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.evidencia.fitxerOriginal}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerOriginal)}"/>">${__theForm.evidencia.fitxerOriginal.nom}</a>
</small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerOriginalID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerOriginalID').on('change', function(){
						var ruta = $('#fitxerOriginalID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerOriginalID-custom-file-label').css('display','block');
						$('#fitxerOriginalID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FITXERADAPTATID)}">
        <tr id="evidencia_fitxerAdaptatID_rowid">
          <td id="evidencia_fitxerAdaptatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FITXERADAPTATID])?'evidencia.fitxerAdaptatID':__theForm.labels[EvidenciaFields.FITXERADAPTATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FITXERADAPTATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FITXERADAPTATID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_fitxerAdaptatID_columnvalueid">
              <form:errors path="evidencia.fitxerAdaptatID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERADAPTATID)}" >
              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerAdaptat)}"/>">${__theForm.evidencia.fitxerAdaptat.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERADAPTATID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERADAPTATID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERADAPTATID)? ' uneditable-input' : ''}"   path="fitxerAdaptatID" type="file" />
                  <label class="custom-file-label" for="fitxerAdaptatID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.evidencia.fitxerAdaptat}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerAdaptat)}"/>">${__theForm.evidencia.fitxerAdaptat.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxerAdaptatIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerAdaptatID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerAdaptatID').on('change', function(){
						var ruta = $('#fitxerAdaptatID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerAdaptatID-custom-file-label').css('display','block');
						$('#fitxerAdaptatID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EvidenciaFields.FITXERSIGNATID)}">
        <tr id="evidencia_fitxerSignatID_rowid">
          <td id="evidencia_fitxerSignatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EvidenciaFields.FITXERSIGNATID])?'evidencia.fitxerSignatID':__theForm.labels[EvidenciaFields.FITXERSIGNATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EvidenciaFields.FITXERSIGNATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EvidenciaFields.FITXERSIGNATID]}" ></i>
              </c:if>
            </td>
          <td id="evidencia_fitxerSignatID_columnvalueid">
              <form:errors path="evidencia.fitxerSignatID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERSIGNATID)}" >
              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerSignat)}"/>">${__theForm.evidencia.fitxerSignat.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERSIGNATID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERSIGNATID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EvidenciaFields.FITXERSIGNATID)? ' uneditable-input' : ''}"   path="fitxerSignatID" type="file" />
                  <label class="custom-file-label" for="fitxerSignatID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.evidencia.fitxerSignat}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${evi:fileUrl(__theForm.evidencia.fitxerSignat)}"/>">${__theForm.evidencia.fitxerSignat.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxerSignatIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerSignatID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerSignatID').on('change', function(){
						var ruta = $('#fitxerSignatID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerSignatID-custom-file-label').css('display','block');
						$('#fitxerSignatID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
