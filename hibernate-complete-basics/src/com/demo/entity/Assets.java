package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Assets_Table")
@NamedQuery(name="Assets.average_location_price", query="Select a.assetLocation,avg(a.assetPrice) From Assets a group by a.assetLocation")
public class Assets {
	@Id
	@Column(name = "ID")
	private int assetId;
	@Column(name = "SR_NUMBER")
	private int serialNo;
	@Column(name = "PR_NUMBER")
	private int prNo;
	@Column(name = "ASSET_TYPE")
	private String assetType;
	@Column(name = "ASSET_PRICE")
	private int assetPrice;
	@Column(name = "ASSET_LOCATION")
	private String assetLocation;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getPrNo() {
		return prNo;
	}

	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public int getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(int assetPrice) {
		this.assetPrice = assetPrice;
	}

	public String getAssetLocation() {
		return assetLocation;
	}

	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}
}
