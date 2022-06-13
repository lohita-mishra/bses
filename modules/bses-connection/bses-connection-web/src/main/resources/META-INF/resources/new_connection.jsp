<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<style>
	input[type="radio"] {
    	opacity: 1 !important;
    	margin-top: 0 !important;	
	}
	
	input[type="checkbox"]{
    	opacity: 1 !important;
    	margin-top: 10 !important;	
	}
	
	.radio label::before{
		content:none !important;
	}
	
	label[for="<portlet:namespace/>selfDeclaration"] {
		font-size: 1em !important;
		font-weight: 700 !important;
	}
	
	input[type="checkbox"]+span {
   		background: none !important;
    	border: none !important;
    	margin-left: 0px !important;
    	margin-top: -10px !important;
    	color: #ca3e46 !important;
	}
	
	.text-warning {
   		color: #bf343c !important;
	}
	
	input[type='checkbox']:checked+span::after {
    	content:none !important;
	}
	.upload-btn{
		font-size: 1.5rem !important;
		font-weight: bold;
	}
	
.modal {
  display: none;
  position: fixed;
  z-index: 1; 
  padding-top: 100px; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
}

.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 60%;
}

.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}


</style>
<portlet:resourceURL var="fileUploadURL" id="fileUpload">
</portlet:resourceURL>
<%
	long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
	if(connectionRequestId==0 && session.getAttribute(ConnectionRequest.class.getName()+"#id")!=null){
		connectionRequestId=(Long)session.getAttribute(ConnectionRequest.class.getName()+"#id");
	}
	String mobileNo=ParamUtil.getString(request, "mobileNo", "");
	String emailId=ParamUtil.getString(request, "emailId", "");
	
	ConnectionRequest requestEntity=null;
	
	if(connectionRequestId==0){
		requestEntity=ConnectionRequestLocalServiceUtil.createConnectionRequest(mobileNo, emailId);
		connectionRequestId=requestEntity.getConnectionRequestId();
	}else{
		requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
	}
	
	request.setAttribute(ConnectionRequest.class.getName(), requestEntity);
	session.setAttribute(ConnectionRequest.class.getName()+"#id", requestEntity.getConnectionRequestId());
	
	String autoSaveFlag = PropsUtil.get("connection.request.auto.save");
	
	if(autoSaveFlag!=null){
		try{
			autoSaveFlag=String.valueOf(Boolean.parseBoolean(autoSaveFlag));
		}catch(Exception e){}
	}else{
		autoSaveFlag="true";
	}
	//autoSaveFlag="false";
%>
<div class="card card-primary bg-light mb-2">
	<div class="card-header">
		<liferay-util:include page="/request_header.jsp" servletContext="<%=application%>">
		</liferay-util:include>
	</div>
	<div class="card-body">
		<liferay-util:include page="/consumer.jsp" servletContext="<%=application%>">
		</liferay-util:include>
		<liferay-util:include page="/address.jsp" servletContext="<%=application%>">
		</liferay-util:include>
		
		<liferay-util:include page="/connection.jsp" servletContext="<%=application%>">
		</liferay-util:include>
		
		<liferay-util:include page="/checklist.jsp" servletContext="<%=application%>">
		</liferay-util:include>

		<liferay-util:include page="/documents.jsp" servletContext="<%=application%>">
		</liferay-util:include>
		<liferay-util:include page="/declaration.jsp" servletContext="<%=application%>">
		</liferay-util:include>		
	</div>
	<div class="card-footer">
		<liferay-util:include page="/actions.jsp" servletContext="<%=application%>">
		</liferay-util:include>
	</div>
</div>




<script>
	var portletNamespace="<portlet:namespace/>";
	var autoSaveFlag = <%=autoSaveFlag%>;
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		documentOnload();
		initSelect2();
	});
	
	function showHideConsumerTypeDiv() {
		
		$('#firmDiv').hide();
		$('#'+portletNamespace+'consumerType')
				.change(
						function() {
							//alert("showHideConsumerTypeDiv <portlet:namespace/>");
							if (this.options[this.selectedIndex].value == 'Firm') {
								$('#indvDiv').hide();
								$('#firmDiv').show();
							} else if (this.options[this.selectedIndex].value == 'Individual') {
								$('#indvDiv').show();
								$('#firmDiv').hide();
							} else {
								$('#indvDiv').show();
								$('#firmDiv').hide();
							}
						});
	}

	function upicAvailableOnChange() {
		$("input[name=<portlet:namespace/>upic]").change(function() {
			var upic = "";

			var upic = $(this).val();
			if (upic == "1") {
				showUpicNoDiv(true);
			} else {
				showUpicNoDiv(false);
			}
		});
	}
	function elcbOnChange() {
		$("input[name=<portlet:namespace/>elcbInstalled]").change(function() {
			var elcb = "";

			var elcb = $(this).val();
			if (elcb == "1") {
				showElcbUpload(true);
				$("#elcbblink").show();
			} else {
				showElcbUpload(false);
				$("#elcbblink").hide();
				var kw = $("#<portlet:namespace/>loadKw").val();
				if (kw != "" && kw != "0" && kw >= 2) {
					showElcbUploadErrorDiv(true);
				}
			}
		});
	}

	function stiltParkingOnChange() {
		$("input[name=<portlet:namespace/>stiltParking]").change(function() {
			var stiltParking = "";

			var stiltParking = $(this).val();
			if (stiltParking == "1") {
				showBuilding15(false);
				showBuilding17(true);
				showFcc(false);
			} else {
				showBuilding15(true);
				showBuilding17(false);
				showFcc(false);
			}
		});
	}

	function building15OnChange() {
		$("input[name=<portlet:namespace/>height15Mtr]").change(function() {
			var height15 = "";

			var height15 = $(this).val();
			if (height15 == "0") {
				showFcc(true);
			} else {
				showFcc(false);
			}
		});
	}

	function building17OnChange() {
		$("input[name=<portlet:namespace/>height17Mtr]").change(function() {
			var height17 = "";
			var height17 = $(this).val();
			if (height17 == "0") {
				showFcc(true);
			} else {
				showFcc(false);
			}
		});
	}

	function fccOnChange() {
		$("input[name=<portlet:namespace/>fcc]").change(function() {
			var fcc = "";
			var fcc = $(this).val();
			if (fcc == "1") {
				showFccUpload(true);
				$("#fccblink").show();
			} else {
				showFccUpload(false);
				$("#fccblink").hide();
			}
		});
	}

	function liftOnChange() {
		$("input[name=<portlet:namespace/>lift]").change(function() {
			var lift = "";
			var lift = $(this).val();
			if (lift == "1") {
				showLiftUpload(true);
				$("#liftblink").show();
			} else {
				showLiftUpload(false);
				$("#liftblink").hide();
			}
		});
	}

	function wiringOnChange() {
		$("input[name=<portlet:namespace/>wiringTest]").change(function() {
			var wiring = "";
			var wiring = $(this).val();
			if (wiring == "1") {
				showWiringUpload(true);
				$("#wiringblink").show();
			} else {
				showWiringUpload(false);
				$("#wiringblink").hide();
			}
		});
	}

	function bdoCertOnChange() {
		$("input[name=<portlet:namespace/>bdocert]").change(function() {
			var bdocert = "";
			var bdocert = $(this).val();
			if (bdocert == "1") {
				showBDOCertUpload(true);
				$("#bdocertblink").show();
			} else {
				showBDOCertUpload(false);
				$("#bdocertblink").hide();
			}
		});
	}

	function emailServiceOnChange() {
		$("input[name=<portlet:namespace/>eServiceOnMail]").change(function() {
			var emailservice = "";
			var emailservice = $(this).val();
			if (emailservice == "1") {
				showEmailServiceDiv(true);
			} else {
				showEmailServiceDiv(false);
			}
		});
	}

	function permTempOnChange() {
		$("input[name=<portlet:namespace/>permTemp]").change(function() {
			var permTemp = "";
			var permTemp = $(this).val();
			if (permTemp == "1") {
				$("#prePostPaid").prop("disabled", false);
				kwOnChange();
			} else {
				$("#prePostPaid").val('1');
				$("#prePostPaid").prop("disabled", true);
			}
		});
	}

	function tariffCategoryOnChange() {
		
		$("#<portlet:namespace/>tariffCategory").change(function() {
			var tariffCategory = "";
			var tariffCategory = $(this).val();
			if (tariffCategory == "0100") {
				showLoadKvaDiv(false);
				$("#<portlet:namespace/>loadKw").prop("disabled", false);
				$("#<portlet:namespace/>loadKw").val("");
				$("#<portlet:namespace/>loadKva").val("");
			} else {
				showLoadKvaDiv(true);
				$("#<portlet:namespace/>loadKva").prop("disabled", false);
				$("#<portlet:namespace/>loadKw").prop("disabled", true);
				$("#<portlet:namespace/>loadKw").val("");
				$("#<portlet:namespace/>loadKva").val("");
			}
			if (tariffCategory == "0250") {
				showBDOCert(true);
			} else {
				showBDOCert(false);
			}
		});
	}

	function kvaOnChange() {
		$("#<portlet:namespace/>loadKva").change(function() {
			var kva = $("#<portlet:namespace/>loadKva").val();
			if (kva != "" && kva != "0") {
				$("#<portlet:namespace/>loadKw").val(kva * 0.98);
			}
		});
	}

	function kwOnChange() {
		$("#<portlet:namespace/>loadKw").change(function() {
			var kw = $("#<portlet:namespace/>loadKw").val();
			if (kw != "" && kw != "0" && kw >= 45) {
				$("#prePostPaid").val('1');
				$("#prePostPaid").prop("disabled", true);
			} else {
				$("#prePostPaid").prop("disabled", false);
			}
		});
	}

	function showUpicNoDiv(showHide) {
		if (showHide) {
			$("#upicnodiv").show();
		} else {
			$("#upicnodiv").hide();
		}
	}
	function showElcbUpload(showHide) {
		if (showHide) {
			$("#elcbuploaddiv").show();
		} else {
			$("#elcbuploaddiv").hide();
		}
	}
	function showLoadKvaDiv(showHide) {
		if (showHide) {
			$("#loadkvadiv").show();
		} else {
			$("#loadkvadiv").hide();
		}
	}


	function showBuilding15(showHide) {
		if (showHide) {
			$("#building15div").show();
		} else {
			$("#building15div").hide();
		}
	}

	function showBuilding17(showHide) {
		if (showHide) {
			$("#building17div").show();
		} else {
			$("#building17div").hide();
		}
	}
	function showFcc(showHide) {
		if (showHide) {
			$("#fccdiv").show();
		} else {
			$("#fccdiv").hide();
		}
	}
	function showFccUpload(showHide) {
		if (showHide) {
			$("#fccuploaddiv").show();
		} else {
			$("#fccuploaddiv").hide();
		}
	}

	function showLiftUpload(showHide) {
		if (showHide) {
			$("#liftuploaddiv").show();
		} else {
			$("#liftuploaddiv").hide();
		}
	}

	function showWiringUpload(showHide) {
		if (showHide) {
			$("#wiringuploaddiv").show();
		} else {
			$("#wiringuploaddiv").hide();
		}
	}

	function showBDOCert(showHide) {
		if (showHide) {
			$("#bdocertdiv").show();
		} else {
			$("#bdocertdiv").hide();
		}
	}

	function showBDOCertUpload(showHide) {
		if (showHide) {
			$("#bdocertuploaddiv").show();
		} else {
			$("#bdocertuploaddiv").hide();
		}
	}

	function showEmailServiceDiv(showHide) {
		if (showHide) {
			$("#emailservicediv").show();
		} else {
			$("#emailservicediv").hide();
		}
	}

	function showElcbUploadErrorDiv(showHide) {
		$("#elcberror").modal();
		/*if (showHide) {
			$("#elcbuploaderrordiv").show();
		} else {
			$("#elcbuploaderrordiv").hide();
		}*/
	}

	function initSelect2() {
		//This is for enabling select2 plugin for select/dropdown controls
		$(".select2").each(function(index, item) {
			var placeholdertext = $(item).find('option:first').html();
			var selectedVal = $(item).val();
			var itemselect2 = $(item).select2({
				placeholder : placeholdertext,
				allowClear : true
			});

			if (selectedVal != '' && selectedVal != '0') {
				$(itemselect2).val(selectedVal).trigger('change');
			}
		});
	}

	function blinkText(){
		setInterval(function () {
			$(".blink").each(function( index ) {
				console.log($(this).css("opacity"));
	            $(this).css("opacity", 
	            ($(this).css("opacity") == 0 ? 1 : 0));
	       
			});
		}, 1000);
	}

	function documentOnload(){
		//initSelect2();

		showHideConsumerTypeDiv();
		upicAvailableOnChange();
		elcbOnChange();
		stiltParkingOnChange();

		building15OnChange();
		building17OnChange();

		fccOnChange();
		liftOnChange();
		wiringOnChange();

		tariffCategoryOnChange();
		bdoCertOnChange();
		emailServiceOnChange();

		kvaOnChange();
		kwOnChange();
		permTempOnChange();
		showUpicNoDiv(false);
		showLoadKvaDiv(false);
		showBuilding17(false);
		showFcc(false);
		showLiftUpload(false);
		showWiringUpload(true);
		showBDOCert(false);
		showBDOCertUpload(false);
		showEmailServiceDiv(true);
		//blinkText();
		
		$("#liftblink").hide();
		$("#bdocertblink").hide();
		
		handleSubmitBtnClick();
		autoSave();
	}
	
	function uploadFile(connectionRequestId, connectionDocumentId, documentType, documentName, fileElement, uploadProgressBar, callback){
		
		var fileSelected=readFileUrl(fileElement);
		
		if(!fileSelected){
			return false;
		}

	    var mimeType='';
	    var description="Uploaded file";
	    var changeLog=description;
	    
		if(uploadProgressBar){
			uploadProgressBar.startProgress();
		}
		
		addFileEntryWithFile(connectionRequestId, connectionDocumentId, documentType, documentName, fileSelected, callback);
			//callback(fileElement, response);
		//});
		
		return fileSelected;
	}

	function readFileUrl(fileElement) {
		
		if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
			return null;
		}

		var fileSelected = $(fileElement).prop('files')[0];

		if(fileSelected){	
			return fileSelected;
		}else{
			return null;
		}
	}
	
	function addFileEntryWithFile(connectionRequestId, connectionDocumentId, documentType, documentName, file, callback){
		var form = new FormData();
		form.append("file", file, file.name);
		//form.append("repositoryId", repositoryId);
		//form.append("folderId", folderId);
		//form.append("folder", folder);
		
		form.append("name", file.name);
		form.append("mimeType", file.type);
		form.append("title", file.name);
		form.append("connectionRequestId", connectionRequestId);
		form.append("connectionDocumentId", connectionDocumentId);
		form.append("documentType", documentType);
		form.append("documentName", documentName);
		form.append("description", documentName);
		form.append("changeLog", "Uploaded "+documentName+" on "+(new Date()));
		
		
		//form.append("p_auth", Liferay.authToken);
		
		console.log(form);
		
		var settings = {
			"url": "<%=fileUploadURL.toString()%>",
			"method": "POST",
			"timeout": 0,
			"headers": {},
			"processData": false,
			"mimeType": "multipart/form-data",
			"contentType": false,
			"data": form
		};
		
		$.ajax(settings).done(function (response) {
			console.log("addFileEntryWithFile");
			console.log(response);
			callback(JSON.parse(response));
		});
	}
	
	(function ($)
	{
	    $.fn.serializeFormJSON = function () {

	        var o = {};
	        var a = this.serializeArray();
	        $.each(a, function () {
	            if (o[this.name]) {
	                if (!o[this.name].push) {
	                    o[this.name] = [o[this.name]];
	                }
	                o[this.name].push(this.value || '');
	            } else {
	                o[this.name] = this.value || '';
	            }
	        });
	        return o;
	    };
	})(jQuery);
	
	
	function funcOnSaveSuccess(obj){
		console.log(obj);
	}
	
	function funcOnSaveFailure(){
		console.log(obj);
	}
	
	function validateForm(formId){
		var liferayForm = Liferay.Form.get(formId);
		//var liferayForm = Liferay.Form.get('#'+formId);
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
		
	function handleSubmitBtnClick(){
		$("#<portlet:namespace/>submitBtn").click(function() {
			console.log("submitBtn clicked");
			
			submitForms();
		});
	}
	
	function submitForms(validate){
		console.log("Calling saveForms");
		var forms = [];
		var  validForms = true;
		$(".form-auto-save").each(function( index, item ) {
			  if(!validateForm($(item).attr('id'))){
				  validForms = false;
			   }
			
			forms.push(item);
		});
		
		if(validForms){
			autoSaveFlag = false;
			submitFormDetails(forms,0);
			saveChecklistForm();
		}else{
			alert("Please enter valid details...");
		}
	}
	
	function submitFormDetails(forms, currentIndex){
		if(currentIndex <forms.length){
			var formItem =forms[currentIndex];
			var formId = $(formItem).attr('id');
			var sectionPrefixVal =  $(formItem).attr('section-attr');
			var formDataJson = $("#"+formId).serializeFormJSON();
			formDataJson['namespace']='<portlet:namespace/>';
			
			 AUI().use('aui-base', function(A){
			        Liferay.Service(
			            '/bsesconn.connectionrequest/update-connection-request', //call your service here
			            {
			            	connectionRequestId:<%=connectionRequestId%>,
			                params: formDataJson,
			                sectionPrefix:sectionPrefixVal
			            },
			            function(obj) {
			                try{
			                	submitFormDetails(forms,currentIndex+1);
			                }catch(e){}
			            }
			        );
			    });	
		}else{
			handleSubmitSuccess();
		}
	}
	
	function saveChecklistForm(){
		var formDataJson={};
		formDataJson['<portlet:namespace/>wiringTest']=$("input[name=<portlet:namespace/>wiringTest]").val();
		formDataJson['<portlet:namespace/>elcbInstalled']=$("input[name=<portlet:namespace/>elcbInstalled]").val();
		formDataJson['<portlet:namespace/>stiltParking']=$("input[name=<portlet:namespace/>stiltParking]").val();
		formDataJson['<portlet:namespace/>height15Mtr']=$("input[name=<portlet:namespace/>height15Mtr]").val();
		formDataJson['<portlet:namespace/>height17Mtr']=$("input[name=<portlet:namespace/>height17Mtr]").val();
		formDataJson['<portlet:namespace/>fcc']=$("input[name=<portlet:namespace/>fcc]").val();
		formDataJson['<portlet:namespace/>lift']=$("input[name=<portlet:namespace/>lift]").val();
		formDataJson['<portlet:namespace/>hasBdoCertificate']=$("input[name=<portlet:namespace/>hasBdoCertificate]").val();
		formDataJson['<portlet:namespace/>hasDpccLicense']=$("input[name=<portlet:namespace/>hasDpccLicense]").val();
		formDataJson['<portlet:namespace/>hasPollutionCertificate']=$("input[name=<portlet:namespace/>hasPollutionCertificate]").val();
		formDataJson['<portlet:namespace/>eServiceOnMail']=$("input[name=<portlet:namespace/>eServiceOnMail]").val();
		formDataJson['<portlet:namespace/>eServiceMailId']=$("input[name=<portlet:namespace/>eServiceMailId]").val();
		formDataJson['namespace']='<portlet:namespace/>';
		
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/update-connection-request', //call your service here
	            {
	            	connectionRequestId:<%=connectionRequestId%>,
	                params: formDataJson,
	                sectionPrefix:'checklist'
	            },
	            function(obj) {
	                console.log(obj);
	            }
	        );
	    });	
	}
	function handleSubmitSuccess(){
		alert("New connection request submitted");
		//submitSoap();
	}

	function submitSoap(){
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/submit-connection-request-to-soap', //call your service here
	            {
	            	connectionRequestId:<%=connectionRequestId%>
	            },
	            function(obj) {
	                try{
	                	if(obj=="success"){
	                		
	                	}
	                    //onSuccess(obj);
	                }catch(e){}
	            }
	        );
	    });	
	}
	
	//************ Auto Save ****************
	function autoSave(){
		setInterval(function () {
			if(autoSaveFlag){
				console.log("Auto save is called...");
				initAutoSaveForms(false);
			}
		}, 15000);
	}
	
	function initAutoSaveForms(validate){
		console.log("Calling saveForms");
		
		var timeout=0;
		$(".form-auto-save").each(function( index, item ) {
			//console.log("Before submitting : "+index);
			console.log("Submitting "+$(item).attr('id') +" after "+timeout+" milli-seconds.");
			setTimeout(function (){
				autoSaveForm($(item).attr('id'), $(item).attr('section-attr'), validate);
			}, timeout); 
			timeout+=2000;
		}, timeout);
		
		setTimeout(function (){
			saveChecklistForm();
		});
	}
	
	function autoSaveForm(formId, sectionPrefix, validate){
	    if(validate && !validateForm(formId)){
	        return;
	    }
	    var formDataJson = $("#"+formId).serializeFormJSON();
	    console.log(formId +" submitted ...........");
	    console.log(formDataJson);
	    formDataJson['namespace']='<portlet:namespace/>';
	    
	    submitFormDataJson(formDataJson, sectionPrefix, funcOnSaveSuccess, funcOnSaveFailure);
	}

	function submitFormDataJson(formDataJson, sectionPrefix, onSuccess, onFailure){
	    AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/update-connection-request', //call your service here
	            {
	            	connectionRequestId:<%=connectionRequestId%>,
	                params: formDataJson,
	                sectionPrefix:sectionPrefix
	            },
	            function(obj) {
	                try{
	                    onSuccess(obj);
	                }catch(e){}
	            }
	        );
	    });	
	}

	//************ Auto Save End****************

</script>
