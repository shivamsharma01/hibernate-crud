package com.demo.dao;

import java.util.List;

import com.demo.entity.Assets;

public interface AssetsDao {
	public void add(Assets asset);
	public Assets get(int assetId);
	public Assets getCostliestAsset();
	public List<Assets> getPricePerLocation();
}
