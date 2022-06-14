<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>

<%
long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
ConnectionRequest requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);

%>


<portlet:actionURL name="verifyEmail" var="emailVarificationURL" />

<style>
.modal {
	display: none;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			
		</div>
		<div class="col-md-6">
			<div class="card m-3 p-5">
				<div class="card-body bg-dagner">
					<aui:form role="form" action="<%=emailVarificationURL.toString()%>" class="" name="generateOtpForm">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-4">
									<h6>Please verify your email </h6>
										<aui:input type="email" class="form-control" name="emailId" label="otp-login-email-id" value = "<%=requestEntity.getEServiceMailId() %>" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="btn-group btn-group-sm mt-2 float-right">
										<aui:button type="button" cssClass="btn-primary" id="generateOtp" value="Submit"></aui:button>
									</div>
								</div>
							</div>
						</div>
					</aui:form>
					
					<aui:form role="form" style="display:none;" name="validateOtpForm">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-4">
										<p class="help-text text-danger fs-13 my-3">
											<liferay-ui:message key="otp-email-otp-sent" />
										</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-1">
										<aui:input type="text" class="form-control" name="otp" label="otp-login-otp" >
											<aui:validator name="required" errorMessage="Please enter 7 digit's valid OTP!"/>
											<aui:validator name="digits" errorMessage="Please enter 7 digit's valid OTP!" />
											<aui:validator name="minLength" errorMessage="Please enter 7 digit's valid OTP!" >7</aui:validator>
											<aui:validator name="maxLength" errorMessage="Please enter 7 digit's valid OTP!" >7</aui:validator>
										</aui:input>
										<p id="wrontotp"
												class="far fa-paper-plane fa-fw text-danger">
												<span>Invalid OTP.</span>
											</p>
											<p id="expireotp"
												class="far fa-paper-plane fa-fw text-danger">
												<span>OTP Expired.</span>
											</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="btn-group btn-group-sm mt-2 float-right">
										<aui:button type="button" cssClass="btn-primary mr-3" id="resendOtp" value="Resend OTP"></aui:button>
										<!-- a href="typeConnection.html" class="btn btn-danger">Submit</a> -->
										<aui:button cssClass="btn-danger" id="validateOtp" value=" Submit " />
									</div>
								</div>
							</div>
						</div>
					</aui:form>
					
					<div style="display:none;" class="email-success">
						<div class="container-fluid">
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-1">
											<p class="far fa-paper-plane fa-fw fs-14 text-primary">
												<liferay-ui:message key="email-services-verified" />
											</p>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			
		</div>
	</div>
</div>

<aui:script use="aui-base liferay-form">
$(document).ready(function(){
	$("#<portlet:namespace/>emailId").focus();
	$("#<portlet:namespace/>validateOtpForm").hide();
	$("#wrontotp").hide();
	$("#expireotp").hide();
});
function validateForm(formId){
	
    var liferayForm = Liferay.Form.get(formId);

    if (liferayForm) {
        var validator = liferayForm.formValidator;
        
		//alert("A.instanceOf(validator, A.FormValidator): "+(A.instanceOf(validator, A.FormValidator)));
		//if (A.instanceOf(validator, A.FormValidator)) {
            validator.validate();

            var hasErrors = validator.hasErrors();

            if (hasErrors) {
                validator.focusInvalidField();

                return false;
            }
        //}
	}
    return true;
}

$('#<portlet:namespace />generateOtp').click(function() {
		generateOtp();
	});
	
$('#<portlet:namespace />validateOtp').click(function() {
		validateOtp();
	});
	
$('#<portlet:namespace />resendOtp').click(function() {
		reGenerateOtp();
	});
function generateOtp(){
	let mobNo = <%=requestEntity.getMobileNo() %>;
	var emailId = $('#<portlet:namespace />emailId').val();
	console.log(mobNo+"--------------"+emailId);
	if(!mobNo==""){
	Liferay.Service(
  '/bsesconn.otp/generate-email-otp',
  {
    mobileNo: mobNo,
    email: emailId
  },
  function(obj) {
    
    if(obj != null){
    	console.log("obj----"+obj)
    	$("#<portlet:namespace/>generateOtpForm").hide();
		
		$("#<portlet:namespace/>validateOtpForm").show();
    	
$('#counter').runCounter({
    start: 30,
    end: 0,
    duration: 30000
});
    	}
  });
 }
}
	

function validateOtp(){

	 let mobileNo = <%=requestEntity.getMobileNo() %>;
	var otpNumber = $('#<portlet:namespace />otp').val();
	console.log(mobileNo+"--------------"+otpNumber);
	Liferay.Service(
  '/bsesconn.otp/validate-otp',
  {
    mobileNo: mobileNo,
    otpNumber: otpNumber
  },
  function(obj) {
    console.log(obj);
    if(obj=="valid"){
   		$("#<portlet:namespace/>generateOtpForm").hide();
		
		$("#<portlet:namespace/>validateOtpForm").hide();
   		$(".email-success").show();
   		//var detailsForm = $("#<portlet:namespace/>generateOtpForm");
   		//detailsForm.submit();
   }
   else if(obj=="invalid"){
    	$("#wrontotp").show();
    }
    else{
    		$("#expireotp").show();
    }
  }
);
}

function reGenerateOtp(){

	let mobNo = $('#<portlet:namespace />mobileNo').val();
	var emailId = $('#<portlet:namespace />emailId').val();
	console.log(mobNo+"--------------"+emailId);
	if(!mobNo==""){
	Liferay.Service(
  '/bsesconn.otp/resend-email-otp',
  {
    mobileNo: mobNo,
    email: emailId
  },
  function(obj) {
    console.log(obj);
  }
);
 }
}
	
</aui:script>

