<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="com.bses.connection2.service.ConnectionDocumentLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionDocument"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GroupThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>

<%@ include file="/init.jsp"%>

<%!
	private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.document_upload_005felement_jsp");
%>
<%
long groupId = themeDisplay.getScopeGroupId();
long repositoryId = groupId;

long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

ServiceContext serviceContext = new ServiceContext();
serviceContext.setScopeGroupId(groupId);

String elementName=ParamUtil.getString(request, "elementName");
String fileTypes=ParamUtil.getString(request, "fileTypes");
String placeHolder=ParamUtil.getString(request, "placeHolder");
String savedValue=ParamUtil.getString(request, elementName);
String documentType=ParamUtil.getString(request, "documentType");
String documentName=ParamUtil.getString(request, "documentName");

String clientFileName="";
long connectionDocumentId=0;
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
long connectionRequestId=requestEntity.getConnectionRequestId();

try{
	ConnectionDocument connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestIdAndDocumentType(requestEntity.getConnectionRequestId(), documentType);
	connectionDocumentId=connectionDocument.getConnectionDocumentId();
	clientFileName="<span class=\"text-primary\">"+connectionDocument.getClientFileName()+"</span> uploaded successfully";
}catch(Exception e){
	LOGGER.error(e.getMessage());
}

String progressBarId = elementName.concat("_progressbar");

String hiddenStyle="";
String acceptTypes=(StringUtils.isNotBlank(fileTypes)?"accept=\""+fileTypes+"\"":"");
%>
<div class="input-group" id="<%=elementName%>_container" <%=hiddenStyle%>>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>" id="<portlet:namespace/><%=elementName%>" value="<%=savedValue%>"/>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>_connectionDocumentId" id="<portlet:namespace/><%=elementName%>_connectionDocumentId" value="<%=connectionDocumentId%>"/>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>_documentType" id="<portlet:namespace/><%=elementName%>_documentType" value="<%=documentType%>"/>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>_documentName" id="<portlet:namespace/><%=elementName%>_documentName" value="<%=documentName%>"/>
	
<%--	<input type="file" name="<portlet:namespace/><%=namePrefix+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>">--%>
	<input type="file" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName%>_file" style="width:0px;" <%=acceptTypes%>> 

	<%--<label id="<portlet:namespace /><%=elementName+"_document"%>"> --%>
		<button type="button" class="btn btn-primary upload-btn" id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" value="Choose File" >Upload File</button>
		<span id="<portlet:namespace /><%=elementName+"_fileName"%>"><%=clientFileName %></span>
		<a id="<portlet:namespace /><%=elementName+"_deleteBtn"%>" style="float: right; display:none;color:red;"><i class="fa fa-close"></i>Delete</a>
		
		<%--<a id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a> <%=StringUtils.isNotBlank(placeHolder)?placeHolder:"Choose a file to upload.."%>--%>
	<%--</label> --%>
	
</div>
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="10"/>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
<%--	A.one('#<portlet:namespace /><%=elementName%>_uploadBtn').on('click', function(event) {
	
		var el = document.getElementById("<portlet:namespace/><%=elementName%>_file");
	    if (el) {
	        el.click();  
	    }
		A.one('#<portlet:namespace/><%=elementName%>_file').trigger('click');
	}); --%>
	
	<%--$('#<portlet:namespace /><%=elementName%>_fileName').on('click', function(event) {
		$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
	});--%>
	
	$('#<portlet:namespace/><%=elementName%>_file').on('change', function(event) {
		var connectionDocumentId=$('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val();
		console.log('Uploading for '+'<%=connectionRequestId%>, '+connectionDocumentId+' , <%=documentType%>' + $('#<portlet:namespace/><%=elementName%>_documentName').val());
		uploadFile('<%=connectionRequestId%>', connectionDocumentId, '<%=documentType%>', $('#<portlet:namespace/><%=elementName%>_documentName').val(), 
				$('#<portlet:namespace/><%=elementName%>_file'), <%=progressBarId%>, <portlet:namespace /><%=elementName%>_uploadFileOnSuccess);
	});
	
	$('#<portlet:namespace /><%=elementName%>_deleteBtn').on('click', function(event) {
		var yn=confirm("Are you sure you want to remove the file?");
		if(yn){
			
			$('#<portlet:namespace/><%=elementName%>').val('');
			$('#<portlet:namespace/><%=elementName%>_fileName').html('');
			$('#<portlet:namespace /><%=elementName%>_deleteBtn').hide();
			$('#<portlet:namespace /><%=elementName%>_uploadBtn').show();
		}
	});

	function <portlet:namespace /><%=elementName%>_uploadFileOnSuccess(response){
		$('#<portlet:namespace/><%=elementName%>').val(response.connectionDocumentId);
		$('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val(response.connectionDocumentId);
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').hide();
		$('#<portlet:namespace/><%=elementName%>_fileName').html('<span class="text-primary">'+response.clientFileName+'</span> uploaded successfully');
		$('#<portlet:namespace /><%=elementName%>_deleteBtn').show();
		console.log(<%=progressBarId%>);
	}		

	$(document).ready(function() {
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').on('click', function(event) {
			$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
		});
<%
		if(StringUtils.isNotBlank(clientFileName)){
%>
			$('#<portlet:namespace/><%=elementName%>_fileName').show();
			$('#<portlet:namespace /><%=elementName%>_uploadBtn').hide();
			$('#<portlet:namespace /><%=elementName%>_deleteBtn').show();
<%
		}
%>
	});

</aui:script>
<script>
<%--
function <%=elementName%>_clearFile(){
	var yn=confirm("Are you sure you want to remove the file?");
	if(yn){
		$('#<portlet:namespace /><%=elementName%>_deleteBtn').trigger('click');
		$('#<%=elementName%>_fileViewContainer').css('display','none');
		$('#<%=elementName%>_container').css('display','block');
		$('.progress-bar').attr('style', "width: 0%");
	}
}--%>
</script>
<%--
<div class="custom-file">
	<input type="file" class="custom-file-input" onchange="uploadFile('<portlet:namespace/><%=elementName%>', <%=progressBarId%>)" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>">
	<label class="custom-file-label" for="customFile">Upload a file</label>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>" id="<portlet:namespace/><%=elementName%>">
</div> 
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />
--%>
