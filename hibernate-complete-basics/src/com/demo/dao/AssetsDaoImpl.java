package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.demo.entity.Assets;
import com.demo.util.HibernateUtil;

public class AssetsDaoImpl implements AssetsDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public void add(Assets asset) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(asset);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Assets get(int assetId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Assets asset = session.get(Assets.class, assetId);
		session.getTransaction().commit();
		session.close();
		return asset;
	}

	@Override
	public Assets getCostliestAsset() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select a from Assets a where a.assetPrice = (select max(aa.assetPrice) from Assets aa)");
		Assets asset = (Assets)query.list().get(0);
		session.getTransaction().commit();
		session.close();
		return asset;
	}

	@Override
	public List<Assets> getPricePerLocation() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createNamedQuery("Assets.average_location_price");
		List<Object[]> assets = query.list();
		List<Assets> returnList = new ArrayList<>();
		Assets asset = null;
		for (Object[] ob: assets) {
			 asset = new Assets();
			 asset.setAssetLocation((String)ob[0]);
			 double price = (double)ob[1];
			 asset.setAssetPrice((int)price);
			 returnList.add(asset);
		}
		session.getTransaction().commit();
		session.close(); 
		return returnList;
	}

}
