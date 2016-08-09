package com.nshpage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="/Cartoon")
public class CartoonController {

	private static final Logger logger = LoggerFactory.getLogger(CartoonController.class);
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String callMainPage() {
		logger.info("cartoon main page request");
		
		return "cartoon/main";
	}
	
	
}
