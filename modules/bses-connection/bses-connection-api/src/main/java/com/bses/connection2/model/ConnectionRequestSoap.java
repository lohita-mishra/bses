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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bses.connection2.service.http.ConnectionRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConnectionRequestSoap implements Serializable {

	public static ConnectionRequestSoap toSoapModel(ConnectionRequest model) {
		ConnectionRequestSoap soapModel = new ConnectionRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setConnectionRequestId(model.getConnectionRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRequestNo(model.getRequestNo());
		soapModel.setMobileNo(model.getMobileNo());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setRequestDate(model.getRequestDate());
		soapModel.setRequestType(model.getRequestType());
		soapModel.setRequestStatus(model.getRequestStatus());
		soapModel.setRequestMode(model.getRequestMode());
		soapModel.setConsumerType(model.getConsumerType());
		soapModel.setTitle(model.getTitle());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setSonDaughterWife(model.getSonDaughterWife());
		soapModel.setFatherOrHusbandName(model.getFatherOrHusbandName());
		soapModel.setFirmName(model.getFirmName());
		soapModel.setSignatoryName(model.getSignatoryName());
		soapModel.setSignatoryDesignation(model.getSignatoryDesignation());
		soapModel.setOrganizationType(model.getOrganizationType());
		soapModel.setIncorporationDate(model.getIncorporationDate());
		soapModel.setGstIn(model.getGstIn());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setLocality(model.getLocality());
		soapModel.setDistrict(model.getDistrict());
		soapModel.setHouseNo(model.getHouseNo());
		soapModel.setFloor(model.getFloor());
		soapModel.setBuildingName(model.getBuildingName());
		soapModel.setStreet(model.getStreet());
		soapModel.setColonyArea(model.getColonyArea());
		soapModel.setLandmark(model.getLandmark());
		soapModel.setLandmarkDetails(model.getLandmarkDetails());
		soapModel.setPinCode(model.getPinCode());
		soapModel.setConnectionType(model.getConnectionType());
		soapModel.setTariffCategory(model.getTariffCategory());
		soapModel.setLoadKva(model.getLoadKva());
		soapModel.setLoadKw(model.getLoadKw());
		soapModel.setAreaType(model.getAreaType());
		soapModel.setPremisesType(model.getPremisesType());
		soapModel.setUpicAvailable(model.isUpicAvailable());
		soapModel.setUpic(model.getUpic());
		soapModel.setWiringTest(model.isWiringTest());
		soapModel.setWiringCertificate(model.getWiringCertificate());
		soapModel.setElcbInstalled(model.isElcbInstalled());
		soapModel.setElcbDocument(model.getElcbDocument());
		soapModel.setStiltParking(model.isStiltParking());
		soapModel.setHeight15Mtr(model.isHeight15Mtr());
		soapModel.setHeight17Mtr(model.isHeight17Mtr());
		soapModel.setFcc(model.isFcc());
		soapModel.setFccCertificate(model.getFccCertificate());
		soapModel.setLift(model.isLift());
		soapModel.setLiftCertificate(model.getLiftCertificate());
		soapModel.setAgriConsumer(model.isAgriConsumer());
		soapModel.setHasBdoCertificate(model.isHasBdoCertificate());
		soapModel.setBdoCertificate(model.getBdoCertificate());
		soapModel.setHasDpccCertificate(model.isHasDpccCertificate());
		soapModel.setDpccCertificate(model.getDpccCertificate());
		soapModel.setHasPollutionCertificate(model.isHasPollutionCertificate());
		soapModel.setPollutionCertificate(model.getPollutionCertificate());
		soapModel.setEServiceOnMail(model.isEServiceOnMail());
		soapModel.setEServiceMailId(model.getEServiceMailId());
		soapModel.setEServiceMailValidated(model.isEServiceMailValidated());
		soapModel.setApplicantPhoto(model.getApplicantPhoto());
		soapModel.setApplicantSignature(model.getApplicantSignature());
		soapModel.setIdProofType(model.getIdProofType());
		soapModel.setIdProofNo(model.getIdProofNo());
		soapModel.setIdProofDocument(model.getIdProofDocument());
		soapModel.setOwnershipProofType(model.getOwnershipProofType());
		soapModel.setOwnershipProofDocument(model.getOwnershipProofDocument());
		soapModel.setSelfDeclaration(model.isSelfDeclaration());
		soapModel.setSelfDeclarationTime(model.getSelfDeclarationTime());
		soapModel.setBpNumber(model.getBpNumber());
		soapModel.setOrderNo(model.getOrderNo());
		soapModel.setDocumentUploaded(model.getDocumentUploaded());
		soapModel.setSapOrderGenerated(model.getSapOrderGenerated());

		return soapModel;
	}

	public static ConnectionRequestSoap[] toSoapModels(
		ConnectionRequest[] models) {

		ConnectionRequestSoap[] soapModels =
			new ConnectionRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConnectionRequestSoap[][] toSoapModels(
		ConnectionRequest[][] models) {

		ConnectionRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ConnectionRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConnectionRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConnectionRequestSoap[] toSoapModels(
		List<ConnectionRequest> models) {

		List<ConnectionRequestSoap> soapModels =
			new ArrayList<ConnectionRequestSoap>(models.size());

		for (ConnectionRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConnectionRequestSoap[soapModels.size()]);
	}

	public ConnectionRequestSoap() {
	}

	public long getPrimaryKey() {
		return _connectionRequestId;
	}

	public void setPrimaryKey(long pk) {
		setConnectionRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getConnectionRequestId() {
		return _connectionRequestId;
	}

	public void setConnectionRequestId(long connectionRequestId) {
		_connectionRequestId = connectionRequestId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getRequestNo() {
		return _requestNo;
	}

	public void setRequestNo(String requestNo) {
		_requestNo = requestNo;
	}

	public String getMobileNo() {
		return _mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		_mobileNo = mobileNo;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public Date getRequestDate() {
		return _requestDate;
	}

	public void setRequestDate(Date requestDate) {
		_requestDate = requestDate;
	}

	public String getRequestType() {
		return _requestType;
	}

	public void setRequestType(String requestType) {
		_requestType = requestType;
	}

	public String getRequestStatus() {
		return _requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		_requestStatus = requestStatus;
	}

	public String getRequestMode() {
		return _requestMode;
	}

	public void setRequestMode(String requestMode) {
		_requestMode = requestMode;
	}

	public String getConsumerType() {
		return _consumerType;
	}

	public void setConsumerType(String consumerType) {
		_consumerType = consumerType;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getSonDaughterWife() {
		return _sonDaughterWife;
	}

	public void setSonDaughterWife(String sonDaughterWife) {
		_sonDaughterWife = sonDaughterWife;
	}

	public String getFatherOrHusbandName() {
		return _fatherOrHusbandName;
	}

	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		_fatherOrHusbandName = fatherOrHusbandName;
	}

	public String getFirmName() {
		return _firmName;
	}

	public void setFirmName(String firmName) {
		_firmName = firmName;
	}

	public String getSignatoryName() {
		return _signatoryName;
	}

	public void setSignatoryName(String signatoryName) {
		_signatoryName = signatoryName;
	}

	public String getSignatoryDesignation() {
		return _signatoryDesignation;
	}

	public void setSignatoryDesignation(String signatoryDesignation) {
		_signatoryDesignation = signatoryDesignation;
	}

	public String getOrganizationType() {
		return _organizationType;
	}

	public void setOrganizationType(String organizationType) {
		_organizationType = organizationType;
	}

	public Date getIncorporationDate() {
		return _incorporationDate;
	}

	public void setIncorporationDate(Date incorporationDate) {
		_incorporationDate = incorporationDate;
	}

	public String getGstIn() {
		return _gstIn;
	}

	public void setGstIn(String gstIn) {
		_gstIn = gstIn;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	public String getLocality() {
		return _locality;
	}

	public void setLocality(String locality) {
		_locality = locality;
	}

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public String getHouseNo() {
		return _houseNo;
	}

	public void setHouseNo(String houseNo) {
		_houseNo = houseNo;
	}

	public String getFloor() {
		return _floor;
	}

	public void setFloor(String floor) {
		_floor = floor;
	}

	public String getBuildingName() {
		return _buildingName;
	}

	public void setBuildingName(String buildingName) {
		_buildingName = buildingName;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getColonyArea() {
		return _colonyArea;
	}

	public void setColonyArea(String colonyArea) {
		_colonyArea = colonyArea;
	}

	public String getLandmark() {
		return _landmark;
	}

	public void setLandmark(String landmark) {
		_landmark = landmark;
	}

	public String getLandmarkDetails() {
		return _landmarkDetails;
	}

	public void setLandmarkDetails(String landmarkDetails) {
		_landmarkDetails = landmarkDetails;
	}

	public String getPinCode() {
		return _pinCode;
	}

	public void setPinCode(String pinCode) {
		_pinCode = pinCode;
	}

	public String getConnectionType() {
		return _connectionType;
	}

	public void setConnectionType(String connectionType) {
		_connectionType = connectionType;
	}

	public String getTariffCategory() {
		return _tariffCategory;
	}

	public void setTariffCategory(String tariffCategory) {
		_tariffCategory = tariffCategory;
	}

	public float getLoadKva() {
		return _loadKva;
	}

	public void setLoadKva(float loadKva) {
		_loadKva = loadKva;
	}

	public float getLoadKw() {
		return _loadKw;
	}

	public void setLoadKw(float loadKw) {
		_loadKw = loadKw;
	}

	public String getAreaType() {
		return _areaType;
	}

	public void setAreaType(String areaType) {
		_areaType = areaType;
	}

	public String getPremisesType() {
		return _premisesType;
	}

	public void setPremisesType(String premisesType) {
		_premisesType = premisesType;
	}

	public boolean getUpicAvailable() {
		return _upicAvailable;
	}

	public boolean isUpicAvailable() {
		return _upicAvailable;
	}

	public void setUpicAvailable(boolean upicAvailable) {
		_upicAvailable = upicAvailable;
	}

	public String getUpic() {
		return _upic;
	}

	public void setUpic(String upic) {
		_upic = upic;
	}

	public boolean getWiringTest() {
		return _wiringTest;
	}

	public boolean isWiringTest() {
		return _wiringTest;
	}

	public void setWiringTest(boolean wiringTest) {
		_wiringTest = wiringTest;
	}

	public String getWiringCertificate() {
		return _wiringCertificate;
	}

	public void setWiringCertificate(String wiringCertificate) {
		_wiringCertificate = wiringCertificate;
	}

	public boolean getElcbInstalled() {
		return _elcbInstalled;
	}

	public boolean isElcbInstalled() {
		return _elcbInstalled;
	}

	public void setElcbInstalled(boolean elcbInstalled) {
		_elcbInstalled = elcbInstalled;
	}

	public String getElcbDocument() {
		return _elcbDocument;
	}

	public void setElcbDocument(String elcbDocument) {
		_elcbDocument = elcbDocument;
	}

	public boolean getStiltParking() {
		return _stiltParking;
	}

	public boolean isStiltParking() {
		return _stiltParking;
	}

	public void setStiltParking(boolean stiltParking) {
		_stiltParking = stiltParking;
	}

	public boolean getHeight15Mtr() {
		return _height15Mtr;
	}

	public boolean isHeight15Mtr() {
		return _height15Mtr;
	}

	public void setHeight15Mtr(boolean height15Mtr) {
		_height15Mtr = height15Mtr;
	}

	public boolean getHeight17Mtr() {
		return _height17Mtr;
	}

	public boolean isHeight17Mtr() {
		return _height17Mtr;
	}

	public void setHeight17Mtr(boolean height17Mtr) {
		_height17Mtr = height17Mtr;
	}

	public boolean getFcc() {
		return _fcc;
	}

	public boolean isFcc() {
		return _fcc;
	}

	public void setFcc(boolean fcc) {
		_fcc = fcc;
	}

	public String getFccCertificate() {
		return _fccCertificate;
	}

	public void setFccCertificate(String fccCertificate) {
		_fccCertificate = fccCertificate;
	}

	public boolean getLift() {
		return _lift;
	}

	public boolean isLift() {
		return _lift;
	}

	public void setLift(boolean lift) {
		_lift = lift;
	}

	public String getLiftCertificate() {
		return _liftCertificate;
	}

	public void setLiftCertificate(String liftCertificate) {
		_liftCertificate = liftCertificate;
	}

	public boolean getAgriConsumer() {
		return _agriConsumer;
	}

	public boolean isAgriConsumer() {
		return _agriConsumer;
	}

	public void setAgriConsumer(boolean agriConsumer) {
		_agriConsumer = agriConsumer;
	}

	public boolean getHasBdoCertificate() {
		return _hasBdoCertificate;
	}

	public boolean isHasBdoCertificate() {
		return _hasBdoCertificate;
	}

	public void setHasBdoCertificate(boolean hasBdoCertificate) {
		_hasBdoCertificate = hasBdoCertificate;
	}

	public String getBdoCertificate() {
		return _bdoCertificate;
	}

	public void setBdoCertificate(String bdoCertificate) {
		_bdoCertificate = bdoCertificate;
	}

	public boolean getHasDpccCertificate() {
		return _hasDpccCertificate;
	}

	public boolean isHasDpccCertificate() {
		return _hasDpccCertificate;
	}

	public void setHasDpccCertificate(boolean hasDpccCertificate) {
		_hasDpccCertificate = hasDpccCertificate;
	}

	public String getDpccCertificate() {
		return _dpccCertificate;
	}

	public void setDpccCertificate(String dpccCertificate) {
		_dpccCertificate = dpccCertificate;
	}

	public boolean getHasPollutionCertificate() {
		return _hasPollutionCertificate;
	}

	public boolean isHasPollutionCertificate() {
		return _hasPollutionCertificate;
	}

	public void setHasPollutionCertificate(boolean hasPollutionCertificate) {
		_hasPollutionCertificate = hasPollutionCertificate;
	}

	public String getPollutionCertificate() {
		return _pollutionCertificate;
	}

	public void setPollutionCertificate(String pollutionCertificate) {
		_pollutionCertificate = pollutionCertificate;
	}

	public boolean getEServiceOnMail() {
		return _eServiceOnMail;
	}

	public boolean isEServiceOnMail() {
		return _eServiceOnMail;
	}

	public void setEServiceOnMail(boolean eServiceOnMail) {
		_eServiceOnMail = eServiceOnMail;
	}

	public String getEServiceMailId() {
		return _eServiceMailId;
	}

	public void setEServiceMailId(String eServiceMailId) {
		_eServiceMailId = eServiceMailId;
	}

	public boolean getEServiceMailValidated() {
		return _eServiceMailValidated;
	}

	public boolean isEServiceMailValidated() {
		return _eServiceMailValidated;
	}

	public void setEServiceMailValidated(boolean eServiceMailValidated) {
		_eServiceMailValidated = eServiceMailValidated;
	}

	public String getApplicantPhoto() {
		return _applicantPhoto;
	}

	public void setApplicantPhoto(String applicantPhoto) {
		_applicantPhoto = applicantPhoto;
	}

	public long getApplicantSignature() {
		return _applicantSignature;
	}

	public void setApplicantSignature(long applicantSignature) {
		_applicantSignature = applicantSignature;
	}

	public String getIdProofType() {
		return _idProofType;
	}

	public void setIdProofType(String idProofType) {
		_idProofType = idProofType;
	}

	public String getIdProofNo() {
		return _idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		_idProofNo = idProofNo;
	}

	public String getIdProofDocument() {
		return _idProofDocument;
	}

	public void setIdProofDocument(String idProofDocument) {
		_idProofDocument = idProofDocument;
	}

	public String getOwnershipProofType() {
		return _ownershipProofType;
	}

	public void setOwnershipProofType(String ownershipProofType) {
		_ownershipProofType = ownershipProofType;
	}

	public String getOwnershipProofDocument() {
		return _ownershipProofDocument;
	}

	public void setOwnershipProofDocument(String ownershipProofDocument) {
		_ownershipProofDocument = ownershipProofDocument;
	}

	public boolean getSelfDeclaration() {
		return _selfDeclaration;
	}

	public boolean isSelfDeclaration() {
		return _selfDeclaration;
	}

	public void setSelfDeclaration(boolean selfDeclaration) {
		_selfDeclaration = selfDeclaration;
	}

	public Date getSelfDeclarationTime() {
		return _selfDeclarationTime;
	}

	public void setSelfDeclarationTime(Date selfDeclarationTime) {
		_selfDeclarationTime = selfDeclarationTime;
	}

	public String getBpNumber() {
		return _bpNumber;
	}

	public void setBpNumber(String bpNumber) {
		_bpNumber = bpNumber;
	}

	public String getOrderNo() {
		return _orderNo;
	}

	public void setOrderNo(String orderNo) {
		_orderNo = orderNo;
	}

	public String getDocumentUploaded() {
		return _documentUploaded;
	}

	public void setDocumentUploaded(String documentUploaded) {
		_documentUploaded = documentUploaded;
	}

	public String getSapOrderGenerated() {
		return _sapOrderGenerated;
	}

	public void setSapOrderGenerated(String sapOrderGenerated) {
		_sapOrderGenerated = sapOrderGenerated;
	}

	private String _uuid;
	private long _connectionRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _requestNo;
	private String _mobileNo;
	private String _emailId;
	private Date _requestDate;
	private String _requestType;
	private String _requestStatus;
	private String _requestMode;
	private String _consumerType;
	private String _title;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _sonDaughterWife;
	private String _fatherOrHusbandName;
	private String _firmName;
	private String _signatoryName;
	private String _signatoryDesignation;
	private String _organizationType;
	private Date _incorporationDate;
	private String _gstIn;
	private String _panNo;
	private String _locality;
	private String _district;
	private String _houseNo;
	private String _floor;
	private String _buildingName;
	private String _street;
	private String _colonyArea;
	private String _landmark;
	private String _landmarkDetails;
	private String _pinCode;
	private String _connectionType;
	private String _tariffCategory;
	private float _loadKva;
	private float _loadKw;
	private String _areaType;
	private String _premisesType;
	private boolean _upicAvailable;
	private String _upic;
	private boolean _wiringTest;
	private String _wiringCertificate;
	private boolean _elcbInstalled;
	private String _elcbDocument;
	private boolean _stiltParking;
	private boolean _height15Mtr;
	private boolean _height17Mtr;
	private boolean _fcc;
	private String _fccCertificate;
	private boolean _lift;
	private String _liftCertificate;
	private boolean _agriConsumer;
	private boolean _hasBdoCertificate;
	private String _bdoCertificate;
	private boolean _hasDpccCertificate;
	private String _dpccCertificate;
	private boolean _hasPollutionCertificate;
	private String _pollutionCertificate;
	private boolean _eServiceOnMail;
	private String _eServiceMailId;
	private boolean _eServiceMailValidated;
	private String _applicantPhoto;
	private long _applicantSignature;
	private String _idProofType;
	private String _idProofNo;
	private String _idProofDocument;
	private String _ownershipProofType;
	private String _ownershipProofDocument;
	private boolean _selfDeclaration;
	private Date _selfDeclarationTime;
	private String _bpNumber;
	private String _orderNo;
	private String _documentUploaded;
	private String _sapOrderGenerated;

}