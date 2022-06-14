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

<portlet:renderURL var="deleteConnectionURL">
	<portlet:param name="mvcPath" value="/delete_connection.jsp" />
	<portlet:param name="mobileNo" value="<%=mobileNo%>" />
	<portlet:param name="emailId" value="<%=emailId%>" />
</portlet:renderURL>

<%
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
			<div class="col-md-12 text-center">
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
								<button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="tooltip" data-placement="top" title="Edit" value="Edit" data-id-attr="<%=r.getConnectionRequestId()%>" data-rno-attr="<%=r.getRequestNo()%>">
									<%--<i class="fas fa-pencil-alt fa-sm text-primary"></i> --%>
									Edit
								</button>
								<button type="button" class="btn btn-danger btn-sm delete-btn ml-1 " data-placement="top" data-toggle="tooltip" title="Delete" value="Delete" data-id-attr="<%=r.getConnectionRequestId()%>" data-rno-attr="<%=r.getRequestNo()%>">
									<%--<i class="far fa-trash-alt fa-sm text-danger"></i>--%>
									Delete
								</button>
						</span></td>
						<td>BRPL</td>
						<td>Nehru Place</td>
						<td></td>
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

<div id="div-delete-confirmation" style="display:none;">
	<div class="card card-primary mb-2">
		<div class="card-header">
			<h5>Delete Connection Request</h5>
		</div>
		<div class="card-body">
			Are you sure to delete the request no <span class="font-weight-bold" id="span-display-request-no"></span> ?
		</div>
		<div class="card-footer">
			<button type="button" class="btn btn-danger btn-sm" id="yes-btn" value="Yes">Yes</button>
			<button type="button" class="btn btn-primary btn-sm" id="no-btn" value="No">No</button>
		</div>
	</div>
</div>

<aui:script use="aui-modal,aui-overlay-manager">
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		$("#<portlet:namespace/>applyOnlineBtn").click(function(){
			window.location.href='<%=newConnectionURL.toString()%>';	
		});
		
		$(".edit-btn").click(function(){
			window.location.href='<%=editConnectionURL.toString()%>&<portlet:namespace/>connectionRequestId='+$(this).attr("data-id-attr");
		});
		
		$(".delete-btn").click(function(){
			/*var dialog = new A.Modal({
				title: "Delete Connection Request",
				bodyContent: A.one("#div-delete-confirmation").html(),
				headerContent: 'Delete Connection Request',
				centered: true,
				modal: true,
				height: 200,
				width:300,
				render: '#div-delete-confirmation',
				close: true
			});
			dialog.render();*/
			if(confirm("Are you sure to delete the request?")){
				window.location.href='<%=deleteConnectionURL.toString()%>&<portlet:namespace/>connectionRequestId='+$(this).attr("data-id-attr");
			}
		});
	});
</aui:script>