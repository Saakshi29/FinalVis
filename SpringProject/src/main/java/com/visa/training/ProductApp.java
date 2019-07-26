package com.visa.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.training.ui.ProductConsoleUI;

public class ProductApp {

	public static void main(String[] args) {
		// ProductConsoleUI ui = new ProductConsoleUI();
		Class[] config = { ProductAppConfiguration.class, PersistenceJPAConfiguration.class };
		ApplicationContext springContainer = new AnnotationConfigApplicationContext(ProductAppConfiguration.class);
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		ui.createProductwithUI();

	}

}
