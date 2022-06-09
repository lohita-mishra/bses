package com.bses.connection2.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSUtil {

private static final Log log = LogFactoryUtil.getLog(SMSUtil.class);

public static void sendSMS(String mobileNo, String message) {

	try {
		System.out.println("send sms ...");
		String requestUrl = PropsUtil.get("bses.otp.service");
		String encodedURL = requestUrl;
		StringBuffer postData = new StringBuffer(StringPool.BLANK);
		postData.append("mnumber").append(StringPool.EQUAL).append(mobileNo);
		postData.append(StringPool.AMPERSAND);
		postData.append("message").append(StringPool.EQUAL).append(URLEncoder.encode(message, "UTF-8"));

		System.out.println("post data ...." + postData);
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		URL url = new URL(encodedURL);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setDoOutput(true);
		uc.setRequestMethod("POST");
		uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		uc.setRequestProperty("charset", "utf-8");
		uc.setRequestProperty("Content-Length", Integer.toString(postDataBytes.length));
		uc.getOutputStream().write(postDataBytes);

		uc.getResponseMessage();

		// get SMS response String
		log.debug("SMS response code - " + uc.getResponseCode());
		StringBuffer response = new StringBuffer();
		if (uc.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		}
		String responseStr = response.toString();
		StringBuffer sb1 = new StringBuffer("responseStr === ");
		sb1.append(responseStr);
		log.info(sb1);

		if (uc.getResponseCode() == 200) {
			log.info("SMS successfully sent .... !!!");
		} else {
			log.info("Failed to send SMS with erro code.... " + uc.getResponseCode());
		}

	} catch (Exception e) {
		log.error("sendSMSTest() Exception - " + e);
	}

}

}
