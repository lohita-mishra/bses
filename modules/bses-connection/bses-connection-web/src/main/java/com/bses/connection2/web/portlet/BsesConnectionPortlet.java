package com.bses.connection2.web.portlet;

import com.bses.connection2.model.ConnectionDocument;
import com.bses.connection2.model.ConnectionRequest;
import com.bses.connection2.service.ConnectionDocumentLocalServiceUtil;
import com.bses.connection2.service.ConnectionRequestLocalServiceUtil;
import com.bses.connection2.util.RequestTypeModeStatus;
import com.bses.connection2.web.constants.BsesConnectionPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * @author arjun
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=BSES",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BSES Connection Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BsesConnectionPortletKeys.BsesConnection,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-css=/css/bootstrap.min-4.6.1.css",
		"com.liferay.portlet.header-portlet-css=/css/select2.min.css",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.min-3.6.0.js",
		"com.liferay.portlet.header-portlet-javascript=/js/bootstrap.bundle.min-4.6.1.js",
		"com.liferay.portlet.header-portlet-javascript=/js/custom.js",
		"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
	},
	service = Portlet.class
)
public class BsesConnectionPortlet extends MVCPortlet {
	private static final Log LOGGER=LogFactoryUtil.getLog(BsesConnectionPortlet.class.getName());
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {
		String viewMode = renderRequest.getPreferences().getValue("viewMode", " ");
		LOGGER.info("doView(RenderRequest renderRequest, RenderResponse renderResponse) is called : "+viewMode);
		switch(viewMode){    
		case "U01":    
			handleNewConnectionView(renderRequest,renderResponse);
			break;  //optional  
		case "U02":    
			 handleNameChangeView(renderRequest,renderResponse); 
			 break;  //optional  
		case "U07":    
			 handleAddressChangeView(renderRequest,renderResponse); 
			 break;  //optional    
		case "U03":    
			 handleLoadChangeView(renderRequest,renderResponse);  
			 break;  //optional
		case "U04":    
			 handleLoadChangeView(renderRequest,renderResponse);  
			 break;  //optional
		default:     
			// include(viewTemplate, renderRequest, renderResponse); 
			include("/invalid_config.jsp", renderRequest, renderResponse);
	}    
	}	
	
	private void handleNewConnectionView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		System.out.println("BsesConnectionPortlet:handleNewConnectionView");
		String view = "/new_connection_view.jsp";
		PortletSession session = renderRequest.getPortletSession();
		String loginId=(String) session.getAttribute("mobileNo");
		
		System.out.println("loginId - "+loginId);
		if(StringUtils.isBlank(loginId)) {
			view = "/mobile_login.jsp";
		}else {
			int draftCount=ConnectionRequestLocalServiceUtil.getCurrentDraftCount(loginId);
			int maxCount=ConnectionRequestLocalServiceUtil.getMaxDraftCount();
			if(draftCount>=maxCount) {
				view = "/list_connections.jsp";
			}
		}

		include(view, renderRequest, renderResponse);
	}
	
	private void handleLoadChangeView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String view = "/load_change_view.jsp";
		PortletSession session = renderRequest.getPortletSession();
		String loginId=(String) session.getAttribute("NEW_CONNECTION_LOGIN_ID");
		if(StringUtils.isBlank(loginId)) {
			view = "/mobile_login.jsp";
		}
		include(view, renderRequest, renderResponse);
	}

	private void handleAddressChangeView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String view = "/address_change_view.jsp";
		PortletSession session = renderRequest.getPortletSession();
		String loginId=(String) session.getAttribute("NEW_CONNECTION_LOGIN_ID");
		if(StringUtils.isBlank(loginId)) {
			view = "/mobile_login.jsp";
		}
		include(view, renderRequest, renderResponse);
		
	}

	private void handleNameChangeView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String view = "/name_change_view.jsp";
		PortletSession session = renderRequest.getPortletSession();
		String loginId=(String) session.getAttribute("caNumber");
		if(StringUtils.isBlank(loginId)) {
			view = "/ca_number_login.jsp";
		}else {
		
			String requestId =(String) session.getAttribute(ConnectionRequest.class.getName()+"#id");
			if(StringUtils.isBlank(requestId)) {
				try {
					ConnectionRequest connectionRequest = ConnectionRequestLocalServiceUtil.createNameChangeRequest(loginId);
					if(connectionRequest != null) {
						System.out.println("connectionRequest.getConnectionRequestId()- "+connectionRequest.getConnectionRequestId());
						session.setAttribute(ConnectionRequest.class.getName()+"#id",connectionRequest.getConnectionRequestId());
					}
				
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}
		include(view, renderRequest, renderResponse);
		
	}
	
	
	public void newConnectionApplyOnlineView(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:newConnectionApplyOnlineView");
		PortletSession session = request.getPortletSession();
		session.setAttribute("newConnectionMode", RequestTypeModeStatus.MODE_ONLINE);
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		//session.setAttribute("newConnectionMode", "online");
	}
	
	public void newConnectionApplyAppointmentView(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:newConnectionApplyAppoinmentView");
		PortletSession session = request.getPortletSession();
		session.setAttribute("newConnectionMode", RequestTypeModeStatus.MODE_APPOINTMENT);
		//session.setAttribute("newConnectioMode", "appointment");
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void newConnectionLogin(ActionRequest request, ActionResponse response) {
		
		String mobileNo = ParamUtil.getString(request, "mobileNo");
        String email = ParamUtil.getString(request, "email");
        LOGGER.info("BsesConnectionPortlet:newConnectionLogin, mobileNo: "+mobileNo+", email: "+email);
		PortletSession session = request.getPortletSession();
		
		session.setAttribute("mobileNo", mobileNo);
		session.setAttribute("email", email);

		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void caNumberLogin(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:caNumberLogin");
		String caNumber = ParamUtil.getString(request, "caNumber");
		String mobileNo = ParamUtil.getString(request, "mobileNo");
		
		PortletSession session = request.getPortletSession();
		
		session.setAttribute("mobileNo", mobileNo);
		session.setAttribute("caNumber", caNumber);

		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		ConnectionDocument connectionDocument =null;
        
		String cmd=ParamUtil.getString(resourceRequest, "cmd", "");
		if(StringUtils.equalsIgnoreCase(cmd, "upload")) {
			JSONObject result=JSONFactoryUtil.createJSONObject();
			try {
				connectionDocument = uploadDocument(resourceRequest);
				result.put("status","success");
				result.put("connectionDocumentId", connectionDocument.getConnectionDocumentId());
				result.put("clientFileName", connectionDocument.getClientFileName());
			} catch (PortalException e) {
				result.put("status", "fail");
				result.put("error", e.getMessage());
			}
			
			PrintWriter pw=resourceResponse.getWriter();
	     	pw.write(result.toJSONString());
	     	pw.flush();
	     	pw.close();
		}else if(StringUtils.equalsIgnoreCase(cmd, "download")) {
			long connectionDocumentId=ParamUtil.getLong(resourceRequest, "connectionDocumentId",0);
	        try {
				connectionDocument=ConnectionDocumentLocalServiceUtil.getConnectionDocument(connectionDocumentId);
				File file = new File(connectionDocument.getDocumentPath());
				//byte[] arr = new byte[(int)file.length()];
				InputStream inputStream = new FileInputStream(file);
				//OutputStream out=resourceResponse.getPortletOutputStream();
				
				PortletResponseUtil.sendFile(resourceRequest, resourceResponse, connectionDocument.getClientFileName(), inputStream, ContentTypes.APPLICATION_PDF);
			} catch (PortalException e) {
				LOGGER.error(e);
			}
			
		}
	}
	
	private ConnectionDocument uploadDocument(ResourceRequest resourceRequest) throws PortalException {
		UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(resourceRequest);
     	//String fileElementName=uploadRequest.getParameter(resourceResponse.getNamespace()+"elementName");
     	//String filePath=uploadRequest.getParameter(fileElementName+"_path");
     	File sourceFile=uploadRequest.getFile("file");
        long connectionRequestId=ParamUtil.getLong(uploadRequest, "connectionRequestId",0);
        long connectionDocumentId=ParamUtil.getLong(uploadRequest, "connectionDocumentId",0);
        String documentType=ParamUtil.getString(uploadRequest, "documentType");
        String documentName=ParamUtil.getString(uploadRequest, "documentName");
        String clientFileName=ParamUtil.getString(uploadRequest, "name");

        ConnectionDocument connectionDocument=ConnectionDocumentLocalServiceUtil.updateConnectionDocument(connectionDocumentId, connectionRequestId, documentType, documentName, clientFileName, sourceFile);
		return connectionDocument;
	}

	public String generateTwelveDigitCANo(String accNo) {
		String formattedNumber = StringPool.BLANK;
		if (Validator.isNotNull(accNo)) {
			formattedNumber = String.format("%012d", Long.valueOf(accNo));
			//log.debug("Formatted account number from  getValidAccountNumber method ::::::::  " + formattedNumber);
		}
		return formattedNumber;
	}
}
