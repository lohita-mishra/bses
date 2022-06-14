<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>

<%
long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
ConnectionRequest requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);

%>
<div class="card card-primary  mb-2">
	<div class="card-header">
		<h6>Please verify your email </h6>
		 <label data-error="wrong" data-success="right" for="defaultForm-email">Email</label>
	 </div>
	<div class="card-body">
		<label data-error="wrong" data-success="right" for="defaultForm-pass">OTP</label>
         <input type="number" id="otp" class="form-control validate">
         <button type="button" class="btn btn-primary btn-sm" id="ok-btn" onclick="">Submit</button>
	</div>
</div>