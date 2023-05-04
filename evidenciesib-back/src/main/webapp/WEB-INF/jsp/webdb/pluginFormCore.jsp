<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PluginFields" className="es.caib.evidenciesib.model.fields.PluginFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.NOM)}">
        <tr id="plugin_nom_rowid">
          <td id="plugin_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.NOM])?'plugin.nom':__theForm.labels[PluginFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="plugin_nom_columnvalueid">
            <form:errors path="plugin.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="plugin.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.DESCRIPCIO)}">
        <tr id="plugin_descripcio_rowid">
          <td id="plugin_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.DESCRIPCIO])?'plugin.descripcio':__theForm.labels[PluginFields.DESCRIPCIO]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="plugin_descripcio_columnvalueid">
            <form:errors path="plugin.descripcio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.DESCRIPCIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginFields.DESCRIPCIO)? ' uneditable-input' : ''}"  style="" maxlength="255" path="plugin.descripcio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.CLASSE)}">
        <tr id="plugin_classe_rowid">
          <td id="plugin_classe_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.CLASSE])?'plugin.classe':__theForm.labels[PluginFields.CLASSE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.CLASSE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.CLASSE]}" ></i>
              </c:if>
            </td>
          <td id="plugin_classe_columnvalueid">
            <form:errors path="plugin.classe" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.CLASSE)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginFields.CLASSE)? ' uneditable-input' : ''}"  style="" maxlength="255" path="plugin.classe"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.TIPUS)}">
        <tr id="plugin_tipus_rowid">
          <td id="plugin_tipus_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.TIPUS])?'plugin.tipus':__theForm.labels[PluginFields.TIPUS]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.TIPUS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.TIPUS]}" ></i>
              </c:if>
            </td>
          <td id="plugin_tipus_columnvalueid">
          <form:errors path="plugin.tipus" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginFields.TIPUS)}" >
          <form:hidden path="plugin.tipus"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.plugin.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginFields.TIPUS)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="plugin_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="form-control col-md-9-optional" path="plugin.tipus">
            <c:forEach items="${__theForm.listOfValuesForTipus}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.PROPIETATS)}">
        <tr id="plugin_propietats_rowid">
          <td id="plugin_propietats_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.PROPIETATS])?'plugin.propietats':__theForm.labels[PluginFields.PROPIETATS]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.PROPIETATS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.PROPIETATS]}" ></i>
              </c:if>
            </td>
          <td id="plugin_propietats_columnvalueid">
              <form:errors path="plugin.propietats" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.PROPIETATS)? 'true' : 'false'}" path="plugin.propietats"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_propietats" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_propietats" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('plugin.propietats'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('plugin.propietats'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('plugin.propietats'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_propietats').on('click', function(){
					var valor = ($('#dropdownMenuContainer_propietats').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_propietats').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.ACTIU)}">
        <tr id="plugin_actiu_rowid">
          <td id="plugin_actiu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.ACTIU])?'plugin.actiu':__theForm.labels[PluginFields.ACTIU]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginFields.ACTIU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginFields.ACTIU]}" ></i>
              </c:if>
            </td>
          <td id="plugin_actiu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)}" >
              <form:errors path="plugin.actiu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)? 'false' : 'true'}" path="plugin.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.plugin.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
