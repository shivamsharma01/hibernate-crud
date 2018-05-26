package com.demo.service;

import java.util.List;

import com.demo.dao.AssetsDao;
import com.demo.dao.AssetsDaoImpl;
import com.demo.entity.Assets;

public class AssetsServiceImpl implements AssetsService {
	private AssetsDao dao = new AssetsDaoImpl();
	@Override
	public void add(Assets asset) {
		dao.add(asset);
	}

	@Override
	public Assets get(int assetId) {
		return dao.get(assetId);
	}

	@Override
	public Assets getCostliestAsset() {
		return dao.getCostliestAsset();
	}

	@Override
	public List<Assets> getPricePerLocation() {
		return dao.getPricePerLocation();
	}

}
