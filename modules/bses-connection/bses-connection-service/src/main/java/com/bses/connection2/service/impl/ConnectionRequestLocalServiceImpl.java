/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bses.connection2.service.impl;

import com.bses.connection2.exception.NoSuchConnectionRequestException;
import com.bses.connection2.helper.DigitalSevaKendraServiceHelper;
import com.bses.connection2.model.ConnectionDocument;
import com.bses.connection2.model.ConnectionRequest;
import com.bses.connection2.service.ConnectionDocumentLocalService;
import com.bses.connection2.service.base.ConnectionRequestLocalServiceBaseImpl;
import com.bses.connection2.util.RequestTypeModeStatus;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the connection request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bses.connection2.service.ConnectionRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionRequestLocalServiceBaseImpl
 * @see com.bses.connection2.service.ConnectionRequestLocalServiceUtil
 */
public class ConnectionRequestLocalServiceImpl extends ConnectionRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.bses.connection2.service.ConnectionRequestLocalServiceUtil} to access the
	 * connection request local service.
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(ConnectionRequestLocalServiceImpl.class);
	private static final String PREFIX_CONSUMER = "consumer";
	private static final String PREFIX_ADDRESS = "address";
	private static final String PREFIX_CONNECTION = "connection";
	private static final String PREFIX_CHECKLIST = "checklist";
	private static final String PREFIX_DOCUMENT = "document";

	public static final String FORM_EMAIL_ID = "bsesnoreply@relianceada.com";
	public static final String SUBJECT = "OTP for New Connection";
	public static DateFormat dateFormat=null;
	public static final int RETENTION_DAYS=5;
	
	@Reference
	private ConnectionDocumentLocalService connectionDocumentLocalService;

	public ConnectionRequest createConnectionRequest(String mobileNo, String emailId) throws PortalException {
		String requestNo = "R-TMP-" + new Date().getTime();
		LOGGER.info(mobileNo + " - " + emailId + " - " + requestNo);
		int draftCount=connectionRequestPersistence.countByMobileNoAndRequestStatus(mobileNo, RequestTypeModeStatus.STATUS_DRAFT);
		
		int maxCount=5;
		try{
			maxCount=Integer.parseInt(PropsUtil.get("connection.request.draft.max.count").trim());
		}catch(Exception e){}
		
		if(draftCount>=maxCount) {
			throw new PortalException("Maximum number of pending requests reached "+maxCount);
		}
		
		ConnectionRequest connectionRequest = connectionRequestPersistence.create(CounterLocalServiceUtil.increment(ConnectionRequest.class.getName()));
		connectionRequest.setMobileNo(mobileNo);
		connectionRequest.setEmailId(emailId);
		connectionRequest.setRequestNo(requestNo);
		connectionRequest.setRequestType(RequestTypeModeStatus.TYPE_NEW_CONNECTION);
		connectionRequest.setRequestStatus(RequestTypeModeStatus.STATUS_DRAFT);
		connectionRequestPersistence.update(connectionRequest);
		return connectionRequest;
	}
	
	public ConnectionRequest createConnectionRequest(String mobileNo, String emailId, String requestType, String requestMode) throws PortalException {
		String requestNo = "R-TMP-" + new Date().getTime();
		LOGGER.info(mobileNo + " - " + emailId + " - " + requestNo);
		int draftCount=connectionRequestPersistence.countByMobileNoAndRequestStatus(mobileNo, RequestTypeModeStatus.STATUS_DRAFT);
		int maxCount=5;
		try{
			maxCount=Integer.parseInt(PropsUtil.get("connection.request.draft.max.count").trim());
		}catch(Exception e){}
		
		if(draftCount>=maxCount) {
			throw new PortalException("Maximum number of pending requests reached "+maxCount);
		}
		ConnectionRequest connectionRequest = connectionRequestPersistence.create(CounterLocalServiceUtil.increment(ConnectionRequest.class.getName()));
		connectionRequest.setMobileNo(mobileNo);
		connectionRequest.setEmailId(emailId);
		connectionRequest.setRequestNo(requestNo);
		connectionRequest.setRequestType(requestType);
		connectionRequest.setRequestMode(requestMode);
		connectionRequest.setRequestStatus(RequestTypeModeStatus.STATUS_DRAFT);
		connectionRequestPersistence.update(connectionRequest);
		return connectionRequest;
	}
	

	public String updateConsumerDetails(String requestNo, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(requestNo, params, PREFIX_CONSUMER);
	}

	public String updateConsumerDetails(long connectionRequestId, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(connectionRequestId, params, PREFIX_CONSUMER);
	}

	public String updateAddress(String requestNo, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(requestNo, params, PREFIX_ADDRESS);
	}

	public String updateAddress(long connectionRequestId, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(connectionRequestId, params, PREFIX_ADDRESS);
	}

	public String updateConnection(String requestNo, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(requestNo, params, PREFIX_CONNECTION);
	}

	public String updateConnection(long connectionRequestId, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(connectionRequestId, params, PREFIX_CONNECTION);
	}

	public String updateChecklistDocuments(String requestNo, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(requestNo, params, PREFIX_CHECKLIST);
	}

	public String updateChecklistDocuments(long connectionRequestId, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(connectionRequestId, params, PREFIX_CHECKLIST);
	}

	public String updateImportantDocuments(String requestNo, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(requestNo, params, PREFIX_DOCUMENT);
	}

	public String updateImportantDocuments(long connectionRequestId, Map<String, String> params) {
		LOGGER.info(params);
		return updateConnectionRequest(connectionRequestId, params, PREFIX_DOCUMENT);
	}

	public ConnectionRequest getConnectionRequest(String requestNo) {
		try {
			return connectionRequestPersistence.findByRequestNo(requestNo).get(0);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ConnectionRequest getConnectionRequestByMobileNoAndRequestNo(String mobileNo, String requestNo) {
		try {
			return connectionRequestPersistence.findByMobileNoAndRequestNo(mobileNo, requestNo).get(0);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public List<ConnectionRequest> getConnectionRequestsByMobileNo(String mobileNo) {
		List<ConnectionRequest> connectionRequests = new ArrayList();
		try {
			connectionRequests = connectionRequestPersistence.findByMobileNo(mobileNo);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return connectionRequests;
	}
	
	public List<ConnectionRequest> getConnectionRequestsByMobileNoAndRequestStatus(String mobileNo, String requestStatus) {
		List<ConnectionRequest> connectionRequests = new ArrayList();
		try {
			connectionRequests = connectionRequestPersistence.findByMobileNoAndRequestStatus(mobileNo, requestStatus);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return connectionRequests;
	}
	

	public String updateConnectionRequest(String requestNo, Map<String, String> params, String sectionPrefix) {
		try {
			ConnectionRequest connectionRequest = getConnectionRequest(requestNo);
			setAttributes(connectionRequest, params, sectionPrefix);
			connectionRequestPersistence.update(connectionRequest);
			return "success";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return "failure";
	}

	public String updateConnectionRequest(long connectionRequestId, Map<String, String> params, String sectionPrefix) {
		try {
			ConnectionRequest connectionRequest = getConnectionRequest(connectionRequestId);
			setAttributes(connectionRequest, params, sectionPrefix);
			connectionRequestPersistence.update(connectionRequest);
			return "success";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return "failure";
	}

	public String submitConnectionRequestToSoap(long connectionRequestId) {
		try {
			ConnectionRequest connectionRequest=
			connectionRequestPersistence.findByPrimaryKey(connectionRequestId);
			String serviceOrder=DigitalSevaKendraServiceHelper.addNewConnectionRequestDetailSoapCall(connectionRequest);
			if(StringUtils.isNotEmpty(serviceOrder)) {
				connectionRequest.setOrderNo(serviceOrder);
				connectionRequest.setSapOrderGenerated("Y");
				connectionRequest.setRequestStatus(RequestTypeModeStatus.STATUS_ORDER_GENERATED);
				connectionRequestPersistence.update(connectionRequest);
				return "success";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return "failure";
	}

	private ConnectionRequest toConnectionRequest(ConnectionRequest source) {
		ResourceBundle bundle = getResourceBundle();

		if (bundle == null) {
			LOGGER.error("Error: Bundle is null..");
			return null;
		}

		ConnectionRequest target = connectionRequestPersistence.create(0);
		Enumeration<String> enumBundle = bundle.getKeys();
		while (enumBundle.hasMoreElements()) {
			String prefix = "";
			String key = enumBundle.nextElement();

			if (key.startsWith(PREFIX_CONSUMER + ".")) {
				prefix = PREFIX_CONSUMER;
			} else if (key.startsWith(PREFIX_ADDRESS + ".")) {
				prefix = PREFIX_ADDRESS;
			} else if (key.startsWith(PREFIX_CONNECTION + ".")) {
				prefix = PREFIX_CONNECTION;
			} else if (key.startsWith(PREFIX_CHECKLIST + ".")) {
				prefix = PREFIX_CHECKLIST;
			} else if (key.startsWith(PREFIX_DOCUMENT + ".")) {
				prefix = PREFIX_DOCUMENT;
			}
			String targetKey = key;
			if (StringUtils.isNotBlank(prefix) && key.startsWith(prefix + ".")) {
				targetKey = key.substring((prefix + ".").length());
			}

			String sourceKey = bundle.getString(key);
			LOGGER.error("Processing sourceKey=[" + targetKey + "], targetKey=[" + targetKey + "]");
			if (StringUtils.isBlank(sourceKey)) {
				continue;
			}
			copyAttribute(source, target, sourceKey, targetKey);
		}
		return target;
	}

	private void copyAttribute(ConnectionRequest source, ConnectionRequest target, String sourceKey, String targetKey) {
		Object sourceValue = getAttribute(source, sourceKey);
		setAttribute(target, targetKey, String.valueOf(sourceValue));
	}

	private void setAttributes(ConnectionRequest obj, Map<String, String> params, String attrPrefix) {

		ResourceBundle bundle = getResourceBundle();

		if (bundle == null) {
			LOGGER.error("Error: Bundle is null..");
			return;
		}

		String namespace = params.get("namespace");
		System.out.println("Namespace ---" + namespace);
		// String formName=params.get("formName");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String sourceKey = entry.getKey();
			
			if("namespace".equalsIgnoreCase(sourceKey)) {
				continue;
			}
			
			System.out.println("source key ..." + sourceKey);

			if (sourceKey.contains(namespace)) {
				sourceKey = sourceKey.substring((namespace).length());
			}
			// sourceKey = attrPrefix + "." + sourceKey;
			System.out.println("source key updated ..." + sourceKey);

			String targetKey = null;
			try {
				targetKey = bundle.getString(attrPrefix + "." + sourceKey);

			} catch (Exception e) {

				LOGGER.error(e.getMessage());
			}
			LOGGER.info("Processing sourceKey=[" + sourceKey + "], targetKey=[" + targetKey + "] and value=["
					+ entry.getValue() + "]");

			if (StringUtils.isBlank(targetKey)) {
				if (StringUtils.isBlank(entry.getValue())) {
					continue;
				} else {
					targetKey = sourceKey;
				}
			}
			setAttribute(obj, targetKey, entry.getValue());
		}
	}

	private ResourceBundle getResourceBundle() {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("META-INF/config/field-mapping", Locale.getDefault(), getClassLoader());
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		return bundle;
	}

	/*
	 * private void setAttribute(ConnectionRequest obj, String name, String value) {
	 * Method methodSet=null; try {
	 * methodSet=getSetterMethod(ConnectionRequest.class, name, new Class[]
	 * {String.class}); methodSet.invoke(obj, value); } catch (Exception e) {
	 * LOGGER.error("Error in setAttribute for [DssNewConnRequest."+name
	 * +"] to value ["+value+"]"); LOGGER.error(e); } }
	 */

	private void setAttribute(ConnectionRequest obj, String name, String value) {
		try {
			LOGGER.info("SettingAttribute  - "+value+" - for "+name);
			Method methodGet = getGetterMethod(ConnectionRequest.class, StringUtils.trim(name));
			LOGGER.info(methodGet.getReturnType()+" - "+value+" - for "+name);
			Method methodSet = getSetterMethod(ConnectionRequest.class, StringUtils.trim(name), new Class[] { methodGet.getReturnType() });
			if(methodGet.getReturnType()==int.class) {
				methodSet.invoke(obj, Integer.parseInt(value));
			}else if(methodGet.getReturnType()==long.class) {
				methodSet.invoke(obj, Long.parseLong(value));
			}else if(methodGet.getReturnType()==float.class) {
				methodSet.invoke(obj, Float.parseFloat(value));
			}else if(methodGet.getReturnType()==double.class) {
				methodSet.invoke(obj, Double.parseDouble(value));
			}else if(methodGet.getReturnType()==boolean.class) {
				boolean boolValue="1".equals(value)|| "y".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value);
				methodSet.invoke(obj, boolValue);
			}else if(methodGet.getReturnType()==Date.class) {
				methodSet.invoke(obj, dateFormat.parse(value));
			}else {
				methodSet.invoke(obj, value);
			}
		} catch (Exception e) {
			//LOGGER.error(e);
			LOGGER.error("Error in setAttribute for [ConnectionRequest." + name + "] to value [" + value + "]");

		}
	}

	/*
	 * private Object getAttribute(ConnectionRequest obj, String name) { Method
	 * methodGet=null; try { methodGet=getGetterMethod(ConnectionRequest.class,
	 * name); return methodGet.invoke(obj); } catch (Exception e) {
	 * LOGGER.error("Error in getAttribute for [DssNewConnRequest."+name +"]");
	 * LOGGER.error(e); } return null; }
	 */

	private Object getAttribute(ConnectionRequest obj, String name) {
		Method methodGet = null;
		try {
			methodGet = getGetterMethod(ConnectionRequest.class, StringUtils.trim(name));
			return methodGet.invoke(obj);
		} catch (Exception e) {
			LOGGER.error("Error in getAttribute for [ConnectionRequest." + name + "]");

		}
		return null;
	}

	private Method getSetterMethod(Class clazz, String name, Class[] paramTypes) {
		try {
			return clazz.getMethod("set" + StringUtils.capitalize(StringUtils.trim(name)), paramTypes);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	private Method getGetterMethod(Class clazz, String name) {
		try {
			return clazz.getMethod("get" + StringUtils.capitalize(StringUtils.trim(name)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public boolean getEmailAndSendOTPNEW(String emailId, ThemeDisplay themeDisplay) {
		String siteName = "";
		try {
			siteName = themeDisplay.getScopeGroupName();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		String otp = "";
		boolean showOTP = false;
		boolean ismailSent = false;
		if (showOTP) {
			StringBuffer body = new StringBuffer();

			body.append("<p>Dear Customer, </p>");
			body.append("<p>Your One Time Password for New Connection is " + otp
					+ ". Do not share this OTP to anyone for security reasons. BRPL shall not be responsible for any misuse</p>");
			body.append("<br/>");
			body.append("<br/>");
			body.append("<p>Thanks & Regards</p>");
			body.append("<p>BSES Power Limited.</p>");

			String mailBody = body.toString();
			ismailSent = sendEmail(FORM_EMAIL_ID, emailId, SUBJECT, mailBody);
			// ismailSent = true;
			// _log.info("emailId--------"+emailId);
			if (ismailSent == true) {
				return true;
			}
		}
		return false;
	}

	private boolean sendEmail(String from, String to, String subject, String body) {

		MailMessage mailMessage = new MailMessage();
		try {
			mailMessage.setTo(new InternetAddress(to));
			mailMessage.setFrom(new InternetAddress(from));
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			// File Attachement

			MailServiceUtil.sendEmail(mailMessage);

			return true;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return false;
	}
	private static DateFormat getSourceDateFormat() {
		if(dateFormat==null) {
			dateFormat=new SimpleDateFormat(PropsUtil.get("source.date.format"));
		}
		return dateFormat;
	}
	
	public ConnectionRequest deleteByConnectionRequestId(long connectionRequestId) throws NoSuchConnectionRequestException {
		ConnectionRequest connectionRequest=connectionRequestPersistence.findByPrimaryKey(connectionRequestId);
		deleteConnectionRequestAndDocuments(connectionRequest);
		return connectionRequest;
	}
	
	private boolean deleteConnectionRequestAndDocuments(ConnectionRequest connectionRequest) {
		List<ConnectionDocument> documents=connectionDocumentLocalService.getConnectionDocumentByConnectionRequestId(connectionRequest.getConnectionRequestId());
		for(ConnectionDocument d:documents) {
			connectionDocumentLocalService.deleteConnectionDocument(d);
		}
		connectionRequestPersistence.remove(connectionRequest);
		return true;
	}
	
	public int deleteStaleConnectionRequests(String mobileNo) {
		int retentionDays=RETENTION_DAYS;
		try {
			retentionDays=Integer.parseInt(PropsUtil.get("connection.request.draft.retention").trim());
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		long retentionMills=retentionDays*24*60*60*1000;
		Calendar today=Calendar.getInstance();
		
		int deleted=0;
		List<ConnectionRequest> connectionRequests=connectionRequestPersistence.findByMobileNo(mobileNo);
		for(ConnectionRequest connectionRequest:connectionRequests) {
			if(today.getTimeInMillis()-connectionRequest.getModifiedDate().getTime()>=retentionMills) {
				deleteConnectionRequestAndDocuments(connectionRequest);
				deleted++;
			}
		}
		return deleted;
	}
}