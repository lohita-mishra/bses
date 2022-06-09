package com.bses.connection2.helper;

import com.bses.connection2.model.ConnectionRequest;
import com.bses.connection2.service.ConnectionRequestLocalServiceUtil;
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
		String serviceOrder = null;
		try {
			ConnectionRequest connectionRequest=ConnectionRequestLocalServiceUtil.getConnectionRequest(connectionRequestId);
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
	// _log.info("requestXML----"+requestXML);

			serviceOrder = callService(requestXML);
			
			if (serviceOrder.equals(null) || serviceOrder.isEmpty() || serviceOrder.equals("null")) {
				serviceOrder = callService(requestXML);
			}

			LOGGER.info("getServiceOrder from sap for req no '" + connectionRequest.getRequestNo() + "' is "+ serviceOrder);

			// save service order and bp number into external database
			if (Validator.isNotNull(serviceOrder)) {
				connectionRequest.setBpNumber(StringPool.BLANK);
				connectionRequest.setOrderNo(serviceOrder);
				connectionRequest.setDocumentUploaded("Y");
				connectionRequest.setSapOrderGenerated("Y");
				ConnectionRequestLocalServiceUtil.updateConnectionRequest(connectionRequest);
				//ConnectionRequest connectionRequest = _dssNewConnRequestLocalService.updateDssNewConnRequest(dssNewConnRequest);

				//dssNewConDocsPathLocalService.addNewConDocPathFromNewConDocTemp(dssNewConnRequest.getRequestNo(),
				//		dssNewConnRequest.getOrderNo(), dssNewConnRequest.getUserName());
			} else {
				ConnectionRequestLocalServiceUtil.deleteConnectionRequest(connectionRequest);
				//_dssNewConnRequestLocalService.deleteDssNewConnRequest(dssNewConnRequest.getRequestNo());
				LOGGER.info("ServiceOrder is empty from SAP, record deleted from DSS_NEW_CON_REQUEST for req no - "
						+ connectionRequest.getRequestNo());
			}

		} catch (Exception e) {
			LOGGER.error(" Error occuired while creating new connection request :- " + e);
		}
		return serviceOrder;
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
