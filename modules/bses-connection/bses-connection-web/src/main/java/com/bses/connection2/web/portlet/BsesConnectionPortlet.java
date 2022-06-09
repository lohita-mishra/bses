package com.bses.connection2.web.portlet;

import com.bses.connection2.web.constants.BsesConnectionPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
		//"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
	},
	service = Portlet.class
)
public class BsesConnectionPortlet extends MVCPortlet {
	private static final Log LOGGER=LogFactoryUtil.getLog(BsesConnectionPortlet.class.getName());
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
     	UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(resourceRequest);
     	//String fileElementName=uploadRequest.getParameter(resourceResponse.getNamespace()+"elementName");
     	//String filePath=uploadRequest.getParameter(fileElementName+"_path");
     	File sourceFile=uploadRequest.getFile("file");
     	String folder=uploadRequest.getParameter("folder");
     	String name=uploadRequest.getParameter("name");
     	
     	LOGGER.info("Source File: "+sourceFile.getAbsolutePath()+ " -- "+sourceFile.length());
     	File folderPath=new File(folder);
     	if(!folderPath.exists()) {
     		folderPath.mkdirs();
     	}
     	File destFile=new File(folderPath, name);
     	sourceFile.renameTo(destFile);
     	LOGGER.info("Dest File: "+destFile.getAbsolutePath()+" -- "+destFile.length());
     	PrintWriter pw=resourceResponse.getWriter();
     	pw.write("{\"status\":\"success\","
     			+ "\"uploadPath\":\""+destFile.getAbsolutePath()+"\"}");
     	pw.flush();
     	pw.close();
	}
}