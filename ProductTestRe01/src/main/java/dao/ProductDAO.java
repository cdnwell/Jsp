package dao;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	private SqlSession session;
	
	private ProductDAO() {
		session = DBManager.getInstance().getSession();
	}
	
	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		
		return instance;
	}
	
}
