package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.ProductDTO;

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

	public int insertProduct(ProductDTO dto) {
		return session.insert("insertProduct",dto);
	}

	public List<ProductDTO> selectAllProduct() {
		return session.selectList("selectAllProduct");
	}

	
	
	
}
