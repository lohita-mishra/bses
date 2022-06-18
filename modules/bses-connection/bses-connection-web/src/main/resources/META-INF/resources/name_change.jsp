<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="javax.portlet.PortletSession"%>
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
<portlet:resourceURL var="documentUploadURL" id="documentUpload">
</portlet:resourceURL>
<%--
<portlet:resourceURL id="/document/upload" var="documentUploadURL" />
<portlet:resourceURL id="/document/download" var="documentDownloadURL" />
--%>
<%
	long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
	if(connectionRequestId==0 && session.getAttribute(ConnectionRequest.class.getName()+"#id")!=null){
		connectionRequestId=(Long)session.getAttribute(ConnectionRequest.class.getName()+"#id");
	}
	
	System.out.println("name change - connectionRequestId 1 - " +connectionRequestId);
	if(connectionRequestId==0 && portletSession.getAttribute(ConnectionRequest.class.getName()+"#id")!=null){
		connectionRequestId=(Long)portletSession.getAttribute(ConnectionRequest.class.getName()+"#id");
	}	
	
	System.out.println("name change - connectionRequestId - " +connectionRequestId);
	String mobileNo=ParamUtil.getString(request, "mobileNo", "");
	String emailId=ParamUtil.getString(request, "emailId", "");
	
	ConnectionRequest requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
	
	request.setAttribute(ConnectionRequest.class.getName(), requestEntity);
	session.setAttribute(ConnectionRequest.class.getName()+"#id", requestEntity.getConnectionRequestId());
%>

<portlet:renderURL var="emailVerificationURL">
	<portlet:param name="mvcPath" value="/email_verification.jsp" />
	<portlet:param name="connectionRequestId" value="<%=String.valueOf(connectionRequestId) %>" />
</portlet:renderURL>

<portlet:renderURL var="connectionRequestSuccessURL">
	<portlet:param name="mvcPath" value="/connection_request_success.jsp" />
	<portlet:param name="connectionRequestId" value="<%=String.valueOf(connectionRequestId) %>" />
</portlet:renderURL>

<portlet:renderURL var="acknowledgementURL" >
	<portlet:param name="mvcPath" value="/acknowledgement.jsp" />
	<portlet:param name="connectionRequestId" value="<%=String.valueOf(requestEntity.getConnectionRequestId()) %>" />
</portlet:renderURL>

<div class="card card-primary bg-light mb-2">
	<div class="card-header">
		<liferay-util:include page="/request_header.jsp" servletContext="<%=application%>">
		</liferay-util:include>
	</div>
	<div class="card-body">
		<liferay-util:include page="/consumer.jsp" servletContext="<%=application%>">
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
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		documentOnload();
		initSelect2();
		showHideComponents();
	});
	
	function documentOnload(){
		handleSubmitBtnClick();
		idProofTypeOnChange();
	}
	
	function showHideComponents(){
		showHideConsumerTypeDiv();
	}
	
	function showHideConsumerTypeDiv() {
		
		$('#firmDiv').hide();
		var consumerType=$('#'+portletNamespace+'consumerType').val();
		if (consumerType == 'Firm') {
			$('#indvDiv').hide();
			$('#firmDiv').show();
			$('#registered-address-row').show();
		} else if (consumerType == 'Individual') {
			$('#indvDiv').show();
			$('#firmDiv').hide();
			$('#registered-address-row').hide();
		}
	}
	
		
	function idProofTypeOnChange() {
		$("#<portlet:namespace/>idProofType").change(function() {
			handleIdProofTypeChange();
		})
	}
	
	function handleIdProofTypeChange() {
		var docName=$("#<portlet:namespace/>idProofType option:selected" ).text();
		$("#<portlet:namespace/>idProof_documentName").val(docName);
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
			"url": "<%=documentUploadURL.toString()%>",
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
	
	function funcOnSaveFailure(obj){
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
			submitFormDetails(forms,0);
			//saveChecklistForm();
			//saveDocumentForm();
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
		formDataJson['<portlet:namespace/>hasDpccCertificate']=$("input[name=<portlet:namespace/>hasDpccCertificate]").val();
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
	
	function saveDocumentForm(){
		var formDataJson={};
		formDataJson['<portlet:namespace/>idProofType']=$("#<portlet:namespace/>idProofType").val();
		formDataJson['<portlet:namespace/>idProofNo']=$("#<portlet:namespace/>idProofNo").val();
		formDataJson['namespace']='<portlet:namespace/>';
		
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/update-connection-request', //call your service here
	            {
	            	connectionRequestId:<%=connectionRequestId%>,
	                params: formDataJson,
	                sectionPrefix:'document'
	            },
	            function(obj) {
	                console.log(obj);
	            }
	        );
	    });	
	}
	function handleSubmitSuccess(){
			window.location.href="<%=acknowledgementURL.toString() %>";
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
	
	function deleteConnectionDocument(connectionDocumentId){
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectiondocument/remove-connection-document', //call your service here
	            {
	            	connectionDocumentId:connectionDocumentId
	            },
	            function(obj) {
	                try{
	                    onSuccess(obj);
	                }catch(e){}
	            }
	        );
	    });	
	}

</script>
