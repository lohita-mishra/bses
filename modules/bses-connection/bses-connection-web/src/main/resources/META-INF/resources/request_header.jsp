<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
%>
<div class="container-fluid p-1">
	<div class="row">
		<div class="col-md-6">
			<h6 class="mt-3" style="font-weight: 700;">
<%
	if(requestEntity.getRequestType().equalsIgnoreCase(RequestTypeModeStatus.TYPE_NEW_CONNECTION)){
		if(requestEntity.getRequestMode().equalsIgnoreCase(RequestTypeModeStatus.MODE_ONLINE)){
%>
		Online Services / New Connection / Apply Online 
<%			
		}else{
%>
		Online Services / New Connection / Appointment for Visit 
<%			
		}
	}else{
%>	
		Online Services / Change Request	
<%
	}
%>			
			Request No: <%=requestEntity.getRequestNo() %></h6>
		</div>
		<div class="col-md-6">
			<div class="float-right">
				<a href="#" class="btn btn-link text-danger"><i class="fas fa-check-double" aria-hidden="true"></i> Important Guidlines</a>
			</div>
		</div>
	</div>
</div>
