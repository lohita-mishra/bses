<%@page import="com.bses.connection2.service.LocalityDivisionLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.LocalityDivision"%>
<%@page import="java.util.Map"%>
<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
LocalityDivision appointmentDivision=LocalityDivisionLocalServiceUtil.getLocalityDivisionByDivisionCode(requestEntity.getAppointmentDistrict());
String appointmentDistrictName="";
if(appointmentDivision!=null){
	appointmentDistrictName=appointmentDivision.getDivisionName();
}
%>
<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formAction" value="saveAppointmentSchedule" />
</portlet:actionURL>

<aui:form cssClass="custom-form form-auto-save" role="form" id ="appointmentScheduleForm" name="appointmentScheduleForm" section-attr="appointment-schedule">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="font-weight-bold text-uppercase bg-light p-3"><liferay-ui:message key="appointment-schedule-section-title" /></h6>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-4">
				<aui:input type="date" class="form-control" name="appointmentDate" label="appointment-schedule-appointment-date" value="<%=requestEntity.getAppointmentDate()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>
			<div class="form-group col-md-4">
				<aui:input type="text" class="form-control" name="appointmentDistrictName" label="appointment-schedule-appointment-division" value="<%=appointmentDistrictName%>" readonly="true"/>
				<aui:input type="hidden" class="form-control" name="appointmentDistrict" label="" value="<%=requestEntity.getAppointmentDistrict()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>			
			<div class="form-group col-md-4">
				<aui:input type="time" class="form-control" name="appointmentTime" label="appointment-schedule-appointment-time" value="<%=requestEntity.getAppointmentTime()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>
		</div>
	</div>
</aui:form>