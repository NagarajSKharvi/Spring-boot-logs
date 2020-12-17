package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected String logPrefix  = "{} : {}";
	
	@GetMapping("/rest")
	public String getMessage() {
		logger.debug(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		return "Rest Call working";
	}
	
}
