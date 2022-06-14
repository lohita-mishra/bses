<%@page
	import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
	long connectionRequestId = ParamUtil.getLong(request, "connectionRequestId", 0);
	String mobileNo = ParamUtil.getString(request, "mobileNo", "");
	String emailId = ParamUtil.getString(request, "emailId", "");
	ConnectionRequest connectionRequest = ConnectionRequestLocalServiceUtil
			.getConnectionRequest(connectionRequestId);
	ConnectionRequestLocalServiceUtil.deleteConnectionRequest(connectionRequestId);
%>
<portlet:renderURL var="listConnectionURL">
	<portlet:param name="mvcPath" value="/list_connections.jsp" />
	<portlet:param name="mobileNo" value="<%=mobileNo%>" />
	<portlet:param name="emailId" value="<%=emailId%>" />
</portlet:renderURL>
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<div class="card mt-5" style="width:400px;">
				<div class="card-header">
					<h5>Delete Connection Request</h5>
				</div>
				<div class="card-body">
					Connection Request <span class="font-weight-bold"><%=connectionRequest.getRequestNo()%></span>
					was deleted successfully!
				</div>
				<div class="card-footer">
					<button type="button" class="btn btn-primary btn-sm" id="ok-btn"
						value="OK">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		$("#ok-btn").click(function(){
			window.location.href='<%=listConnectionURL.toString()%>';
		});
	})
</script>
