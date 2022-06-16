<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%

String caNumber=(String)portletSession.getAttribute("caNumber");

 if(StringUtils.isNotBlank(caNumber)){
	String mobileNo=(String)portletSession.getAttribute("mobileNo");
%>
<liferay-util:include page="/name_change.jsp" servletContext="<%=application%>">
	<liferay-util:param name="mobileNo" value="<%=mobileNo%>" />
	<liferay-util:param name="caNumber" value="<%=caNumber%>" />
</liferay-util:include>
<%
}else{
%>
Invalid CA Number
<%
}
%>
