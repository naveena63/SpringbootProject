package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
@Autowired
	private MessageSource messagesource;
	
	
	@GetMapping("/hello")
	
	
	public String Hello() {
		return "naveenauday";
	}

	// passing parameters
	// example: hello-world/path-variable/naveena
	@GetMapping(path = "/hello-world/id/{name}")
	
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) 
	{
		return new HelloWorldBean(String.format("helloworld ,%s", name));
	}
	@GetMapping(path="/hello-world- internalization")
	public String HelloInternalization(
//			@RequestHeader(name="Accept-language",required = false)Locale locale
			) {
		return messagesource.getMessage("good.morning.message",null,"defalut meesage", LocaleContextHolder.getLocale());
	}

//	@GetMapping(path="/hello-internalized")
//	
//	
//	public String Hellointernlized() {
//		return "naveenauday";
//	}

}
