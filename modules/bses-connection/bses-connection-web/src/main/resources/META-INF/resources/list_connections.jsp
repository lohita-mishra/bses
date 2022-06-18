<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.bses.connection2.util.RequestTypeModeStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.bses.connection2.web.model.MasterData"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<style>
.modal{
	display:none;
}
</style>
<%
	String mobileNo=ParamUtil.getString(request, "mobileNo", "");
	String emailId=ParamUtil.getString(request, "emailId", "");
%>
<portlet:renderURL var="newConnectionURL">
	<portlet:param name="mvcPath" value="/new_connection.jsp" />
	<portlet:param name="mobileNo" value="<%=mobileNo%>" />
	<portlet:param name="emailId" value="<%=emailId%>" />
</portlet:renderURL>

<portlet:renderURL var="editConnectionURL">
	<portlet:param name="mvcPath" value="/new_connection.jsp" />
	<portlet:param name="mobileNo" value="<%=mobileNo%>" />
	<portlet:param name="emailId" value="<%=emailId%>" />
</portlet:renderURL>

<portlet:renderURL var="deleteConnectionURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/delete_connection.jsp" />
</portlet:renderURL>
<portlet:renderURL var="listConnectionURL">
	<portlet:param name="mvcPath" value="/list_connections.jsp" />
	<portlet:param name="mobileNo" value="<%=mobileNo%>" />
	<portlet:param name="emailId" value="<%=emailId%>" />
</portlet:renderURL>
<%
	session.removeAttribute(ConnectionRequest.class.getName()+"#id");
	List<ConnectionRequest> connectionRequestList=(List)request.getAttribute(ConnectionRequest.class.getName()+"#list");
	if(connectionRequestList==null){
		connectionRequestList=ConnectionRequestLocalServiceUtil.getConnectionRequestsByMobileNoAndRequestStatus(mobileNo, RequestTypeModeStatus.STATUS_DRAFT);
	}
	DateFormat dateFormat=new SimpleDateFormat(PropsUtil.get("display.datetime.format"));
%>
<div class="card card-primary bg-light mb-2">
	<div class="card-header">
		<div class="container-fluid p-1">
			<div class="row">
				<div class="col-md-6">
					<h6><liferay-ui:message key="list-connection-title" /></h6>
				</div>
				
				<div class="col-md-6">
					<div class="float-right">
						
						<a href="#" class="btn btn-link text-danger"><i class="fas fa-check-double" aria-hidden="true"></i> Important Guidlines</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-body">
		<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center font-weight-bold text-danger">
<%
	int count=5;
	try{
		count=Integer.parseInt(PropsUtil.get("connection.request.draft.max.count").trim());
	}catch(Exception e){}

	if(connectionRequestList.size()>0){
%>		
				<liferay-ui:message key="list-connection-existing-connection-alert" arguments="<%=connectionRequestList.size() %>"/>
<%
	}

	if(connectionRequestList.size()<count){
%>	
				<liferay-ui:message key="list-connection-create-new-connection"/>			
				<a href="#" class="btn-primary text-white p-2 ml-3" id="<portlet:namespace/>applyOnlineBtn" value="New Connection">New Connection</a>
<%
	}
%>				
			</div>
		</div>
		</div>
		<div class="table-responsive shadow bg-white mx-3 p-4 mt-4 w-100">
			<table class="table table-sm table-bordered">
				<thead class="bg-light">
					<tr>
						<th scope="col">Request No</th>
						<th scope="col">Company</th>
						<th scope="col">District</th>
						<th scope="col">Request Type</th>
						<th scope="col">Name</th>
						<th scope="col">Email Id</th>
						<th scope="col">Mobile No</th>
						<th scope="col">Entry Date</th>
					</tr>
				</thead>
				<tbody>
<%
				for(ConnectionRequest r:connectionRequestList){
					
					String name=MasterData.getTitleValue(r.getTitle())+" "+r.getFirstName()+(StringUtils.isNotBlank(r.getMiddleName())?" "+r.getMiddleName():"")+(StringUtils.isNotBlank(r.getLastName())?" "+r.getLastName():"");
					//System.out.println("name = "+name);
%>				
					<tr>
						<td class="d-flex align-items-center"><span class="text-primary"> <a href=""><%=r.getRequestNo() %></a></span> <span class="btn-group ml-2">
								<button type="button" class="btn btn-primary edit-connection-btn" data-toggle="tooltip" data-placement="top" title="Edit" value="Edit" data-id="<%=r.getConnectionRequestId()%>" data-rno="<%=r.getRequestNo()%>">
									<%--<i class="fas fa-pencil-alt fa-sm text-primary"></i> --%>
									<i class="icon-edit"></i>
								</button>
								
								<button type="button" class="btn btn-danger delete-connection-btn ml-1 " data-placement="top" data-toggle="tooltip" title="Delete" value="Delete" data-id="<%=r.getConnectionRequestId()%>" data-rno="<%=r.getRequestNo()%>">
									<%--<i class="far fa-trash-alt fa-sm text-danger"></i>--%>
									<i class="icon-trash"></i>
								</button>
						</span></td>
						<td>BRPL</td>
						<td>Nehru Place</td>
						<td><%=RequestTypeModeStatus.getRequestType(StringUtils.trim(r.getRequestType()))%></td>
						<td><%=StringUtils.trim(name)%></td>
						<td><%=StringUtils.trim(r.getEmailId()) %></td>
						<td><%=StringUtils.trim(r.getMobileNo()) %></td>
						<td><%=dateFormat.format(r.getCreateDate())%></td>
					</tr>
<%
				}
%>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="modal" id="delete-connection-modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header" style="border-bottom: none;">
				<h5 class="modal-title">Delete Connection Request?</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body align-items-center justify-content-center" style="padding-top:25px; padding-bottom:25px;">
				<div class="help-text text-danger text-center fs-18">
					<!-- i class="far fa-paper-plane fa-fw text-danger"></i-->
					Are you sure to delete the request no <span class="font-weight-bold" id="delete-connection-request-no"></span> ?
				</div>
			</div>
			<div class="modal-footer align-items-center justify-content-center">
				<div class="text-danger text-center">
					<button type="button" class="btn btn-danger btn-sm" id="delete-connection-yes-btn" value="Yes" data-id="">Yes</button>
					<button type="button" class="btn btn-primary btn-sm" id="delete-connection-no-btn" value="No">No</button>
				</div>
			</div>
		</div>
	</div>
</div>


<aui:script use="aui-modal,aui-overlay-manager">
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		$("#<portlet:namespace/>applyOnlineBtn").click(function(){
			window.location.href='<%=newConnectionURL.toString()%>';	
		});
		
		$(".edit-connection-btn").click(function(){
			window.location.href='<%=editConnectionURL.toString()%>&<portlet:namespace/>connectionRequestId='+$(this).attr("data-id");
		});
		
		$(".delete-connection-btn").click(function(){
			$('#delete-connection-yes-btn').attr('data-id', $(this).attr("data-id"));
			$('#delete-connection-request-no').html($(this).attr("data-rno"));
			$('#delete-connection-modal').modal('show');
		});
		
		Liferay.provide(
			window,
			'<portlet:namespace />listConnections_closeDialog',
			function(data) {
				if(data){
					console.log(data);	
				}
				var dialog = Liferay.Util.Window.getById('<portlet:namespace/>'+data.dialogId);
				dialog.destroy();
				if(data.refresh){
					window.location.href='<%=listConnectionURL%>';
				}
			},
			['liferay-util-window']
		);
		
		$("#delete-connection-yes-btn").click(function(){
			deleteConnection($(this).attr('data-id'));
		});
		$("#delete-connection-no-btn").click(function(){
			$('#delete-connection-modal').modal('hide').data('bs.modal', null );
		})
		
		blinkText();
	});
	
	function deleteConnection(connectionRequestId){
		Liferay.Service('/bsesconn.connectionrequest/delete-by-connection-request-id', 
			{
				"connectionRequestId" : connectionRequestId
			},
			function(response) {	
				var message="Record deletion failed.";
				if(response!=true){
					message="Record deletion failed.";
				}
				$('#delete-connection-modal').modal('hide').data('bs.modal', null );
				if(response==true){
					window.location.href="<%=listConnectionURL.toString()%>";
				}
			}
		);	
	}
	
	function blinkText(){
		setInterval(function () {
			$(".blink").each(function( index ) {
				console.log($(this).css("opacity"));
	            $(this).css("opacity", 
	            ($(this).css("opacity") == 0 ? 1 : 0));
	       
			});
		}, 1000);
	}
</aui:script>