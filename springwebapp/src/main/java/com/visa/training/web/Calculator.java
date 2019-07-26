package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
	@RequestMapping("/cal")
	public ModelAndView caLculate(@RequestParam("n1") String n1, @RequestParam("n2") String n2,
			@RequestParam("op") String op) {

		double no1 = Double.parseDouble(n1);
		double no2 = Double.parseDouble(n2);
		double result = 0;
		switch (op) {
		case "+":
			result = no1 + no2;
			break;

		case "-":
			result = no1 - no2;
			break;

		case "*":
			result = no1 * no2;
			break;

		case "/":
			result = no1 / no2;
			break;
		}
		String viewName = "calculator";
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("result", result);
		return new ModelAndView(viewName, attributes);

	}
}
