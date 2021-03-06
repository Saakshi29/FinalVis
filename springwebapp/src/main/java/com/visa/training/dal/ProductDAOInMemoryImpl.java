package com.visa.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.visa.training.domain.Product;

//@Repository
public class ProductDAOInMemoryImpl implements ProductDAO {

	int idSequence;
	Map<Integer, Product> data = new HashMap<>();

	public Product save(Product p) {
		int id = ++idSequence;
		p.setId(id);
		data.put(id, p);
		return p;
	}

	public Product findById(int id) {
		return data.get(id);
	}

	public List<Product> findAll() {
		return new ArrayList<>(data.values());
	}

	public void update(Product p) {
		data.put(p.getId(), p);
	}

	public void remove(int id) {
		data.remove(id);
	}

}
