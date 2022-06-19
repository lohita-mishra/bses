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
				<aui:input type="date" class="form-control" name="appointmentDate" label="appointment-schedule-appointment-date" value="<%=requestEntity.getAppointmentDate()%>" min='2022-06-20' max='2022-07-19'>
					<aui:validator name="required"/>
				</aui:input>
			</div>
<%--
			<div class="form-group col-md-4">
				<aui:input type="text" class="form-control" name="appointmentDistrictName" label="appointment-schedule-appointment-division" value="<%=appointmentDistrictName%>" readonly="true"/>
				<aui:input type="hidden" class="form-control" name="appointmentDistrict" label="" value="<%=requestEntity.getAppointmentDistrict()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>	
 --%>					
			<div class="form-group col-md-4">
				<aui:select class="form-control select2" name="appointmentTime" label="appointment-schedule-appointment-time" >
					<aui:option value="" label="-Select-" />
<%
				if(StringUtils.isNotBlank(requestEntity.getAppointmentTime())){
%>				
						<aui:option value="<%=requestEntity.getAppointmentTime()%>" label="<%=requestEntity.getAppointmentTime()%>" selected="true"/>
<%
				}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>
		</div>
	</div>
</aui:form>
<script>
$("#<portlet:namespace/>appointmentDate").attr('min', "2022-06-20");
$("#<portlet:namespace/>appointmentDate").attr('max', "2022-07-20");
	$("#<portlet:namespace/>appointmentDate").change(function(){
		$("#<portlet:namespace/>appointmentTime").empty();
		var apptDate=$(this).val();
		//getting the division from address.jsp district input
		var division=$("#<portlet:namespace/>district").val();
		var slots=[];
		slots[0]={value:"09:30:00", text:"09:30 AM - 10:15 AM"};
		slots[1]={value:"10:15:00", text:"10:15 AM - 11:00 AM"};
		slots[2]={value:"11:00:00", text:"11:00 AM - 11:45 AM"};
		slots[3]={value:"11:45:00", text:"11:45 AM - 12:30 PM"};
		populateAppointmentTimeSlots(slots);
		<%--
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/get-available-time-slots', //call your service here
	            {
	            	appointmentDate:apptDate,
	            	appointmentDivision:division,
	            },
	            function(obj) {
	                try{
	                	populateAppointmentTimeSlots($.parseJSON(obj));
	                }catch(e){}
	            }
	        );
	    });--%>	
	})
	function populateAppointmentTimeSlots(slots){
		var appointmentTime=$("#<portlet:namespace/>appointmentTime");
		$(appointmentTime).empty();
		$(appointmentTime).append($('<option>', {value : ''}).text('-Select-'));
		$.each(slots, function(i, e){
			$(appointmentTime).append($('<option>', {value : e['value']}).text(e['text']));
		});
	}
</script>