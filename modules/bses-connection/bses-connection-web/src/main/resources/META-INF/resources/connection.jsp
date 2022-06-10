<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
%>
<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formAction" value="saveConnection" />
</portlet:actionURL>

<aui:form role="form" class="CustomForm" id="connectionForm" section-attr="connection">
	<div class="container-fluid bg-white shadow p-5 my-3">
		<div class="row">
			<div class="col-md-12">
				<h6 class="font-weight-bold my-3 text-uppercase bg-light p-3"><liferay-ui:message key="connection-section-title" /></h6>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<div class="form-check form-check-inline">
					<aui:input class="form-check-input" type="radio" name="connectionType" value="1" checked="true" label="connection-type.permanent" /> <%--<label class="form-check-label text-primary"
						for="exampleRadios1" style="font-size: 16px;"> <liferay-ui:message key="connection-type-permanent" /></label>--%>
				</div>
				<div class="form-check form-check-inline">
					<aui:input class="form-check-input" type="radio" name="connectionType" value="2" label="connection-type.temporary" /> <%--<label class="form-check-label text-primary" for="exampleRadios2"
						style="font-size: 16px;"><liferay-ui:message key="connection-type-permanent" /></label>--%>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<%--<label class="font-weight-bold">Tariff Category</label>--%> 
				<aui:select class="form-control" name="tariffCategory" label="connection-tariff-category">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getTariffCategories().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=(StringUtils.isBlank(requestEntity.getTariffCategory()) && entry.getKey().equals("0100")) || StringUtils.equals(requestEntity.getTariffCategory(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>

			<div class="form-group col-md-3" id="loadkvadiv">
				<%--<label class="font-weight-bold">Load (KVA) </label>--%> 
				<aui:input type="number" class="form-control" disabled="true" name="loadKva" label="connection-load-kva" value="<%=requestEntity.getLoadKva() %>"/>
				<p class="help-text fs-13 mt-1 p-1 text-danger d-none" style="background: #ffff00;">Note: ELCB Bill copy is required for more then or equal to
					2 KW.</p>
			</div>

			<div class="form-group  col-md-3">
				<%--<label class="font-weight-bold">Load (KW) </label>--%> 
				<aui:input type="number" class="form-control" name="loadKw" label="connection-load-kw" value="<%=requestEntity.getLoadKw() %>"/>
				<p class="help-text fs-13 mt-1 p-1 text-danger d-none" style="background: #ffff00;">Note: ELCB Bill copy is required for more then or equal to
					2 KW.</p>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<%--<label>Type of area</label>--%> 
				<aui:select class="form-control" name="areaType" label="connection-area-type">
					<aui:option value="" label="-Select-" />
					<!-- option value="DDA_CGHS">Govt. House/DDA Flat/CGHS Flat</option> -->
					<aui:option value="JJCLUSTER" label="Jhuggi Jhopri Cluster" selected="<%=StringUtils.equals(requestEntity.getAreaType(),"JJCLUSTER")%>" />
					<aui:option value="OTHR" label="Others" selected="<%=StringUtils.equals(requestEntity.getAreaType(),"OTHR")%>" />
					<aui:validator name="required"/>
				</aui:select>
			</div>

			<div class="form-group col-md-6">
				<%--<label>Type of Premises</label>--%> 
				<aui:select class="form-control" name="premisesType" label="connection-premises-type">
					<aui:option value="" label="-Select-" />
<%
		for(Map.Entry<String, String> entry:MasterData.getPremisesTypes().entrySet()){
%>	
			<aui:option value="<%=entry.getKey()%>" label="<%=entry.getValue()%>" selected="<%=StringUtils.equals(requestEntity.getPremisesType(), entry.getKey())%>"/>
<%
		}
%>
					<aui:validator name="required"/>
				</aui:select>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<div class="form-group">
				<%--<label>Unique property Identification Code(UPIC) available?</label>--%>
				<label class="control-label"><liferay-ui:message key="connection-upic-available" /></label>
				
				<div class="">
					<div class="form-check form-check-inline">
						
						<aui:input class="form-check-input" type="radio" name="upic" id="upicYes" value="1" label="Yes" checked="<%=requestEntity.getUpicAvailable()%>"/> <%--<label class="form-check-label text-primary"
							for="exampleRadios1" style="font-size: 16px;"> <liferay-ui:message key="connection-type-permanent" /></label>--%>
						
					</div>
					<div class="form-check form-check-inline">
						<aui:input class="form-check-input" type="radio" name="upic" id="upicNo" value="2" label="No" checked="<%=!requestEntity.getUpicAvailable()%>"/> <%--<label class="form-check-label text-primary" for="exampleRadios2"
							style="font-size: 16px;"><liferay-ui:message key="connection-type-permanent" /></label>--%>
					</div>
				</div>
				</div>
				 <%--
				 <aui:select class="form-control" name="upicAvailable" label="connection-upic-available">
					<option>-Select-</option>
					<option value="1">Yes</option>
					<option value="0">No</option>
				</aui:select>
				 --%>
			</div>

			<div class="form-group col-md-6" id="upicnodiv">
				<%--<label>Unique Property Identification Code (UPIC Number)<span class="text-danger">*</span></label>--%>
				<aui:input type="text" class="form-control" name="upicNo" label="connection-upic" value="<%=requestEntity.getUpic()%>"/>
			</div>
		</div>
	</div>
</aui:form>