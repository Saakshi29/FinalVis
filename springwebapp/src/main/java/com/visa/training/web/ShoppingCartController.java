package com.visa.training.web;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "selectedBooks", "selectedCars", "selectedBikes" })
public class ShoppingCartController {

	@RequestMapping("/addBooks")
	public String handAddBook(@RequestParam("books") String[] books, Map model) {
		model.put("selectedBooks", books);
		return "cars";

	}

	@RequestMapping("/addCars")
	public String handAddCar(@RequestParam("cars") String[] cars, Map model) {
		model.put("selectedCars", cars);
		return "bikes";

	}

	@RequestMapping("/addBikes")
	public String handAddBikes(@RequestParam("bikes") String[] bikes, Map model) {
		model.put("selectedBikes", bikes);
		return "cart";

	}
}
