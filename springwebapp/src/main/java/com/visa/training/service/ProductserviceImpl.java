package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.dal.ProductDAOInMemoryImpl;
import com.visa.training.domain.Product;

@Service
public class ProductserviceImpl implements ProductService {

	// ProductDAO dao = new ProductDAOInMemoryImpl();
	ProductDAO dao;

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		int id = 0;
		if (p.getPrice() * p.getQoh() >= 10000) {
			Product created = dao.save(p);
			id = created.getId();

		} else {
			throw new IllegalArgumentException("min value should be atleast 10k");
		}

		return id;
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		Product p = dao.findById(id);
		if (p.getQoh() > 1000) {
			throw new IllegalArgumentException("cant remove value> 10000");
		} else {
			dao.remove(id);
		}
	}

}
