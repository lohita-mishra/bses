<%@ include file="/init.jsp"%>

<portlet:actionURL name="newConnectionApplyOnlineView" var="applyOnlineURL" />

<portlet:actionURL name="newConnectionApplyAppointmentView" var="applyAppointmentURL" />

<style>
.modal {
	display: none;
}
</style>

<!-- START CONNECTION TYPE START -->

<div class="modal" id="connectionTypeModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header" style="border-bottom: none;">
				<h6 class="modal-title">Apply for New Connection</h6>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body align-items-center justify-content-center shadow px-4 py-3 rounded" style="min-height: 200px;">
				<div class="help-text text-danger text-center fs-18 my-3">
					<!-- i class="far fa-paper-plane fa-fw text-danger"></i-->
					<span style="text-decoration: underline;">Important Note:</span><br> "Request for Appointment" is not applicable for connections <br>with
					load > 45 KW.
				</div>
				<div class="text-danger text-center my-5">
					<button class="btn btn-primary mx-2" id="<portlet:namespace/>appointmentBtn">Request for Appointment</a> 
					<button class="btn btn-danger" id="<portlet:namespace/>applyOnlineBtn">Apply Online</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- START CONNECTION TYPE END -->

<aui:script use="aui-base liferay-form">
$(document).ready(function(){
	$('#connectionTypeModal').modal('show'); 
	
	$('#<portlet:namespace/>appointmentBtn').click(function(){
		window.location.href="<%=applyAppointmentURL.toString()%>";
	})
	$('#<portlet:namespace/>applyOnlineBtn').click(function(){
		window.location.href="<%=applyOnlineURL.toString()%>";
	});
});
</aui:script>


