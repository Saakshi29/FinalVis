package com.visa.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	ProductValidator validator;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView listProducts() {
		Product product = new Product();
		List<Product> productList = service.findAll();
		Map<String, Object> attr = new HashMap<>();
		attr.put("productList", productList);
		attr.put("product", product);

		return new ModelAndView("productslist", attr);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product p, Errors validationErrors) {
		// Product p = new Product(name, price, qoh);
		validator.validate(p, validationErrors);
		if (!validationErrors.hasErrors()) {
			service.addNewProduct(p);
		}
		List<Product> productList = service.findAll();
		Map<String, Object> attr = new HashMap<>();
		attr.put("productList", productList);
		return new ModelAndView("productslist", attr);
	}

	@RequestMapping("/removeProduct")
	public ModelAndView removeProduct(@RequestParam("id") int id) {
		try {
			service.deleteProduct(id);
		} catch (IllegalArgumentException e) {
			return new ModelAndView("removeFailed");
		}
		List<Product> productList = service.findAll();
		Map<String, Object> attr = new HashMap<>();
		attr.put("productList", productList);
		Product product = new Product();
		attr.put("product", product);
		return new ModelAndView("productslist", attr);
	}

	/*
	 * @ModelAttribute("productList") public List<Product> getProductList(){ return
	 * service.findAll(); }
	 */

}
/*
 * @RequestMapping(value = "/products", method = RequestMethod.GET) public
 * ModelAndView listProducts() { Product product = new Product(); List<Product>
 * productslist = service.findAll(); Map<String, Object> attr = new HashMap<>();
 * attr.put("productslist", productslist); attr.put("product", product); return
 * new ModelAndView("productslist", attr);
 * 
 * // return new ModelAndView("productslist", "product", product); }
 * 
 * @RequestMapping(value = "/products", method = RequestMethod.POST) public
 * String addProduct(@ModelAttribute("product") Product p, Errors
 * validationErrors) { // Product p = new Product(name, price, qoh);
 * validator.validate(p, validationErrors); if (!validationErrors.hasErrors()) {
 * service.addNewProduct(p); }
 * 
 * return "productslist"; }
 * 
 * @RequestMapping("/removeProduct") public String
 * removeProduct(@RequestParam("id") int id) { try { service.deleteProduct(id);
 * } catch (IllegalArgumentException e) { return "removeFailed"; }
 * 
 * return "productslist"; }
 * 
 * @ModelAttribute("productList") public List<Product> getProductList() { return
 * service.findAll(); }
 * 
 * } /*
 * 
 * @Autowired ProductService service;
 * 
 * @Autowired ProductValidator validator;
 * 
 * // @RequestMapping("/listProducts")
 * 
 * @RequestMapping(value = "/products", method = RequestMethod.GET) public
 * String ListProducts() {
 * 
 * // List<Product> productList = service.findAll(); // return new
 * ModelAndView("products", "productList", productList); return "productlist"; }
 * 
 * /* // @RequestMapping("/addProduct")
 * 
 * @RequestMapping(value = "/products", method = RequestMethod.POST) public
 * String addProduct(@ModelAttribute("product") Product p) { // public String
 * addProduct(@RequestParam("name") String name, @RequestParam("price") float
 * price, // @RequestParam("qoh") int qoh) { // Product p = new Product(name,
 * price, qoh); service.addNewProduct(p);
 * 
 * // List<Product> productList = service.findAll(); // return new
 * ModelAndView("products", "productList", productList); return "productlist"; }
 */
/*
 * @RequestMapping(value = "/products", method = RequestMethod.GET) public
 * ModelAndView listProducts() { Product product = new Product(); return new
 * ModelAndView("productslist", "product", product); }
 * 
 * public String removeProduct(@RequestParam("id") int id) { try {
 * service.deleteProduct(id); } catch (Exception e) {
 * 
 * } // List<Product> productList = service.findAll(); // return new
 * ModelAndView("products", "productList", productList); return "productlist"; }
 * 
 * @ModelAttribute("productList") public List<Product> getProductList() {
 * 
 * return service.findAll(); }
 * 
 * }
 */
