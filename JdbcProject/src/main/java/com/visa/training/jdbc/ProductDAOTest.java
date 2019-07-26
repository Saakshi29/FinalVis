package com.visa.training.jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOTest {

	public static void main(String[] args) throws SQLException {
		ProductDAO p = new ProductDAO();
		/*
		 * Product x = new Product("op", 65, 4000); // p.save(x); //p.findAll(); int
		 * generatedId=p.save(x); System.out.println(generatedId); Product
		 * fromDb=p.findById(generatedId); System.out.println(fromDb);
		 */
		List<Product> all = p.findAll();
		all.forEach(System.out::println);

		p.remove(3);
	}

}
