package service;

import java.util.List;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductService {
	private static ProductService instance = new ProductService();
	
	private ProductService() {
		
	}
	
	public static ProductService getInstance() {
		if(instance == null)
			instance = new ProductService();
		
		return instance;
	}

	public int insertProduct(ProductDTO dto) {
		return ProductDAO.getInstance().insertProduct(dto);
	}

	public List<ProductDTO> selectAllProduct() {
		return ProductDAO.getInstance().selectAllProduct();
	}

	
	
}
