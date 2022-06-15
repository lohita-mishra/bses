<%@ include file="init.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>

<%
		long connectionRequestId = ParamUtil.getLong(request, "connectionRequestId", 0);
		ConnectionRequest connectionRequest = ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
		
	%>

<div class="portlet-inner">
	<div class="row">
		<div class="col-xs-12">
			<div class="form-horizontal mt-30">
				<div class="col-md-12">
					<div id="detailedRec">
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
								<tr>
									<th colspan='4'style="text-align: center;"><img src="${siteLogo}"></img><strong><h4>Acknowledgement
												for New Connection Request - Online Mode</h4></strong></th>
								</tr>
								<tr>
									<td><strong>Service Order Number</strong></td>
									<td><%=connectionRequest.getOrderNo()%></td>
									<td><strong>Order Date</strong></td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="<%=connectionRequest.getModifiedDate()%>"/></td>
								</tr>
								<tr>
									<td><strong>BP Number</strong></td>
									<td colspan="3"><%=connectionRequest.getBpNumber()%></td>
								</tr>
								<tr>
									<td><strong>Name</strong></td>
									<td><%=connectionRequest.getFirstName()%></td>
									<td><strong>Mobile No</strong></td>
									<td><%=connectionRequest.getMobileNo()%></td>
								</tr>
								<tr>
									<td><strong>Division</strong></td>
									<td>${division}</td>
								</tr>
							
								<tr>
										<td colspan="4">
											<p>We acknowledge your online request for new connection. You will be contacted shortly.</p>
										</td>
									</tr>
							</table>
							<div><p>
							In case of any query pertaining to this application, please contact </br>
							</br>
							DSK Helpline No.</br>
							011- 49109931 </br>
							RAJEEV AWASTHI </br>
							(DSK Manager ) </br>
							011-49107593</br>
							rajeev.awasthi@relianceada.com</br>
							</p>
							</div>

						</div>
						<div class="row">
							<div class="col-xs-12">
						      	<p><strong>Registered office: </strong></p>
						      	<br>
						      	<%-- <c:choose>
						      		<c:when test="${not empty noteForAck}">
						      			<p><strong>Note: </strong>${noteForAck}</p>
						      		</c:when>
						      		<c:otherwise>
						      			<p><strong>Note: </strong>Your request subject to submission of complete application form with requisite documents to our representative or at division office and completion of commercial formalities. <c:if test="${not empty contactNoOnAckReceipt}">For any Enquiry please call at ${contactNoOnAckReceipt}.</c:if></p>
						      			<p><strong>Note: </strong>The timeline starts after completion of commercial formalities . If there is any deficiency in documents , same will be
										communicated through defined channels of SMS and/or E-mail and/or Letter.</p>
						      		</c:otherwise>
						      	</c:choose> --%>
						      	<p><strong>Note: </strong>The timeline starts after completion of commercial formalities . If there is any deficiency in documents , same will be
										communicated through defined channels of SMS and/or E-mail and/or Letter.</p>
						        <br>	
					
						        <p>Please take either print or write the Service Order Number for future references</p>
						        <P><center><strong style="font-size: x-large;">Safety first! Installation of ELCB is mandatory for 2kW &amp; above connections.</strong></center></P> 
						        <br>  
						    </div>
						 </div>
					 </div>   
					<div class="row">
						<div class="col-xs-12 col-xs-offset-5">
							<aui:button type="button" value="Print" name="printPage"
								cssClass="btn-blue btn-md" onClick="printReceipt()"></aui:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("div.journal-content-article div.inner-title h1").html("<liferay-ui:message key='header.newconnection' />");
	});
	function printReceipt(){
		var printContent = $("#detailedRec").html();
		$("body div#wrapper").children().hide();
		$('<div id="printReceiptSection">'+printContent+'</div>').appendTo('body');
	    window.print();
	    $("#printReceiptSection").remove();
	    $("body div#wrapper").children().show();
	   hideModalOncePrintIsOver();
	}
</script>