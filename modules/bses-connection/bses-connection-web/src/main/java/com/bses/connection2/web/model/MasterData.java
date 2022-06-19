package com.bses.connection2.web.model;

import com.bses.connection2.util.RequestTypeModeStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public class MasterData {
	static final Map<String, String> floors=new LinkedHashMap<>();
	static final Map<String, String> landmarks=new LinkedHashMap<>();
	static final Map<String, String> titles=new LinkedHashMap<>();
	static final Map<String, String> tariffCategories=new LinkedHashMap<>();
	static final Map<String, String> premisesTypes=new LinkedHashMap<>();
	static final Map<String, String> idProofTypes=new LinkedHashMap<>();
	static final Map<String, String> firmIdProofTypes=new LinkedHashMap<>();
	
	static final Map<String, String> ownershipProofTypes=new LinkedHashMap<>();
	static final Map<String, String> firmOwnershipProofTypes=new LinkedHashMap<>();
	static final Map<String, String> requestTypes=new LinkedHashMap<>();
	static final Map<String, String> timeSlots=new LinkedHashMap<>();
	
	public static Map<String, String> getRequestTypes(){
		if(requestTypes.isEmpty()) {
			requestTypes.put(RequestTypeModeStatus.TYPE_NEW_CONNECTION, "New Connection");
			requestTypes.put(RequestTypeModeStatus.TYPE_NAME_CHANGE, "Name Change");
			requestTypes.put(RequestTypeModeStatus.TYPE_ADDRESS_CHANGE, "Address Change");
			requestTypes.put(RequestTypeModeStatus.TYPE_LOAD_CHANGE, "Load Change");
			requestTypes.put(RequestTypeModeStatus.TYPE_CATEGORY_CHANGE, "Category Change");
		}
		return requestTypes;
	}
	
	public static String getRequestType(String key){
		if(requestTypes.isEmpty()) {
			getRequestTypes();
		}
		return requestTypes.get(key);
	}
	
	public static Map<String, String> getFloors(){
		if(floors.isEmpty()) {
			floors.put("0", "Ground");
			floors.put("-1", "Basement");
			for(int i=1; i<100; i++) {
				floors.put(String.valueOf(i), "Floor "+i);
			}
			floors.put("100", "Terrace");
		}
		return floors;
	}
	
	public static String getFloorValue(String key) {
		if(floors.isEmpty()) {
			getFloors();
		}
		return floors.get(key);
	}
	
	public static Map<String, String> getLandmarks(){
		if(landmarks.isEmpty()) {
			landmarks.put("Above", "Above");
			landmarks.put("Behind", "Behind");
			landmarks.put("Below", "Below");
			landmarks.put("Near", "Near");
			landmarks.put("Opposite", "Opposite");
		}
		return landmarks;
	}
	
	public static String getLandmarkValue(String key) {
		if(landmarks.isEmpty()) {
			getLandmarks();
		}
		return landmarks.get(key);
	}
	
	public static Map<String, String> getTitles(){
		if(titles.isEmpty()) {
			titles.put("0002", "Mr.");
			titles.put("0001", "Ms");
			titles.put("0003", "Dr");
			titles.put("0004", "Prof.");
			titles.put("0006", "M/s");
		}
		return titles;
	}
	
	public static String getTitleValue(String key) {
		if(titles.isEmpty()) {
			getTitles();
		}
		return titles.get(key);
	}
	
	public static Map<String, String> getTariffCategories(){
		if(tariffCategories.isEmpty()) {
			tariffCategories.put("0100", "Domestic");
			tariffCategories.put("0290", "Non Domestic");
			tariffCategories.put("0320", "Industrial");
			tariffCategories.put("0250", "Agriculture");
			tariffCategories.put("0280", "Mushrooms");
			tariffCategories.put("0600", "Public Utility");
			tariffCategories.put("0700", "Charging Station e-Vehicles");
		}
		return tariffCategories;
	}
	public static String getTariffCategoryValue(String key) {
		if(tariffCategories.isEmpty()) {
			getTariffCategories();
		}
		return tariffCategories.get(key);
	}
	
	public static Map<String, String> getPremisesTypes(){
		if(premisesTypes.isEmpty()) {
			premisesTypes.put("1", "Owned");
			premisesTypes.put("2", "Rented/Leased");
			premisesTypes.put("3", "Others");
		}
		return premisesTypes;
	}
	
	public static String getPremisesTypeValue(String key) {
		if(premisesTypes.isEmpty()) {
			getPremisesTypes();
		}
		return premisesTypes.get(key);
	}
	
	public static Map<String, String> getIDProofTypes(){
		if(idProofTypes.isEmpty()) {
			idProofTypes.put("DL", "Driving License");
			idProofTypes.put("Election", "Electoral Identity Card");
			idProofTypes.put("Aadhaar", "Aadhaar Card");
			idProofTypes.put("Govt Identity Card", "Photo Identity Card Issued By Any Govt. Agency");
			idProofTypes.put("Passport", "Passport");
			idProofTypes.put("PAN", "PAN Card");
			idProofTypes.put("Ration Card", "Ration Card having Photograph");
		}
		return idProofTypes;
	}
	
	public static String getIDProofTypeValue(String key) {
		if(idProofTypes.isEmpty()) {
			getIDProofTypes();
		}
		return idProofTypes.get(key);
	}
	
	public static Map<String, String> getFirmIDProofTypes(){
		if(firmIdProofTypes.isEmpty()) {
			firmIdProofTypes.put("Authorization Letter", "Authorization Letter for Authorized Signatory");
			firmIdProofTypes.put("Self Attested ID Proof", "Self Attested Authorized Signatory ID Proof");
			firmIdProofTypes.put("Certificate of incorporation", "Certificate of incorporation / Registration issued by Registrar / Resolution of Board");
		}
		return firmIdProofTypes;
	}
	
	public static String getFirmIDProofTypeValue(String key) {
		if(firmIdProofTypes.isEmpty()) {
			getFirmIDProofTypes();
		}
		return firmIdProofTypes.get(key);
	}
	
	public static Map<String, String> getOwnershipProofTypes(){
		if(ownershipProofTypes.isEmpty()) {
			ownershipProofTypes.put("Title Deed", "Certified Copy of Title Deed");
		}
		return ownershipProofTypes;
	}
	
	public static String getOwnershipProofTypeValue(String key) {
		if(ownershipProofTypes.isEmpty()) {
			getOwnershipProofTypes();
		}
		return ownershipProofTypes.get(key);
	}
	
	public static Map<String, String> getFirmOwnershipProofTypes(){
		if(firmOwnershipProofTypes.isEmpty()) {
			firmOwnershipProofTypes.put("GPA", "Board Resolution General Power of Attorney (GPA)");
			firmOwnershipProofTypes.put("MOA", "Memorandum and Articles of Association");
			firmOwnershipProofTypes.put("VIL/LDC", "Valid Industrial Certificate/Lal Dora Certificate ");
		}
		return firmOwnershipProofTypes;
	}
	
	public static String getFirmOwnershipProofTypeValue(String key) {
		if(firmOwnershipProofTypes.isEmpty()) {
			getFirmOwnershipProofTypes();
		}
		return firmOwnershipProofTypes.get(key);
	}
	
	public static Map<String, String> getTimeSlots(){
		if(timeSlots.isEmpty()) {
			timeSlots.put("09:30:00", "09:30 AM - 10:15 AM");
			timeSlots.put("10:15:00", "10:15 AM - 11:00 AM");
			timeSlots.put("11:00:00", "11:00 AM - 11:45 AM");
			timeSlots.put("11:45:00", "11:45 AM - 12:30 PM");
			timeSlots.put("12:30:00", "12:30 PM - 01:15 PM");
			timeSlots.put("14:25:00", "02:25 PM - 03:10 PM");
			timeSlots.put("15:10:00", "03:10 PM - 03:55 PM");
		}
		return timeSlots;
	}
	
	public static String getTimeSlotValue(String key) {
		if(timeSlots.isEmpty()) {
			getTimeSlots();
		}
		return timeSlots.get(key);
	}
	
	public static String getTimeSlotsString() {
		if(timeSlots.isEmpty()) {
			getTimeSlots();
		}
		StringBuilder str=new StringBuilder("");
		for(String key:timeSlots.keySet()) {
			str.append(key).append(",");
		}
		return str.substring(0, str.length()-1);
	}
	
	public enum ConsumerTypes{
		Individual, Firm
	}
}
