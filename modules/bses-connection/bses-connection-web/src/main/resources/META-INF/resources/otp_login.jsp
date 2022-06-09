<%@ include file="/init.jsp"%>

<portlet:renderURL var="applyOnlineURL">
	<portlet:param name="mvcPath" value="/apply_online.jsp" />
</portlet:renderURL>

<style>
.modal {
	display: none;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-5">
			<div class="card m-3 p-5">
				<div class="card-body bg-dagner">
					<aui:form role="form" class="" name="generateOtpForm">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-4">
										<aui:input type="text" class="form-control" name="mobileNo" label="otp-login-mobile-no" >
											<aui:validator name="required" errorMessage="Please enter 10 digit's valid mobile number!"/>
											<aui:validator name="digits" errorMessage="Please enter 10 digit's valid mobile number!"/>
											<aui:validator name="minLength" errorMessage="Please enter 10 digit's valid mobile number!">10</aui:validator>
											<aui:validator name="maxLength" errorMessage="Please enter 10 digit's valid mobile number!">10</aui:validator>
										</aui:input>
										<aui:input type="email" class="form-control" name="emailId" label="otp-login-email-id" />
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
											<liferay-ui:message key="otp-login-otp-sent" />
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
				</div>
			</div>
		</div>
		<div class="col-md-7">
			Write your content here.
		</div>
	</div>
</div>
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
					<span style="text-decoration: underline;">Important Note:</span><br> Request for Appointment is not applicable for connections <br>with
					load > 45 KW.
				</div>
				<div class="text-danger text-center my-5">
					<a href="appointment_request.html" class="btn btn-primary mx-2">Request for Appointment</a> <a href="<%=applyOnlineURL.toString() %>"
						class="btn btn-danger" id="<portlet:namespace/>applyOnlineLink">Apply Online</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- START CONNECTION TYPE END -->

<aui:script use="aui-base liferay-form">
$(document).ready(function(){
	$("#<portlet:namespace/>mobileNo").focus();
	$("#<portlet:namespace/>validateOtpForm").hide();
	$("#wrontotp").hide();
	$("#expireotp").hide();

	$("#<portlet:namespace/>applyOnlineLink").click(function(){
		$('#connectionTypeModal').modal('hide'); 
		window.location.href="<%=applyOnlineURL.toString()%>&<portlet:namespace/>mobileNo="+$("#<portlet:namespace/>mobileNo").val()+"&<portlet:namespace/>emailId="+$("#<portlet:namespace/>emailId").val();
	})
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
alert("test1");
	let mobNo = $('#<portlet:namespace />mobileNo').val();
	var emailId = $('#<portlet:namespace />emailId').val();
	console.log(mobNo+"--------------"+emailId);
	if(!mobNo==""){
	Liferay.Service(
  '/bsesconn.otp/generate-otp',
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

	 let mobileNo = $('#<portlet:namespace />mobileNo').val();
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
   		$('#connectionTypeModal').modal('show'); 
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
  '/bsesconn.otp/resend-otp',
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.runCounter.js"></script>