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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ConnectionRequest service. Represents a row in the &quot;bsesconn_ConnectionRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.bses.connection2.model.impl.ConnectionRequestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.bses.connection2.model.impl.ConnectionRequestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionRequest
 * @generated
 */
@ProviderType
public interface ConnectionRequestModel
	extends BaseModel<ConnectionRequest>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a connection request model instance should use the {@link ConnectionRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this connection request.
	 *
	 * @return the primary key of this connection request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this connection request.
	 *
	 * @param primaryKey the primary key of this connection request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this connection request.
	 *
	 * @return the uuid of this connection request
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this connection request.
	 *
	 * @param uuid the uuid of this connection request
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the connection request ID of this connection request.
	 *
	 * @return the connection request ID of this connection request
	 */
	public long getConnectionRequestId();

	/**
	 * Sets the connection request ID of this connection request.
	 *
	 * @param connectionRequestId the connection request ID of this connection request
	 */
	public void setConnectionRequestId(long connectionRequestId);

	/**
	 * Returns the group ID of this connection request.
	 *
	 * @return the group ID of this connection request
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this connection request.
	 *
	 * @param groupId the group ID of this connection request
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this connection request.
	 *
	 * @return the company ID of this connection request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this connection request.
	 *
	 * @param companyId the company ID of this connection request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this connection request.
	 *
	 * @return the user ID of this connection request
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this connection request.
	 *
	 * @param userId the user ID of this connection request
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this connection request.
	 *
	 * @return the user uuid of this connection request
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this connection request.
	 *
	 * @param userUuid the user uuid of this connection request
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this connection request.
	 *
	 * @return the user name of this connection request
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this connection request.
	 *
	 * @param userName the user name of this connection request
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this connection request.
	 *
	 * @return the create date of this connection request
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this connection request.
	 *
	 * @param createDate the create date of this connection request
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this connection request.
	 *
	 * @return the modified date of this connection request
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this connection request.
	 *
	 * @param modifiedDate the modified date of this connection request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the request no of this connection request.
	 *
	 * @return the request no of this connection request
	 */
	@AutoEscape
	public String getRequestNo();

	/**
	 * Sets the request no of this connection request.
	 *
	 * @param requestNo the request no of this connection request
	 */
	public void setRequestNo(String requestNo);

	/**
	 * Returns the mobile no of this connection request.
	 *
	 * @return the mobile no of this connection request
	 */
	@AutoEscape
	public String getMobileNo();

	/**
	 * Sets the mobile no of this connection request.
	 *
	 * @param mobileNo the mobile no of this connection request
	 */
	public void setMobileNo(String mobileNo);

	/**
	 * Returns the email ID of this connection request.
	 *
	 * @return the email ID of this connection request
	 */
	@AutoEscape
	public String getEmailId();

	/**
	 * Sets the email ID of this connection request.
	 *
	 * @param emailId the email ID of this connection request
	 */
	public void setEmailId(String emailId);

	/**
	 * Returns the request date of this connection request.
	 *
	 * @return the request date of this connection request
	 */
	public Date getRequestDate();

	/**
	 * Sets the request date of this connection request.
	 *
	 * @param requestDate the request date of this connection request
	 */
	public void setRequestDate(Date requestDate);

	/**
	 * Returns the consumer type of this connection request.
	 *
	 * @return the consumer type of this connection request
	 */
	@AutoEscape
	public String getConsumerType();

	/**
	 * Sets the consumer type of this connection request.
	 *
	 * @param consumerType the consumer type of this connection request
	 */
	public void setConsumerType(String consumerType);

	/**
	 * Returns the title of this connection request.
	 *
	 * @return the title of this connection request
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this connection request.
	 *
	 * @param title the title of this connection request
	 */
	public void setTitle(String title);

	/**
	 * Returns the first name of this connection request.
	 *
	 * @return the first name of this connection request
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this connection request.
	 *
	 * @param firstName the first name of this connection request
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the middle name of this connection request.
	 *
	 * @return the middle name of this connection request
	 */
	@AutoEscape
	public String getMiddleName();

	/**
	 * Sets the middle name of this connection request.
	 *
	 * @param middleName the middle name of this connection request
	 */
	public void setMiddleName(String middleName);

	/**
	 * Returns the last name of this connection request.
	 *
	 * @return the last name of this connection request
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this connection request.
	 *
	 * @param lastName the last name of this connection request
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the son daughter wife of this connection request.
	 *
	 * @return the son daughter wife of this connection request
	 */
	@AutoEscape
	public String getSonDaughterWife();

	/**
	 * Sets the son daughter wife of this connection request.
	 *
	 * @param sonDaughterWife the son daughter wife of this connection request
	 */
	public void setSonDaughterWife(String sonDaughterWife);

	/**
	 * Returns the father or husband name of this connection request.
	 *
	 * @return the father or husband name of this connection request
	 */
	@AutoEscape
	public String getFatherOrHusbandName();

	/**
	 * Sets the father or husband name of this connection request.
	 *
	 * @param fatherOrHusbandName the father or husband name of this connection request
	 */
	public void setFatherOrHusbandName(String fatherOrHusbandName);

	/**
	 * Returns the firm name of this connection request.
	 *
	 * @return the firm name of this connection request
	 */
	@AutoEscape
	public String getFirmName();

	/**
	 * Sets the firm name of this connection request.
	 *
	 * @param firmName the firm name of this connection request
	 */
	public void setFirmName(String firmName);

	/**
	 * Returns the signatory name of this connection request.
	 *
	 * @return the signatory name of this connection request
	 */
	@AutoEscape
	public String getSignatoryName();

	/**
	 * Sets the signatory name of this connection request.
	 *
	 * @param signatoryName the signatory name of this connection request
	 */
	public void setSignatoryName(String signatoryName);

	/**
	 * Returns the signatory designation of this connection request.
	 *
	 * @return the signatory designation of this connection request
	 */
	@AutoEscape
	public String getSignatoryDesignation();

	/**
	 * Sets the signatory designation of this connection request.
	 *
	 * @param signatoryDesignation the signatory designation of this connection request
	 */
	public void setSignatoryDesignation(String signatoryDesignation);

	/**
	 * Returns the organization type of this connection request.
	 *
	 * @return the organization type of this connection request
	 */
	@AutoEscape
	public String getOrganizationType();

	/**
	 * Sets the organization type of this connection request.
	 *
	 * @param organizationType the organization type of this connection request
	 */
	public void setOrganizationType(String organizationType);

	/**
	 * Returns the incorporation date of this connection request.
	 *
	 * @return the incorporation date of this connection request
	 */
	public Date getIncorporationDate();

	/**
	 * Sets the incorporation date of this connection request.
	 *
	 * @param incorporationDate the incorporation date of this connection request
	 */
	public void setIncorporationDate(Date incorporationDate);

	/**
	 * Returns the gst in of this connection request.
	 *
	 * @return the gst in of this connection request
	 */
	@AutoEscape
	public String getGstIn();

	/**
	 * Sets the gst in of this connection request.
	 *
	 * @param gstIn the gst in of this connection request
	 */
	public void setGstIn(String gstIn);

	/**
	 * Returns the pan no of this connection request.
	 *
	 * @return the pan no of this connection request
	 */
	@AutoEscape
	public String getPanNo();

	/**
	 * Sets the pan no of this connection request.
	 *
	 * @param panNo the pan no of this connection request
	 */
	public void setPanNo(String panNo);

	/**
	 * Returns the locality of this connection request.
	 *
	 * @return the locality of this connection request
	 */
	@AutoEscape
	public String getLocality();

	/**
	 * Sets the locality of this connection request.
	 *
	 * @param locality the locality of this connection request
	 */
	public void setLocality(String locality);

	/**
	 * Returns the district of this connection request.
	 *
	 * @return the district of this connection request
	 */
	@AutoEscape
	public String getDistrict();

	/**
	 * Sets the district of this connection request.
	 *
	 * @param district the district of this connection request
	 */
	public void setDistrict(String district);

	/**
	 * Returns the house no of this connection request.
	 *
	 * @return the house no of this connection request
	 */
	@AutoEscape
	public String getHouseNo();

	/**
	 * Sets the house no of this connection request.
	 *
	 * @param houseNo the house no of this connection request
	 */
	public void setHouseNo(String houseNo);

	/**
	 * Returns the floor of this connection request.
	 *
	 * @return the floor of this connection request
	 */
	@AutoEscape
	public String getFloor();

	/**
	 * Sets the floor of this connection request.
	 *
	 * @param floor the floor of this connection request
	 */
	public void setFloor(String floor);

	/**
	 * Returns the building name of this connection request.
	 *
	 * @return the building name of this connection request
	 */
	@AutoEscape
	public String getBuildingName();

	/**
	 * Sets the building name of this connection request.
	 *
	 * @param buildingName the building name of this connection request
	 */
	public void setBuildingName(String buildingName);

	/**
	 * Returns the street of this connection request.
	 *
	 * @return the street of this connection request
	 */
	@AutoEscape
	public String getStreet();

	/**
	 * Sets the street of this connection request.
	 *
	 * @param street the street of this connection request
	 */
	public void setStreet(String street);

	/**
	 * Returns the colony area of this connection request.
	 *
	 * @return the colony area of this connection request
	 */
	@AutoEscape
	public String getColonyArea();

	/**
	 * Sets the colony area of this connection request.
	 *
	 * @param colonyArea the colony area of this connection request
	 */
	public void setColonyArea(String colonyArea);

	/**
	 * Returns the landmark of this connection request.
	 *
	 * @return the landmark of this connection request
	 */
	@AutoEscape
	public String getLandmark();

	/**
	 * Sets the landmark of this connection request.
	 *
	 * @param landmark the landmark of this connection request
	 */
	public void setLandmark(String landmark);

	/**
	 * Returns the landmark details of this connection request.
	 *
	 * @return the landmark details of this connection request
	 */
	@AutoEscape
	public String getLandmarkDetails();

	/**
	 * Sets the landmark details of this connection request.
	 *
	 * @param landmarkDetails the landmark details of this connection request
	 */
	public void setLandmarkDetails(String landmarkDetails);

	/**
	 * Returns the pin code of this connection request.
	 *
	 * @return the pin code of this connection request
	 */
	@AutoEscape
	public String getPinCode();

	/**
	 * Sets the pin code of this connection request.
	 *
	 * @param pinCode the pin code of this connection request
	 */
	public void setPinCode(String pinCode);

	/**
	 * Returns the connection type of this connection request.
	 *
	 * @return the connection type of this connection request
	 */
	@AutoEscape
	public String getConnectionType();

	/**
	 * Sets the connection type of this connection request.
	 *
	 * @param connectionType the connection type of this connection request
	 */
	public void setConnectionType(String connectionType);

	/**
	 * Returns the tariff category of this connection request.
	 *
	 * @return the tariff category of this connection request
	 */
	@AutoEscape
	public String getTariffCategory();

	/**
	 * Sets the tariff category of this connection request.
	 *
	 * @param tariffCategory the tariff category of this connection request
	 */
	public void setTariffCategory(String tariffCategory);

	/**
	 * Returns the load kva of this connection request.
	 *
	 * @return the load kva of this connection request
	 */
	public float getLoadKva();

	/**
	 * Sets the load kva of this connection request.
	 *
	 * @param loadKva the load kva of this connection request
	 */
	public void setLoadKva(float loadKva);

	/**
	 * Returns the load kw of this connection request.
	 *
	 * @return the load kw of this connection request
	 */
	public float getLoadKw();

	/**
	 * Sets the load kw of this connection request.
	 *
	 * @param loadKw the load kw of this connection request
	 */
	public void setLoadKw(float loadKw);

	/**
	 * Returns the area type of this connection request.
	 *
	 * @return the area type of this connection request
	 */
	@AutoEscape
	public String getAreaType();

	/**
	 * Sets the area type of this connection request.
	 *
	 * @param areaType the area type of this connection request
	 */
	public void setAreaType(String areaType);

	/**
	 * Returns the premises type of this connection request.
	 *
	 * @return the premises type of this connection request
	 */
	@AutoEscape
	public String getPremisesType();

	/**
	 * Sets the premises type of this connection request.
	 *
	 * @param premisesType the premises type of this connection request
	 */
	public void setPremisesType(String premisesType);

	/**
	 * Returns the upic available of this connection request.
	 *
	 * @return the upic available of this connection request
	 */
	public boolean getUpicAvailable();

	/**
	 * Returns <code>true</code> if this connection request is upic available.
	 *
	 * @return <code>true</code> if this connection request is upic available; <code>false</code> otherwise
	 */
	public boolean isUpicAvailable();

	/**
	 * Sets whether this connection request is upic available.
	 *
	 * @param upicAvailable the upic available of this connection request
	 */
	public void setUpicAvailable(boolean upicAvailable);

	/**
	 * Returns the upic of this connection request.
	 *
	 * @return the upic of this connection request
	 */
	@AutoEscape
	public String getUpic();

	/**
	 * Sets the upic of this connection request.
	 *
	 * @param upic the upic of this connection request
	 */
	public void setUpic(String upic);

	/**
	 * Returns the wiring test of this connection request.
	 *
	 * @return the wiring test of this connection request
	 */
	public boolean getWiringTest();

	/**
	 * Returns <code>true</code> if this connection request is wiring test.
	 *
	 * @return <code>true</code> if this connection request is wiring test; <code>false</code> otherwise
	 */
	public boolean isWiringTest();

	/**
	 * Sets whether this connection request is wiring test.
	 *
	 * @param wiringTest the wiring test of this connection request
	 */
	public void setWiringTest(boolean wiringTest);

	/**
	 * Returns the wiring certificate of this connection request.
	 *
	 * @return the wiring certificate of this connection request
	 */
	@AutoEscape
	public String getWiringCertificate();

	/**
	 * Sets the wiring certificate of this connection request.
	 *
	 * @param wiringCertificate the wiring certificate of this connection request
	 */
	public void setWiringCertificate(String wiringCertificate);

	/**
	 * Returns the elcb installed of this connection request.
	 *
	 * @return the elcb installed of this connection request
	 */
	public boolean getElcbInstalled();

	/**
	 * Returns <code>true</code> if this connection request is elcb installed.
	 *
	 * @return <code>true</code> if this connection request is elcb installed; <code>false</code> otherwise
	 */
	public boolean isElcbInstalled();

	/**
	 * Sets whether this connection request is elcb installed.
	 *
	 * @param elcbInstalled the elcb installed of this connection request
	 */
	public void setElcbInstalled(boolean elcbInstalled);

	/**
	 * Returns the elcb document of this connection request.
	 *
	 * @return the elcb document of this connection request
	 */
	@AutoEscape
	public String getElcbDocument();

	/**
	 * Sets the elcb document of this connection request.
	 *
	 * @param elcbDocument the elcb document of this connection request
	 */
	public void setElcbDocument(String elcbDocument);

	/**
	 * Returns the stilt parking of this connection request.
	 *
	 * @return the stilt parking of this connection request
	 */
	public boolean getStiltParking();

	/**
	 * Returns <code>true</code> if this connection request is stilt parking.
	 *
	 * @return <code>true</code> if this connection request is stilt parking; <code>false</code> otherwise
	 */
	public boolean isStiltParking();

	/**
	 * Sets whether this connection request is stilt parking.
	 *
	 * @param stiltParking the stilt parking of this connection request
	 */
	public void setStiltParking(boolean stiltParking);

	/**
	 * Returns the height15 mtr of this connection request.
	 *
	 * @return the height15 mtr of this connection request
	 */
	public boolean getHeight15Mtr();

	/**
	 * Returns <code>true</code> if this connection request is height15 mtr.
	 *
	 * @return <code>true</code> if this connection request is height15 mtr; <code>false</code> otherwise
	 */
	public boolean isHeight15Mtr();

	/**
	 * Sets whether this connection request is height15 mtr.
	 *
	 * @param height15Mtr the height15 mtr of this connection request
	 */
	public void setHeight15Mtr(boolean height15Mtr);

	/**
	 * Returns the height17 mtr of this connection request.
	 *
	 * @return the height17 mtr of this connection request
	 */
	public boolean getHeight17Mtr();

	/**
	 * Returns <code>true</code> if this connection request is height17 mtr.
	 *
	 * @return <code>true</code> if this connection request is height17 mtr; <code>false</code> otherwise
	 */
	public boolean isHeight17Mtr();

	/**
	 * Sets whether this connection request is height17 mtr.
	 *
	 * @param height17Mtr the height17 mtr of this connection request
	 */
	public void setHeight17Mtr(boolean height17Mtr);

	/**
	 * Returns the fcc of this connection request.
	 *
	 * @return the fcc of this connection request
	 */
	public boolean getFcc();

	/**
	 * Returns <code>true</code> if this connection request is fcc.
	 *
	 * @return <code>true</code> if this connection request is fcc; <code>false</code> otherwise
	 */
	public boolean isFcc();

	/**
	 * Sets whether this connection request is fcc.
	 *
	 * @param fcc the fcc of this connection request
	 */
	public void setFcc(boolean fcc);

	/**
	 * Returns the fcc certificate of this connection request.
	 *
	 * @return the fcc certificate of this connection request
	 */
	@AutoEscape
	public String getFccCertificate();

	/**
	 * Sets the fcc certificate of this connection request.
	 *
	 * @param fccCertificate the fcc certificate of this connection request
	 */
	public void setFccCertificate(String fccCertificate);

	/**
	 * Returns the lift of this connection request.
	 *
	 * @return the lift of this connection request
	 */
	public boolean getLift();

	/**
	 * Returns <code>true</code> if this connection request is lift.
	 *
	 * @return <code>true</code> if this connection request is lift; <code>false</code> otherwise
	 */
	public boolean isLift();

	/**
	 * Sets whether this connection request is lift.
	 *
	 * @param lift the lift of this connection request
	 */
	public void setLift(boolean lift);

	/**
	 * Returns the lift certificate of this connection request.
	 *
	 * @return the lift certificate of this connection request
	 */
	@AutoEscape
	public String getLiftCertificate();

	/**
	 * Sets the lift certificate of this connection request.
	 *
	 * @param liftCertificate the lift certificate of this connection request
	 */
	public void setLiftCertificate(String liftCertificate);

	/**
	 * Returns the agri consumer of this connection request.
	 *
	 * @return the agri consumer of this connection request
	 */
	public boolean getAgriConsumer();

	/**
	 * Returns <code>true</code> if this connection request is agri consumer.
	 *
	 * @return <code>true</code> if this connection request is agri consumer; <code>false</code> otherwise
	 */
	public boolean isAgriConsumer();

	/**
	 * Sets whether this connection request is agri consumer.
	 *
	 * @param agriConsumer the agri consumer of this connection request
	 */
	public void setAgriConsumer(boolean agriConsumer);

	/**
	 * Returns the has bdo certificate of this connection request.
	 *
	 * @return the has bdo certificate of this connection request
	 */
	public boolean getHasBdoCertificate();

	/**
	 * Returns <code>true</code> if this connection request is has bdo certificate.
	 *
	 * @return <code>true</code> if this connection request is has bdo certificate; <code>false</code> otherwise
	 */
	public boolean isHasBdoCertificate();

	/**
	 * Sets whether this connection request is has bdo certificate.
	 *
	 * @param hasBdoCertificate the has bdo certificate of this connection request
	 */
	public void setHasBdoCertificate(boolean hasBdoCertificate);

	/**
	 * Returns the bdo certificate of this connection request.
	 *
	 * @return the bdo certificate of this connection request
	 */
	@AutoEscape
	public String getBdoCertificate();

	/**
	 * Sets the bdo certificate of this connection request.
	 *
	 * @param bdoCertificate the bdo certificate of this connection request
	 */
	public void setBdoCertificate(String bdoCertificate);

	/**
	 * Returns the e service on mail of this connection request.
	 *
	 * @return the e service on mail of this connection request
	 */
	public boolean getEServiceOnMail();

	/**
	 * Returns <code>true</code> if this connection request is e service on mail.
	 *
	 * @return <code>true</code> if this connection request is e service on mail; <code>false</code> otherwise
	 */
	public boolean isEServiceOnMail();

	/**
	 * Sets whether this connection request is e service on mail.
	 *
	 * @param eServiceOnMail the e service on mail of this connection request
	 */
	public void setEServiceOnMail(boolean eServiceOnMail);

	/**
	 * Returns the e service mail ID of this connection request.
	 *
	 * @return the e service mail ID of this connection request
	 */
	@AutoEscape
	public String getEServiceMailId();

	/**
	 * Sets the e service mail ID of this connection request.
	 *
	 * @param eServiceMailId the e service mail ID of this connection request
	 */
	public void setEServiceMailId(String eServiceMailId);

	/**
	 * Returns the applicant photo of this connection request.
	 *
	 * @return the applicant photo of this connection request
	 */
	@AutoEscape
	public String getApplicantPhoto();

	/**
	 * Sets the applicant photo of this connection request.
	 *
	 * @param applicantPhoto the applicant photo of this connection request
	 */
	public void setApplicantPhoto(String applicantPhoto);

	/**
	 * Returns the applicant signature of this connection request.
	 *
	 * @return the applicant signature of this connection request
	 */
	public long getApplicantSignature();

	/**
	 * Sets the applicant signature of this connection request.
	 *
	 * @param applicantSignature the applicant signature of this connection request
	 */
	public void setApplicantSignature(long applicantSignature);

	/**
	 * Returns the id proof type of this connection request.
	 *
	 * @return the id proof type of this connection request
	 */
	@AutoEscape
	public String getIdProofType();

	/**
	 * Sets the id proof type of this connection request.
	 *
	 * @param idProofType the id proof type of this connection request
	 */
	public void setIdProofType(String idProofType);

	/**
	 * Returns the id proof no of this connection request.
	 *
	 * @return the id proof no of this connection request
	 */
	@AutoEscape
	public String getIdProofNo();

	/**
	 * Sets the id proof no of this connection request.
	 *
	 * @param idProofNo the id proof no of this connection request
	 */
	public void setIdProofNo(String idProofNo);

	/**
	 * Returns the id proof document of this connection request.
	 *
	 * @return the id proof document of this connection request
	 */
	@AutoEscape
	public String getIdProofDocument();

	/**
	 * Sets the id proof document of this connection request.
	 *
	 * @param idProofDocument the id proof document of this connection request
	 */
	public void setIdProofDocument(String idProofDocument);

	/**
	 * Returns the ownership proof type of this connection request.
	 *
	 * @return the ownership proof type of this connection request
	 */
	@AutoEscape
	public String getOwnershipProofType();

	/**
	 * Sets the ownership proof type of this connection request.
	 *
	 * @param ownershipProofType the ownership proof type of this connection request
	 */
	public void setOwnershipProofType(String ownershipProofType);

	/**
	 * Returns the ownership proof document of this connection request.
	 *
	 * @return the ownership proof document of this connection request
	 */
	@AutoEscape
	public String getOwnershipProofDocument();

	/**
	 * Sets the ownership proof document of this connection request.
	 *
	 * @param ownershipProofDocument the ownership proof document of this connection request
	 */
	public void setOwnershipProofDocument(String ownershipProofDocument);

	/**
	 * Returns the self declaration of this connection request.
	 *
	 * @return the self declaration of this connection request
	 */
	public boolean getSelfDeclaration();

	/**
	 * Returns <code>true</code> if this connection request is self declaration.
	 *
	 * @return <code>true</code> if this connection request is self declaration; <code>false</code> otherwise
	 */
	public boolean isSelfDeclaration();

	/**
	 * Sets whether this connection request is self declaration.
	 *
	 * @param selfDeclaration the self declaration of this connection request
	 */
	public void setSelfDeclaration(boolean selfDeclaration);

	/**
	 * Returns the self declaration time of this connection request.
	 *
	 * @return the self declaration time of this connection request
	 */
	public Date getSelfDeclarationTime();

	/**
	 * Sets the self declaration time of this connection request.
	 *
	 * @param selfDeclarationTime the self declaration time of this connection request
	 */
	public void setSelfDeclarationTime(Date selfDeclarationTime);

	/**
	 * Returns the bp number of this connection request.
	 *
	 * @return the bp number of this connection request
	 */
	@AutoEscape
	public String getBpNumber();

	/**
	 * Sets the bp number of this connection request.
	 *
	 * @param bpNumber the bp number of this connection request
	 */
	public void setBpNumber(String bpNumber);

	/**
	 * Returns the order no of this connection request.
	 *
	 * @return the order no of this connection request
	 */
	@AutoEscape
	public String getOrderNo();

	/**
	 * Sets the order no of this connection request.
	 *
	 * @param orderNo the order no of this connection request
	 */
	public void setOrderNo(String orderNo);

	/**
	 * Returns the document uploaded of this connection request.
	 *
	 * @return the document uploaded of this connection request
	 */
	@AutoEscape
	public String getDocumentUploaded();

	/**
	 * Sets the document uploaded of this connection request.
	 *
	 * @param documentUploaded the document uploaded of this connection request
	 */
	public void setDocumentUploaded(String documentUploaded);

	/**
	 * Returns the sap order generated of this connection request.
	 *
	 * @return the sap order generated of this connection request
	 */
	@AutoEscape
	public String getSapOrderGenerated();

	/**
	 * Sets the sap order generated of this connection request.
	 *
	 * @param sapOrderGenerated the sap order generated of this connection request
	 */
	public void setSapOrderGenerated(String sapOrderGenerated);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ConnectionRequest connectionRequest);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ConnectionRequest> toCacheModel();

	@Override
	public ConnectionRequest toEscapedModel();

	@Override
	public ConnectionRequest toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}