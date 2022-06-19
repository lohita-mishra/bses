<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.bses.connection2.service.LocalityDivisionLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.LocalityDivision"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
	ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
	List<LocalityDivision> localityList=LocalityDivisionLocalServiceUtil.getLocalityDivisions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	LocalityDivision localityDistrict=null;
	if(StringUtils.isNotBlank(requestEntity.getLocality())){
		localityDistrict=LocalityDivisionLocalServiceUtil.getLocalityDivision(Long.parseLong(requestEntity.getLocality()));	
	}
	
%>
<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formAction" value="saveAddress" />
</portlet:actionURL>

<aui:form cssClass="custom-form form-auto-save" role="form" name="addressForm" id="addressForm" section-attr="address">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="text-uppercase text-body font-weight-bold bg-light p-3"><liferay-ui:message key="address-section-title" /></h6>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<%--<label class="font-weight-bold">Locailty<span class="text-danger">*</span></label>--%> 
				<aui:select cssClass="select2" name="locality" label="address-locality">
					<aui:option value="" label="-Select-" />
<%
				for(LocalityDivision ld:localityList){
%>				
					<aui:option value="<%=ld.getLocalityDivisionId()%>" label="<%=ld.getLocalityName()%>" selected="<%=StringUtils.equals(requestEntity.getLocality(), String.valueOf(ld.getLocalityDivisionId())) %>"/>	
<%
				}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>

			<div class="form-group col-md-6">
				<%--<label class="font-weight-bold">District <span class="text-danger">*</span></label>--%> 
				<%--<aui:select class="form-control select2" name="district" label="address-district">
					<option>-Select-</option>
					<option>Central Delhi</option>
					<option>East Delhi</option>
					<option>New Delhi</option>
					<option>North Delhi</option>
					<option>North East Delhi</option>
					<option>North West Delhi</option>
					<option>Shahdara</option>
					<option>South Delhi</option>
					<option>South East Delhi</option>
					<option>South West Delhi</option>
					<option>West Delhi</option>
					<aui:validator name="required"/>
				</aui:select> --%>
				<aui:input type="hidden" name="district" label="" value="<%=(localityDistrict!=null?localityDistrict.getDivisionCode():"")%>" />
				<aui:input type="text" name="districtName" label="address-district" value="<%=(localityDistrict!=null?localityDistrict.getDivisionName():"")%>" readonly="true" />
			</div>

			<div class="form-group col-md-3">
				<%--<label>House No. <span class="text-danger">*</span></label>--%> 
				<aui:input type="text" name="houseNo" label="address-house-no" value="<%=requestEntity.getHouseNo()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Floor <span class="text-danger">*</span></label>--%> 
				<aui:select class="form-control select2" name="floor" label="address-floor" >
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getFloors().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getFloor(), entry.getKey())%>"/>
<%
		}
%>
				
				</aui:select>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Building Name</label>--%> 
				<aui:input type="text" class="form-control" name="buildingName" label="address-building-name" value="<%=requestEntity.getBuildingName()%>">
					<%--<aui:validator name="required"/> --%>
				</aui:input>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Street <span class="text-danger">*</span></label>--%> 
				<aui:input type="text" class="form-control" name="street" label="address-street" value="<%=requestEntity.getStreet() %>">
					<aui:validator name="required"/>
				</aui:input>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Colony/Area <span class="text-danger">*</span></label>--%> 
				<aui:input type="text" class="form-control" name="colonyArea" label="address-colony-area" value="<%=requestEntity.getColonyArea()%>">
					<aui:validator name="required"/>
				</aui:input>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Landmark</label>--%> 
				<aui:select type="text" class="form-control" name="landmark" label="address-landmark">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getLandmarks().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equalsIgnoreCase(requestEntity.getLandmark(), entry.getKey())%>"/>
<%
		}
%>
				</aui:select>
			</div>

			<div class="form-group col-md-3">
				<%--<label>Landmark Details</label>--%> 
				<aui:input type="text" class="form-control" name="landmarkDetail" label="address-landmark-detail" value="<%=requestEntity.getLandmarkDetails()%>">
				
				</aui:input>
			</div>

			<div class="form-group col-md-3">
				<%--<label>City Postal Code <span class="text-danger">*</span></label>--%>
				<aui:input type="number" class="form-control" name="pinCode" label="address-pin-code" value="<%=requestEntity.getPinCode()%>">
					<aui:validator name="required"/>
					<aui:validator name="min">110001</aui:validator>
					<aui:validator name="max">110110</aui:validator>
				</aui:input>
			</div>
		</div>
		<div class="row" id="registered-address-row">
			<div class="form-group col-md-6">
				<%--<label>Building Name</label>--%> 
				<aui:input type="textarea" class="form-control" name="registeredAddress" col="300" row="5" label="address-registered-address" value="<%=requestEntity.getRegisteredAddress() %>">
				</aui:input>
			</div>
		</div>
	</div>
</aui:form>
