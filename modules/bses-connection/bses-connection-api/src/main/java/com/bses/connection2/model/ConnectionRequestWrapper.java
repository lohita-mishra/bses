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

package com.bses.connection2.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ConnectionRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionRequest
 * @generated
 */
public class ConnectionRequestWrapper
	implements ConnectionRequest, ModelWrapper<ConnectionRequest> {

	public ConnectionRequestWrapper(ConnectionRequest connectionRequest) {
		_connectionRequest = connectionRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return ConnectionRequest.class;
	}

	@Override
	public String getModelClassName() {
		return ConnectionRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("connectionRequestId", getConnectionRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("requestNo", getRequestNo());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("emailId", getEmailId());
		attributes.put("requestDate", getRequestDate());
		attributes.put("requestType", getRequestType());
		attributes.put("consumerType", getConsumerType());
		attributes.put("title", getTitle());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("sonDaughterWife", getSonDaughterWife());
		attributes.put("fatherOrHusbandName", getFatherOrHusbandName());
		attributes.put("firmName", getFirmName());
		attributes.put("signatoryName", getSignatoryName());
		attributes.put("signatoryDesignation", getSignatoryDesignation());
		attributes.put("organizationType", getOrganizationType());
		attributes.put("incorporationDate", getIncorporationDate());
		attributes.put("gstIn", getGstIn());
		attributes.put("panNo", getPanNo());
		attributes.put("locality", getLocality());
		attributes.put("district", getDistrict());
		attributes.put("houseNo", getHouseNo());
		attributes.put("floor", getFloor());
		attributes.put("buildingName", getBuildingName());
		attributes.put("street", getStreet());
		attributes.put("colonyArea", getColonyArea());
		attributes.put("landmark", getLandmark());
		attributes.put("landmarkDetails", getLandmarkDetails());
		attributes.put("pinCode", getPinCode());
		attributes.put("connectionType", getConnectionType());
		attributes.put("tariffCategory", getTariffCategory());
		attributes.put("loadKva", getLoadKva());
		attributes.put("loadKw", getLoadKw());
		attributes.put("areaType", getAreaType());
		attributes.put("premisesType", getPremisesType());
		attributes.put("upicAvailable", isUpicAvailable());
		attributes.put("upic", getUpic());
		attributes.put("wiringTest", isWiringTest());
		attributes.put("wiringCertificate", getWiringCertificate());
		attributes.put("elcbInstalled", isElcbInstalled());
		attributes.put("elcbDocument", getElcbDocument());
		attributes.put("stiltParking", isStiltParking());
		attributes.put("height15Mtr", isHeight15Mtr());
		attributes.put("height17Mtr", isHeight17Mtr());
		attributes.put("fcc", isFcc());
		attributes.put("fccCertificate", getFccCertificate());
		attributes.put("lift", isLift());
		attributes.put("liftCertificate", getLiftCertificate());
		attributes.put("agriConsumer", isAgriConsumer());
		attributes.put("hasBdoCertificate", isHasBdoCertificate());
		attributes.put("bdoCertificate", getBdoCertificate());
		attributes.put("hasDpccCertificate", isHasDpccCertificate());
		attributes.put("dpccCertificate", getDpccCertificate());
		attributes.put("hasPollutionCertificate", isHasPollutionCertificate());
		attributes.put("pollutionCertificate", getPollutionCertificate());
		attributes.put("eServiceOnMail", isEServiceOnMail());
		attributes.put("eServiceMailId", getEServiceMailId());
		attributes.put("applicantPhoto", getApplicantPhoto());
		attributes.put("applicantSignature", getApplicantSignature());
		attributes.put("idProofType", getIdProofType());
		attributes.put("idProofNo", getIdProofNo());
		attributes.put("idProofDocument", getIdProofDocument());
		attributes.put("ownershipProofType", getOwnershipProofType());
		attributes.put("ownershipProofDocument", getOwnershipProofDocument());
		attributes.put("selfDeclaration", isSelfDeclaration());
		attributes.put("selfDeclarationTime", getSelfDeclarationTime());
		attributes.put("bpNumber", getBpNumber());
		attributes.put("orderNo", getOrderNo());
		attributes.put("documentUploaded", getDocumentUploaded());
		attributes.put("sapOrderGenerated", getSapOrderGenerated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long connectionRequestId = (Long)attributes.get("connectionRequestId");

		if (connectionRequestId != null) {
			setConnectionRequestId(connectionRequestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String requestNo = (String)attributes.get("requestNo");

		if (requestNo != null) {
			setRequestNo(requestNo);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		Date requestDate = (Date)attributes.get("requestDate");

		if (requestDate != null) {
			setRequestDate(requestDate);
		}

		String requestType = (String)attributes.get("requestType");

		if (requestType != null) {
			setRequestType(requestType);
		}

		String consumerType = (String)attributes.get("consumerType");

		if (consumerType != null) {
			setConsumerType(consumerType);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String sonDaughterWife = (String)attributes.get("sonDaughterWife");

		if (sonDaughterWife != null) {
			setSonDaughterWife(sonDaughterWife);
		}

		String fatherOrHusbandName = (String)attributes.get(
			"fatherOrHusbandName");

		if (fatherOrHusbandName != null) {
			setFatherOrHusbandName(fatherOrHusbandName);
		}

		String firmName = (String)attributes.get("firmName");

		if (firmName != null) {
			setFirmName(firmName);
		}

		String signatoryName = (String)attributes.get("signatoryName");

		if (signatoryName != null) {
			setSignatoryName(signatoryName);
		}

		String signatoryDesignation = (String)attributes.get(
			"signatoryDesignation");

		if (signatoryDesignation != null) {
			setSignatoryDesignation(signatoryDesignation);
		}

		String organizationType = (String)attributes.get("organizationType");

		if (organizationType != null) {
			setOrganizationType(organizationType);
		}

		Date incorporationDate = (Date)attributes.get("incorporationDate");

		if (incorporationDate != null) {
			setIncorporationDate(incorporationDate);
		}

		String gstIn = (String)attributes.get("gstIn");

		if (gstIn != null) {
			setGstIn(gstIn);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String locality = (String)attributes.get("locality");

		if (locality != null) {
			setLocality(locality);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String houseNo = (String)attributes.get("houseNo");

		if (houseNo != null) {
			setHouseNo(houseNo);
		}

		String floor = (String)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String buildingName = (String)attributes.get("buildingName");

		if (buildingName != null) {
			setBuildingName(buildingName);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String colonyArea = (String)attributes.get("colonyArea");

		if (colonyArea != null) {
			setColonyArea(colonyArea);
		}

		String landmark = (String)attributes.get("landmark");

		if (landmark != null) {
			setLandmark(landmark);
		}

		String landmarkDetails = (String)attributes.get("landmarkDetails");

		if (landmarkDetails != null) {
			setLandmarkDetails(landmarkDetails);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String connectionType = (String)attributes.get("connectionType");

		if (connectionType != null) {
			setConnectionType(connectionType);
		}

		String tariffCategory = (String)attributes.get("tariffCategory");

		if (tariffCategory != null) {
			setTariffCategory(tariffCategory);
		}

		Float loadKva = (Float)attributes.get("loadKva");

		if (loadKva != null) {
			setLoadKva(loadKva);
		}

		Float loadKw = (Float)attributes.get("loadKw");

		if (loadKw != null) {
			setLoadKw(loadKw);
		}

		String areaType = (String)attributes.get("areaType");

		if (areaType != null) {
			setAreaType(areaType);
		}

		String premisesType = (String)attributes.get("premisesType");

		if (premisesType != null) {
			setPremisesType(premisesType);
		}

		Boolean upicAvailable = (Boolean)attributes.get("upicAvailable");

		if (upicAvailable != null) {
			setUpicAvailable(upicAvailable);
		}

		String upic = (String)attributes.get("upic");

		if (upic != null) {
			setUpic(upic);
		}

		Boolean wiringTest = (Boolean)attributes.get("wiringTest");

		if (wiringTest != null) {
			setWiringTest(wiringTest);
		}

		String wiringCertificate = (String)attributes.get("wiringCertificate");

		if (wiringCertificate != null) {
			setWiringCertificate(wiringCertificate);
		}

		Boolean elcbInstalled = (Boolean)attributes.get("elcbInstalled");

		if (elcbInstalled != null) {
			setElcbInstalled(elcbInstalled);
		}

		String elcbDocument = (String)attributes.get("elcbDocument");

		if (elcbDocument != null) {
			setElcbDocument(elcbDocument);
		}

		Boolean stiltParking = (Boolean)attributes.get("stiltParking");

		if (stiltParking != null) {
			setStiltParking(stiltParking);
		}

		Boolean height15Mtr = (Boolean)attributes.get("height15Mtr");

		if (height15Mtr != null) {
			setHeight15Mtr(height15Mtr);
		}

		Boolean height17Mtr = (Boolean)attributes.get("height17Mtr");

		if (height17Mtr != null) {
			setHeight17Mtr(height17Mtr);
		}

		Boolean fcc = (Boolean)attributes.get("fcc");

		if (fcc != null) {
			setFcc(fcc);
		}

		String fccCertificate = (String)attributes.get("fccCertificate");

		if (fccCertificate != null) {
			setFccCertificate(fccCertificate);
		}

		Boolean lift = (Boolean)attributes.get("lift");

		if (lift != null) {
			setLift(lift);
		}

		String liftCertificate = (String)attributes.get("liftCertificate");

		if (liftCertificate != null) {
			setLiftCertificate(liftCertificate);
		}

		Boolean agriConsumer = (Boolean)attributes.get("agriConsumer");

		if (agriConsumer != null) {
			setAgriConsumer(agriConsumer);
		}

		Boolean hasBdoCertificate = (Boolean)attributes.get(
			"hasBdoCertificate");

		if (hasBdoCertificate != null) {
			setHasBdoCertificate(hasBdoCertificate);
		}

		String bdoCertificate = (String)attributes.get("bdoCertificate");

		if (bdoCertificate != null) {
			setBdoCertificate(bdoCertificate);
		}

		Boolean hasDpccCertificate = (Boolean)attributes.get(
			"hasDpccCertificate");

		if (hasDpccCertificate != null) {
			setHasDpccCertificate(hasDpccCertificate);
		}

		String dpccCertificate = (String)attributes.get("dpccCertificate");

		if (dpccCertificate != null) {
			setDpccCertificate(dpccCertificate);
		}

		Boolean hasPollutionCertificate = (Boolean)attributes.get(
			"hasPollutionCertificate");

		if (hasPollutionCertificate != null) {
			setHasPollutionCertificate(hasPollutionCertificate);
		}

		String pollutionCertificate = (String)attributes.get(
			"pollutionCertificate");

		if (pollutionCertificate != null) {
			setPollutionCertificate(pollutionCertificate);
		}

		Boolean eServiceOnMail = (Boolean)attributes.get("eServiceOnMail");

		if (eServiceOnMail != null) {
			setEServiceOnMail(eServiceOnMail);
		}

		String eServiceMailId = (String)attributes.get("eServiceMailId");

		if (eServiceMailId != null) {
			setEServiceMailId(eServiceMailId);
		}

		String applicantPhoto = (String)attributes.get("applicantPhoto");

		if (applicantPhoto != null) {
			setApplicantPhoto(applicantPhoto);
		}

		Long applicantSignature = (Long)attributes.get("applicantSignature");

		if (applicantSignature != null) {
			setApplicantSignature(applicantSignature);
		}

		String idProofType = (String)attributes.get("idProofType");

		if (idProofType != null) {
			setIdProofType(idProofType);
		}

		String idProofNo = (String)attributes.get("idProofNo");

		if (idProofNo != null) {
			setIdProofNo(idProofNo);
		}

		String idProofDocument = (String)attributes.get("idProofDocument");

		if (idProofDocument != null) {
			setIdProofDocument(idProofDocument);
		}

		String ownershipProofType = (String)attributes.get(
			"ownershipProofType");

		if (ownershipProofType != null) {
			setOwnershipProofType(ownershipProofType);
		}

		String ownershipProofDocument = (String)attributes.get(
			"ownershipProofDocument");

		if (ownershipProofDocument != null) {
			setOwnershipProofDocument(ownershipProofDocument);
		}

		Boolean selfDeclaration = (Boolean)attributes.get("selfDeclaration");

		if (selfDeclaration != null) {
			setSelfDeclaration(selfDeclaration);
		}

		Date selfDeclarationTime = (Date)attributes.get("selfDeclarationTime");

		if (selfDeclarationTime != null) {
			setSelfDeclarationTime(selfDeclarationTime);
		}

		String bpNumber = (String)attributes.get("bpNumber");

		if (bpNumber != null) {
			setBpNumber(bpNumber);
		}

		String orderNo = (String)attributes.get("orderNo");

		if (orderNo != null) {
			setOrderNo(orderNo);
		}

		String documentUploaded = (String)attributes.get("documentUploaded");

		if (documentUploaded != null) {
			setDocumentUploaded(documentUploaded);
		}

		String sapOrderGenerated = (String)attributes.get("sapOrderGenerated");

		if (sapOrderGenerated != null) {
			setSapOrderGenerated(sapOrderGenerated);
		}
	}

	@Override
	public Object clone() {
		return new ConnectionRequestWrapper(
			(ConnectionRequest)_connectionRequest.clone());
	}

	@Override
	public int compareTo(ConnectionRequest connectionRequest) {
		return _connectionRequest.compareTo(connectionRequest);
	}

	/**
	 * Returns the agri consumer of this connection request.
	 *
	 * @return the agri consumer of this connection request
	 */
	@Override
	public boolean getAgriConsumer() {
		return _connectionRequest.getAgriConsumer();
	}

	/**
	 * Returns the applicant photo of this connection request.
	 *
	 * @return the applicant photo of this connection request
	 */
	@Override
	public String getApplicantPhoto() {
		return _connectionRequest.getApplicantPhoto();
	}

	/**
	 * Returns the applicant signature of this connection request.
	 *
	 * @return the applicant signature of this connection request
	 */
	@Override
	public long getApplicantSignature() {
		return _connectionRequest.getApplicantSignature();
	}

	/**
	 * Returns the area type of this connection request.
	 *
	 * @return the area type of this connection request
	 */
	@Override
	public String getAreaType() {
		return _connectionRequest.getAreaType();
	}

	/**
	 * Returns the bdo certificate of this connection request.
	 *
	 * @return the bdo certificate of this connection request
	 */
	@Override
	public String getBdoCertificate() {
		return _connectionRequest.getBdoCertificate();
	}

	/**
	 * Returns the bp number of this connection request.
	 *
	 * @return the bp number of this connection request
	 */
	@Override
	public String getBpNumber() {
		return _connectionRequest.getBpNumber();
	}

	/**
	 * Returns the building name of this connection request.
	 *
	 * @return the building name of this connection request
	 */
	@Override
	public String getBuildingName() {
		return _connectionRequest.getBuildingName();
	}

	/**
	 * Returns the colony area of this connection request.
	 *
	 * @return the colony area of this connection request
	 */
	@Override
	public String getColonyArea() {
		return _connectionRequest.getColonyArea();
	}

	/**
	 * Returns the company ID of this connection request.
	 *
	 * @return the company ID of this connection request
	 */
	@Override
	public long getCompanyId() {
		return _connectionRequest.getCompanyId();
	}

	/**
	 * Returns the connection request ID of this connection request.
	 *
	 * @return the connection request ID of this connection request
	 */
	@Override
	public long getConnectionRequestId() {
		return _connectionRequest.getConnectionRequestId();
	}

	/**
	 * Returns the connection type of this connection request.
	 *
	 * @return the connection type of this connection request
	 */
	@Override
	public String getConnectionType() {
		return _connectionRequest.getConnectionType();
	}

	/**
	 * Returns the consumer type of this connection request.
	 *
	 * @return the consumer type of this connection request
	 */
	@Override
	public String getConsumerType() {
		return _connectionRequest.getConsumerType();
	}

	/**
	 * Returns the create date of this connection request.
	 *
	 * @return the create date of this connection request
	 */
	@Override
	public Date getCreateDate() {
		return _connectionRequest.getCreateDate();
	}

	/**
	 * Returns the district of this connection request.
	 *
	 * @return the district of this connection request
	 */
	@Override
	public String getDistrict() {
		return _connectionRequest.getDistrict();
	}

	/**
	 * Returns the document uploaded of this connection request.
	 *
	 * @return the document uploaded of this connection request
	 */
	@Override
	public String getDocumentUploaded() {
		return _connectionRequest.getDocumentUploaded();
	}

	/**
	 * Returns the dpcc certificate of this connection request.
	 *
	 * @return the dpcc certificate of this connection request
	 */
	@Override
	public String getDpccCertificate() {
		return _connectionRequest.getDpccCertificate();
	}

	/**
	 * Returns the elcb document of this connection request.
	 *
	 * @return the elcb document of this connection request
	 */
	@Override
	public String getElcbDocument() {
		return _connectionRequest.getElcbDocument();
	}

	/**
	 * Returns the elcb installed of this connection request.
	 *
	 * @return the elcb installed of this connection request
	 */
	@Override
	public boolean getElcbInstalled() {
		return _connectionRequest.getElcbInstalled();
	}

	/**
	 * Returns the email ID of this connection request.
	 *
	 * @return the email ID of this connection request
	 */
	@Override
	public String getEmailId() {
		return _connectionRequest.getEmailId();
	}

	/**
	 * Returns the e service mail ID of this connection request.
	 *
	 * @return the e service mail ID of this connection request
	 */
	@Override
	public String getEServiceMailId() {
		return _connectionRequest.getEServiceMailId();
	}

	/**
	 * Returns the e service on mail of this connection request.
	 *
	 * @return the e service on mail of this connection request
	 */
	@Override
	public boolean getEServiceOnMail() {
		return _connectionRequest.getEServiceOnMail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _connectionRequest.getExpandoBridge();
	}

	/**
	 * Returns the father or husband name of this connection request.
	 *
	 * @return the father or husband name of this connection request
	 */
	@Override
	public String getFatherOrHusbandName() {
		return _connectionRequest.getFatherOrHusbandName();
	}

	/**
	 * Returns the fcc of this connection request.
	 *
	 * @return the fcc of this connection request
	 */
	@Override
	public boolean getFcc() {
		return _connectionRequest.getFcc();
	}

	/**
	 * Returns the fcc certificate of this connection request.
	 *
	 * @return the fcc certificate of this connection request
	 */
	@Override
	public String getFccCertificate() {
		return _connectionRequest.getFccCertificate();
	}

	/**
	 * Returns the firm name of this connection request.
	 *
	 * @return the firm name of this connection request
	 */
	@Override
	public String getFirmName() {
		return _connectionRequest.getFirmName();
	}

	/**
	 * Returns the first name of this connection request.
	 *
	 * @return the first name of this connection request
	 */
	@Override
	public String getFirstName() {
		return _connectionRequest.getFirstName();
	}

	/**
	 * Returns the floor of this connection request.
	 *
	 * @return the floor of this connection request
	 */
	@Override
	public String getFloor() {
		return _connectionRequest.getFloor();
	}

	/**
	 * Returns the group ID of this connection request.
	 *
	 * @return the group ID of this connection request
	 */
	@Override
	public long getGroupId() {
		return _connectionRequest.getGroupId();
	}

	/**
	 * Returns the gst in of this connection request.
	 *
	 * @return the gst in of this connection request
	 */
	@Override
	public String getGstIn() {
		return _connectionRequest.getGstIn();
	}

	/**
	 * Returns the has bdo certificate of this connection request.
	 *
	 * @return the has bdo certificate of this connection request
	 */
	@Override
	public boolean getHasBdoCertificate() {
		return _connectionRequest.getHasBdoCertificate();
	}

	/**
	 * Returns the has dpcc certificate of this connection request.
	 *
	 * @return the has dpcc certificate of this connection request
	 */
	@Override
	public boolean getHasDpccCertificate() {
		return _connectionRequest.getHasDpccCertificate();
	}

	/**
	 * Returns the has pollution certificate of this connection request.
	 *
	 * @return the has pollution certificate of this connection request
	 */
	@Override
	public boolean getHasPollutionCertificate() {
		return _connectionRequest.getHasPollutionCertificate();
	}

	/**
	 * Returns the height15 mtr of this connection request.
	 *
	 * @return the height15 mtr of this connection request
	 */
	@Override
	public boolean getHeight15Mtr() {
		return _connectionRequest.getHeight15Mtr();
	}

	/**
	 * Returns the height17 mtr of this connection request.
	 *
	 * @return the height17 mtr of this connection request
	 */
	@Override
	public boolean getHeight17Mtr() {
		return _connectionRequest.getHeight17Mtr();
	}

	/**
	 * Returns the house no of this connection request.
	 *
	 * @return the house no of this connection request
	 */
	@Override
	public String getHouseNo() {
		return _connectionRequest.getHouseNo();
	}

	/**
	 * Returns the id proof document of this connection request.
	 *
	 * @return the id proof document of this connection request
	 */
	@Override
	public String getIdProofDocument() {
		return _connectionRequest.getIdProofDocument();
	}

	/**
	 * Returns the id proof no of this connection request.
	 *
	 * @return the id proof no of this connection request
	 */
	@Override
	public String getIdProofNo() {
		return _connectionRequest.getIdProofNo();
	}

	/**
	 * Returns the id proof type of this connection request.
	 *
	 * @return the id proof type of this connection request
	 */
	@Override
	public String getIdProofType() {
		return _connectionRequest.getIdProofType();
	}

	/**
	 * Returns the incorporation date of this connection request.
	 *
	 * @return the incorporation date of this connection request
	 */
	@Override
	public Date getIncorporationDate() {
		return _connectionRequest.getIncorporationDate();
	}

	/**
	 * Returns the landmark of this connection request.
	 *
	 * @return the landmark of this connection request
	 */
	@Override
	public String getLandmark() {
		return _connectionRequest.getLandmark();
	}

	/**
	 * Returns the landmark details of this connection request.
	 *
	 * @return the landmark details of this connection request
	 */
	@Override
	public String getLandmarkDetails() {
		return _connectionRequest.getLandmarkDetails();
	}

	/**
	 * Returns the last name of this connection request.
	 *
	 * @return the last name of this connection request
	 */
	@Override
	public String getLastName() {
		return _connectionRequest.getLastName();
	}

	/**
	 * Returns the lift of this connection request.
	 *
	 * @return the lift of this connection request
	 */
	@Override
	public boolean getLift() {
		return _connectionRequest.getLift();
	}

	/**
	 * Returns the lift certificate of this connection request.
	 *
	 * @return the lift certificate of this connection request
	 */
	@Override
	public String getLiftCertificate() {
		return _connectionRequest.getLiftCertificate();
	}

	/**
	 * Returns the load kva of this connection request.
	 *
	 * @return the load kva of this connection request
	 */
	@Override
	public float getLoadKva() {
		return _connectionRequest.getLoadKva();
	}

	/**
	 * Returns the load kw of this connection request.
	 *
	 * @return the load kw of this connection request
	 */
	@Override
	public float getLoadKw() {
		return _connectionRequest.getLoadKw();
	}

	/**
	 * Returns the locality of this connection request.
	 *
	 * @return the locality of this connection request
	 */
	@Override
	public String getLocality() {
		return _connectionRequest.getLocality();
	}

	/**
	 * Returns the middle name of this connection request.
	 *
	 * @return the middle name of this connection request
	 */
	@Override
	public String getMiddleName() {
		return _connectionRequest.getMiddleName();
	}

	/**
	 * Returns the mobile no of this connection request.
	 *
	 * @return the mobile no of this connection request
	 */
	@Override
	public String getMobileNo() {
		return _connectionRequest.getMobileNo();
	}

	/**
	 * Returns the modified date of this connection request.
	 *
	 * @return the modified date of this connection request
	 */
	@Override
	public Date getModifiedDate() {
		return _connectionRequest.getModifiedDate();
	}

	/**
	 * Returns the order no of this connection request.
	 *
	 * @return the order no of this connection request
	 */
	@Override
	public String getOrderNo() {
		return _connectionRequest.getOrderNo();
	}

	/**
	 * Returns the organization type of this connection request.
	 *
	 * @return the organization type of this connection request
	 */
	@Override
	public String getOrganizationType() {
		return _connectionRequest.getOrganizationType();
	}

	/**
	 * Returns the ownership proof document of this connection request.
	 *
	 * @return the ownership proof document of this connection request
	 */
	@Override
	public String getOwnershipProofDocument() {
		return _connectionRequest.getOwnershipProofDocument();
	}

	/**
	 * Returns the ownership proof type of this connection request.
	 *
	 * @return the ownership proof type of this connection request
	 */
	@Override
	public String getOwnershipProofType() {
		return _connectionRequest.getOwnershipProofType();
	}

	/**
	 * Returns the pan no of this connection request.
	 *
	 * @return the pan no of this connection request
	 */
	@Override
	public String getPanNo() {
		return _connectionRequest.getPanNo();
	}

	/**
	 * Returns the pin code of this connection request.
	 *
	 * @return the pin code of this connection request
	 */
	@Override
	public String getPinCode() {
		return _connectionRequest.getPinCode();
	}

	/**
	 * Returns the pollution certificate of this connection request.
	 *
	 * @return the pollution certificate of this connection request
	 */
	@Override
	public String getPollutionCertificate() {
		return _connectionRequest.getPollutionCertificate();
	}

	/**
	 * Returns the premises type of this connection request.
	 *
	 * @return the premises type of this connection request
	 */
	@Override
	public String getPremisesType() {
		return _connectionRequest.getPremisesType();
	}

	/**
	 * Returns the primary key of this connection request.
	 *
	 * @return the primary key of this connection request
	 */
	@Override
	public long getPrimaryKey() {
		return _connectionRequest.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _connectionRequest.getPrimaryKeyObj();
	}

	/**
	 * Returns the request date of this connection request.
	 *
	 * @return the request date of this connection request
	 */
	@Override
	public Date getRequestDate() {
		return _connectionRequest.getRequestDate();
	}

	/**
	 * Returns the request no of this connection request.
	 *
	 * @return the request no of this connection request
	 */
	@Override
	public String getRequestNo() {
		return _connectionRequest.getRequestNo();
	}

	/**
	 * Returns the request type of this connection request.
	 *
	 * @return the request type of this connection request
	 */
	@Override
	public String getRequestType() {
		return _connectionRequest.getRequestType();
	}

	/**
	 * Returns the sap order generated of this connection request.
	 *
	 * @return the sap order generated of this connection request
	 */
	@Override
	public String getSapOrderGenerated() {
		return _connectionRequest.getSapOrderGenerated();
	}

	/**
	 * Returns the self declaration of this connection request.
	 *
	 * @return the self declaration of this connection request
	 */
	@Override
	public boolean getSelfDeclaration() {
		return _connectionRequest.getSelfDeclaration();
	}

	/**
	 * Returns the self declaration time of this connection request.
	 *
	 * @return the self declaration time of this connection request
	 */
	@Override
	public Date getSelfDeclarationTime() {
		return _connectionRequest.getSelfDeclarationTime();
	}

	/**
	 * Returns the signatory designation of this connection request.
	 *
	 * @return the signatory designation of this connection request
	 */
	@Override
	public String getSignatoryDesignation() {
		return _connectionRequest.getSignatoryDesignation();
	}

	/**
	 * Returns the signatory name of this connection request.
	 *
	 * @return the signatory name of this connection request
	 */
	@Override
	public String getSignatoryName() {
		return _connectionRequest.getSignatoryName();
	}

	/**
	 * Returns the son daughter wife of this connection request.
	 *
	 * @return the son daughter wife of this connection request
	 */
	@Override
	public String getSonDaughterWife() {
		return _connectionRequest.getSonDaughterWife();
	}

	/**
	 * Returns the stilt parking of this connection request.
	 *
	 * @return the stilt parking of this connection request
	 */
	@Override
	public boolean getStiltParking() {
		return _connectionRequest.getStiltParking();
	}

	/**
	 * Returns the street of this connection request.
	 *
	 * @return the street of this connection request
	 */
	@Override
	public String getStreet() {
		return _connectionRequest.getStreet();
	}

	/**
	 * Returns the tariff category of this connection request.
	 *
	 * @return the tariff category of this connection request
	 */
	@Override
	public String getTariffCategory() {
		return _connectionRequest.getTariffCategory();
	}

	/**
	 * Returns the title of this connection request.
	 *
	 * @return the title of this connection request
	 */
	@Override
	public String getTitle() {
		return _connectionRequest.getTitle();
	}

	/**
	 * Returns the upic of this connection request.
	 *
	 * @return the upic of this connection request
	 */
	@Override
	public String getUpic() {
		return _connectionRequest.getUpic();
	}

	/**
	 * Returns the upic available of this connection request.
	 *
	 * @return the upic available of this connection request
	 */
	@Override
	public boolean getUpicAvailable() {
		return _connectionRequest.getUpicAvailable();
	}

	/**
	 * Returns the user ID of this connection request.
	 *
	 * @return the user ID of this connection request
	 */
	@Override
	public long getUserId() {
		return _connectionRequest.getUserId();
	}

	/**
	 * Returns the user name of this connection request.
	 *
	 * @return the user name of this connection request
	 */
	@Override
	public String getUserName() {
		return _connectionRequest.getUserName();
	}

	/**
	 * Returns the user uuid of this connection request.
	 *
	 * @return the user uuid of this connection request
	 */
	@Override
	public String getUserUuid() {
		return _connectionRequest.getUserUuid();
	}

	/**
	 * Returns the uuid of this connection request.
	 *
	 * @return the uuid of this connection request
	 */
	@Override
	public String getUuid() {
		return _connectionRequest.getUuid();
	}

	/**
	 * Returns the wiring certificate of this connection request.
	 *
	 * @return the wiring certificate of this connection request
	 */
	@Override
	public String getWiringCertificate() {
		return _connectionRequest.getWiringCertificate();
	}

	/**
	 * Returns the wiring test of this connection request.
	 *
	 * @return the wiring test of this connection request
	 */
	@Override
	public boolean getWiringTest() {
		return _connectionRequest.getWiringTest();
	}

	@Override
	public int hashCode() {
		return _connectionRequest.hashCode();
	}

	/**
	 * Returns <code>true</code> if this connection request is agri consumer.
	 *
	 * @return <code>true</code> if this connection request is agri consumer; <code>false</code> otherwise
	 */
	@Override
	public boolean isAgriConsumer() {
		return _connectionRequest.isAgriConsumer();
	}

	@Override
	public boolean isCachedModel() {
		return _connectionRequest.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this connection request is elcb installed.
	 *
	 * @return <code>true</code> if this connection request is elcb installed; <code>false</code> otherwise
	 */
	@Override
	public boolean isElcbInstalled() {
		return _connectionRequest.isElcbInstalled();
	}

	@Override
	public boolean isEscapedModel() {
		return _connectionRequest.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this connection request is e service on mail.
	 *
	 * @return <code>true</code> if this connection request is e service on mail; <code>false</code> otherwise
	 */
	@Override
	public boolean isEServiceOnMail() {
		return _connectionRequest.isEServiceOnMail();
	}

	/**
	 * Returns <code>true</code> if this connection request is fcc.
	 *
	 * @return <code>true</code> if this connection request is fcc; <code>false</code> otherwise
	 */
	@Override
	public boolean isFcc() {
		return _connectionRequest.isFcc();
	}

	/**
	 * Returns <code>true</code> if this connection request is has bdo certificate.
	 *
	 * @return <code>true</code> if this connection request is has bdo certificate; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasBdoCertificate() {
		return _connectionRequest.isHasBdoCertificate();
	}

	/**
	 * Returns <code>true</code> if this connection request is has dpcc certificate.
	 *
	 * @return <code>true</code> if this connection request is has dpcc certificate; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasDpccCertificate() {
		return _connectionRequest.isHasDpccCertificate();
	}

	/**
	 * Returns <code>true</code> if this connection request is has pollution certificate.
	 *
	 * @return <code>true</code> if this connection request is has pollution certificate; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasPollutionCertificate() {
		return _connectionRequest.isHasPollutionCertificate();
	}

	/**
	 * Returns <code>true</code> if this connection request is height15 mtr.
	 *
	 * @return <code>true</code> if this connection request is height15 mtr; <code>false</code> otherwise
	 */
	@Override
	public boolean isHeight15Mtr() {
		return _connectionRequest.isHeight15Mtr();
	}

	/**
	 * Returns <code>true</code> if this connection request is height17 mtr.
	 *
	 * @return <code>true</code> if this connection request is height17 mtr; <code>false</code> otherwise
	 */
	@Override
	public boolean isHeight17Mtr() {
		return _connectionRequest.isHeight17Mtr();
	}

	/**
	 * Returns <code>true</code> if this connection request is lift.
	 *
	 * @return <code>true</code> if this connection request is lift; <code>false</code> otherwise
	 */
	@Override
	public boolean isLift() {
		return _connectionRequest.isLift();
	}

	@Override
	public boolean isNew() {
		return _connectionRequest.isNew();
	}

	/**
	 * Returns <code>true</code> if this connection request is self declaration.
	 *
	 * @return <code>true</code> if this connection request is self declaration; <code>false</code> otherwise
	 */
	@Override
	public boolean isSelfDeclaration() {
		return _connectionRequest.isSelfDeclaration();
	}

	/**
	 * Returns <code>true</code> if this connection request is stilt parking.
	 *
	 * @return <code>true</code> if this connection request is stilt parking; <code>false</code> otherwise
	 */
	@Override
	public boolean isStiltParking() {
		return _connectionRequest.isStiltParking();
	}

	/**
	 * Returns <code>true</code> if this connection request is upic available.
	 *
	 * @return <code>true</code> if this connection request is upic available; <code>false</code> otherwise
	 */
	@Override
	public boolean isUpicAvailable() {
		return _connectionRequest.isUpicAvailable();
	}

	/**
	 * Returns <code>true</code> if this connection request is wiring test.
	 *
	 * @return <code>true</code> if this connection request is wiring test; <code>false</code> otherwise
	 */
	@Override
	public boolean isWiringTest() {
		return _connectionRequest.isWiringTest();
	}

	@Override
	public void persist() {
		_connectionRequest.persist();
	}

	/**
	 * Sets whether this connection request is agri consumer.
	 *
	 * @param agriConsumer the agri consumer of this connection request
	 */
	@Override
	public void setAgriConsumer(boolean agriConsumer) {
		_connectionRequest.setAgriConsumer(agriConsumer);
	}

	/**
	 * Sets the applicant photo of this connection request.
	 *
	 * @param applicantPhoto the applicant photo of this connection request
	 */
	@Override
	public void setApplicantPhoto(String applicantPhoto) {
		_connectionRequest.setApplicantPhoto(applicantPhoto);
	}

	/**
	 * Sets the applicant signature of this connection request.
	 *
	 * @param applicantSignature the applicant signature of this connection request
	 */
	@Override
	public void setApplicantSignature(long applicantSignature) {
		_connectionRequest.setApplicantSignature(applicantSignature);
	}

	/**
	 * Sets the area type of this connection request.
	 *
	 * @param areaType the area type of this connection request
	 */
	@Override
	public void setAreaType(String areaType) {
		_connectionRequest.setAreaType(areaType);
	}

	/**
	 * Sets the bdo certificate of this connection request.
	 *
	 * @param bdoCertificate the bdo certificate of this connection request
	 */
	@Override
	public void setBdoCertificate(String bdoCertificate) {
		_connectionRequest.setBdoCertificate(bdoCertificate);
	}

	/**
	 * Sets the bp number of this connection request.
	 *
	 * @param bpNumber the bp number of this connection request
	 */
	@Override
	public void setBpNumber(String bpNumber) {
		_connectionRequest.setBpNumber(bpNumber);
	}

	/**
	 * Sets the building name of this connection request.
	 *
	 * @param buildingName the building name of this connection request
	 */
	@Override
	public void setBuildingName(String buildingName) {
		_connectionRequest.setBuildingName(buildingName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_connectionRequest.setCachedModel(cachedModel);
	}

	/**
	 * Sets the colony area of this connection request.
	 *
	 * @param colonyArea the colony area of this connection request
	 */
	@Override
	public void setColonyArea(String colonyArea) {
		_connectionRequest.setColonyArea(colonyArea);
	}

	/**
	 * Sets the company ID of this connection request.
	 *
	 * @param companyId the company ID of this connection request
	 */
	@Override
	public void setCompanyId(long companyId) {
		_connectionRequest.setCompanyId(companyId);
	}

	/**
	 * Sets the connection request ID of this connection request.
	 *
	 * @param connectionRequestId the connection request ID of this connection request
	 */
	@Override
	public void setConnectionRequestId(long connectionRequestId) {
		_connectionRequest.setConnectionRequestId(connectionRequestId);
	}

	/**
	 * Sets the connection type of this connection request.
	 *
	 * @param connectionType the connection type of this connection request
	 */
	@Override
	public void setConnectionType(String connectionType) {
		_connectionRequest.setConnectionType(connectionType);
	}

	/**
	 * Sets the consumer type of this connection request.
	 *
	 * @param consumerType the consumer type of this connection request
	 */
	@Override
	public void setConsumerType(String consumerType) {
		_connectionRequest.setConsumerType(consumerType);
	}

	/**
	 * Sets the create date of this connection request.
	 *
	 * @param createDate the create date of this connection request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_connectionRequest.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this connection request.
	 *
	 * @param district the district of this connection request
	 */
	@Override
	public void setDistrict(String district) {
		_connectionRequest.setDistrict(district);
	}

	/**
	 * Sets the document uploaded of this connection request.
	 *
	 * @param documentUploaded the document uploaded of this connection request
	 */
	@Override
	public void setDocumentUploaded(String documentUploaded) {
		_connectionRequest.setDocumentUploaded(documentUploaded);
	}

	/**
	 * Sets the dpcc certificate of this connection request.
	 *
	 * @param dpccCertificate the dpcc certificate of this connection request
	 */
	@Override
	public void setDpccCertificate(String dpccCertificate) {
		_connectionRequest.setDpccCertificate(dpccCertificate);
	}

	/**
	 * Sets the elcb document of this connection request.
	 *
	 * @param elcbDocument the elcb document of this connection request
	 */
	@Override
	public void setElcbDocument(String elcbDocument) {
		_connectionRequest.setElcbDocument(elcbDocument);
	}

	/**
	 * Sets whether this connection request is elcb installed.
	 *
	 * @param elcbInstalled the elcb installed of this connection request
	 */
	@Override
	public void setElcbInstalled(boolean elcbInstalled) {
		_connectionRequest.setElcbInstalled(elcbInstalled);
	}

	/**
	 * Sets the email ID of this connection request.
	 *
	 * @param emailId the email ID of this connection request
	 */
	@Override
	public void setEmailId(String emailId) {
		_connectionRequest.setEmailId(emailId);
	}

	/**
	 * Sets the e service mail ID of this connection request.
	 *
	 * @param eServiceMailId the e service mail ID of this connection request
	 */
	@Override
	public void setEServiceMailId(String eServiceMailId) {
		_connectionRequest.setEServiceMailId(eServiceMailId);
	}

	/**
	 * Sets whether this connection request is e service on mail.
	 *
	 * @param eServiceOnMail the e service on mail of this connection request
	 */
	@Override
	public void setEServiceOnMail(boolean eServiceOnMail) {
		_connectionRequest.setEServiceOnMail(eServiceOnMail);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_connectionRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_connectionRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_connectionRequest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the father or husband name of this connection request.
	 *
	 * @param fatherOrHusbandName the father or husband name of this connection request
	 */
	@Override
	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		_connectionRequest.setFatherOrHusbandName(fatherOrHusbandName);
	}

	/**
	 * Sets whether this connection request is fcc.
	 *
	 * @param fcc the fcc of this connection request
	 */
	@Override
	public void setFcc(boolean fcc) {
		_connectionRequest.setFcc(fcc);
	}

	/**
	 * Sets the fcc certificate of this connection request.
	 *
	 * @param fccCertificate the fcc certificate of this connection request
	 */
	@Override
	public void setFccCertificate(String fccCertificate) {
		_connectionRequest.setFccCertificate(fccCertificate);
	}

	/**
	 * Sets the firm name of this connection request.
	 *
	 * @param firmName the firm name of this connection request
	 */
	@Override
	public void setFirmName(String firmName) {
		_connectionRequest.setFirmName(firmName);
	}

	/**
	 * Sets the first name of this connection request.
	 *
	 * @param firstName the first name of this connection request
	 */
	@Override
	public void setFirstName(String firstName) {
		_connectionRequest.setFirstName(firstName);
	}

	/**
	 * Sets the floor of this connection request.
	 *
	 * @param floor the floor of this connection request
	 */
	@Override
	public void setFloor(String floor) {
		_connectionRequest.setFloor(floor);
	}

	/**
	 * Sets the group ID of this connection request.
	 *
	 * @param groupId the group ID of this connection request
	 */
	@Override
	public void setGroupId(long groupId) {
		_connectionRequest.setGroupId(groupId);
	}

	/**
	 * Sets the gst in of this connection request.
	 *
	 * @param gstIn the gst in of this connection request
	 */
	@Override
	public void setGstIn(String gstIn) {
		_connectionRequest.setGstIn(gstIn);
	}

	/**
	 * Sets whether this connection request is has bdo certificate.
	 *
	 * @param hasBdoCertificate the has bdo certificate of this connection request
	 */
	@Override
	public void setHasBdoCertificate(boolean hasBdoCertificate) {
		_connectionRequest.setHasBdoCertificate(hasBdoCertificate);
	}

	/**
	 * Sets whether this connection request is has dpcc certificate.
	 *
	 * @param hasDpccCertificate the has dpcc certificate of this connection request
	 */
	@Override
	public void setHasDpccCertificate(boolean hasDpccCertificate) {
		_connectionRequest.setHasDpccCertificate(hasDpccCertificate);
	}

	/**
	 * Sets whether this connection request is has pollution certificate.
	 *
	 * @param hasPollutionCertificate the has pollution certificate of this connection request
	 */
	@Override
	public void setHasPollutionCertificate(boolean hasPollutionCertificate) {
		_connectionRequest.setHasPollutionCertificate(hasPollutionCertificate);
	}

	/**
	 * Sets whether this connection request is height15 mtr.
	 *
	 * @param height15Mtr the height15 mtr of this connection request
	 */
	@Override
	public void setHeight15Mtr(boolean height15Mtr) {
		_connectionRequest.setHeight15Mtr(height15Mtr);
	}

	/**
	 * Sets whether this connection request is height17 mtr.
	 *
	 * @param height17Mtr the height17 mtr of this connection request
	 */
	@Override
	public void setHeight17Mtr(boolean height17Mtr) {
		_connectionRequest.setHeight17Mtr(height17Mtr);
	}

	/**
	 * Sets the house no of this connection request.
	 *
	 * @param houseNo the house no of this connection request
	 */
	@Override
	public void setHouseNo(String houseNo) {
		_connectionRequest.setHouseNo(houseNo);
	}

	/**
	 * Sets the id proof document of this connection request.
	 *
	 * @param idProofDocument the id proof document of this connection request
	 */
	@Override
	public void setIdProofDocument(String idProofDocument) {
		_connectionRequest.setIdProofDocument(idProofDocument);
	}

	/**
	 * Sets the id proof no of this connection request.
	 *
	 * @param idProofNo the id proof no of this connection request
	 */
	@Override
	public void setIdProofNo(String idProofNo) {
		_connectionRequest.setIdProofNo(idProofNo);
	}

	/**
	 * Sets the id proof type of this connection request.
	 *
	 * @param idProofType the id proof type of this connection request
	 */
	@Override
	public void setIdProofType(String idProofType) {
		_connectionRequest.setIdProofType(idProofType);
	}

	/**
	 * Sets the incorporation date of this connection request.
	 *
	 * @param incorporationDate the incorporation date of this connection request
	 */
	@Override
	public void setIncorporationDate(Date incorporationDate) {
		_connectionRequest.setIncorporationDate(incorporationDate);
	}

	/**
	 * Sets the landmark of this connection request.
	 *
	 * @param landmark the landmark of this connection request
	 */
	@Override
	public void setLandmark(String landmark) {
		_connectionRequest.setLandmark(landmark);
	}

	/**
	 * Sets the landmark details of this connection request.
	 *
	 * @param landmarkDetails the landmark details of this connection request
	 */
	@Override
	public void setLandmarkDetails(String landmarkDetails) {
		_connectionRequest.setLandmarkDetails(landmarkDetails);
	}

	/**
	 * Sets the last name of this connection request.
	 *
	 * @param lastName the last name of this connection request
	 */
	@Override
	public void setLastName(String lastName) {
		_connectionRequest.setLastName(lastName);
	}

	/**
	 * Sets whether this connection request is lift.
	 *
	 * @param lift the lift of this connection request
	 */
	@Override
	public void setLift(boolean lift) {
		_connectionRequest.setLift(lift);
	}

	/**
	 * Sets the lift certificate of this connection request.
	 *
	 * @param liftCertificate the lift certificate of this connection request
	 */
	@Override
	public void setLiftCertificate(String liftCertificate) {
		_connectionRequest.setLiftCertificate(liftCertificate);
	}

	/**
	 * Sets the load kva of this connection request.
	 *
	 * @param loadKva the load kva of this connection request
	 */
	@Override
	public void setLoadKva(float loadKva) {
		_connectionRequest.setLoadKva(loadKva);
	}

	/**
	 * Sets the load kw of this connection request.
	 *
	 * @param loadKw the load kw of this connection request
	 */
	@Override
	public void setLoadKw(float loadKw) {
		_connectionRequest.setLoadKw(loadKw);
	}

	/**
	 * Sets the locality of this connection request.
	 *
	 * @param locality the locality of this connection request
	 */
	@Override
	public void setLocality(String locality) {
		_connectionRequest.setLocality(locality);
	}

	/**
	 * Sets the middle name of this connection request.
	 *
	 * @param middleName the middle name of this connection request
	 */
	@Override
	public void setMiddleName(String middleName) {
		_connectionRequest.setMiddleName(middleName);
	}

	/**
	 * Sets the mobile no of this connection request.
	 *
	 * @param mobileNo the mobile no of this connection request
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		_connectionRequest.setMobileNo(mobileNo);
	}

	/**
	 * Sets the modified date of this connection request.
	 *
	 * @param modifiedDate the modified date of this connection request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_connectionRequest.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_connectionRequest.setNew(n);
	}

	/**
	 * Sets the order no of this connection request.
	 *
	 * @param orderNo the order no of this connection request
	 */
	@Override
	public void setOrderNo(String orderNo) {
		_connectionRequest.setOrderNo(orderNo);
	}

	/**
	 * Sets the organization type of this connection request.
	 *
	 * @param organizationType the organization type of this connection request
	 */
	@Override
	public void setOrganizationType(String organizationType) {
		_connectionRequest.setOrganizationType(organizationType);
	}

	/**
	 * Sets the ownership proof document of this connection request.
	 *
	 * @param ownershipProofDocument the ownership proof document of this connection request
	 */
	@Override
	public void setOwnershipProofDocument(String ownershipProofDocument) {
		_connectionRequest.setOwnershipProofDocument(ownershipProofDocument);
	}

	/**
	 * Sets the ownership proof type of this connection request.
	 *
	 * @param ownershipProofType the ownership proof type of this connection request
	 */
	@Override
	public void setOwnershipProofType(String ownershipProofType) {
		_connectionRequest.setOwnershipProofType(ownershipProofType);
	}

	/**
	 * Sets the pan no of this connection request.
	 *
	 * @param panNo the pan no of this connection request
	 */
	@Override
	public void setPanNo(String panNo) {
		_connectionRequest.setPanNo(panNo);
	}

	/**
	 * Sets the pin code of this connection request.
	 *
	 * @param pinCode the pin code of this connection request
	 */
	@Override
	public void setPinCode(String pinCode) {
		_connectionRequest.setPinCode(pinCode);
	}

	/**
	 * Sets the pollution certificate of this connection request.
	 *
	 * @param pollutionCertificate the pollution certificate of this connection request
	 */
	@Override
	public void setPollutionCertificate(String pollutionCertificate) {
		_connectionRequest.setPollutionCertificate(pollutionCertificate);
	}

	/**
	 * Sets the premises type of this connection request.
	 *
	 * @param premisesType the premises type of this connection request
	 */
	@Override
	public void setPremisesType(String premisesType) {
		_connectionRequest.setPremisesType(premisesType);
	}

	/**
	 * Sets the primary key of this connection request.
	 *
	 * @param primaryKey the primary key of this connection request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_connectionRequest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_connectionRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the request date of this connection request.
	 *
	 * @param requestDate the request date of this connection request
	 */
	@Override
	public void setRequestDate(Date requestDate) {
		_connectionRequest.setRequestDate(requestDate);
	}

	/**
	 * Sets the request no of this connection request.
	 *
	 * @param requestNo the request no of this connection request
	 */
	@Override
	public void setRequestNo(String requestNo) {
		_connectionRequest.setRequestNo(requestNo);
	}

	/**
	 * Sets the request type of this connection request.
	 *
	 * @param requestType the request type of this connection request
	 */
	@Override
	public void setRequestType(String requestType) {
		_connectionRequest.setRequestType(requestType);
	}

	/**
	 * Sets the sap order generated of this connection request.
	 *
	 * @param sapOrderGenerated the sap order generated of this connection request
	 */
	@Override
	public void setSapOrderGenerated(String sapOrderGenerated) {
		_connectionRequest.setSapOrderGenerated(sapOrderGenerated);
	}

	/**
	 * Sets whether this connection request is self declaration.
	 *
	 * @param selfDeclaration the self declaration of this connection request
	 */
	@Override
	public void setSelfDeclaration(boolean selfDeclaration) {
		_connectionRequest.setSelfDeclaration(selfDeclaration);
	}

	/**
	 * Sets the self declaration time of this connection request.
	 *
	 * @param selfDeclarationTime the self declaration time of this connection request
	 */
	@Override
	public void setSelfDeclarationTime(Date selfDeclarationTime) {
		_connectionRequest.setSelfDeclarationTime(selfDeclarationTime);
	}

	/**
	 * Sets the signatory designation of this connection request.
	 *
	 * @param signatoryDesignation the signatory designation of this connection request
	 */
	@Override
	public void setSignatoryDesignation(String signatoryDesignation) {
		_connectionRequest.setSignatoryDesignation(signatoryDesignation);
	}

	/**
	 * Sets the signatory name of this connection request.
	 *
	 * @param signatoryName the signatory name of this connection request
	 */
	@Override
	public void setSignatoryName(String signatoryName) {
		_connectionRequest.setSignatoryName(signatoryName);
	}

	/**
	 * Sets the son daughter wife of this connection request.
	 *
	 * @param sonDaughterWife the son daughter wife of this connection request
	 */
	@Override
	public void setSonDaughterWife(String sonDaughterWife) {
		_connectionRequest.setSonDaughterWife(sonDaughterWife);
	}

	/**
	 * Sets whether this connection request is stilt parking.
	 *
	 * @param stiltParking the stilt parking of this connection request
	 */
	@Override
	public void setStiltParking(boolean stiltParking) {
		_connectionRequest.setStiltParking(stiltParking);
	}

	/**
	 * Sets the street of this connection request.
	 *
	 * @param street the street of this connection request
	 */
	@Override
	public void setStreet(String street) {
		_connectionRequest.setStreet(street);
	}

	/**
	 * Sets the tariff category of this connection request.
	 *
	 * @param tariffCategory the tariff category of this connection request
	 */
	@Override
	public void setTariffCategory(String tariffCategory) {
		_connectionRequest.setTariffCategory(tariffCategory);
	}

	/**
	 * Sets the title of this connection request.
	 *
	 * @param title the title of this connection request
	 */
	@Override
	public void setTitle(String title) {
		_connectionRequest.setTitle(title);
	}

	/**
	 * Sets the upic of this connection request.
	 *
	 * @param upic the upic of this connection request
	 */
	@Override
	public void setUpic(String upic) {
		_connectionRequest.setUpic(upic);
	}

	/**
	 * Sets whether this connection request is upic available.
	 *
	 * @param upicAvailable the upic available of this connection request
	 */
	@Override
	public void setUpicAvailable(boolean upicAvailable) {
		_connectionRequest.setUpicAvailable(upicAvailable);
	}

	/**
	 * Sets the user ID of this connection request.
	 *
	 * @param userId the user ID of this connection request
	 */
	@Override
	public void setUserId(long userId) {
		_connectionRequest.setUserId(userId);
	}

	/**
	 * Sets the user name of this connection request.
	 *
	 * @param userName the user name of this connection request
	 */
	@Override
	public void setUserName(String userName) {
		_connectionRequest.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this connection request.
	 *
	 * @param userUuid the user uuid of this connection request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_connectionRequest.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this connection request.
	 *
	 * @param uuid the uuid of this connection request
	 */
	@Override
	public void setUuid(String uuid) {
		_connectionRequest.setUuid(uuid);
	}

	/**
	 * Sets the wiring certificate of this connection request.
	 *
	 * @param wiringCertificate the wiring certificate of this connection request
	 */
	@Override
	public void setWiringCertificate(String wiringCertificate) {
		_connectionRequest.setWiringCertificate(wiringCertificate);
	}

	/**
	 * Sets whether this connection request is wiring test.
	 *
	 * @param wiringTest the wiring test of this connection request
	 */
	@Override
	public void setWiringTest(boolean wiringTest) {
		_connectionRequest.setWiringTest(wiringTest);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ConnectionRequest>
		toCacheModel() {

		return _connectionRequest.toCacheModel();
	}

	@Override
	public ConnectionRequest toEscapedModel() {
		return new ConnectionRequestWrapper(
			_connectionRequest.toEscapedModel());
	}

	@Override
	public String toString() {
		return _connectionRequest.toString();
	}

	@Override
	public ConnectionRequest toUnescapedModel() {
		return new ConnectionRequestWrapper(
			_connectionRequest.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _connectionRequest.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConnectionRequestWrapper)) {
			return false;
		}

		ConnectionRequestWrapper connectionRequestWrapper =
			(ConnectionRequestWrapper)object;

		if (Objects.equals(
				_connectionRequest,
				connectionRequestWrapper._connectionRequest)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _connectionRequest.getStagedModelType();
	}

	@Override
	public ConnectionRequest getWrappedModel() {
		return _connectionRequest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _connectionRequest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _connectionRequest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_connectionRequest.resetOriginalValues();
	}

	private final ConnectionRequest _connectionRequest;

}