package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
//URI versioning
	@GetMapping("/PersonNameV1")
	public PersonNameV1 personNameV1() {
		return new PersonNameV1("akcn");
	}

	@GetMapping("/PersonNameV2")
	public PersonNameV2 personNameV2() {
		return new PersonNameV2(new Name("cm", "zcm"));
	}
//req parameter versioning
	@GetMapping(value = "/PersonNameV1/params", params = "version=1")
	public PersonNameV1 personNameV1Param() {
		return new PersonNameV1("naveena");
	}

	@GetMapping(value = "/PersonNameV2/params", params = "version=2")
	public PersonNameV2 personNameV2Param() {
		return new PersonNameV2(new Name("uday", "kiran"));
	}
//header versioning
	@GetMapping(value = "/PersonNameV1/header", headers = "X-API-version=1")
	public PersonNameV1 header1() {
		return new PersonNameV1("kiran");
	}

	@GetMapping(value = "/PersonNameV2/header", headers = "X-API-version=2")
	public PersonNameV2 header2() {
		return new PersonNameV2(new Name("uday", "kiran"));
	}
	
	//mind versioning also called Media Type Versioning,Content negotiation,Accept header 
	@GetMapping(value = "/PersonNameV1/produces", headers = "application/X-API-version=1+json")
	public PersonNameV1 producesV1() {
		return new PersonNameV1("kiran");
	}
	
	@GetMapping(value = "/PersonNameV2/produces", headers = "application/X-API-version=2+json")
	public PersonNameV2 producesV2() {
		return new PersonNameV2(new Name("uday", "kiran"));
	}

}
