<%@ include file="/init.jsp"%>

<aui:form role="form" class="CustomForm" id="checklistForm">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="text-uppercase text-body font-weight-bold bg-light p-3"><liferay-ui:message key="checklist-section-title" /></h6>
			</div>
		</div>
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
				<aui:input type="file" style="border:0px; padding:0;" name="wiringCertificate" label="checklist-wiring-test-certificate" />
			</div>
		</div>

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
				<%--<label class="font-weight-bold">Upload ELCB document <span class="text-danger" id="agconsumeruploadmandatory">*</span>
				</label>--%> <aui:input type="file" style="border:0px; padding:0;" name="elcbDocuemnt" label="checklist-elcb-docuemnt" />
			</div>
			<!-- <div class="col-md-4" id="elcbuploaderrordiv">
											<%--<label class="px-2 py-2 text-danger" style="background-color:yellow;"><i class="fas fa-exclamation-triangle mr-1"></i>ELCB document required for more than 2 KW load.</label>--%>
										</div>
										 -->
		</div>

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
				<%--<label class="font-weight-bold">Upload fire clearance certificate </label>--%> <aui:input type="file" style="border:0px; padding:0;" name="fccCertificate" label="checklist-stilt-parking-fcc-certificate" />
			</div>
		</div>


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
				<%--<label class="font-weight-bold">Upload lift fitness certificate </label>--%> <aui:input type="file" style="border:0px; padding:0;" name="liftCertificate" label="checklist-lift-certificate" />
			</div>
		</div>

		<%--
		<div class="form-group row d-flex align-items-center" style="margin-bottom: 0 !important;">
			<label for="inputEmail3" class="col-sm-6 font-weight-bold col-form-label">
				<liferay-ui:message key="checklist-agri-consumer" />
			</label>
			<div class="col-sm-2">
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="agriConsumer" value="1" label="Yes" />
				</div>
				<div class="form-check-inline">
					<aui:input class="form-check-input" type="radio" name="agriConsumer" value="0" checked="true" label="No" />
				</div>
			</div>
		</div>
 		--%>
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
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger" id="agconsumeruploadmandatory">*</span>
				</label>--%> 
				<aui:input type="file" style="border:0px; padding:0;" name="bdoCertificate" label="checklist-agri-consumer-bdo-certificate" />
			</div>
		</div>

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
				<%--<label class="font-weight-bold">Upload the DPCC License Certificate<span class="text-danger">*</span>
				</label>--%> <aui:input type="file" style="border:0px; padding:0;" name="dpccLicenseCertificate" label="checklist-dpcc-license-certificate" />
			</div>
		</div>

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
				<%--<label class="font-weight-bold">Upload Certificate from BDO <span class="text-danger">*</span>
				</label>--%> <aui:input type="file" style="border:0px; padding:0;" name="polutionCertificate"  label="checklist-polution-free-certificate" />
			</div>
		</div>

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