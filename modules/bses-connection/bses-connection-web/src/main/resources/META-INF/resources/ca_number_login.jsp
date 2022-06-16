<%@ include file="/init.jsp"%>

<portlet:actionURL name="caNumberLogin" var="caNumberLoginURL" />

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
					<aui:form role="form" action="<%=caNumberLoginURL.toString()%>" class="" name="generateOtpForm">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-4">
										<aui:input type="text" class="form-control" name="caNumber" label="CA Number" >
											<aui:validator name="required" errorMessage="Please enter 12 digit's valid mobile number!"/>
											<aui:validator name="digits" errorMessage="Please enter 12 digit's valid mobile number!"/>
											<aui:validator name="minLength" errorMessage="Please enter 12 digit's valid mobile number!">12</aui:validator>
											<aui:validator name="maxLength" errorMessage="Please enter 12 digit's valid mobile number!">12</aui:validator>
										</aui:input>
										<aui:input  type="hidden" name="mobileNo" ></aui:input>
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

<aui:script use="aui-base liferay-form">
var mobileNo="";
$(document).ready(function(){
	$("#<portlet:namespace/>caNumber").focus();
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
		 generateOtpforCaNumber();
	});
	
$('#<portlet:namespace />validateOtp').click(function() {
		validateOtp();
	});
	
$('#<portlet:namespace />resendOtp').click(function() {
		reGenerateOtp();
	});
function generateOtpforCaNumber(){
	let caNumber = $('#<portlet:namespace />caNumber').val();
	console.log(caNumber+"--------------");
	if(!caNumber==""){
	Liferay.Service(
  '/bsesconn.otp/generate-otp-for-ca-number',
  {
    caNumber: caNumber
  },
  function(obj) {
    console.log(obj);
    if(obj != null){
    	mobileNo = obj;
    	$("#<portlet:namespace/>mobileNo").val(mobileNo);
    	$("#<portlet:namespace/>generateOtpForm").hide();
		
		$("#<portlet:namespace/>validateOtpForm").show();
    
    }
  });
 }
}
	

function validateOtp(){
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
   		console.log(obj);
   		var detailsForm = $("#<portlet:namespace/>generateOtpForm");
   		detailsForm.submit();
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
	Liferay.Service(
  '/bsesconn.otp/resend-otp',
  {
    mobileNo: mobileNo,
    email: ''
  },
  function(obj) {
    console.log(obj);
  }
);

}
	
</aui:script>
