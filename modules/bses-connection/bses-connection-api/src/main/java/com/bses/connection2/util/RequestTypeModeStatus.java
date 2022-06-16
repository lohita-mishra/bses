package com.bses.connection2.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestTypeModeStatus {
	public static String TYPE_NEW_CONNECTION="U01";
	public static String TYPE_NAME_CHANGE="U02";
	public static String TYPE_LOAD_INCREASE="U03";
	public static String TYPE_LOAD_DECREASE="U04";
	public static String TYPE_CATEGORY_CHANGE_LTH="U05";
	public static String TYPE_CATEGORY_CHANGE_HTL="U06";
	public static String TYPE_ADDRESS_CHANGE="U07";
	
	public static String TYPE_LOAD_CHANGE="U03/U04";
	public static String TYPE_CATEGORY_CHANGE="U05/U06";
	
	public static String MODE_ONLINE="Online";
	public static String MODE_APPOINTMENT="Appointment";
	
	public static String STATUS_DRAFT="Draft";
	public static String STATUS_SUBMITTED="Submitted";
	public static String STATUS_PENDING="Pending";
	public static String STATUS_ORDER_GENERATED="Order generated";
	
	private static Map<String, String> requestTypes=new LinkedHashMap<String, String> ();
	public static String getRequestType(String key) {
		if(requestTypes.isEmpty()) {
			requestTypes.put(TYPE_NEW_CONNECTION, "New Connection");
			requestTypes.put(TYPE_NAME_CHANGE, "Name Change");
			requestTypes.put(TYPE_LOAD_CHANGE, "Load Change");
			requestTypes.put(TYPE_CATEGORY_CHANGE, "Category Change");
			requestTypes.put(TYPE_ADDRESS_CHANGE, "Address Change");
		}
		return requestTypes.get(key);
	}
}
