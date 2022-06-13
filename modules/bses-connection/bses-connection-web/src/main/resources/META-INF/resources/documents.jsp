<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map"%>
<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%>
<%
long connectionDocumentId=0;
//Calendar calendar=Calendar.getInstance();
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
long connectionRequestId=requestEntity.getConnectionRequestId();
//String folder="/Users/arjun/Documents/tools/liferay7/liferay-dxp-7.0.10.17-sp17/bses/application/newconnection_docs/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/RQ005";
%>
<aui:form cssClass="custom-form" role="form" name="documentForm" id="documentForm" section-attr="document">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="text-uppercase text-body font-weight-bold bg-light p-3"><liferay-ui:message key="document-section-title" /></h6>
			</div>
		</div>
		
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
			<div class="col-sm-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="applicantPhoto" />
					<liferay-util:param name="documentType" value="Applicant Photo" />
					<liferay-util:param name="documentName" value="Applicant Photo" />
				</liferay-util:include>
				<%--<aui:input type="file" style="border:0px; padding:0;" name="applicantPhoto" label="" /> --%>
			</div>

			<%--<div class="col-sm-4 input-group-prepend">
				<button class="btn btn-primary btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="fas fa-upload"></i> Upload
				</button>
				<button class="btn btn-danger btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="far fa-trash-alt text-white"></i> Delete
				</button>
				<button type="button" class="btn btn-outline-secondary btn-sm">
					<i class="far fa-eye text-body"></i> View
				</button>
			</div> --%>
		</div>

		<div class="row mb-3">
			<div class="col-md-7 pl-5">
				<label class="justify-content-start"><liferay-ui:message key="document-signature" /></label>
			</div>
			
			<div class="col-md-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="applicantSignature" />
					<liferay-util:param name="documentType" value="Applicant Signature" />
					<liferay-util:param name="documentName" value="Applicant Signature" />
				</liferay-util:include>
				<%--
				<aui:input type="file" style="border:0px; padding:0;" name="applicantSignature" label="" />
				--%>
			</div>

			<%--
			<div class="col-md-4 input-group-prepend">
				<button class="btn btn-primary btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="fas fa-upload"></i> Upload
				</button>
				<button class="btn btn-danger btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="far fa-trash-alt text-white"></i> Delete
				</button>
				<button type="button" class="btn btn-outline-secondary btn-sm">
					<i class="far fa-eye text-body"></i> View
				</button>
			</div>
			 --%>
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
				<aui:select class="form-control d-block w-100" name="idProofType" label="document-id-proof-type">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getIDProofTypes().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getFloor(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
				
				</div>
				<div class="col-md-3">
					<aui:input type="text" class="form-control" name="idProofNo" label="document-id-proof-no" />
				</div>
			<div class="col-md-5 pt-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="idProof" />
					<liferay-util:param name="documentType" value="ID Proof" />
					<liferay-util:param name="documentName" value="ID Proof" />
				</liferay-util:include>
				<%--<aui:input type="file" style="border:0px; padding:0;" name="idProofDocument" label="" /> --%>
			</div>
			<%--<div class="col-md-4 input-group-prepend">
				<button class="btn btn-primary btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="fas fa-upload"></i> Upload
				</button>
				<button class="btn btn-danger btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="far fa-trash-alt text-white"></i> Delete
				</button>
				<button type="button" class="btn btn-outline-secondary btn-sm">
					<i class="far fa-eye text-body"></i> View
				</button>
			</div> --%>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-12">
				<h6 class="font-weight-bold mb-0" style="border-radius: 4px 4px 0 0;">
					3. <liferay-ui:message key="document-ownership-proof" />
				</h6>
			</div>
		</div>
			
		<div class="row">
			<div class="col-md-4 pl-5">
				<aui:select class="form-control d-block w-100" name="ownershipProofType" label="">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getOwnershipProofTypes().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getFloor(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>
			<div class="col-md-3"></div>
			<div class="col-sm-5">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="ownershipProof" />
					<liferay-util:param name="documentType" value="Ownership Proof" />
					<liferay-util:param name="documentName" value="Ownership Proof" />
				</liferay-util:include>
				<%-- <aui:input type="file" style="border:0px; padding:0;" name="ownershipProofDocument" label="" />--%>
			</div>
			<%--<div class="col-sm-4 input-group-prepend">
				<button class="btn btn-primary btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="fas fa-upload"></i> Upload
				</button>
				<button class="btn btn-danger btn-sm mr-2" type="button" id="inputGroupFileAddon03">
					<i class="far fa-trash-alt text-white"></i> Delete
				</button>
				<button type="button" class="btn btn-outline-secondary btn-sm">
					<i class="far fa-eye text-body"></i> View
				</button>
			</div>
			 --%>
		</div>
	</div>
</aui:form>