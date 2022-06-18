<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

long connectionDocumentId=ParamUtil.getLong(request, "connectionDocumentId", 0);
String elementName=ParamUtil.getString(request, "elementName");
String fileTypes=ParamUtil.getString(request, "fileTypes");
String placeHolder=ParamUtil.getString(request, "placeHolder");
String savedValue=ParamUtil.getString(request, elementName);
String documentType=ParamUtil.getString(request, "documentType");
String documentName=ParamUtil.getString(request, "documentName");
boolean thumbnail=ParamUtil.getBoolean(request, "thumbnail", false);
boolean readOnly=ParamUtil.getBoolean(request, "readOnly", false);

String displayFileName="";
String fileName="";
ConnectionDocument connectionDocument=null;
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
long connectionRequestId=requestEntity.getConnectionRequestId();

try{
	if(connectionDocumentId>0){
		connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocument(connectionDocumentId);
	}else{
		connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestIdAndDocumentType(requestEntity.getConnectionRequestId(), documentType);
		connectionDocumentId=connectionDocument.getConnectionDocumentId();
	}
	fileName=connectionDocument.getClientFileName();
	//displayFileName="<span class=\"text-primary\">"+fileName+"</span> uploaded successfully";
	displayFileName="<span class=\"text-primary\">"+fileName+"</span>";
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
	<input type="hidden" name="<portlet:namespace/><%=elementName%>_fileName" id="<portlet:namespace/><%=elementName%>_fileName" value="<%=fileName%>"/>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>_acceptTypes" id="<portlet:namespace/><%=elementName%>_acceptTypes" value="<%=fileTypes%>"/>
	
<%--	<input type="file" name="<portlet:namespace/><%=namePrefix+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>">--%>
	<input type="file" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName%>_file" style="width:0px;" <%=acceptTypes%>> 

	<%--<label id="<portlet:namespace /><%=elementName+"_document"%>"> --%>
		<button type="button" class="btn btn-primary btn-sx" id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" style="font-size:1em;<%=(readOnly?"display:none;":"")%>" value="Choose File" >Upload File</button>
<%
	if(!thumbnail){
%>		
		<span id="<portlet:namespace /><%=elementName+"_displayFileName"%>"><%=displayFileName %></span>
<%
	}else{
%>	
		<img id="<portlet:namespace/><%=elementName%>_document-iframe" src="" width="0" height="0" class="mb-2 mt-2" style="left:auto; border:1px solid black;"/>	
<%
	}
%>
		<%--<a id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a> <%=StringUtils.isNotBlank(placeHolder)?placeHolder:"Choose a file to upload.."%>--%>
	<%--</label> --%>
	
</div>
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="0"/>
<button type="button" class="btn btn-success btn-sx pl-2 pr-2" id="<portlet:namespace /><%=elementName+"_viewBtn"%>" style="font-size:1em; display:none; padding-left:12px !important; padding-right:12px !important;"><i class="fa fa-close"></i>View</button>
<button type="button" class="btn btn-danger btn-sx ml-2 pl-2 pr-2" id="<portlet:namespace /><%=elementName+"_deleteBtn"%>" style="font-size:1em; display:none;  padding-left:12px !important; padding-right:12px !important;"><i class="fa fa-close"></i>Delete</button>

<portlet:resourceURL var="documentDownloadURL" id="documentDownload">
	<portlet:param name="cmd" value="download"/>
</portlet:resourceURL>

<portlet:renderURL var="documentViewerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/document_viewer.jsp" />
</portlet:renderURL>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
	var thumbnail=<%=thumbnail%>;
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
				$('#<portlet:namespace/><%=elementName%>_file'), $('#<portlet:namespace/><%=elementName%>_acceptTypes').val(),'', <portlet:namespace /><%=elementName%>_uploadFileOnSuccess);
	});
	
	$('#<portlet:namespace /><%=elementName%>_deleteBtn').on('click', function(event) {
		var yn=confirm("Are you sure you want to remove the file?");
		if(yn){
			deleteConnectionDocument($('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val(), <portlet:namespace /><%=elementName%>_onDeleteSuccess);
		}
	});
	
	function <portlet:namespace /><%=elementName%>_onDeleteSuccess(obj){

		if(obj==true || obj=="true"){
			$('#<portlet:namespace/><%=elementName%>').val('');
			$('#<portlet:namespace/><%=elementName%>_fileName').val('');
			if(!thumbnail){
				$('#<portlet:namespace/><%=elementName%>_displayFileName').html('');
			}else{
				<portlet:namespace /><%=elementName%>_clearThumbnail();
			}
			$('#<portlet:namespace /><%=elementName%>_deleteBtn').hide();
			$('#<portlet:namespace /><%=elementName%>_viewBtn').hide();
			$('#<portlet:namespace /><%=elementName%>_uploadBtn').show();
		}
	}

	function <portlet:namespace /><%=elementName%>_uploadFileOnSuccess(response){
		$('#<portlet:namespace/><%=elementName%>').val(response.connectionDocumentId);
		$('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val(response.connectionDocumentId);
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').hide();
		$('#<portlet:namespace/><%=elementName%>_fileName').val(response.clientFileName);
		$('#<portlet:namespace /><%=elementName%>_deleteBtn').show();

		if(!thumbnail){
			$('#<portlet:namespace/><%=elementName%>_displayFileName').html('<span class="text-primary">'+response.clientFileName+'</span>');
			$('#<portlet:namespace /><%=elementName%>_viewBtn').show();
		}else{
			<portlet:namespace /><%=elementName%>_showThumbnail(response.connectionDocumentId);
		}
		console.log(<%=progressBarId%>);
	}		

	$('#<portlet:namespace /><%=elementName%>_viewBtn').on('click', function(event) {
		<portlet:namespace /><%=elementName%>_downloadDocument($('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val());
	});
	$(document).ready(function() {
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').on('click', function(event) {
			$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
		});
<%
		if(StringUtils.isNotBlank(displayFileName)){
%>
			if(!thumbnail){
				$('#<portlet:namespace/><%=elementName%>_displayFileName').show();
				$('#<portlet:namespace /><%=elementName%>_viewBtn').show();
			}else{
				<portlet:namespace /><%=elementName%>_showThumbnail($('#<portlet:namespace/><%=elementName%>_connectionDocumentId').val())
			}
			$('#<portlet:namespace /><%=elementName%>_uploadBtn').hide();
<%
			if(!readOnly){
%>
				$('#<portlet:namespace /><%=elementName%>_deleteBtn').show();
<%
			}
		}
%>
	});

	function <portlet:namespace /><%=elementName%>_downloadDocument(connectionDocumentId){
		<%--
		var viewerUrl='<%=documentDownloadURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId;
		
		$('#document-viewer-iframe').attr("src", viewerUrl);
		$('#document-viewer-modal').modal('show'); 
		--%>
		Liferay.Util.openWindow(
				{
					dialog: {
						//cssClass: 'aui-popup-example',
						destroyOnHide: true,
						resizable: true,
						width: 1524,
						height: 840,
						
					},
					dialogIframe: {
						//bodyCssClass: 'custom-css-class'
					},
					title: 'Document Viewer',
					uri: '<%=documentViewerURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId
				}
			);
		<%--
			window.open('<%=documentDownloadURL%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId);
		--%>
	}
	
	function <portlet:namespace /><%=elementName%>_showThumbnail(connectionDocumentId){
		var viewerUrl='<%=documentDownloadURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId;
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("src", viewerUrl);
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("height", 150);
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("width", 120);
	}
	
	function <portlet:namespace /><%=elementName%>_clearThumbnail(){
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("src", '');
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("height", 0);
		$('#<portlet:namespace/><%=elementName%>_document-iframe').attr("width", 0);
	}
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
