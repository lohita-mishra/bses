<%@page import="com.bses.connection2.service.LocalityDivisionLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List" %>
<%@page import="com.bses.connection2.service.ConnectionDocumentLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionDocument"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>

<meta name='viewport' content='width=device-width, initial-scale=1'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="js/select2.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!-- script src='main.js'></script> -->

<style>
a {
	text-decoration: underline;
}

input[type="file"] {
	display: inline-block;
}
.form-control:disabled, .form-control[readonly] {
    
    opacity: 1;
    background-color: white;
}

.sap_upload {
	border: 3px solid black;
}

.signature {
	border: 3px solid black;
}

.declaration_for_building_height_paragraph {
	font-size: 10px;
	
}

.declaration_paragraph {
	font-size: 10px;
	
}

.declaration_for_building_height {
	border: 3px solid black;
	display:none;
}

.general_particulars {
	border: 3px solid black;
}

.uploaded_documents {
	border: 3px solid black;
}

.applicant_details {
	border: 3px solid black;
}

.category {
	border: 3px solid black;
}

.address {
	border: 3px solid black;
}

.declaration {
	border: 3px solid black;
	display:none;
}
.documents_checklist{
border: 3px solid black;
}
.load {
	width: 60%;
}

.form-control {
	width: 90%;
}
label[for=alignRight] {
	margin-left: 20px;
	font-size: 11px;
}
label {
	
	font-size: 11px;
}

.input-class {
	margin-left: 60px;
	color: red;
}

.mt-5, .my-5 {
	margin-top: 4rem !important;
}

.col-sm-6 {
	max-width: 60%;
}

</style>

</head>
<body>


<%
		long connectionRequestId = ParamUtil.getLong(request, "connectionRequestId", 0);
		ConnectionRequest connectionRequest = ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
		System.out.println(connectionRequest);
		List<ConnectionDocument> connectionDocumentList = ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestId(connectionRequestId);
		
		//ConnectionDocument connectionDocument = ConnectionDocumentLocalServiceUtil.getConnectionDocumentByConnectionRequestIdAndDocumentType(connectionRequestId,"Applicant Photo");
		//String docId = String.valueOf(connectionDocument.getConnectionDocumentId());
	%>
<portlet:renderURL var="documentViewerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/document_viewer.jsp" />
</portlet:renderURL>
	

			<div class="col-md-10 pt-2">
				<div class="card card-primary bg-light mb-2">
					<div class="card-body row">
						<div class="col-md-12 pt-2 mb-4">
							<div class="col ml-5" style="margin-left: 28% ! important;" >
								<img class="img-fluid"
									src="<%=request.getContextPath()%>/images/header.jpg"
									alt="Header Images" title="Header">
								<h4 class="font-weight-bold  text-uppercase bg-light p-3">ONLINE
									NEW CONNECTION SERVICE(S) FORM</h4>
									</div>
								<div class="row">
									<div class="col-8">
										<div class="mt-5 row ml-2"
											style="border: 5px solid black; width: 50%;">
											<label for="alignRight"
												class="font-weight-bold text-uppercase"
												style="color: black;">Request No</label>
											<div class="col-sm-6">
												<input readonly
													class=" input-class form-control-plaintext font-weight-bold text-uppercase"
													id="requestNo" value="<%=connectionRequest.getRequestNo()%>">

											</div>
										</div>
										<div class="mt-5 ml-2 row">
											<label for="typeOfRegistration">Type Of Registration
											</label>
											<div class="form-group col-md-6">
												<input type="text" class="form-control" readonly
													id="typeOfRegistration" value="<%=connectionRequest.getConsumerType()%>">
													
													
													
												
											</div>
										</div>
										<div class="mt-5 ml-2 row ">
											<h5 class="font-weight-bold">Section 1. Applicant
												Details</h5>
										</div>
									</div>
									<div class="col-4" style="margin-top: 5%;">
									
							<%-- <img class="img-fluid"
											src="<%=%>/images/man.jpeg"
											alt="Side Images" title="man"> 
											
											<iframe id="<portlet:namespace/>document-iframe" src="<%=documentDownloadURL.toString()%>" width="100%" height="100"></iframe>--%>

							<div class="col-sm-5">
								<liferay-util:include page="/document-upload-element.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="elementName" value="applicantPhoto" />
									<liferay-util:param name="documentType" value="Applicant Photo" />
									<liferay-util:param name="documentName" value="Applicant Photo" />
									<liferay-util:param name="fileTypes"
										value="image/png,image/jpeg" />
									<liferay-util:param name="thumbnail" value="true"  />
									<liferay-util:param name="readonly" value="true"/>
									
								</liferay-util:include>
							</div>
						</div>

								</div>
							




							<section class="applicant_details">
			<%if(connectionRequest.getConsumerType().equalsIgnoreCase("Individual")){ %>				
								<div  >

									<!-- <div class="row">
										<div class="col-8 ml-0">
											<h5>
												1a. &nbsp <b>Name of Applicant (specify as mentioned in
													proof of photo identity)</b>
											</h5>
										</div>
										<div class="col-4">
											<h5>
												<a href="#">Edit Consumer Personal Details</a>
											</h5>
										</div>
									</div> -->



									<div class="row ml-2">
									<div class="col-md-2">
									
									<label for="title">Title</label><br>
									<select type="text" 
													id="title">
	<%
		for(Map.Entry<String, String> entry:MasterData.getTitles().entrySet()){
			
		if(connectionRequest.getTitle().equals(entry.getKey())){
%>												
													<option ><%=entry.getValue()%></option>
													
<%}} %>													
												</select>
									
									</div>

										<div class="col-md-3">
											<p>
												<label for="firstName">First name</label><br> <input
													type="text" readonly name="first_name" value="<%=connectionRequest.getFirstName()%>">
											</p>
										</div>

										<div class="col-md-3">
											<p>
												<label for="middleName">Middle name</label><br> <input
													type="text" readonly name="middle_name" value="<%=connectionRequest.getMiddleName()%>">
											</p>
										</div>

										<div class="col-md-3">
											<p>
												<label for="lastName">Last Name</label><br> <input
													type="text" readonly name="last_name" value="<%=connectionRequest.getLastName()%>">
											</p>
										</div>

									</div>




									<h7 class="ml-2">
										1b. <b>Additional Details</b>
									</h7>

									<div class="row ml-2">
										<div class="col-8">
											

											 <div class="row">

												
												<div class="col-8">
													<label for="alignRight"> <input type="radio"  name="son" id="S" disabled>
														Son
													</label > <label for="alignRight"> <input type="radio"  name="daughter" id="D" disabled>
														Daughter
													</label> <label for="alignRight"> <input type="radio"  name="wifeOf"
														id="W" disabled> Wife of
													</label>
												</div>

											</div>
 
											<div class="row">
											
												<div class="col mb-4 ml-2">
													<input type="text" class="form-control" readonly name="father's_husband's_Name" value="<%=connectionRequest.getFatherOrHusbandName()%>">
												</div>
												
											</div>

											

										</div>

										

									</div>

								</div>
								<%} else { %>
								<div>
								
								<div class="row ml-1">
								<div class="col-6">
								<div class="row">
								<div class="col-12 ml-3">
												<label for="company">Firm/Trust/Company/Others Name </label><br> <input
													type="text" readonly class="form-control"  name="company" value="<%=connectionRequest.getFirmName()%>">
											</div>
								</div>
								
							
								<div class="row">
								<div class="col-6 mb-2 ml-3">
												<label for="typeOfOrganisation">Type Of Organisation </label><br> <input
													type="text" readonly name="typeOfOrganisation" value="<%=connectionRequest.getOrganizationType()%>">
											</div>
								<div class="col-5">
												<label for="dateOfIncorporation">Date Of Incorporation </label><br> <input
												style="width: 95%;"	type="date" readonly name="dateOfIncorporation" value="<%=connectionRequest.getIncorporationDate()%>">
											</div>
								
								
								</div>
								</div>
								<div class="col-6">
								<div class="row">
								<div class="col-6 ">
												<label for="authorizedSignatory">Name Of Authorized Signatory </label><br> <input
													type="text" readonly name="authorizedSignatory" value="<%=connectionRequest.getSignatoryName()%>">
											</div>
								<div class="col-6">
												<label for="designationOfSignatory">Designation of Signatory </label><br> <input
													type="text" readonly name="designationOfSignatory" value="<%=connectionRequest.getSignatoryDesignation()%>">
											</div>
								
								
								</div>
								<div class="row">
								<div class="col-6">
												<label for="gstNo">GST No. </label><br> <input
													type="text" readonly name="gstNo" value="<%=connectionRequest.getGstIn()%>">
											</div>
								<div class="col-6">
												<label for="panNo">Pan No. </label><br> <input
													type="text" readonly name="panNo" value="<%=connectionRequest.getPanNo()%>">
											</div>
								
								
								</div>
								
								
								</div>
								</div>
								
								
								
								
								</div>
								<%} %>
							</section>

							<div class="mt-5 row">
								<h5 class="font-weight-bold ml-4">Section 2. Address</h5>
							</div>


							<section class="address">
								<div >

									
									<div class="row mt-2 ml-2">
									<div class="col-6 mb-2">
									<div class="row">
									<div class="col-12">
											<label>Locality</label><br>
										
											<select style="width: 95%;" type="text" class="form-control" id="#">
												<option ><%=LocalityDivisionLocalServiceUtil.getLocalityDivision(Long.parseLong(connectionRequest.getLocality())).getLocalityName()%></option>
												
											</select>
										
									</div>
									
									</div>
									<div class="row">
									<div class="col-6"><label>House No.</label><br>
										
											<input type="text" class="form-control" readonly name="houseNo" value="<%=connectionRequest.getHouseNo()%>"></div>
									<div class="col-6"><label>Floor</label><br>
										
											<select type="text" class="form-control"   id="#">
	<%
		for(Map.Entry<String, String> entry:MasterData.getFloors().entrySet()){
			if(connectionRequest.getFloor().equals(entry.getKey())){
		
%>											
												 <option ><%=entry.getValue()%></option> 
<%}} %>												
											</select></div>
											
										
									
									
									</div>
									<div class="row">
									<div class="col-6"><label>Colony/Area</label><br>
										
											<input type="text" class="form-control" readonly name="colony_area" value="<%=connectionRequest.getColonyArea()%>"></div>
									<div class="col-6"><label>Landmark</label><br>
										
											<select type="text"  class="form-control" id="#">
												 <option ><%=connectionRequest.getLandmark()%></option> 
												
											</select></div>
											
										
									
									
									</div>
									
									</div>
									<div class="col-6 mb-2">
									<div class="row">
									<div class="col-12">
											<label>District</label><br>
										
											<input style="width: 95%;" type="text" readonly class="form-control" name="district" value="<%=connectionRequest.getDistrict()%>">
										
									
									</div>
									</div>
									<div class="row">
									<div class="col-6"><label>Building Name</label><br>
										
											<input type="text" readonly class="form-control" name="buildingName" value="<%=connectionRequest.getBuildingName()%>"></div>
									<div class="col-6"><label>Street</label><br>
										
											<input type="text" readonly class="form-control"  name="street" value="<%=connectionRequest.getStreet()%>"></div>
											
										
									
									
									</div>
									<div class="row">
									<div class="col-6"><label>Landmark Details</label><br>
										
											<input type="text" readonly class="form-control"  name="landmarkDetails" value="<%=connectionRequest.getLandmarkDetails()%>"></div>
									<div class="col-6"><label>City Postal Code </label><br>
										
											<input type="text" readonly class="form-control" name="cityPostalCode" value="<%=connectionRequest.getPinCode()%>"></div>
											
										
									
									
									</div>
									
									</div>
									
									
									
									
									</div>

									

								</div>

							</section>





							<div class="mt-5 row">
								<h5 class="font-weight-bold ml-4">Section 3. Category</h5>
							</div>

							<section class="category">
								<div >

									

									<div class="mt-3 row">

										<div class="form-group col ml-2 ">
										             <label for="alignRight"> <input type="radio"  name="title"  id="1" disabled>
														Permanent
													</label> <label for="alignRight"> <input type="radio"  name="title" id="0" disabled
														> Temporary
													</label> 
											
										</div>

									</div>
									<div class="row ml-2">
									<div class="col-6 ">
									                  <label for="title">Tariff Category</label><br>
									<select type="text"   class="form-control"
													id="tarrifCategory">
<%
		for(Map.Entry<String, String> entry:MasterData.getTariffCategories().entrySet()){
			if(connectionRequest.getTariffCategory().equals(entry.getKey())){
		
%>														
													<option  ><%=entry.getValue()%></option>
<%}} %>													
													
												</select>
									</div>
									<div class="col-4"><p>
												<label for="load">Load (KW)</label><br> <input
													type="text" readonly name="load" value="<%=connectionRequest.getLoadKw()%>">
											</p></div>
									
									
									</div>
									<div class="row ml-2">
									<div class="col-6"><label for="title">Type Of Area</label><br>
									<select type="text"  class="form-control"
													id="typeOfArea">
												<% 	if(connectionRequest.getAreaType().equals("JJCLUSTER")){%>
													<option value="typeOfAreaJJCLUSTER" id="JJCLUSTER">Jhuggi Jhopri Cluster</option>
													<%} else { %>
													<option value="typeOfAreaOTHR" id="OTHR">Others</option>
													<%} %>
												</select></div>
									<div class="col-6"><label for="title">Type of Premises</label><br>
									<select type="text"  class="form-control"
													id="typeOfPremises">
	<%
		for(Map.Entry<String, String> entry:MasterData.getPremisesTypes().entrySet()){
			if(connectionRequest.getPremisesType().equals(entry.getKey())){
%>													
													<option><%=entry.getValue()%></option>
<%}} %>													
												</select></div>
									
									
									</div>


									 <div class="row ml-4 mt-4">
										<h7>
											 <b> Unique Property Identification Code (UPIC) available ? </b>
										</h7>
									</div>
									<div class="row ml-2">
									<label for="alignRight"> <input type="radio"  name="yes"
												 id="true" disabled> Yes
											</label> <label for="alignRight"> <input type="radio" 
												name="yes"  id="false" disabled>
												No
											</label> 
									
									</div>

									
								</div>
							</section>
							<div class="mt-5 row">
								<h5 class="font-weight-bold ml-4">Documents CheckList</h5>
							</div>
							<section class="documents_checklist">
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">1.</span><span> Internal Wiring at the premises has been tested by a Licensed Electrical Contractor/designated officer of the Government and the test Certificate is available with the applicant. </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label > <input type="radio"  name="Wiring"
												 id="Wiringtrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="Wiring"  id="Wiringfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
							<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">2.</span><span> ELCB(Earth Leakage Circuit Breaker) installed ? </span>
				</label>
							</div>
							<div class="col-sm-2">	
							<label for=""> <input type="radio"  name="installed"
												 id="ELCBtrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="installed"  id="ELCBfalse" disabled>
												No
											</label>
							</div>
							</div>
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">3.</span><span> Do you have Stilt Parking? </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="Parking"
												 id="Parkingtrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="Parking"  id="Parkingfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<div class="row mt-2 ml-3">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
				<%if(connectionRequest.getStiltParking()==false){ %>
					<span class="font-weight-bold mr-2">i.</span><span>Is your building height < 15 meters? </span>
					<%} else { %>
					<span class="font-weight-bold mr-2">i.</span><span>Is your building height < 17.5 meters? </span>
					<%} %>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="height"
												 id="heighttrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="height"  id="heightfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<%if(connectionRequest.getStiltParking()==true && (connectionRequest.getHeight15Mtr()==false ||connectionRequest.getHeight17Mtr()==false)){ %>
							<div class="row mt-2 ml-4">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">ii.</span><span>Do you have fire clearance certificate(FCC) ? </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="FCC"
												 id="FCCtrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="FCC"  id="FCCfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<%} %>
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">4.</span><span>  Lift is installed in premises and the applicant has obtained the lift fitness certificate from the Electrical Inspector for the lift in the said premises and the same is available with the applicant. </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="Lift"
												 id="Lifttrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="Lift"  id="Liftfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							
							<%if(connectionRequest.getTariffCategory().equals("0250")){ %>
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">5.</span><span>Do you have agriculture certificate from Block Development Officer(BDO)? </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="agriculture"
												 id="agriculturetrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="agriculture"  id="agriculturefalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<%} else { %>
							<div class="row mt-2 ml-2">
							<div class="col-sm-8">
				<label for="" class="font-weight-bold col-form-label">
					<span class="font-weight-bold mr-2">6.</span><span>Do you want to avail E-Services on Email?
 </span>
				</label>
			
			</div>
						<div class="col-sm-2">	
							
							<label for=""> <input type="radio"  name="Email"
												 id="Emailtrue" disabled> Yes
											</label> <label for=""> <input type="radio" 
												name="Email"  id="Emailfalse" disabled>
												No
											</label> 
							
							
							
							</div>
							
							
							</div>
							<%} %>
							</section>
							<div class="mt-5 row">
								<h5 class="font-weight-bold ml-4">Uploaded Documents</h5>
							</div>


							<section class="uploaded_documents">
								<div class="col ml-4" >
									<table style="width: 100%">
										<tr>
											<th>S.No.</th>
											<th>Document Name</th>
											<th>Document Type</th>
											<th>Download/Show</th>

										</tr>
									<% 
										int i=1;
										for(ConnectionDocument connectionDocument2:connectionDocumentList){
											if(connectionDocument2.getDocumentType().equalsIgnoreCase("Applicant Photo")||connectionDocument2.getDocumentType().equalsIgnoreCase("Applicant Signature"))
												continue;
									%>
										<tr>
											<td><%=i++ %></td>
											<td><%=connectionDocument2.getDocumentName() %></td>
											<td><%=connectionDocument2.getDocumentType() %></td>
											<td><button Class="btn-primary m-1"  id="btnShow" value="Show" onClick="viewDocument(<%=connectionDocument2.getConnectionDocumentId() %>)" >View</button></td>
										</tr>
									<%
										}
									%>
									</table>
								</div>
							</section>
							<div class="mt-5 row">
								<h5 hidden class="font-weight-bold ml-4">Declaration</h5>
							</div>


							<section class="declaration" >
								<div >
									<div class="row ml-1 mr-1 declaration_paragraph">
										<p>
											1.That no objection certificate for seeking electricity
											connection from the co-owner has been obtained (in case the
											applicant is not the sole owner of the premises).<br> 2.
											To indemnify the licensee against all proceedings, claims,
											demands, costs, damages, expenses that the licensee may incur
											by reason of a fresh service connection given to the
											Applicant.<br> 3. That to the best of applicants
											knowledge, all electrical works done within the premises are
											as per Central Electricity Authority(Measures relating to
											Safety and Electricity Supply) Regulations, 2010 as amended
											from time to time.<br> 4. That the internal Wiring at
											the premises has been tested by a Licensed Electrical
											Contractor/designated officer of the Government and the test
											certificate is available with the applicant.<br> *In
											case of Government Quarters/Offices,<br> 5. That the
											building has been constructed as per prevalent building
											Bye-Laws and the fire clearance certificate, if required, is
											available with the applicant.<br> 6. *That there is a
											provision of lift in the premises and the applicant has
											obtained the lift fitness certificate from the Electrical
											Inspector for the lift in the said premises and the same is
											available with the applicant.<br> *Strike out which is
											not applicable<br> 7. That the applicant has applied for
											the correct category of tariff as per the applicable tariff
											schedule. For either of the following categories of
											connection, the applicant has the relevant documents
											available with him.<br> <strong>A.Industrial
												(Tick whichever is available)</strong><br> a.(i)Valid Industrial
											License; <strong>or</strong><br> (ii)Factory License; <strong>or</strong><br>
											(iii)Household Licence; <strong>or</strong><br> (iv)Lal
											Dora Certificate in case of rural village; <strong>or</strong><br>
											(v)Any other document authorizing the applicant to run the
											industry; <strong>OR</strong><br>
											b.(i)Occupancy-cum-completion certificate from concerned
											Municipal Corporation or DDA; <strong>or</strong><br>
											(ii)Consent to Establish from Delhi Pollution Control
											Committee (DPCC) ; <strong>or</strong><br>
											(iii)Provisional Industrial License ; <strong>or</strong><br>
											(iv)Sanctioned building plan from concerned Municipal
											Corporation or DDA<br> <strong>B.Agricultural
												Consumers</strong><br> (i) Certificate of Residence from Block
											Development Officer<br> <strong>C.Non-domestic
												for Khokhas and Temporary Structure</strong><br> (i) The Bazaari
											Receipt Number ; or<br> (ii) No Objection Certificate
											for Khokha/Temporary Structure from concerned Municipal
											Corporation of Delhi or Delhi Development Authority or any
											other concerned Land<br> Owning Agency Please provide
											following information in respect of certificate available
											with the applicant (Certificate No., issuing authority, date
											of issue, Purpose, validity, if applicable)<br> <strong>D.Charging
												station for electric vehicles</strong><br> An undertaking by the
											applicant that the charging station for electric vehicles is
											as per the specifications as may be specified by Central
											Electricity Authority or Bureau of Indian Standards from time
											to time.<br> 8.*That the industrial connection is taken
											based on the documents mentioned in clause 7A(b) above and I
											shall obtain the valid document as mentioned in clause 7A(a)
											above within a period of 3 months from issue of electricity
											connection.<br> *Strike out if not applicable.<br>
											9.That above referred applicable documents/certificates
											indicated at various points are available with me and can be
											inspected by the Licensee at any time. In case of failure or
											reluctance to produce/allow the inspection of said
											documents/certificates the licensee may disconnect the
											connection granted owing to such failure/, reluctance.<br>
											10.That I shall provide a legible and certified copy of any
											of above applicable documents to the licensee pursuant to
											order/request of any government agency, judicial forum or any
											other authority seeking such information.<br> 11.That my
											industry/trade has not been declared to be releasing
											obnoxious hazardous/pollutant by any government agency and
											that no orders of any Court or judicial authority would be
											breached by running of my industry/trade or granting any
											electricity connection to the same. The licensee is
											indemnified against any loss accrued by the applicant on this
											account that on an Order issued by a Court of law or judicial
											authority or any government agency for disconnection of
											electricity, the licensee may disconnect the supply.<br>
											12.That I shall indemnify and hold harmless, the licensee, in
											case of any injury or incident on account of any fault in
											electrical work in the premises, and the licensee shall not
											be liable for any mishap or incident occurring at the
											premises to the applicant on account of any
											faulty/defective/inferior quality wiring at the premises for
											which the connection is being applied.<br> 13.To pay the
											electricity consumption bills and all other charges at the
											rates set out in the licensee's Tariff Schedule and
											miscellaneous charges for supply as may be in force from time
											to time, regularly as and when the same becomes due for
											payment.<br> 14.To deposit the additional security
											deposit and additional service line cum development (SLD)
											charges, if any from time to time based on the prevailing
											Orders/rules, directions and Regulations of the Commission.<br>
											15.To abide by the provisions of the Electricity Act, 2003,
											all applicable laws, conditions of Supply/Tariff Orders and
											any other Rules or Regulations as may be notified by the
											Commission, as applicable from time to time.<br> 16.That
											licensee shall be at liberty to adjust the electricity
											consumption charges due/outstanding along with any other
											charges against the Consumer Security Deposit paid by the
											Applicant, in the event of termination of the agreement prior
											to expiry of the contracted period or in case of any
											contractual default as per provisions of regulations/rules/
											orders/directions of the Commission.<br> 17.That as per
											Delhi Electricity Regulatory Commission (Supply Code and
											Performance Standards) Regulations, 2017 or as amended from
											time to time, I shall provide suitable and adequate land
											space for installation of the meter/electrical equipments
											where the licensee may have ready access to the same.<br>
											18. To allow clear and un-encumbered access to the meters for
											the purpose of meter reading and it's checking etc.<br>
											19. That the licensee may disconnect the electric supply
											under reference, in the event of any default, non-compliance
											of statutory provisions and in the event of a legally binding
											directive by Statutory Authority (ies) to effect such an
											order. This shall be without prejudice to any other rights of
											the licensee including that of getting its payment as on the
											date of disconnection.<br> 20. All the above declaration
											given by the Applicant shall be construed to an Agreement
											between the licensee and the Applicant.<br> 21. That the
											applicant is having the approval for safety and/or fire
											clearance for EV charging station wherever applicable from
											the concerned department such as Petroleum and Explosives
											Safety Organization (PESO), Fire Department etc.<br> 22.
											That I/the applicant do hereby confirm and undertake that in
											case of falling within the requirement as stated below:<br>
											(i) Total cumulative demand of all floors in the plot/
											building for LT service connection exceeds 100 kW/ 108 kVA; <strong>or</strong><br>
											(ii) Total cumulative built up area of the premises in the
											plot/building exceeds 1000 sqm; <strong>or</strong><br>
											(iii) Plot of size above 500 sqm or above;<br> I/the
											applicant shall unconditionally and unequivocally provide the
											space along with right to access, without any charge & in
											perpetuity, for installation of Distribution Transformer to
											BRPL to energize my connection along with supply to other
											outside consumers and shall execute all other documents
											including Sub-station Space Agreement/ Affidavit as notified
											by BRPL time to time.<br> 23. If Unique Property
											Identification Code (UPIC) is not submitted, I declare that I
											will submit it with BRPL, whenever it is issued to me by the
											concerned authorities.
										</p>
									</div>
								</div>
							</section>
							<div class="mt-5 row">
								<h5 hidden class="font-weight-bold ml-4">Declaration for Building
									Height</h5>
							</div>


							<section class="declaration_for_building_height" >
								<div>
									<div class="row ml-1  mr-1 declaration_for_building_height_paragraph">
										<p>
											I, (hereinafter referred to as <sup>"</sup>Applicant<sup>"</sup>,
											which term shall mean and include executors, administrators,
											heirs, successors and assigns), do hereby swear and declare
											as under: A. That the Applicant / deponent is owner /
											occupant of the premises. &nbsp<br> B. That I have
											applied for new connection (Domestic/ Non-domestic/
											Industrial at the above-mentioned address<br> C. That I
											have submitted the ownership / occupancy documents of the
											said premises / property / flat.<br> D. I understand
											that mere release of electrify connection / installation of
											meter/issuance of bill for the use of electricity shall not
											be termed as confirming any ownership or other rights over
											the concerned land or premise.<br> E. The deponent
											undertakes:-<br> (a) The dwelling unit where electricity
											connection is applied is within the height of 15 meters
											without stilt parking/ 17.5 meters with stilt parking of the
											building.<br> (b) The electricity connection granted to
											the premises will not be used for extending electricity
											supply to other dwelling units.<br> (c) In case, it
											comes to my knowledge that there is illegal extension of
											supply or electricity is used at dwelling units beyond the
											height of 15 meters without stilt parking/ 17.5 meters with
											stilt parking of the building, I will promptly bring the same
											to the DISCOM<sup>'</sup>s notice.<br> (d) I do hereby
											confirm and agree that I shall ensure that NO illegal
											extension of supply or electricity is used at dwelling units
											beyond the height of 15 meters without stilt parking / 17.5
											meters with stilt parking of the building from my connection.
											I do hereby undertake that in case the illegal extension of
											supply or electricity is used from my connection at dwelling
											units beyond the height of 15 meters without stilt parking /
											17.5 meters with stilt parking of the building, I shall be
											liable to pay all outstanding bill of the said unit along
											with the bill as assessed by BSES without disputing the
											assessment and / or raising any claim whatsoever and the
											DISCOM shall be free to disconnect the electricity connection
											immediately, without any notice.<br> F. I hereby
											undertake that I shall be using electricity for purposes
											applied for & shall not use / permit to use in any other
											manner.<br> G. I agree and confirm that in case of any
											declaration containing in the instant undertaking is found
											false at any later occasion, the same shall be mutatis
											mutandis be termed as breach of the agreement between BRPL
											and the deponent, and BRPL shall be free to take all such
											action as permitted under law including the same related to
											breach of terms of agreement.<br> H. I declare that the
											above statements are true and correct, and I shall be
											unequivocally liable to abide the terms stated in this
											undertaking cum affidavit.
										</p>

									</div>
								</div>
							</section>
							<div class="mt-5 row">
								<h5 class="font-weight-bold ml-4">Signature</h5>
							</div>


							<section class="signature">
								<div class="container">
									<div class="row ml-1">

										<div class="row">
											<h6>
												<b>Signature of Applicant/Authorized Signatory or Thumb
													Impression</b>
											</h6>

										</div>
								<div class="col-md-5">
									<liferay-util:include page="/document-upload-element.jsp"
										servletContext="<%=application%>">
										<liferay-util:param name="elementName"
											value="applicantSignature" />
										<liferay-util:param name="documentType"
											value="Applicant Signature" />
										<liferay-util:param name="documentName"
											value="Applicant Signature" />
										<liferay-util:param name="fileTypes"
											value="image/png,image/jpeg" />
										<liferay-util:param name="thumbnail" value="true" />
										<liferay-util:param name="readonly" value="true"/>
									</liferay-util:include>
								</div>
							</div>
								</div>
							</section>

							<!-- <section class="sap_upload mt-2">
								<div class="container">

									<div class="row ml-1 mt-2 mb-2">
										<div class="col-4">
											<h6>
												<b> Application From(PDF) : </b>
											</h6>
										</div>
										<form action="#">

											<input type="file" id="myFile" name="filename">
											<button type="submit">Sap Upload</button>
										</form>
									</div>

								</div>
							</section> -->



						</div>
					</div>
				</div>
			</div>
		



	<button onclick="window.print()" style="margin-left: 30%; width: 6%;">Print
	</button>
<aui:script use="aui-base, liferay-preview, liferay-util-window"> 
document.getElementById("<%=connectionRequest.getSonDaughterWife()%>").checked=true;

document.getElementById("<%=connectionRequest.getConnectionType()%>").checked=true;


document.getElementById("<%=connectionRequest.getUpicAvailable()%>").checked=true;
document.getElementById("Wiring<%=connectionRequest.getWiringTest()%>").checked=true;
document.getElementById("ELCB<%=connectionRequest.getElcbInstalled()%>").checked=true;
document.getElementById("Parking<%=connectionRequest.getStiltParking()%>").checked=true;
document.getElementById("height<%=connectionRequest.getHeight15Mtr()%>").checked=true;
<%-- document.getElementById("height<%=connectionRequest.getHeight17Mtr()%>").checked=true; --%>
<%if(connectionRequest.getStiltParking()==true && (connectionRequest.getHeight15Mtr()==false ||connectionRequest.getHeight17Mtr()==false)){ %>
document.getElementById("FCC<%=connectionRequest.getFcc()%>").checked=true;
<%} %>
document.getElementById("Lift<%=connectionRequest.getLift()%>").checked=true;

<%if(connectionRequest.getTariffCategory().equals("0250")){ %>
document.getElementById("agriculture<%=connectionRequest.getAgriConsumer()%>").checked=true;
<%} else { %>
document.getElementById("Email<%=connectionRequest.getEServiceOnMail()%>").checked=true;
<%} %>

</aui:script>

<script>
function viewDocument(connectionDocumentId){
	
	window.location.href='<%=documentViewerURL.toString()%>&<portlet:namespace/>connectionDocumentId='+connectionDocumentId;
}


</script>
</body>

</html>