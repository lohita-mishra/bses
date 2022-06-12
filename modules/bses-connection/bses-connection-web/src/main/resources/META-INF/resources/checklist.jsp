<%@page import="com.bses.connection2.model.ConnectionDocument"%>
<%@page import="com.bses.connection2.service.ConnectionDocumentLocalServiceUtil"%>
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
<aui:form cssClass="custom-form form-auto-save" role="form" name="checklistForm" id="checklistForm" section-attr="checklist" >
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
					<aui:input class="form-check-input" type="radio" name="wiringTest" label="Yes" value="1" checked="true" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="wiringTest" label="No" value="0" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
			</div>
			<div class="col-md-4" id="wiringuploaddiv">
				<%--<label class="font-weight-bold">Upload wiring test certificate </label>--%> 
				<%--<aui:input type="file" style="border:0px; padding:0;" name="wiringCertificate" label="checklist-wiring-test-certificate" /> --%>
			
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="wiringCertificate" />
					<liferay-util:param name="documentType" value="Wiring Certificate" />
					<liferay-util:param name="documentName" value="Wiring Certificate" />
				</liferay-util:include>
			</div>
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
					<aui:input class="form-check-input" type="radio" name="elcbInstalled" value="1" checked="true" label="Yes"/> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="elcbInstalled" value="0" label="No" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
			</div>
			<div class="col-md-4" id="elcbuploaddiv">

				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="elcbDocument" />
					<liferay-util:param name="documentType" value="ELCB Document" />
					<liferay-util:param name="documentName" value="ELCB Document" />
				</liferay-util:include>
			</div>
		</div>
		
		<%-- STILT PARKING --%>
		<div class="form-group row align-items-center" style="margin-bottom: 0 !important;">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label">
				<liferay-ui:message key="checklist-stilt-parking" />
			</label>
			<div class="col-sm-6">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="stiltParking" value="1" label="Yes" /> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="stiltParking" value="0" label="No" checked="true" /> <%--<label class="form-check-label font-weight-bold">
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
					<aui:input class="form-check-input" type="radio" name="height15Mtr" value="1" checked="true" label="Yes" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height15Mtr" value="0" label="No" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
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
					<aui:input class="form-check-input" type="radio" name="height17Mtr" value="1" checked="true" label="Yes" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="height17Mtr" value="0" label="No" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
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
					<aui:input class="form-check-input" type="radio" name="fcc" value="1" checked="true" label="Yes" /> <%--<label class="form-check-label font-weight-bold"> Yes
					</label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="fcc" value="0" label="No" /> <%--<label class="form-check-label font-weight-bold"> No </label>--%>
				</div>
				<p></p>
			</div>
			<div class="col-sm-4" id="fccuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="fccCertificate" />
					<liferay-util:param name="documentType" value="FCC Certificate" />
					<liferay-util:param name="documentName" value="FCC Certificate" />
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload fire clearance certificate </label> 
				<aui:input type="file" style="border:0px; padding:0;" name="fccCertificate" label="checklist-stilt-parking-fcc-certificate" />--%>
			</div>
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
					<aui:input class="form-check-input" type="radio" name="lift" value="1" label="Yes" /> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="lift" value="0" checked="true" label="No" /> <%--<label class="form-check-label font-weight-bold"> No
					</label>--%>
				</div>

			</div>
			<div class="col-md-4" id="liftuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="liftCertificate" />
					<liferay-util:param name="documentType" value="Lift Certificate" />
					<liferay-util:param name="documentName" value="Lift Certificate" />
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload lift fitness certificate </label>
				 <aui:input type="file" style="border:0px; padding:0;" name="liftCertificate" label="checklist-lift-certificate" />
				 --%>
			</div>
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
					<aui:input class="form-check-input" type="radio" name="hasBdoCertificate" value="1" label="Yes" /> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="hasBdoCertificate" value="0" checked="true" label="No" /> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>

			</div>
			<div class="col-md-4" id="bdocertuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="bdoCertificate" />
					<liferay-util:param name="documentType" value="BDO Certificate" />
					<liferay-util:param name="documentName" value="BDO Certificate" />
				</liferay-util:include>
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger" id="agconsumeruploadmandatory">*</span>
				</label> 
				<aui:input type="file" style="border:0px; padding:0;" name="bdoCertificate" label="checklist-agri-consumer-bdo-certificate" />
				--%>
			</div>
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
					<aui:input class="form-check-input" type="radio" name="dpccLicense" value="1" label="Yes"/> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="dpccLicense" value="0" checked="true" label="No" /> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>
			</div>
			<div class="col-md-4" id="licenseuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="dpccLicenseCertificate" />
					<liferay-util:param name="documentType" value="DPCC License" />
					<liferay-util:param name="documentName" value="DPCC License" />
				</liferay-util:include>			
				<%--<label class="font-weight-bold">Upload the DPCC License Certificate<span class="text-danger">*</span>
				</label>--%> <aui:input type="file" style="border:0px; padding:0;" name="dpccLicenseCertificate" label="checklist-dpcc-license-certificate" />
			</div>
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
					<aui:input class="form-check-input" type="radio" name="polutionFree" value="1" label="Yes" /> <%--<label class="form-check-label font-weight-bold"> Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="polutionFree" value="0" checked="true" label="No" /> <%--<label class="form-check-label font-weight-bold">
						No </label>--%>
				</div>
			</div>
			<div class="col-md-4" id="polutionuploaddiv">
				<liferay-util:include page="/document-upload-element.jsp" servletContext="<%=application%>">
					<liferay-util:param name="elementName" value="polutionCertificate" />
					<liferay-util:param name="documentType" value="Polution Certificate" />
					<liferay-util:param name="documentName" value="Polution Certificate" />
				</liferay-util:include>
				
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger">*</span>
				</label>
				 <aui:input type="file" style="border:0px; padding:0;" name="polutionCertificate"  label="checklist-polution-free-certificate" />
				--%>
			</div>
		</div>
		
		<%-- EMAIL E-SERVICE --%>			
		<div class="form-group row d-flex align-items-center">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label"> 
				<liferay-ui:message key="checklist-eservice" /> 
			</label>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" value="1" checked ="true" name="eServiceOnMail" label="Yes" /> <%--<label class="form-check-label font-weight-bold">
						Yes </label>--%>
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" value="0" name="eServiceOnMail" label="No" /> <%--<label class="form-check-label font-weight-bold"> No
					</label>--%>
				</div>
			</div>
			<div class="col-sm-4" id="emailservicediv">
				<%--<label for="inputEmail3" class="font-weight-bold">Enter your Email ID<span class="text-danger">*</span></label>--%> <aui:input type="email"
					class="form-control" placeholder="Enter your email Id" style="font-size: small !important; line-height: 1 !important;" name="eServiceMailId" label="checklist-eservice-email"/>
			</div>
		</div>
	</div>
</aui:form>