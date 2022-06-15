package com.jwc.data.dao;

import java.util.List;

import com.jwc.domain.model.Product;

//Data Access Object
//DB랑 연결할 
public interface ProductDao {

	String TABLE_NAME = "product";
	String COLUMN_ID = "p_id";

	// interface 안에서는 public 생략되어 있고 public만 됨.
	List<Product> getAll();

	void insert(Product product);

	void update(Product product);

	void delete(Product product);
}
