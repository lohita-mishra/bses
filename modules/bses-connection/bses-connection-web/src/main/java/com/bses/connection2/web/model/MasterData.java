package com.bses.connection2.web.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MasterData {
	static final Map<String, String> floors=new LinkedHashMap<>();
	static final Map<String, String> landmarks=new LinkedHashMap<>();
	static final Map<String, String> titles=new LinkedHashMap<>();
	static final Map<String, String> tariffCategories=new LinkedHashMap<>();
	static final Map<String, String> premisesTypes=new LinkedHashMap<>();
	static final Map<String, String> idProofTypes=new LinkedHashMap<>();
	static final Map<String, String> ownershipProofTypes=new LinkedHashMap<>();
	
	
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
			idProofTypes.put("Passport", "Owned");
			idProofTypes.put("Aadhaar Card", "Aadhaar Card");
			idProofTypes.put("PAN Card", "PAN Card");
			idProofTypes.put("Driving License", "Driving License");
		}
		return idProofTypes;
	}
	
	public static String getIDProofTypeValue(String key) {
		if(idProofTypes.isEmpty()) {
			getIDProofTypes();
		}
		return idProofTypes.get(key);
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
	
	
	public enum ConsumerTypes{
		Individual, Firm
	}
}
