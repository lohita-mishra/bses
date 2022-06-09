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
String folder=ParamUtil.getString(request, "folder");

if(StringUtils.isNotBlank(folder) && StringUtils.indexOf(folder,"/")>=0 && !StringUtils.equals(folder, StringPool.FORWARD_SLASH)){
	String[] folderNames=folder.split("/");
	
	for(String folderName:folderNames){
		//LOGGER.info("Searching folder for : "+folderName +" under parentID : "+folderId);
		DLFolder dlFolder=null;
		try{
			dlFolder=DLFolderLocalServiceUtil.getFolder(groupId, folderId, folderName);
		}catch(Exception e){
			try{
				dlFolder=DLFolderLocalServiceUtil.addFolder(PrincipalThreadLocal.getUserId(), groupId, repositoryId, false, folderId, folderName, folderName, false, serviceContext);
			}catch(Exception e1){}
		}
		if(dlFolder!=null){
			folderId=dlFolder.getFolderId();
		}
	}
}

//LOGGER.info("Final folderID : "+folderId);

String progressBarId = elementName.concat("_progressbar");

String hiddenStyle="";

if(StringUtils.isNotEmpty(savedValue)){
	try{
		DLFileEntry fileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(savedValue));
		String filePath="/documents/"+fileEntry.getRepositoryId()+"/"+fileEntry.getFolderId()+"/"+URLEncoder.encode(fileEntry.getFileName());
		hiddenStyle="style=\"display:none;\"";
		String iconClass="fa-file-o";
		String mimeType=fileEntry.getMimeType();
		if(mimeType.equalsIgnoreCase("application/pdf")){
			iconClass="fa-file-pdf-o";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.wordprocessingml.document")){	
			iconClass="fa-file-word-o";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){	
			iconClass="fa-file-excel-o";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.presentationml.presentation")){	
			iconClass="fa-file-powerpoint-o";
		}else if(mimeType.startsWith("image/")){
			iconClass="fa-file-image-o";
		}else if(mimeType.equalsIgnoreCase("video/")){
			iconClass="fa-file-video-o";
		}else if(mimeType.equalsIgnoreCase("audio/")){
			iconClass="fa-file-audio-o";
		}else if(mimeType.endsWith("/zip") || mimeType.endsWith("/x-7z-compressed") || mimeType.endsWith("/x-tar")  || mimeType.endsWith("/vnd.rar")  || mimeType.endsWith("/gzip")  || mimeType.endsWith("/java-archive")){
			iconClass="fa-file-archive-o";
		}
%>
			
		<span id="<%=elementName%>_fileViewContainer" style="display:block;">
			<span style="font-style: italic;"><i class="fa <%=iconClass%> mr-1" aria-hidden="true"></i><%=fileEntry.getTitle()%></span>
			<a href="<%=filePath %>" target="_blank">
			<%--<i class="fa fa-download ml-1" aria-hidden="true"></i>--%><i class="icon-download-alt"></i></a>
			<a onclick="<%=elementName%>_clearFile();" style="color:red;"><%--i class="fa fa-times ml-1" aria-hidden="true"></i--%><i class="icon-remove"></i> </a>
		</span>
<%
	}catch(Exception exc){}
}

String acceptTypes=(StringUtils.isNotBlank(fileTypes)?"accept=\""+fileTypes+"\"":"");

%>
<div class="input-group" id="<%=elementName%>_container" <%=hiddenStyle%>>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>" id="<portlet:namespace/><%=elementName%>" value="<%=savedValue%>"/>
<%--	<input type="file" name="<portlet:namespace/><%=namePrefix+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>">--%>
	<input type="file" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName%>_file" style="width:0px;" <%=acceptTypes%>> 

	<%--<label id="<portlet:namespace /><%=elementName+"_document"%>"> --%>
		<button type="button" class="btn btn-primary upload-btn" id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" value="Choose File">Choose File</button>
		<span id="<portlet:namespace /><%=elementName+"_fileName"%>" style="font-weight: bold;"></span>
		<%--<a id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a> <%=StringUtils.isNotBlank(placeHolder)?placeHolder:"Choose a file to upload.."%>--%>
	<%--</label> --%>
	
</div>
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="10"/>
<a id="<portlet:namespace /><%=elementName+"_clearBtn"%>" style="float: right; display:none;color:red;"><i class="fa fa-close"></i>Delete</a>

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
		uploadFile('<%=folder%>', $('#<portlet:namespace/><%=elementName%>_file'), <%=progressBarId%>, <portlet:namespace /><%=elementName%>_uploadFileOnSuccess);
	});
	
	$('#<portlet:namespace /><%=elementName%>_clearBtn').on('click', function(event) {
		var yn=confirm("Are you sure you want to remove the file?");
		if(yn){
			$('#<portlet:namespace/><%=elementName%>').val('');
			$('#<portlet:namespace/><%=elementName%>_fileName').html('');
			$('#<portlet:namespace /><%=elementName%>_clearBtn').css("display", "none");
			$('#<portlet:namespace /><%=elementName%>_uploadBtn').css("display", "block");
		}
	});

	function <portlet:namespace /><%=elementName%>_uploadFileOnSuccess(response){
		$('#<portlet:namespace/><%=elementName%>').val(response.fileEntryId);
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').css("display", "none");
		$('#<portlet:namespace/><%=elementName%>_fileName').html("Uploaded successfully");
		$('#<portlet:namespace /><%=elementName%>_clearBtn').css("display", "block");
		console.log(<%=progressBarId%>);
	}		

	$(document).ready(function() {
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').on('click', function(event) {
			$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
		});
	});

</aui:script>
<script>
<%--
function <%=elementName%>_clearFile(){
	var yn=confirm("Are you sure you want to remove the file?");
	if(yn){
		$('#<portlet:namespace /><%=elementName%>_clearBtn').trigger('click');
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
