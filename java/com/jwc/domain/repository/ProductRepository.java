package com.jwc.domain.repository;

import java.util.List;
import com.jwc.data.ProductRepositoryDbImpl;
import com.jwc.data.ProductRepositoryImpl;
import com.jwc.data.dao.MysqlProductDaoImpl;
import com.jwc.domain.model.Product;

public interface ProductRepository {
    
    public static ProductRepository getInstance() {
//        return ProductRepositoryImpl.getInstance();
         return new ProductRepositoryDbImpl(new MysqlProductDaoImpl());
    }
    
    public List<Product> getAllProducts();
    
    public Product getProductById(String id);
    
    public void addProduct(Product product);
}