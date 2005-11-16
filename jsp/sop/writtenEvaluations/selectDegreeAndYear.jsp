<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="link.exams.searchWrittenEvaluationsByDegreeAndYear"/></h2>

<html:form action="/searchWrittenEvaluationsByDegreeAndYear" focus="executionDegreeID">

	<html:hidden property="method" value="choose"/>
	<html:hidden property="page" value="1"/>

	<span class="error"><html:errors/></span>

	<table>
		<tr>
			<td>
			   	<bean:message key="lable.degree"/>:
			</td>
		</tr>
		<tr>
			<td>
				<html:select property="executionDegreeID" size="1">
					<html:option key="label.all" value=""/>
			    	<html:options collection="executionDegreeLabelValueBeans" property="value" labelProperty="label"/>
			    </html:select>
			</td>
		</tr>
	</table>
	<br/>

	<bean:message key="property.context.curricular.year"/>::<br/>
	<table>
		<tr><td><html:multibox property="selectedCurricularYears">1</html:multibox></td><td>1</td></tr>
		<tr><td><html:multibox property="selectedCurricularYears">2</html:multibox></td><td>2</td></tr>
		<tr><td><html:multibox property="selectedCurricularYears">3</html:multibox></td><td>3</td></tr>
		<tr><td><html:multibox property="selectedCurricularYears">4</html:multibox></td><td>4</td></tr>
		<tr><td><html:multibox property="selectedCurricularYears">5</html:multibox></td><td>5</td></tr>
		<tr><td colspan="2"><html:checkbox property="selectAllCurricularYears"><bean:message key="checkbox.show.all.curricular.years"/></html:checkbox></tr>
	</table>
	<br/>

	<html:submit styleClass="inputbutton">
		<bean:message key="lable.choose"/>
	</html:submit>

</html:form>
