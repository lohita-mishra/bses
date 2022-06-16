<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>
<%
	String connectionDocumentId=ParamUtil.getString(request, "connectionDocumentId","0");
%>
<portlet:resourceURL var="documentDownloadURL" id="documentDownload">
	<portlet:param name="cmd" value="download"/>
	<portlet:param name="connectionDocumentId" value="<%=connectionDocumentId %>"/>
</portlet:resourceURL>

<iframe id="<portlet:namespace/>document-iframe" src="<%=documentDownloadURL.toString()%>" width="100%" height="600"></iframe>
