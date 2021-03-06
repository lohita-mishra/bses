<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
ConnectionRequest requestEntity=(ConnectionRequest)request.getAttribute(ConnectionRequest.class.getName());
%>
<portlet:renderURL var="previewURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >
	<portlet:param name="mvcPath" value="/preview_request.jsp" />
	<portlet:param name="connectionRequestId" value="<%=String.valueOf(requestEntity.getConnectionRequestId()) %>" />
</portlet:renderURL>

<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-12">
			<div class="float-right">
				<a  href="<%=previewURL.toString()%>" class="btn btn-warning" id="<portlet:namespace/>previewBtn" target="_blank">Preview</a> <%--<a " data-toggle="modal" class="btn btn-primary">Save
					as Draft</a> --%> <button type="button" class="btn btn-danger" id="<portlet:namespace/>submitBtn" value="Submit">Submit</button>
			</div>
		</div>
	</div>
</div>
<%-- <aui:script position="inline" use="aui-base">
	$(document).ready(function(){
		$("#<portlet:namespace/>previewBtn").click(function(){
                                
					window.location.href= '<%=previewURL.toString()%>'
				}
			);
		});
</aui:script> --%>
