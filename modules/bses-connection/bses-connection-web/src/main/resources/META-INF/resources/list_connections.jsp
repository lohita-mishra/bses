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
		connectionRequestList=ConnectionRequestLocalServiceUtil.getConnectionRequestsByMobileNo(mobileNo);
	}
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
				<liferay-ui:message key="list-connection-existing-connection-alert" />&gt;&gt;<a href="#" class="btn-primary text-white p-2 ml-3" id="<portlet:namespace/>applyOnlineBtn" value="New Connection">New Connection</a>
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
					String name=r.getTitle()+" "+r.getFirstName()+(StringUtils.isNotBlank(r.getMiddleName())?" "+r.getMiddleName():"")+(StringUtils.isNotBlank(r.getLastName())?" "+r.getLastName():"");
%>				
					<tr>
						<td class="d-flex align-items-center"><span class="text-primary"> <a href=""><%=r.getRequestNo() %></a></span> <span class="btn-group ml-2">
								<button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="tooltip" data-placement="top" title="Edit" value="Edit" data-attr="<%=r.getConnectionRequestId()%>">
									<%--<i class="fas fa-pencil-alt fa-sm text-primary"></i> --%>
									Edit
								</button>
								<button type="button" class="btn btn-danger btn-sm delete-btn ml-1 " data-placement="top" data-toggle="tooltip" title="Delete" value="Delete" data-attr="<%=r.getConnectionRequestId()%>">
									<%--<i class="far fa-trash-alt fa-sm text-danger"></i>--%>
									Delete
								</button>
						</span></td>
						<td>BRPL</td>
						<td>Nehru Place</td>
						<td></td>
						<td><%=name%></td>
						<td><%=r.getEmailId() %></td>
						<td><%=r.getMobileNo() %></td>
						<td><%=r.getCreateDate() %></td>

					</tr>
<%
				}
%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%--
<div id="delete-confirmation-div">
	<div>
		DIVContent Is Rendered In The AUI Modal Popup.
	</div>
</div>
 --%>
<script>
	$(document).ready(function() {
		//$('[data-toggle="tooltip"]').tooltip();
		$("#<portlet:namespace/>applyOnlineBtn").click(function(){
			window.location.href='<%=newConnectionURL.toString()%>';	
		});
		
		$(".edit-btn").click(function(){
			window.location.href='<%=editConnectionURL.toString()%>&<portlet:namespace/>connectionRequestId='+$(this).attr("data-attr");
		});
		
		$(".delete-btn").click(function(){
			if(confirm("Are you sure to delete the request?")){
				window.location.href='<%=deleteConnectionURL.toString()%>&<portlet:namespace/>connectionRequestId='+$(this).attr("data-attr");
			}
		});
	});
</script>