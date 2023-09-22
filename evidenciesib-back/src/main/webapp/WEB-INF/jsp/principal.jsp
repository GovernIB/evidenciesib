<%@page import="org.springframework.security.core.Authentication"
%><%@page import="org.springframework.context.i18n.LocaleContextHolder"
%><%@page import="org.springframework.security.core.context.SecurityContext"
%><%@page import="org.springframework.security.core.context.SecurityContextHolder"
%><%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<div class="clear"></div>
<div class="spacer"></div>

<div>
<br/>
<center>
<img src="<c:url value="/img/app-logo.png"/>"  alt="EvidenciesIB" title="EvidenciesIB"/>

<br/>
<br/>
Evid�nciesIB �s una aplicaci� desenvolupada pel departament de Govern Digital de la Fundaci�Bit <br/>
per a la Comunitat Aut�noma de les Illes Balears. Es tracta d'una aplicaci� que extreu evid�ncies <br/>
del ciutad� amb la finalitat de poder realitzar una signatura (no criptogr�fica) d'un document. 
  

<br/>
<br/>
<table border="0" >
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="top">
<a href="http://blog.fundaciobit.org/category/admindigital/" target="_blank">
<img src="<c:url value="/img/fundaciobit.png"/>"  alt="Fundaci� Bit" title="Fundaci� Bit"/>
</a>
</td>
</tr>
</table>
<br/>
</center>
 
</div>

<c:if test="${evi:isDesenvolupament()}">
<br/>
Only in Development Mode
<br/>
<br/>

Username: ${loginInfo.username}<br/>
&#36;{evi:hasRole(ROLE_ADMIN)}= ${evi:hasRole('ROLE_ADMIN')}<br/>
&#36;{evi:hasRole(ROLE_USER) }= ${evi:hasRole('ROLE_USER') }<br/>
Locale = <%=LocaleContextHolder.getLocale() %> <br/>
lang = ${lang} <br/>
> UserInformation:<br/>
 <c:if test="${not empty loginInfo.userInfo}">
	name= ${loginInfo.userInfo.name} <br/> 
 	surname1= ${loginInfo.userInfo.surname1} <br/>
 	surname2= ${loginInfo.userInfo.surname2} <br/>
 	email= ${loginInfo.userInfo.email} <br/>
 	nif= ${loginInfo.userInfo.attributes["nif"]} <br/> 
  <br/>
</c:if>
<c:if test="${empty loginInfo.userInfo}">
	Error carregant Plugin UserInfo. Revisar logs per mes informacio.<br/>
</c:if>



</c:if>
