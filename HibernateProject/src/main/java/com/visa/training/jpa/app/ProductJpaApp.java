package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class ProductJpaApp {
//f->>fromDB
	public static void main(String[] args) {
		JpaProductDAO dao = new JpaProductDAO();
		/*Product test = new Product("tyu", 45, 900);
		Product saved = dao.save(test);
		System.out.println(saved);
		Product f = dao.findById(saved.getId());
		System.out.println(f);
		System.out.println(f == saved);

		// test update
		f.setPrice(f.getPrice() + 10);
		dao.update(f);

		Product updated = dao.findById(f.getId());
		System.out.println(updated);

	
		// System.out.println(f);
//		 dao.remove(7);
	*/

		List<Product> all=dao.findAll();
		all.forEach(System.out::println);
		System.exit(0);
	
	}

}
