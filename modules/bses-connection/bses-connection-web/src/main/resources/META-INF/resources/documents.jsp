<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.bses.connection2.service.ConnectionDocumentLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionDocument"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map"%>
<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%>
<%!
	private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.documents_005f_jsp");
%>
<%
long connectionDocumentId=0;
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
long connectionRequestId=requestEntity.getConnectionRequestId();
String requestMode=requestEntity.getRequestMode();
String requestType=requestEntity.getRequestType();

boolean idProofAndSignatureRequired=(requestType.equalsIgnoreCase(RequestTypeModeStatus.TYPE_NEW_CONNECTION) || requestType.equalsIgnoreCase(RequestTypeModeStatus.TYPE_NAME_CHANGE));
boolean ownershipProofRequired=(requestType.equalsIgnoreCase(RequestTypeModeStatus.TYPE_NEW_CONNECTION) || requestType.equalsIgnoreCase(RequestTypeModeStatus.TYPE_ADDRESS_CHANGE));
%>
<aui:form cssClass="custom-form" role="form" name="documentForm" id="documentForm" section-attr="document">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="text-uppercase text-body font-weight-bold bg-light p-3"><liferay-ui:message key="document-section-title" /></h6>
			</div>
		</div>
<%
	if(idProofAndSignatureRequired){
%>			
		
		<div class="row">
			<div class="col-md-12">
				<h6 class="font-weight-bold" style="border-radius: 4px 4px 0 0;">
					1.<liferay-ui:message key="document-photo-signature" />
				</h6>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-7 pl-5">
				<label class="justify-content-start"><liferay-ui:message key="document-photo" /></label>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>			
			<div class="col-sm-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="applicantPhoto" />
					<liferay-util:param name="documentType" value="Applicant Photo" />
					<liferay-util:param name="documentName" value="Applicant Photo" />
					<liferay-util:param name="fileTypes" value="image/png, image/jpeg" />
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>

		<div class="row mb-3">
			<div class="col-md-7 pl-5">
				<label class="justify-content-start"><liferay-ui:message key="document-signature" /></label>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>			
			<div class="col-md-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="applicantSignature" />
					<liferay-util:param name="documentType" value="Applicant Signature" />
					<liferay-util:param name="documentName" value="Applicant Signature" />
					<liferay-util:param name="fileTypes" value="image/png, image/jpeg" />					
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>

		<div class="row mb-3">
			<div class="col-md-12">
				<h6 class="font-weight-bold mb-0 " style="border-radius: 4px 4px 0 0;">
					2. <liferay-ui:message key="document-id-proof" />
				</h6>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-4 pl-5">
<%
	String idProofDocumentName="ID Proof";
	try{
		ConnectionDocument connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestIdAndDocumentType(requestEntity.getConnectionRequestId(), "ID Proof");
		idProofDocumentName=connectionDocument.getDocumentName();
	}catch(Exception e){
		LOGGER.error(e.getMessage());
	}
%>			
				<aui:select class="form-control d-block w-100" name="idProofType" label="document-id-proof-type">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getIDProofTypes().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getIdProofType(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
				
				</div>
				<div class="col-md-3">
					<aui:input type="text" class="form-control" name="idProofNo" label="document-id-proof-no" value="<%=requestEntity.getIdProofNo() %>">
						<aui:validator name="required"/>
					</aui:input>
				</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-md-5 pt-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="idProof" />
					<liferay-util:param name="documentType" value="ID Proof" />
					<liferay-util:param name="documentName" value="<%=idProofDocumentName%>" />
					<liferay-util:param name="fileTypes" value="application/pdf" />
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>
<%
	}
%>	

<%
	if(ownershipProofRequired){
%>		
		<div class="row mb-3">
			<div class="col-md-12">
				<h6 class="font-weight-bold mb-0" style="border-radius: 4px 4px 0 0;">
					3. <liferay-ui:message key="document-ownership-proof" />
				</h6>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 pl-5">
<%		
	String ownershipProofDocumentName="Ownership Proof";
	try{
		ConnectionDocument connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestIdAndDocumentType(requestEntity.getConnectionRequestId(), "ID Proof");
		ownershipProofDocumentName=connectionDocument.getDocumentName();
	}catch(Exception e){
		LOGGER.error(e.getMessage());
	}
%>	
				<aui:select class="form-control d-block w-100" name="ownershipProofType" label="">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getOwnershipProofTypes().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getOwnershipProofType(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>
			<div class="col-md-3"></div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>			
			<div class="col-sm-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="ownershipProof" />
					<liferay-util:param name="documentType" value="Ownership Proof" />
					<liferay-util:param name="documentName" value="<%=ownershipProofDocumentName %>" />
					<liferay-util:param name="fileTypes" value="application/pdf" />
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>
<%
	}
%>			
		
	</div>
</aui:form>