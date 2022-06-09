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
 * The base model interface for the LocalityDivision service. Represents a row in the &quot;bsesconn_LocalityDivision&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.bses.connection2.model.impl.LocalityDivisionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.bses.connection2.model.impl.LocalityDivisionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalityDivision
 * @generated
 */
@ProviderType
public interface LocalityDivisionModel
	extends BaseModel<LocalityDivision>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a locality division model instance should use the {@link LocalityDivision} interface instead.
	 */

	/**
	 * Returns the primary key of this locality division.
	 *
	 * @return the primary key of this locality division
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this locality division.
	 *
	 * @param primaryKey the primary key of this locality division
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this locality division.
	 *
	 * @return the uuid of this locality division
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this locality division.
	 *
	 * @param uuid the uuid of this locality division
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the locality division ID of this locality division.
	 *
	 * @return the locality division ID of this locality division
	 */
	public long getLocalityDivisionId();

	/**
	 * Sets the locality division ID of this locality division.
	 *
	 * @param localityDivisionId the locality division ID of this locality division
	 */
	public void setLocalityDivisionId(long localityDivisionId);

	/**
	 * Returns the group ID of this locality division.
	 *
	 * @return the group ID of this locality division
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this locality division.
	 *
	 * @param groupId the group ID of this locality division
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this locality division.
	 *
	 * @return the company ID of this locality division
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this locality division.
	 *
	 * @param companyId the company ID of this locality division
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this locality division.
	 *
	 * @return the user ID of this locality division
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this locality division.
	 *
	 * @param userId the user ID of this locality division
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this locality division.
	 *
	 * @return the user uuid of this locality division
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this locality division.
	 *
	 * @param userUuid the user uuid of this locality division
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this locality division.
	 *
	 * @return the user name of this locality division
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this locality division.
	 *
	 * @param userName the user name of this locality division
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this locality division.
	 *
	 * @return the create date of this locality division
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this locality division.
	 *
	 * @param createDate the create date of this locality division
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this locality division.
	 *
	 * @return the modified date of this locality division
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this locality division.
	 *
	 * @param modifiedDate the modified date of this locality division
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the locality name of this locality division.
	 *
	 * @return the locality name of this locality division
	 */
	@AutoEscape
	public String getLocalityName();

	/**
	 * Sets the locality name of this locality division.
	 *
	 * @param localityName the locality name of this locality division
	 */
	public void setLocalityName(String localityName);

	/**
	 * Returns the division code of this locality division.
	 *
	 * @return the division code of this locality division
	 */
	@AutoEscape
	public String getDivisionCode();

	/**
	 * Sets the division code of this locality division.
	 *
	 * @param divisionCode the division code of this locality division
	 */
	public void setDivisionCode(String divisionCode);

	/**
	 * Returns the division name of this locality division.
	 *
	 * @return the division name of this locality division
	 */
	@AutoEscape
	public String getDivisionName();

	/**
	 * Sets the division name of this locality division.
	 *
	 * @param divisionName the division name of this locality division
	 */
	public void setDivisionName(String divisionName);

	/**
	 * Returns the complaint center of this locality division.
	 *
	 * @return the complaint center of this locality division
	 */
	@AutoEscape
	public String getComplaintCenter();

	/**
	 * Sets the complaint center of this locality division.
	 *
	 * @param complaintCenter the complaint center of this locality division
	 */
	public void setComplaintCenter(String complaintCenter);

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
	public int compareTo(LocalityDivision localityDivision);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LocalityDivision> toCacheModel();

	@Override
	public LocalityDivision toEscapedModel();

	@Override
	public LocalityDivision toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}