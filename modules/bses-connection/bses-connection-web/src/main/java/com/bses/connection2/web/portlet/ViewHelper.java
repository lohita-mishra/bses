package com.bses.connection2.web.portlet;

import com.bses.connection2.model.ConnectionRequest;
import com.bses.connection2.util.RequestTypeModeStatus;

import org.apache.commons.lang3.StringUtils;

public class ViewHelper {
	public static boolean canEditConsumerType(ConnectionRequest requestEntity){
		boolean canEdit = true;
		System.out.println("requestEntity.getRequestType() > "+requestEntity.getRequestType());
		if(requestEntity != null && StringUtils.equalsIgnoreCase(requestEntity.getRequestType(),RequestTypeModeStatus.TYPE_NAME_CHANGE)) {
			canEdit = false;
		}
		
		return canEdit;
		
	}

}
