<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.bses.connection2.web.configuration.BsesConnectionConfiguration"%>
<%@ include file="/init.jsp"%>
 

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<div class="container">

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:fieldset>

        <aui:select name="viewMode" label="View Mode">
            <aui:option value="U01">New Connection</aui:option>
            <aui:option value="U02">Name Change</aui:option>
            <aui:option value="U03">Load Enhancement</aui:option>
            <aui:option value="U04">Load Reduction</aui:option>
     		 <aui:option value="U05">Category Change (Low to High)</aui:option>
            <aui:option value="U06">Category Change (High to Low)</aui:option>
        	  <aui:option value="U07">Address Change</aui:option>
        </aui:select>

    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>

</div>