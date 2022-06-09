package com.bses.connection2.web.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MasterData {
	static final Map<String, String> floors=new LinkedHashMap<>();
	static final Map<String, String> landmarks=new LinkedHashMap<>();
	static final Map<String, String> titles=new LinkedHashMap<>();
	static final Map<String, String> tariffCategories=new LinkedHashMap<>();
	static final Map<String, String> premisesTypes=new LinkedHashMap<>();
	
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
	
	public static Map<String, String> getPremisesTypes(){
		if(premisesTypes.isEmpty()) {
			premisesTypes.put("1", "Owned");
			premisesTypes.put("2", "Rented/Leased");
			premisesTypes.put("3", "Others");
		}
		return premisesTypes;
	}
	
	public enum ConsumerTypes{
		Individual, Firm
	}
}
