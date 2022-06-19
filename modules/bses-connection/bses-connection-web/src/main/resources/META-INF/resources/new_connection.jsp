<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%!
	private static final Log LOGGER=LogFactoryUtil.getLog("new_connection.jsp");
%>
<style>
	.lexicon-icon-asterisk {
		color:red;
		width:5px !important;
		height:5px !important;
	    display: inline-block !important;
	    vertical-align: top !important;
	}
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
  		/*display: none;*/
  	}
<%--	
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
}--%>

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
	<portlet:param name="cmd" value="upload"/>
</portlet:resourceURL>

<portlet:resourceURL var="documentDownloadURL" id="documentDownload">
	<portlet:param name="cmd" value="download"/>
</portlet:resourceURL>

<portlet:renderURL var="documentViewerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/document_viewer.jsp" />
</portlet:renderURL>
<%-- 
<portlet:resourceURL id="documentUpload" var="documentUploadURL" />
<portlet:resourceURL id="/document/download" var="documentDownloadURL" />
 --%>
<%
	long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
	
	LOGGER.info("connectionRequestId : "+connectionRequestId+", session.getAttribute(ConnectionRequest.class.getName()#id) :"+session.getAttribute(ConnectionRequest.class.getName()+"#id"));
	
	if(connectionRequestId==0 && session.getAttribute(ConnectionRequest.class.getName()+"#id")!=null){
		connectionRequestId=(Long)session.getAttribute(ConnectionRequest.class.getName()+"#id");
	}
	
	String mobileNo=ParamUtil.getString(request, "mobileNo", "");
	String emailId=ParamUtil.getString(request, "emailId", "");
	
	ConnectionRequest requestEntity=null;
	
	if(connectionRequestId==0){
		requestEntity=ConnectionRequestLocalServiceUtil.createConnectionRequest(mobileNo, emailId, RequestTypeModeStatus.TYPE_NEW_CONNECTION, RequestTypeModeStatus.MODE_ONLINE);
		connectionRequestId=requestEntity.getConnectionRequestId();
	}else{
		requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
	}
	
	request.setAttribute(ConnectionRequest.class.getName(), requestEntity);
	session.setAttribute(ConnectionRequest.class.getName()+"#id", requestEntity.getConnectionRequestId());
	
	String autoSaveFlag = PropsUtil.get("connection.request.auto.save");
	long autoSaveFrequency=60;
	try{
		autoSaveFrequency=Integer.parseInt(PropsUtil.get("connection.request.auto.save.interval").trim());
	}catch(Exception e){}
	
	long maxDocumentSize=5350400;
	try{
		maxDocumentSize=Long.parseLong(PropsUtil.get("connection.request.document.max.size").trim());
	}catch(Exception e){}
	
	if(autoSaveFlag!=null){
		try{
			autoSaveFlag=String.valueOf(Boolean.parseBoolean(autoSaveFlag));
		}catch(Exception e){}
	}else{
		autoSaveFlag="true";
	}
	autoSaveFlag="false";
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
<%--
<div class="modal" id="document-viewer-modal" style="width:1024px !important; height:800px !important; display: none;">
	<div class="modal-dialog modal-dialog-centered" style="width:100% !important;max-width: 100% !important;
    margin: none !important;">
		<div class="modal-content">
			<div class="modal-header" style="border-bottom: none;">
				<h6 class="modal-title">Document Viewer</h6>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<iframe id="document-viewer-iframe" src="" width="1000" height="786"></iframe>
				
			</div>
		</div>
	</div>
</div>
 --%>
<script>
	//To add aui support

	var portletNamespace="<portlet:namespace/>";
	var autoSaveFlag = <%=autoSaveFlag%>;
	var autoSaveFrequency= <%=autoSaveFrequency%>;
	var maxDocumentSize = <%=maxDocumentSize%>;
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		documentOnload();
		initSelect2();
		showHideComponents();
	});
	
	function showHideComponents(){
		showHideConsumerTypeDiv();
		showDistrict();
		showHideUpicNoDiv();
		showHideElcbUpload();
		showHideBuilding15_17();
		showHideFccUpload();
		showHideLiftUpload();
		showHideWiringUpload();
		showHideEmailServiceDiv();
		handleTariffCategoryChange();
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
	
	function handleConsumerTypeChange() {
		$('#'+portletNamespace+'consumerType').change(function() {
			showHideConsumerTypeDiv();
		});
	}
	
	function handleLocalityChange() {
		
		$('#'+portletNamespace+'locality').change(function() {
			showDistrict();
		});
	}
	
	function showDistrict(){
		$('#'+portletNamespace+'districtName').val('');
		
		var localityDivisionId=$('#'+portletNamespace+'locality').val();
		
		if(localityDivisionId==''){
			return;
		}
		
		Liferay.Service(
			'/bsesconn.localitydivision/get-locality-division',
			{
			 localityDivisionId: localityDivisionId
			},
			function(obj) {
			  console.log(obj);
			  $('#'+portletNamespace+'district').val(obj.divisionCode);
			  $('#'+portletNamespace+'districtName').val(obj.divisionName);
			}
		)
	}
	
	function upicAvailableOnChange() {
		$("input[name=<portlet:namespace/>upic]").change(function() {
			showHideUpicNoDiv();
		});
	}
	
	function showHideUpicNoDiv() {
		var upic = $("input[name=<portlet:namespace/>upic]:checked").val();
		
		if (upic == "1") {
			showUpicNoDiv(true);
		} else {
			showUpicNoDiv(false);
		}
	}
		
	function elcbOnChange() {
		$("input[name=<portlet:namespace/>elcbInstalled]").change(function() {
			var elcb = $(this).val();
			var documentId = $("#<portlet:namespace />elcbDocument_connectionDocumentId").val();
			if(documentId!='' && documentId!='0'){
				confirmDocument(elcb, documentId,"elcbInstalled", "ELCB certificate");
			}else{
				showHideElcbUpload();
			}
		});
	}

	function showHideElcbUpload() {

		var elcb = $("input[name=<portlet:namespace/>elcbInstalled]:checked").val();
		if (elcb == "1") {
			showElcbUpload(true);
			$("#elcbblink").show();
		} else {
			showElcbUpload(false);
			$("#elcbblink").hide();
			var kw = $("#<portlet:namespace/>loadKw").val();
			if (kw != "" && kw != "0" && kw >= 2) {
				showElcbUploadErrorDiv(true);
			}else{
				showElcbUploadErrorDiv(false);
			}
		}
	}
	function stiltParkingOnChange() {
		$("input[name=<portlet:namespace/>stiltParking]").change(function() {
			showHideBuilding15_17();
		});
	}

	function showHideBuilding15_17(){
		var stiltParking = $("input[name=<portlet:namespace/>stiltParking]:checked").val();
		if (stiltParking == "1") {
			showBuilding15(false);
			showBuilding17(true);
			showFcc(false);
		} else {
			showBuilding15(true);
			showBuilding17(false);
			showFcc(false);
		}
	}
	function building15OnChange() {
		$("input[name=<portlet:namespace/>height15Mtr]").change(function() {
			showHideFcc15();
		});
	}

	function showHideFcc15(){
		var stiltParking = $("input[name=<portlet:namespace/>stiltParking]:checked").val();
		if(stiltParking=='0'){
			var height15 = $("input[name=<portlet:namespace/>height15Mtr]:checked").val();
			if (height15 == "0") {
				showFcc(true);
			} else {
				showFcc(false);
			}
		}
	}
	
	function building17OnChange() {
		$("input[name=<portlet:namespace/>height17Mtr]").change(function() {
			showHideFcc17();
		});
	}
	
	function showHideFcc17(){
		var stiltParking = $("input[name=<portlet:namespace/>stiltParking]:checked").val();
		if(stiltParking=='1'){
			var height17 = $("input[name=<portlet:namespace/>height17Mtr]:checked").val();
			if (height17 == "0") {
				showFcc(true);
			} else {
				showFcc(false);
			}
		}
	}
	
	function fccOnChange() {
		$("input[name=<portlet:namespace/>fcc]").change(function() {
			var fcc = $(this).val();
			var documentId = $("#<portlet:namespace />fccCertificate_connectionDocumentId").val();
			if(documentId!='' && documentId!='0'){	
				confirmDocument(fcc, documentId,"fcc", "FCC certificate");
			}else{
				showHideFccUpload();
			}
		});
	}

	function showHideFccUpload(){

		var fcc = $("input[name=<portlet:namespace/>fcc]:checked").val();
		if (fcc == "1") {
			showFccUpload(true);
			$("#fccblink").show();
		} else {
			showFccUpload(false);
			$("#fccblink").hide();
		}
	}
	
	function liftOnChange() {
		$("input[name=<portlet:namespace/>lift]").change(function() {
			
			var lift = $(this).val();
			var documentId = $("#<portlet:namespace />liftCertificate_connectionDocumentId").val();
			
			console.log("lift.lift == "+lift+",   lift.documentId == "+documentId);
			
			if(documentId!='' && documentId!='0'){
				confirmDocument(lift, documentId,"lift", "LIFT certificate");
			}else{
				showHideLiftUpload();
			}
		});
	}

	function showHideLiftUpload(){
		var lift = $("input[name=<portlet:namespace/>lift]:checked").val();

		if (lift == "1") {
			showLiftUpload(true);
			$("#liftblink").show();
		} else {
			showLiftUpload(false);
			$("#liftblink").hide();
		}
	}
	
	function wiringOnChange() {
		$("input[name=<portlet:namespace/>wiringTest]").change(function() {
			var wiring = $(this).val();
			var documentId = $("#<portlet:namespace />wiringCertificate_connectionDocumentId").val();
			if(documentId!='' && documentId!='0'){
				confirmDocument(wiring, documentId, "wiringTest", "Wiring certificate");
			}else{
				showHideWiringUpload();
			}
		});
	}

	function showHideWiringUpload(){
		var wiring = $("input[name=<portlet:namespace/>wiringTest]:checked").val();
		if (wiring == "1") {
			showWiringUpload(true);
			$("#wiringblink").show();
		} else {
			showWiringUpload(false);
			$("#wiringblink").hide();
		}
	}
	
	function bdoCertOnChange() {
		$("input[name=<portlet:namespace/>hasBdoCertificate]").change(function() {
			var bdo = $(this).val();
			var documentId = $("#<portlet:namespace />bdoCertificate_connectionDocumentId").val();
			if(bdo!=''){
				confirmDocument(bdo,documentId,"hasBdoCertificate", "BDO certificate");
			}else{
				showHideBDOCertUpload();
			}
		});
	}

	function showHideBDOCertUpload(){
		var bdocert = $("input[name=<portlet:namespace/>hasBdoCertificate]:checked").val();
		if (bdocert == "1") {
			showBDOCertUpload(true);
			$("#bdocertblink").show();
		} else {
			showBDOCertUpload(false);
			$("#bdocertblink").hide();
		}
	}
		
	function emailServiceOnChange() {
		$("input[name=<portlet:namespace/>eServiceOnMail]").change(function() {
			showHideEmailServiceDiv();
		});
	}

	function showHideEmailServiceDiv(){
		var emailservice = $("input[name=<portlet:namespace/>eServiceOnMail]:checked").val();
		if (emailservice == "1") {
			showEmailServiceDiv(true);
		} else {
			showEmailServiceDiv(false);
		}
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
			handleTariffCategoryChange();
		});
	}
	
	function handleTariffCategoryChange(){
		var tariffCategory = $("#<portlet:namespace/>tariffCategory").val();
		if (tariffCategory == "0100") {
			showLoadKvaDiv(false);
			$("#<portlet:namespace/>loadKw").prop("readonly", false);
			//$("#<portlet:namespace/>loadKw").val("");
			//$("#<portlet:namespace/>loadKva").val("");
		} else {
			showLoadKvaDiv(true);
			$("#<portlet:namespace/>loadKva").prop("readonly", false);
			$("#<portlet:namespace/>loadKw").prop("readonly", true);
			//$("#<portlet:namespace/>loadKw").val("");
			//$("#<portlet:namespace/>loadKva").val("");
		}
		if (tariffCategory == "0250") {
			showBDOCert(true);
		} else {
			showBDOCert(false);
		}
	}
	
	function kvaOnChange() {
		$("#<portlet:namespace/>loadKva").change(function() {
			handleKvaChange();
		});
	}
	
	function handleKvaChange() {
		var kva = $("#<portlet:namespace/>loadKva").val();
		if (kva != "" && kva != "0") {
			var kvakw = Math.round(kva * 0.98);
			console.log("kvakw : "+(kva * 0.98));
			$("#<portlet:namespace/>loadKw").val(kvakw);
		}
	}

	function kwOnChange() {
		$("#<portlet:namespace/>loadKw").change(function() {
			handleKwChange();
		});
	}

	function handleKwChange() {
		var kw = $("#<portlet:namespace/>loadKw").val();
		if (kw != "" && kw != "0" && kw >= 45) {
			$("#prePostPaid").val('1');
			$("#prePostPaid").prop("readonly", true);
		} else {
			$("#prePostPaid").prop("readonly", false);
		}
	}
		
	function ownershipProofTypeOnChange() {
		$("#<portlet:namespace/>ownershipProofType").change(function() {
			handleOwnershipProofTypeChange();
		})
	}
	
	function handleOwnershipProofTypeChange() {
		var docName=$("#<portlet:namespace/>ownershipProofType option:selected" ).text();
		$("#<portlet:namespace/>ownershipProof_documentName").val(docName);
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
		handleConsumerTypeChange();
		handleLocalityChange();
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
		/*showUpicNoDiv(false);
		showLoadKvaDiv(false);
		showBuilding17(false);
		showFcc(false);
		showLiftUpload(false);
		showWiringUpload(true);
		showBDOCert(false);
		showBDOCertUpload(false);
		showEmailServiceDiv(true);*/
		//blinkText();
		
		$("#liftblink").hide();
		$("#bdocertblink").hide();
		
		handleSubmitBtnClick();
		ownershipProofTypeOnChange();
		idProofTypeOnChange();
		autoSave();
	}
	
	Liferay.provide(window, 'uploadFile', function(connectionRequestId, connectionDocumentId, documentType, documentName, fileElement, acceptTypes, uploadProgressBar, callback) {
	//function uploadFile(connectionRequestId, connectionDocumentId, documentType, documentName, fileElement, acceptTypes, uploadProgressBar, callback){
		
		var fileSelected=readFileUrl(fileElement);
		
		if(!fileSelected){
			return false;
		}

	    var mimeType=fileSelected.type;
	    if(acceptTypes.indexOf(mimeType)<0){
	    	alert("The file type selected is not accepted for uploading.")
	    	return;
	    }
	    
	    if(maxDocumentSize>0 && maxDocumentSize<fileSelected.size){
	    	alert("The file size must be less than or equals to "+Math.round(maxDocumentSize/1024/1024)+" MB.");
	    	return;
	    }
	    var description="Uploaded file";
	    var changeLog=description;
	    
		if(uploadProgressBar){
			uploadProgressBar.startProgress();
		}
		
		addFileEntryWithFile(connectionRequestId, connectionDocumentId, documentType, documentName, fileSelected, acceptTypes, callback);
			//callback(fileElement, response);
		//});
		
		return fileSelected;
	});

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
	
	function addFileEntryWithFile(connectionRequestId, connectionDocumentId, documentType, documentName, file, acceptTypes, callback){
		var form = new FormData();
		form.append("file", file, file.name);
		//form.append("repositoryId", repositoryId);
		//form.append("folderId", folderId);
		//form.append("folder", folder);
		
		form.append("name", file.name);
		form.append("mimeType", file.type);
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
			alert("submitBtn clicked");
			submitRequest();
		});
	}
	
	function submitRequest(){
		alert("submitRequest called")
		//if(submitForms()){
			submitSoap();
			//handleSubmitSuccess();
		//}
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
			saveDocumentForm();
			return true;
		}else{
			alert("Please enter valid details...");
			return false;
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
		}
		//else{
		//	handleSubmitSuccess();
		//}
	}
	
	function saveChecklistForm(){
		var formDataJson={};
		formDataJson['<portlet:namespace/>wiringTest']=$("input[name=<portlet:namespace/>wiringTest]:checked").val();
		formDataJson['<portlet:namespace/>elcbInstalled']=$("input[name=<portlet:namespace/>elcbInstalled]:checked").val();
		formDataJson['<portlet:namespace/>stiltParking']=$("input[name=<portlet:namespace/>stiltParking]:checked").val();
		formDataJson['<portlet:namespace/>height15Mtr']=$("input[name=<portlet:namespace/>height15Mtr]:checked").val();
		formDataJson['<portlet:namespace/>height17Mtr']=$("input[name=<portlet:namespace/>height17Mtr]:checked").val();
		formDataJson['<portlet:namespace/>fcc']=$("input[name=<portlet:namespace/>fcc]:checked").val();
		formDataJson['<portlet:namespace/>lift']=$("input[name=<portlet:namespace/>lift]:checked").val();
		formDataJson['<portlet:namespace/>hasBdoCertificate']=$("input[name=<portlet:namespace/>hasBdoCertificate]:checked").val();
		formDataJson['<portlet:namespace/>hasDpccCertificate']=$("input[name=<portlet:namespace/>hasDpccCertificate]:checked").val();
		formDataJson['<portlet:namespace/>hasPollutionCertificate']=$("input[name=<portlet:namespace/>hasPollutionCertificate]:checked").val();
		formDataJson['<portlet:namespace/>eServiceOnMail']=$("input[name=<portlet:namespace/>eServiceOnMail]:checked").val();
		formDataJson['<portlet:namespace/>eServiceMailId']=$("#<portlet:namespace/>eServiceMailId").val();
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
		formDataJson['<portlet:namespace/>ownershipProofType']=$("#<portlet:namespace/>ownershipProofType").val();
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
		
		//submitSoap();
		if($("input[name=<portlet:namespace/>eServiceOnMail]") && $("input[name=<portlet:namespace/>eServiceMailId]").val() !=""){
			window.location = "<%=emailVerificationURL.toString()%>";
		}else{
			<%-- //window.location = "<%=connectionRequestSuccessURL.toString()%>"; --%>
			window.location.href="<%=acknowledgementURL.toString() %>";
		}
	}

	function submitSoap(){
		AUI().use('aui-base', function(A){
	        Liferay.Service(
	            '/bsesconn.connectionrequest/submit-connection-request-to-soap', //call your service here
	            {
	            	connectionRequestId:<%=connectionRequestId%>
	            },
	            function(obj) {
	            	alert("Submitted to soap...."+obj);
	            	console.log("in submitSoap ============ ");
	            	console.log(obj)
	                try{
	                	if(obj=="success"){
	                		
	                	}
	                    //onSuccess(obj);
	                }catch(e){
	                	console.log(e);
	                }
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
		}, autoSaveFrequency*1000);
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
		},1000);
		
		setTimeout(function (){
			saveDocumentForm();
		},1000);
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

	function deleteConnectionDocument(connectionDocumentId, onSuccess){
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
	

	//************ Auto Save End****************



<%--
	function downloadDocument(connectionDocumentId){
		var viewerUrl='<%=documentViewerURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId;
		
		$('#document-viewer-iframe').attr("src", viewerUrl);
		$('#document-viewer-modal').modal('show'); 
		
		Liferay.Util.openWindow(
				{
					dialog: {
						//cssClass: 'aui-popup-example',
						destroyOnHide: true,
						height: 400,
						width: 400
					},
					dialogIframe: {
						//bodyCssClass: 'custom-css-class'
					},
					title: 'My Own Title(400x400 Window Size)',
					uri: '<%=documentViewerURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId
				}
			);
		
			window.open('<%=documentDownloadURL%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId);
		
	}--%>
	function confirmDocument(checkListValue, documentId, checkInputName, documentType){
		
		if(checkListValue==0 && documentId>0)
		{
			alert("You have already uploaded a "+documentType+". Please remove the document before selecting \"No\".");
				//$('#checklist-option-no-alert-document-type-name').html(documentType);
				//$('#checklist-option-no-alert-modal').modal('show');
				$("#<portlet:namespace/>"+checkInputName).prop('checked',true);
				
		}
	}
	$("#checklist-option-no-alert-ok-btn").click(function() {
		$('#checklist-option-no-alert-modal').modal('hide').data('bs.modal', null );
	})
</script>

