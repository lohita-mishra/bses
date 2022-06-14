<%@page import="com.bses.connection2.service.ConnectionRequestLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bses.connection2.model.ConnectionRequest"%>
<%@ include file="/init.jsp"%>

<%
long connectionRequestId=ParamUtil.getLong(request, "connectionRequestId", 0);
ConnectionRequest requestEntity=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);

%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			
		</div>
		<div class="col-md-6">
			<div class="card m-3 p-5">
				<div class="card-body bg-dagner">
					
					<div  class="email-success">
						<div class="container-fluid">
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group mb-1">
											<p class="far fa-paper-plane fa-fw fs-14 text-primary">
												<liferay-ui:message key="connection-request-success" />
											</p>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			
		</div>
	</div>
</div>



