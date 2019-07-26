package com.visa.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;


@Component
public class ProductConsoleUI {
	// ProductService service = new ProductserviceImpl();
	
	ProductService service;

	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	public void createProductwithUI() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a name: ");
		String name = kb.nextLine();
		System.out.println("Enter a price:");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter a qoh:");
		int qoh = Integer.parseInt(kb.nextLine());
		Product p = new Product(name, price, qoh);
		try {
			int id = service.addNewProduct(p);
			System.out.println("created" + id);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println("value too low for creation");
		}
	}

}
