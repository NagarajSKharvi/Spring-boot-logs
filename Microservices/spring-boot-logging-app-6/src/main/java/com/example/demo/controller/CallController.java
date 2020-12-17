package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CallController {
	
	protected String logPrefix  = "{} : {}";
	
	@GetMapping("/rest")
	public String getMessage() {
		log.debug(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		return "Rest Call working";
	}
	
}
