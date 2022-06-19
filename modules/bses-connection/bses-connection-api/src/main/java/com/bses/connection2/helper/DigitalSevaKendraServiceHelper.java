package com.bses.connection2.helper;

import com.bses.connection2.helper.model.NewConnectionWrapper;
import com.bses.connection2.model.ConnectionRequest;
import com.bses.connection2.service.ConnectionRequestLocalServiceUtil;
import com.bses.sap.model.CmsISUCADisplayResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DigitalSevaKendraServiceHelper {
	private static final Log LOGGER=LogFactoryUtil.getLog(DigitalSevaKendraServiceHelper.class);
	public static String addNewConnectionRequestDetailSoapCall(long connectionRequestId) {
		try {
			ConnectionRequest connectionRequest=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
			LOGGER.info("connectionRequest - " + connectionRequest);
			return addNewConnectionRequestDetailSoapCall(connectionRequest);
		}catch(Exception e) {}
		return null;
	}
	public static String addNewConnectionRequestDetailSoapCall(ConnectionRequest connectionRequest) {
		String serviceOrder = null;
		try {
			LOGGER.info("connectionRequest - " + connectionRequest);

			String titleKey = StringPool.BLANK;
			String parentCategory = DigitalSevaKendraConstants.PARENT_CAT_1;
			String male = DigitalSevaKendraConstants.MALE;
			String female = StringPool.BLANK;
			String appliedLoadDkva = StringPool.BLANK;
			String appliedLoad = StringPool.BLANK;
			
			if (Validator.isNull(connectionRequest.getTitle()) || connectionRequest.getTitle().equals("")
					|| connectionRequest.getTitle().equals("-1")) {
				titleKey = "0001";
			} else {
				titleKey = connectionRequest.getTitle();
			}
			
			if (Validator.isNotNull(connectionRequest.getTitle()) && connectionRequest.getTitle().equals(DigitalSevaKendraConstants.TITLE_PARAM)) {
				parentCategory = DigitalSevaKendraConstants.PARENT_CAT_2;
			}
			
		/*
			if (connectionRequest.getAppliedLoadType().equals("KVA")) {
				appliedLoadDkva = Long.toString(connectionRequest.getAppliedLoad());
			} else { // VA
				appliedLoad = Long.toString(connectionRequest.getAppliedLoad());
			}
		*/
			
			SimpleDateFormat webServiceFormat1 = new SimpleDateFormat("yyyyMMdd");
			
			String iIlart="U01";
			String planningPlant="D021";
			
			String xmlString = "";
			StringBuilder reqXML = new StringBuilder();
			reqXML.append(
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema/\" 	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
			.append("<soap:Body>").append("<Z_BAPI_ZDSS_WEB_LINK xmlns=\"http://tempuri.org/\">")
			.append("<I_ILART>").append(iIlart).append("</I_ILART>")
			.append("<I_VKONT>").append(StringPool.BLANK).append("</I_VKONT>")
			.append("<I_VKONA>").append(StringPool.BLANK).append("</I_VKONA>")
			
			.append("<PARTNERCATEGORY>").append(parentCategory).append("</PARTNERCATEGORY>")
			.append("<PARTNERTYPE>").append(DigitalSevaKendraConstants.PARTNER_TYPE).append("</PARTNERTYPE>")
			.append("<TITLE_KEY>").append(titleKey).append("</TITLE_KEY>")
			.append("<FIRSTNAME>").append(StringUtils.defaultString(connectionRequest.getFirstName())).append("</FIRSTNAME>")
			.append("<LASTNAME>").append(StringUtils.defaultString(connectionRequest.getLastName())).append("</LASTNAME>")
			.append("<MIDDLENAME>").append(StringUtils.defaultString(connectionRequest.getMiddleName())).append("</MIDDLENAME>")
			.append("<FATHERSNAME>").append(StringUtils.defaultString(connectionRequest.getFatherOrHusbandName())).append("</FATHERSNAME>")
			.append("<HOUSE_NO>").append(StringUtils.defaultString(connectionRequest.getHouseNo())).append("</HOUSE_NO>")
			.append("<BUILDING>").append(StringUtils.defaultString(connectionRequest.getBuildingName())).append("</BUILDING>")
			.append("<STR_SUPPL1>").append(StringUtils.defaultString(connectionRequest.getStreet())).append("</STR_SUPPL1>")
			.append("<STR_SUPPL2>").append(StringUtils.defaultString(connectionRequest.getColonyArea())).append("</STR_SUPPL2>")
			.append("<STR_SUPPL3>").append(StringUtils.defaultString(connectionRequest.getLandmark())).append("</STR_SUPPL3>")
			.append("<POSTL_COD1>").append(StringUtils.defaultString(connectionRequest.getPinCode())).append("</POSTL_COD1>")
			.append("<CITY>").append(DigitalSevaKendraConstants.CITY).append("</CITY>")
			.append("<E_MAIL>").append(StringUtils.defaultString(connectionRequest.getEmailId())).append("</E_MAIL>")
			.append("<LANDLINE>").append(StringUtils.defaultString(connectionRequest.getMobileNo())).append("</LANDLINE>")
			.append("<MOBILE>").append(connectionRequest.getMobileNo()).append("</MOBILE>")
			.append("<FEMALE>").append(female).append("</FEMALE>")
			.append("<MALE>").append(male).append("</MALE>")
			//.append("<JOBGR>").append(StringUtils.defaultString(connectionRequest.getOccupation())).append("</JOBGR>")
			.append("<JOBGR>").append("").append("</JOBGR>")
			.append("<IDTYPE>").append(StringPool.BLANK).append("</IDTYPE>")
			.append("<IDNUMBER>").append(StringPool.BLANK).append("</IDNUMBER>")
			//.append("<PLANNINGPLANT>").append(dssNewConnRequest.getPlanningPlant()).append("</PLANNINGPLANT>")
			.append("<PLANNINGPLANT>").append(planningPlant).append("</PLANNINGPLANT>")
			.append("<WORKCENTRE>").append(StringUtils.defaultString(connectionRequest.getDistrict())).append("</WORKCENTRE>")
			.append("<SYSTEMCOND>").append(DigitalSevaKendraConstants.SYSTEMCOND).append("</SYSTEMCOND>")
			.append("<APPLIEDCAT>").append(StringUtils.defaultString(connectionRequest.getTariffCategory())).append("</APPLIEDCAT>")
			.append("<APPLIEDLOAD>").append(appliedLoad).append("</APPLIEDLOAD>")
			.append("<APPLIEDLOADKVA>").append(appliedLoadDkva).append("</APPLIEDLOADKVA>")
			.append("<CONNECTIONTYPE>").append(StringUtils.defaultString(connectionRequest.getConnectionType())).append("</CONNECTIONTYPE>")
			.append("<STATEMENT_CA>").append(StringPool.BLANK).append("</STATEMENT_CA>")
			
			/*
			.append("<START_DATE>").append(webServiceFormat1.format(connectionRequest.getAppointmentStartDate())).append("</START_DATE>")
			.append("<START_TIME>").append(StringUtils.defaultString(connectionRequest.getAppointmentStartTime())).append("</START_TIME>")
			.append("<FINISH_DATE>").append(webServiceFormat1.format(connectionRequest.getAppointmentStartDate())).append("</FINISH_DATE>")
			.append("<FINISH_TIME>").append(StringUtils.defaultString(connectionRequest.getAppointmentFinishTime())).append("</FINISH_TIME>")
			*/
			
			.append("<SORTFIELD>").append(DigitalSevaKendraConstants.SORTFIELD).append("</SORTFIELD>")
			.append("<ABKRS>").append(DigitalSevaKendraConstants.ABKRS).append("</ABKRS>")
			.append("<LATITUDE>").append(StringPool.BLANK).append("</LATITUDE>")
			.append("<LONGITUDE>").append(StringPool.BLANK).append("</LONGITUDE>")
			.append("<GEOCOR_ADDRESS>").append(StringPool.BLANK).append("</GEOCOR_ADDRESS>")
			.append("<APPOINT_DIV>").append(StringPool.BLANK).append("</APPOINT_DIV>")
			.append("</Z_BAPI_ZDSS_WEB_LINK>").append("</soap:Body>").append("</soap:Envelope>");
			
			String requestXML = reqXML.toString();			
			LOGGER.info("requestXML----"+requestXML);

			serviceOrder = callService(requestXML);
			
			if (serviceOrder.equals(null) || serviceOrder.isEmpty() || serviceOrder.equals("null")) {
				serviceOrder = callService(requestXML);
			}

			LOGGER.info("getServiceOrder from sap for req no '" + connectionRequest.getRequestNo() + "' is "+ serviceOrder);

		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.error(" Error occuired while creating new connection request :- " + e);
		}
		return serviceOrder;
	}
	
	
	public static String submitNameChageRequest(ConnectionRequest connectionRequest, CmsISUCADisplayResponse cmsResponse) {
		String serviceOrder = null;
		LOGGER.info("submitNameChageRequest : connectionRequest number - " + connectionRequest.getRequestNo());
		try {
			String requestXML = generateNameChangeRequestXML(connectionRequest,cmsResponse);
			
			serviceOrder = callService(requestXML);
			
			if (serviceOrder.equals(null) || serviceOrder.isEmpty() || serviceOrder.equals("null")) {
				serviceOrder = callService(requestXML);
			}
		}catch (Exception e) {
				LOGGER.error(" Error occuired while creating new connection request :- " + e);
		}
		
		return serviceOrder;
	}
	
	
	private static String generateNameChangeRequestXML(ConnectionRequest connectionRequest, CmsISUCADisplayResponse cmsResponse) {
		String titleKey = "";
		if (Validator.isNull(connectionRequest.getTitle()) || connectionRequest.getTitle().equals("")
				|| connectionRequest.getTitle().equals("-1")) {
			titleKey = "0001";
		} else {
			titleKey = connectionRequest.getTitle();
		}
		NewConnectionWrapper newConnectionWrapper = new NewConnectionWrapper();
		//newConnectionWrapper.setDiscom(ncdiscom); //TODO
		newConnectionWrapper.setiIlart("U02");
		newConnectionWrapper.setCaNumber(connectionRequest.getCaNumber());
		newConnectionWrapper.setCaNumberTwelveDigit(generateTwelveDigitCANo(connectionRequest.getCaNumber()));

		newConnectionWrapper.setTitle(titleKey);
		newConnectionWrapper.setFirstName(connectionRequest.getFirstName());
		newConnectionWrapper.setLastName(connectionRequest.getLastName());
		newConnectionWrapper.setFatherName(connectionRequest.getFatherOrHusbandName());
		newConnectionWrapper.setDistrict(connectionRequest.getDistrict());
		newConnectionWrapper.setMobileNo(connectionRequest.getMobileNo());
		//newConnectionWrapper.setIdType(connectionRequest.getIdProofType()); //TODO
		//newConnectionWrapper.setIdNumber(connectionRequest.getIdProofNo());

		newConnectionWrapper.setAppointmentStartDate(connectionRequest.getAppointmentDate());
		newConnectionWrapper.setAppointmentStartTime(connectionRequest.getAppointmentTime());
		newConnectionWrapper.setAppointmentFinishTime(connectionRequest.getAppointmentFinishTime());
		newConnectionWrapper.setAppointmentFinishDate(connectionRequest.getAppointmentDate());
		newConnectionWrapper.setAppointmentDistrict(connectionRequest.getAppointmentDistrict());
	//	newConnectionWrapper.setAppliedCategory(_categoryChangeSoapRequest.getCategoryNew());
		
		String reqXML = chageRequestNewSoapCallXML(newConnectionWrapper) ;
		
		return reqXML;
	}
	
	private static String generateTwelveDigitCANo(String caNumber) {
		String formattedNumber = StringPool.BLANK;
		if (Validator.isNotNull(caNumber)) {
			formattedNumber = String.format("%012d", Long.valueOf(caNumber));
			//log.debug("Formatted account number from  getValidAccountNumber method ::::::::  " + formattedNumber);
		}
		return formattedNumber;
	}
	private static String chageRequestNewSoapCallXML(NewConnectionWrapper newConnectionWrapper) {
		String orderNo = StringPool.BLANK;
		String requestXML = null;
		try {
		
			String parentCat = StringPool.BLANK;
			String female = StringPool.BLANK;
			String male = StringPool.BLANK;
			String appliedLoadkva = StringPool.BLANK;
			String appliedLoad = StringPool.BLANK;
			if (Validator.isNotNull(newConnectionWrapper.getTitle()) && newConnectionWrapper.getTitle().equals(DigitalSevaKendraConstants.TITLE_PARAM)) {
				parentCat = DigitalSevaKendraConstants.PARENT_CAT_2;
			} else {
				parentCat = DigitalSevaKendraConstants.PARENT_CAT_1;
			}
			if (Validator.isNotNull(newConnectionWrapper.getSex()) && newConnectionWrapper.getSex().equals("m")) {
				male = DigitalSevaKendraConstants.MALE;
				female = StringPool.BLANK;
			} else {
				female = DigitalSevaKendraConstants.FEMALE;
				male = StringPool.BLANK;
			}
			if (Validator.isNotNull(newConnectionWrapper.getAppliedLoadType()) && newConnectionWrapper.getAppliedLoadType().equals("KVA")) {
				appliedLoadkva = Long.toString(newConnectionWrapper.getAppliedLoad());
				appliedLoad = StringPool.BLANK;
			} else { // VA
				appliedLoad = Long.toString(newConnectionWrapper.getAppliedLoad());
				appliedLoadkva = StringPool.BLANK;
			}
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
			String startDate = ""; // formater.format(newConnectionWrapper.getAppointmentStartDate());
			String endDate = ""; // formater.format(newConnectionWrapper.getAppointmentFinishDate());
			if (Validator.isNotNull(newConnectionWrapper.getAppointmentStartDate()) && Validator.isNotNull(newConnectionWrapper.getAppointmentFinishDate())) {
				startDate = formater.format(newConnectionWrapper.getAppointmentStartDate());
				endDate = formater.format(newConnectionWrapper.getAppointmentFinishDate());
			} else {

				startDate = formater.format(new Date());
				endDate = formater.format(new Date());
			}
			
		/*	_log.info("I_ILART-----"+newConnectionWrapper.getiIlart());
			_log.info("I_VKONT-----"+newConnectionWrapper.getCaNumberTwelveDigit());
			_log.info("I_VKONA-----"+newConnectionWrapper.getCaNumber());
			_log.info("PARTNERCATEGORY-----"+parentCat);
			_log.info("PARTNERTYPE-----"+DigitalSevaKendraConstants.PARTNER_TYPE);
			_log.info("TITLE_KEY-----"+newConnectionWrapper.getTitle());
			_log.info("FIRSTNAME-----"+newConnectionWrapper.getFirstName());
			_log.info("LASTNAME-----"+newConnectionWrapper.getLastName());
			_log.info("MIDDLENAME-----"+newConnectionWrapper.getMiddleName());
			_log.info("FATHERSNAME-----"+newConnectionWrapper.getFatherName());
			_log.info("HOUSE_NO-----"+newConnectionWrapper.getHouseNo());
			_log.info("BUILDING-----"+newConnectionWrapper.getBuildingName());
			_log.info("STR_SUPPL1-----"+newConnectionWrapper.getStreet());
			_log.info("STR_SUPPL2-----"+newConnectionWrapper.getArea());
			_log.info("STR_SUPPL3-----"+newConnectionWrapper.getLandmark());
			_log.info("POSTL_COD1-----"+newConnectionWrapper.getPin());
			_log.info("CITY-----"+DigitalSevaKendraConstants.CITY);
			_log.info("E_MAIL-----"+newConnectionWrapper.getEmail());
			_log.info("LANDLINE-----"+newConnectionWrapper.getPhoneNo());
			_log.info("MOBILE-----"+newConnectionWrapper.getMobileNo());
			_log.info("FEMALE-----"+female);
			_log.info("MALE-----"+male);
			_log.info("JOBGR-----"+newConnectionWrapper.getOccupation());
			_log.info("IDTYPE-----"+StringPool.BLANK);
			_log.info("IDNUMBER-----"+StringPool.BLANK);
			_log.info("PLANNINGPLANT-----"+newConnectionWrapper.getPlanningPlant());
			_log.info("WORKCENTRE------"+newConnectionWrapper.getDistrict());
			_log.info("SYSTEMCOND-----"+DigitalSevaKendraConstants.SYSTEMCOND);
			_log.info("APPLIEDCAT-----"+newConnectionWrapper.getAppliedCategory()); 
			_log.info("APPLIEDLOAD-----"+appliedLoad);
			_log.info("APPLIEDLOADKVA-----"+appliedLoadkva);
			_log.info("CONNECTIONTYPE-----"+newConnectionWrapper.getConnectionType());
			_log.info("STATEMENT_CA-----"+StringPool.BLANK);
			_log.info("START_DATE-----"+startDate);
			_log.info("START_TIME-----"+newConnectionWrapper.getAppointmentStartTime());
			_log.info("FINISH_DATE-----"+endDate);
			_log.info("FINISH_TIME-----"+newConnectionWrapper.getAppointmentFinishTime());
			_log.info("SORTFIELD-----"+DigitalSevaKendraConstants.SORTFIELD);
			_log.info("ABKRS-----"+DigitalSevaKendraConstants.ABKRS);
			_log.info("LATITUDE-----"+StringPool.BLANK);
			_log.info("LONGITUDE-----"+StringPool.BLANK);
			_log.info("GEOCOR_ADDRESS-----"+StringPool.BLANK);
			_log.info("APPOINT_DIV-----"+StringPool.BLANK);*/
			
			// call web service
			StringBuilder reqXML = new StringBuilder();
			reqXML.append(
					"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema/\" 	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
					.append("<soap:Body>").append("<Z_BAPI_ZDSS_WEB_LINK xmlns=\"http://tempuri.org/\">")
					.append("<I_ILART>").append(Validator.isNotNull(newConnectionWrapper.getiIlart()) ? newConnectionWrapper.getiIlart() : StringPool.BLANK).append("</I_ILART>")
					.append("<I_VKONT>").append(Validator.isNotNull(newConnectionWrapper.getCaNumberTwelveDigit()) ? newConnectionWrapper.getCaNumberTwelveDigit() : StringPool.BLANK).append("</I_VKONT>")
					.append("<I_VKONA>").append(Validator.isNotNull(newConnectionWrapper.getCaNumber()) ? newConnectionWrapper.getCaNumber() : StringPool.BLANK).append("</I_VKONA>")
					.append("<PARTNERCATEGORY>").append(parentCat).append("</PARTNERCATEGORY>")
					.append("<PARTNERTYPE>").append(DigitalSevaKendraConstants.PARTNER_TYPE).append("</PARTNERTYPE>")
					.append("<TITLE_KEY>").append(Validator.isNotNull(newConnectionWrapper.getTitle()) ? newConnectionWrapper.getTitle() : StringPool.BLANK).append("</TITLE_KEY>")
					.append("<FIRSTNAME>").append(Validator.isNotNull(newConnectionWrapper.getFirstName()) ? newConnectionWrapper.getFirstName() : StringPool.BLANK).append("</FIRSTNAME>")
					.append("<LASTNAME>").append(Validator.isNotNull(newConnectionWrapper.getLastName()) ? newConnectionWrapper.getLastName() : StringPool.BLANK).append("</LASTNAME>")
					.append("<MIDDLENAME>").append(Validator.isNotNull(newConnectionWrapper.getMiddleName()) ? newConnectionWrapper.getMiddleName() : StringPool.BLANK).append("</MIDDLENAME>")
					.append("<FATHERSNAME>").append(Validator.isNotNull(newConnectionWrapper.getFatherName()) ? newConnectionWrapper.getFatherName() : StringPool.BLANK).append("</FATHERSNAME>")
					.append("<HOUSE_NO>").append(Validator.isNotNull(newConnectionWrapper.getHouseNo()) ? newConnectionWrapper.getHouseNo() : StringPool.BLANK).append("</HOUSE_NO>")
					.append("<BUILDING>").append(Validator.isNotNull(newConnectionWrapper.getBuildingName()) ? newConnectionWrapper.getBuildingName() : StringPool.BLANK).append("</BUILDING>")
					.append("<STR_SUPPL1>").append(Validator.isNotNull(newConnectionWrapper.getStreet()) ? newConnectionWrapper.getStreet() : StringPool.BLANK).append("</STR_SUPPL1>")
					.append("<STR_SUPPL2>").append(Validator.isNotNull(newConnectionWrapper.getArea()) ? newConnectionWrapper.getArea() : StringPool.BLANK).append("</STR_SUPPL2>")
					.append("<STR_SUPPL3>").append(Validator.isNotNull(newConnectionWrapper.getLandmark()) ? newConnectionWrapper.getLandmark() : StringPool.BLANK).append("</STR_SUPPL3>")
					.append("<POSTL_COD1>").append(Validator.isNotNull(newConnectionWrapper.getPin()) ? newConnectionWrapper.getPin() : StringPool.BLANK).append("</POSTL_COD1>")
					.append("<CITY>").append(DigitalSevaKendraConstants.CITY).append("</CITY>")
					.append("<E_MAIL>").append(Validator.isNotNull(newConnectionWrapper.getEmail()) ? newConnectionWrapper.getEmail() : StringPool.BLANK).append("</E_MAIL>")
					.append("<LANDLINE>").append(Validator.isNotNull(newConnectionWrapper.getPhoneNo()) ? newConnectionWrapper.getPhoneNo() : StringPool.BLANK).append("</LANDLINE>")
					.append("<MOBILE>").append(newConnectionWrapper.getMobileNo()).append("</MOBILE>")
					.append("<FEMALE>").append(female).append("</FEMALE>")
					.append("<MALE>").append(male).append("</MALE>")
					.append("<JOBGR>").append(Validator.isNotNull(newConnectionWrapper.getOccupation()) ? newConnectionWrapper.getOccupation() : StringPool.BLANK).append("</JOBGR>")
					.append("<IDTYPE>").append(StringPool.BLANK).append("</IDTYPE>")
					.append("<IDNUMBER>").append(StringPool.BLANK).append("</IDNUMBER>")
					.append("<PLANNINGPLANT>").append(newConnectionWrapper.getPlanningPlant()).append("</PLANNINGPLANT>")
					.append("<WORKCENTRE>").append(Validator.isNotNull(newConnectionWrapper.getDistrict()) ? newConnectionWrapper.getDistrict() : StringPool.BLANK).append("</WORKCENTRE>")
					.append("<SYSTEMCOND>").append(DigitalSevaKendraConstants.SYSTEMCOND).append("</SYSTEMCOND>")
					.append("<APPLIEDCAT>").append(Validator.isNotNull(newConnectionWrapper.getAppliedCategory()) ? newConnectionWrapper.getAppliedCategory() : StringPool.BLANK).append("</APPLIEDCAT>")
					.append("<APPLIEDLOAD>").append(appliedLoad).append("</APPLIEDLOAD>")
					.append("<APPLIEDLOADKVA>").append(appliedLoadkva).append("</APPLIEDLOADKVA>")
					.append("<CONNECTIONTYPE>").append(Validator.isNotNull(newConnectionWrapper.getConnectionType()) ? newConnectionWrapper.getConnectionType() : StringPool.BLANK).append("</CONNECTIONTYPE>")
					.append("<STATEMENT_CA>").append(StringPool.BLANK).append("</STATEMENT_CA>")
					.append("<START_DATE>").append(startDate).append("</START_DATE>")
					.append("<START_TIME>").append(Validator.isNotNull(newConnectionWrapper.getAppointmentStartTime()) ? newConnectionWrapper.getAppointmentStartTime() : StringPool.BLANK).append("</START_TIME>")
					.append("<FINISH_DATE>").append(endDate).append("</FINISH_DATE>")
					.append("<FINISH_TIME>").append(Validator.isNotNull(newConnectionWrapper.getAppointmentFinishTime()) ? newConnectionWrapper.getAppointmentFinishTime() : StringPool.BLANK).append("</FINISH_TIME>")
					.append("<SORTFIELD>").append(DigitalSevaKendraConstants.SORTFIELD).append("</SORTFIELD>")
					.append("<ABKRS>").append(DigitalSevaKendraConstants.ABKRS).append("</ABKRS>")
					.append("<LATITUDE>").append(StringPool.BLANK).append("</LATITUDE>")
					.append("<LONGITUDE>").append(StringPool.BLANK).append("</LONGITUDE>")
					.append("<GEOCOR_ADDRESS>").append(StringPool.BLANK).append("</GEOCOR_ADDRESS>")
					.append("<APPOINT_DIV>").append(Validator.isNotNull(newConnectionWrapper.getAppointmentDistrict()) ? newConnectionWrapper.getAppointmentDistrict() : StringPool.BLANK).append("</APPOINT_DIV>")
					.append("</Z_BAPI_ZDSS_WEB_LINK>").append("</soap:Body>").append("</soap:Envelope>");
			 requestXML = reqXML.toString();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
			
		return requestXML;
	}
	private static String callService(String requestXML) {
		String xmlString = null;
		String responseString = StringPool.BLANK;
		StringBuffer outputSb = new StringBuffer();
		
		String wsURL=PropsUtil.get("Z_BAPI_ZDSS_WEB_LINK_BASE_URL");
		String SOAPAction=PropsUtil.get("Z_BAPI_ZDSS_WEB_LINK_SOAP_ACTION");
		
		if (Validator.isNotNull(wsURL)) {
			Date startDate = new Date();
			InputStreamReader isr = null;
			try {
				URL url = new URL(wsURL);
				URLConnection connection = url.openConnection();
				HttpURLConnection httpConn = (HttpURLConnection) connection;
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] buffer = new byte[requestXML.length()];
				buffer = requestXML.getBytes();
				bout.write(buffer);
				byte[] b = bout.toByteArray();

				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
				httpConn.setRequestProperty("SOAPAction", SOAPAction);
				httpConn.setRequestMethod("POST");
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				
				OutputStream out = httpConn.getOutputStream();

				// Write the content of the request to the outputstream of the HTTP Connection.
				out.write(b);
				out.close();
				// Ready with sending the request.
				isr = new InputStreamReader(httpConn.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				while ((responseString = in.readLine()) != null) {
					outputSb.append(responseString);
				}
			
			} catch (Exception e) {
				LOGGER.error(e);
				LOGGER.error("Error occured while calling ZBAPI_CS_ORD_STAT with JAVA API : " + e);
			} finally {
				if (Validator.isNotNull(isr)) {
					try {
						isr.close();
					} catch (IOException e) {
						LOGGER.error(e);
					}
				}
			}
		}

		try {
			xmlString = substringBetween(outputSb.toString(), "<E_Service_Order>", "</E_Service_Order>");
			LOGGER.info("xmlString from 1 st call-------" + xmlString);
		} catch (Exception e) {
			LOGGER.info("Exception occured while fetching data from 1 st time");
		}
		return xmlString;
	}
	
	/*
	public String generateRequestNo(String discomKey, String requestType) {
		String discomCode = StringPool.BLANK;
		if (discomKey.equals("D021") || discomKey.equalsIgnoreCase("brpl")) {
			discomCode = "R";
		} else {
			discomCode = "Y";
		}
		// create new request number
		return _dssNewConnRequestLocalService.generateReqNo(discomCode, getConnType(requestType));
	}
	 */
	
	public String getConnType(String requestType) {
		if (requestType.equals("SLCC")) {
			return "S";
		} else if (requestType.equals("MLCC")) {
			return "M";
		} else if (requestType.equals("GCC")) {
			return "G";
		} else if (requestType.equals("KCC")) {
			return "K";
		}
		return StringPool.BLANK;
	}

	public static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != -1) {
			int end = str.indexOf(close, start + open.length());
			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}
	
}
