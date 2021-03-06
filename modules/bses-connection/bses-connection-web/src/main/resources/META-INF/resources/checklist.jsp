<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionDocument"%>
<%@page import="com.bses.connection2.service.ConnectionDocumentLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%>
<style>
	#checklist-option-no-alert-modal{
		display:none;
	}
</style>
<%
long connectionDocumentId=0;
//Calendar calendar=Calendar.getInstance();
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
long connectionRequestId=requestEntity.getConnectionRequestId();
String requestMode=requestEntity.getRequestMode();
String requestType=requestEntity.getRequestType();

//String folder="/Users/arjun/Documents/tools/liferay7/liferay-dxp-7.0.10.17-sp17/bses/application/newconnection_docs/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/RQ005";
%>
<aui:form cssClass="custom-form" role="form" name="checklistForm" id="checklistForm" section-attr="checklist" >
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="text-uppercase text-body font-weight-bold bg-light p-3"><liferay-ui:message key="checklist-section-title" /></h6>
			</div>
		</div>
		
		<%-- WIRING TEST CERTIFICATE --%>
		<div class="form-group row d-flex align-items-center">
			<div class="col-sm-6">
				<label for="inputEmail3" class="font-weight-bold col-form-label">
					<liferay-ui:message key="checklist-wiring-test" />
				</label>
				<p id="wiringblink" class="blink font-weight-bold col-form-label">
					<liferay-ui:message key="checklist-wiring-test-blink" />
				</p>
			</div>
			<div class="col-sm-2">
			
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id ="wiringTest" name="wiringTest" label="Yes" value="1" checked="<%=requestEntity.getWiringTest()%>" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="wiringTest" name="wiringTest" label="No" value="0" checked="<%=!requestEntity.getWiringTest()%>"/> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>			
			<div class="col-md-4" id="wiringuploaddiv">
				<%--<label class="font-weight-bold">Upload wiring test certificate </label>--%> 
				<%--<aui:input type="file" style="border:0px; padding:0;" name="wiringCertificate" label="checklist-wiring-test-certificate" /> --%>
			
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="wiringCertificate" />
					<liferay-util:param name="documentType" value="Wiring Certificate" />
					<liferay-util:param name="documentName" value="Wiring Certificate" />
					<liferay-util:param name="fileTypes" value="application/pdf" />
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>
		
		<%-- ELCB INSTALLATION CERTIFICATE --%>
		<div class="form-group row d-flex align-items-center">
			<div class="col-sm-6">
				<label for="inputEmail3" class="col-form-label">
					<liferay-ui:message key="checklist-elcb" />
				</label>
				<p id="elcbblink" class="blink">
					<liferay-ui:message key="checklist-elcb-blink" />
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="elcbInstalled" name="elcbInstalled" value="1" label="Yes" checked="<%=requestEntity.getElcbInstalled() %>"  /> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="elcbInstalled" name="elcbInstalled" value="0" label="No" checked="<%=!requestEntity.getElcbInstalled() %>"/> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-md-4" id="elcbuploaddiv">

				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="elcbDocument" />
					<liferay-util:param name="documentType" value="ELCB Document" />
					<liferay-util:param name="documentName" value="ELCB Document" />
					<liferay-util:param name="fileTypes" value="application/pdf" />
				</liferay-util:include>
			</div>
<%
	}
%>			
		</div>
		
		<%-- STILT PARKING --%>
		<div class="form-group row align-items-center" style="margin-bottom: 0 !important;">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label">
				<liferay-ui:message key="checklist-stilt-parking" />
			</label>
			<div class="col-sm-6">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="stiltParking" value="1" label="Yes" checked="<%=requestEntity.getStiltParking() %>"/> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="stiltParking" value="0" label="No" checked="<%=!requestEntity.getStiltParking() %>" /> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>
			</div>
		</div>

		<%-- BUILDING HEIGHT 15 MTR --%>
		<div class="form-group row align-items-center" style="margin-bottom: 0 !important;" id="building15div">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label pl-3">
				<liferay-ui:message key="checklist-stilt-parking-building-15" />
			</label>
			<div class="col-sm-6">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height15Mtr" value="1" label="Yes" checked="<%=requestEntity.getHeight15Mtr() %>"/> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height15Mtr" value="0" label="No" checked="<%=!requestEntity.getHeight15Mtr() %>"/> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>

			</div>
		</div>

		<%-- BUILDING HEIGHT 17 MTR --%>
		<div class="form-group row align-items-center" style="margin-bottom: 0 !important;" id="building17div">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label pl-3">
				<liferay-ui:message key="checklist-stilt-parking-building-17" />
			</label>
			<div class="col-sm-6">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height17Mtr" value="1" label="Yes" checked="<%=requestEntity.getHeight15Mtr() %>"/> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height17Mtr" value="0" label="No" checked="<%=!requestEntity.getHeight15Mtr() %>"/> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>

			</div>
		</div>

		<%-- FCC DOCUMENT --%>
		<div class="form-group row align-items-center" id="fccdiv">
			<div class="col-sm-6">
				<label for="inputEmail3" class="font-weight-bold col-form-label pl-3" style="line-height: 1 !important;">
					<liferay-ui:message key="checklist-stilt-parking-fcc" />
				</label>
				<p id="fccblink" class="blink pl-5">
					<liferay-ui:message key="checklist-stilt-parking-fcc-blink" />
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="fcc"  name="fcc" value="1" label="Yes" checked="<%=requestEntity.getFcc() %>" /> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="fcc" name="fcc" value="0" label="No" checked="<%=!requestEntity.getFcc() %>" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
				<p></p>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-sm-4" id="fccuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="fccCertificate" />
					<liferay-util:param name="documentType" value="FCC Certificate" />
					<liferay-util:param name="documentName" value="FCC Certificate" />
					<liferay-util:param name="fileTypes" value="application/pdf" />					
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload fire clearance certificate </label> 
				<aui:input type="file" style="border:0px; padding:0;" name="fccCertificate" label="checklist-stilt-parking-fcc-certificate" />--%>
			</div>
<%
	}
%>			
		</div>
		
		<%-- LIFT DOCUMENT --%>
		<div class="form-group row d-flex align-items-center">
			<div class="col-sm-6">
				<label for="inputEmail3" class="font-weight-bold col-form-label">
					<liferay-ui:message key="checklist-lift" />
				</label>
				<p id="liftblink" class="blink">
					<liferay-ui:message key="checklist-lift-blink" />
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="lift" name="lift" value="1" label="Yes" checked="<%=requestEntity.getLift() %>" /> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="lift" name="lift" value="0" label="No" checked="<%=!requestEntity.getLift() %>"/> <%--<label class="form-check-label font-weight-bold"> No
					</label>--%>
				</div>

			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-md-4" id="liftuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="liftCertificate" />
					<liferay-util:param name="documentType" value="Lift Certificate" />
					<liferay-util:param name="documentName" value="Lift Certificate" />
					<liferay-util:param name="fileTypes" value="application/pdf" />					
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload lift fitness certificate </label>
				 <aui:input type="file" style="border:0px; padding:0;" name="liftCertificate" label="checklist-lift-certificate" />
				 --%>
			</div>
<%
	}
%>			
		</div>
		
		<%-- BDO CERTIFICATE --%>
		<div class="form-group row align-items-center" id="bdocertdiv">
			<div class="col-sm-6">
				<label for="inputEmail3" class="font-weight-bold col-form-label">
					<liferay-ui:message key="checklist-agri-consumer-bdo" /> 
				</label>
				<p id="bdocertblink" class="blink pl-3">
					<liferay-ui:message key="checklist-agri-consumer-bdo-blink" /> 
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="hasBdoCertificate" name="hasBdoCertificate" value="1" label="Yes" checked="<%=requestEntity.getHasBdoCertificate() %>"/> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" id="hasBdoCertificate" name="hasBdoCertificate" value="0" label="No" checked="<%=!requestEntity.getHasBdoCertificate() %>"/> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>

			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>			<div class="col-md-4" id="bdocertuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="bdoCertificate" />
					<liferay-util:param name="documentType" value="BDO Certificate" />
					<liferay-util:param name="documentName" value="BDO Certificate" />
					<liferay-util:param name="fileTypes" value="application/pdf" />					
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger" id="agconsumeruploadmandatory">*</span>
				</label> 
				<aui:input type="file" style="border:0px; padding:0;" name="bdoCertificate" label="checklist-agri-consumer-bdo-certificate" />
				--%>
			</div>
<%
	}
%>			
		</div>
		
		<%-- DPCC LICENSE --%>
		<div class="form-group row align-items-center d-none" id="licensediv">
			<div class="col-sm-6">
				<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label"> 
					<liferay-ui:message key="checklist-dpcc-license" /> 
				</label>
				<p id="bdocertblink" class="blink pl-3">
					<liferay-ui:message key="checklist-dpcc-license-blink" /> 
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="hasDpccCertificate" value="1" label="Yes" checked="<%=requestEntity.getHasDpccCertificate()%>"/> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="hasDpccCertificate" value="0" label="No"  checked="<%=!requestEntity.getHasDpccCertificate()%>"/> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-md-4" id="licenseuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="dpccLicense" />
					<liferay-util:param name="documentType" value="DPCC License" />
					<liferay-util:param name="documentName" value="DPCC License" />
					<liferay-util:param name="fileTypes" value="application/pdf" />					
				</liferay-util:include>			
				<%--<label class="font-weight-bold">Upload the DPCC License Certificate<span class="text-danger">*</span>
				</label> <aui:input type="file" style="border:0px; padding:0;" name="dpccLicenseCertificate" label="checklist-dpcc-license-certificate" />--%>
			</div>
<%
	}
%>			
		</div>

		<%-- POLUTION CERTIFICATE --%>		
		<div class="form-group row align-items-center d-none" id="polutiondiv">
			<div class="col-sm-6">
				<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label">
					<liferay-ui:message key="checklist-polution-free" /> 
				</label>
				<p id="bdocertblink" class="blink pl-3">
					<liferay-ui:message key="checklist-polution-free-blink" /> 
				</p>
			</div>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="hasPollutionCertificate" value="1" label="Yes" checked="<%=requestEntity.getHasPollutionCertificate()%>" /> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="hasPollutionCertificate" value="0" label="No" checked="<%=!requestEntity.getHasPollutionCertificate()%>" /> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>
			</div>
<%
	if(!requestMode.equalsIgnoreCase(RequestTypeModeStatus.MODE_APPOINTMENT)){
%>				
			<div class="col-md-4" id="polutionuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="pollutionCertificate" />
					<liferay-util:param name="documentType" value="Pollution Certificate" />
					<liferay-util:param name="documentName" value="Pollution Certificate" />
					<liferay-util:param name="fileTypes" value="application/pdf" />					
				</liferay-util:include>
				
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger">*</span>
				</label>
				 <aui:input type="file" style="border:0px; padding:0;" name="polutionCertificate"  label="checklist-polution-free-certificate" />
				--%>
			</div>
<%
	}
%>			
		</div>
		
		<%-- EMAIL E-SERVICE --%>			
		<div class="form-group row d-flex align-items-center">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label"> 
				<liferay-ui:message key="checklist-eservice" /> 
			</label>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" value="1" name="eServiceOnMail" label="Yes" checked="<%=requestEntity.getEServiceOnMail()%>" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" value="0" name="eServiceOnMail" label="No" checked="<%=!requestEntity.getEServiceOnMail()%>"/> <%--<label class="form-check-label font-weight-bold"> No
					</label>--%>
				</div>
			</div>
			<div class="col-sm-4" id="emailservicediv">
				<%--<label for="inputEmail3" class="font-weight-bold">Enter your Email ID<span class="text-danger">*</span></label>--%> <aui:input type="email"
					class="form-control" placeholder="Enter your email Id" style="font-size: small !important; line-height: 1 !important;" name="eServiceMailId" label="checklist-eservice-email" value="<%=requestEntity.getEServiceMailId()%>">
						<aui:validator name="required">
		                function() {
		                	return AUI.$('input[name=<portlet:namespace />eServiceOnMail]').val()=="1";
		                }
		        		</aui:validator>
		        		<aui:validator name="email" />
					</aui:input>
			</div>
		</div>
	</div>
</aui:form>

<div class="modal" id="checklist-option-no-alert-modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header" style="border-bottom: none;">
				<h5 class="modal-title">Change Action?</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body align-items-center justify-content-center" style="padding-top:25px; padding-bottom:25px;">
				<div class="help-text text-danger text-center fs-18">
					<!-- i class="far fa-paper-plane fa-fw text-danger"></i-->
					You have already uploaded the <span id="checklist-option-no-alert-document-type-name"></span>. Plese delete the document before selecting "NO".'
				</div>
			</div>
			<div class="modal-footer align-items-center justify-content-center">
				<div class="text-danger text-center">
					<button type="button" class="btn btn-danger btn-sm" id="checklist-option-no-alert-ok-btn" value="Ok" data-id="">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>

