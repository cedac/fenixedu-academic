<%@ taglib uri="/WEB-INF/jsf_core.tld" prefix="f"%>
<%@ taglib uri="/WEB-INF/jsf_tiles.tld" prefix="ft"%>
<%@ taglib uri="/WEB-INF/jsf_fenix_components.tld" prefix="fc"%>
<%@ taglib uri="/WEB-INF/html_basic.tld" prefix="h"%>
<style>
<!--
.alignRight {
	text-align: right;
}
-->
</style>
<ft:tilesView definition="bolonhaManager.masterPage" attributeName="body-inline">
	<f:loadBundle basename="ServidorApresentacao/BolonhaManagerResources" var="bolonhaBundle"/>
	
	<h:outputText value="#{CourseGroupManagement.degreeCurricularPlan.name}" style="font-style: italic"/>
	<h:outputFormat value="<h2>#{bolonhaBundle['create.param']} </h2>" escape="false">
		<f:param value="#{bolonhaBundle['courseGroup']}"/>
	</h:outputFormat>
	<h:outputText styleClass="error" rendered="#{!empty CourseGroupManagement.errorMessage}"
			value="#{bolonhaBundle[CourseGroupManagement.errorMessage]}<br/>" escape="false"/>

	<h:form>
		<h:outputText escape="false" value="<input id='degreeCurricularPlanID' name='degreeCurricularPlanID' type='hidden' value='#{CourseGroupManagement.degreeCurricularPlanID}'"/>
		<h:outputText escape="false" value="<input id='parentCourseGroupID' name='parentCourseGroupID' type='hidden' value='#{CourseGroupManagement.parentCourseGroupID}'"/>
		
		<h:panelGrid columnClasses="alignRight infocell, infocell," columns="2" border="0">
			<h:outputText value="#{bolonhaBundle['name']}: "/>
			<h:panelGroup>
				<h:inputText id="name" required="true" size="60" maxlength="100" value="#{CourseGroupManagement.name}"/>
				<h:message for="name"/>
			</h:panelGroup>
		</h:panelGrid>
		<br/>
		<hr>
		<h:commandButton styleClass="inputbutton" value="#{bolonhaBundle['create']}"
			action="#{CourseGroupManagement.createCourseGroup}"/>
		<h:commandButton immediate="true" styleClass="inputbutton" value="#{bolonhaBundle['cancel']}"
			action="editCurricularPlanStructure"/>		
	</h:form>
</ft:tilesView>