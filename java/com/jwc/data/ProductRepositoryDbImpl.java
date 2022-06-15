package com.jwc.data;

import java.util.Collections;
import java.util.List;

import com.jwc.data.dao.ProductDao;
import com.jwc.domain.model.Product;
import com.jwc.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements  ProductRepository  {
	
	private ProductDao dao;
	
	public ProductRepositoryDbImpl(ProductDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Product getProductById(String id) {
		return getAllProducts().stream().filter((product) -> product.getId().equals(id)) // 조건
				.findFirst() // 첫번째
				.get(); // 얻어
	}

	@Override
	public void addProduct(Product product) {
		dao.insert(product);
	}

}
