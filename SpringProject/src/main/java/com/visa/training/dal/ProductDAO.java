package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.Product;

public interface ProductDAO {

	// dao does crud and query methods
	public Product save(Product p);

	public Product findById(int id);

	public List<Product> findAll();

	public void update(Product p);

	public void remove(int id);

}
