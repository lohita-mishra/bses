package com.bses.connection2.web.portlet;

import com.bses.connection2.model.ConnectionDocument;
import com.bses.connection2.service.ConnectionDocumentLocalServiceUtil;
import com.bses.connection2.web.constants.BsesConnectionPortletKeys;
import com.bses.sap.connector.services.SapConnctorServiceApi;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
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
import org.osgi.service.component.annotations.Reference;

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
		//"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
	},
	service = Portlet.class
)
public class BsesConnectionPortlet extends MVCPortlet {
	private static final Log LOGGER=LogFactoryUtil.getLog(BsesConnectionPortlet.class.getName());
	
	@Reference
	private SapConnctorServiceApi sapServiceApi;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {
		String viewMode = renderRequest.getPreferences().getValue("viewMode", " ");
		
		switch(viewMode){    
		case "U01":    
			 handleNewComnnectionView(renderRequest,renderResponse);
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
	
	private void handleNewComnnectionView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		System.out.println("BsesConnectionPortlet:handleNewComnnectionView");
		String view = "/new_connection_view.jsp";
		PortletSession session = renderRequest.getPortletSession();
		String loginId=(String) session.getAttribute("mobileNo");
		System.out.println("loginId - "+loginId);
		if(StringUtils.isBlank(loginId)) {
			view = "/mobile_login.jsp";
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
		String loginId=(String) session.getAttribute("NAME_CHANGE_LOGIN_ID");
		if(StringUtils.isBlank(loginId)) {
			view = "/ca_number_login.jsp";
		}
		include(view, renderRequest, renderResponse);
		
	}
	
	
	public void newConnectionApplyOnlineView(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:newConnectionApplyOnlineView");
		PortletSession session = request.getPortletSession();
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		session.setAttribute("newConnectionMode", "online");
	}
	
	public void newConnectionApplyAppoinmentView(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:newConnectionApplyAppoinmentView");
		PortletSession session = request.getPortletSession();
		
		session.setAttribute("newConnectioMode", "appointment");
	}
	
	public void newConnectionLogin(ActionRequest request, ActionResponse response) {
		System.out.println("BsesConnectionPortlet:newConnectionLogin");
		String mobileNo = ParamUtil.getString(request, "mobileNo");
        String email = ParamUtil.getString(request, "email");
		
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
     	UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(resourceRequest);
     	//String fileElementName=uploadRequest.getParameter(resourceResponse.getNamespace()+"elementName");
     	//String filePath=uploadRequest.getParameter(fileElementName+"_path");
     	File sourceFile=uploadRequest.getFile("file");
        long connectionRequestId=ParamUtil.getLong(uploadRequest, "connectionRequestId",0);
        long connectionDocumentId=ParamUtil.getLong(uploadRequest, "connectionDocumenetId",0);
        String documentType=ParamUtil.getString(uploadRequest, "documentType");
        String documentName=ParamUtil.getString(uploadRequest, "documentName");

        ConnectionDocument connectionDocument=null;
        String message=documentName+" was updated successfully";
        String status="success";
        
		try {
			connectionDocument = ConnectionDocumentLocalServiceUtil.updateConnectionDocument(connectionDocumentId, connectionRequestId, documentType, documentName, sourceFile);
		} catch (PortalException e) {
			message=documentName+" could not be updated. Error: "+e.getMessage();
			status="failure";
		}
		JSONObject result=JSONFactoryUtil.createJSONObject();
		result.put("status", status);
		result.put("message", message);
		if(connectionDocument!=null) {
			result.put("connectionDocumentId", connectionDocument.getConnectionDocumentId());
			result.put("documentPath", connectionDocument.getDocumentPath());
		}

		PrintWriter pw=resourceResponse.getWriter();
     	pw.write(result.toJSONString());
     	pw.flush();
     	pw.close();
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
