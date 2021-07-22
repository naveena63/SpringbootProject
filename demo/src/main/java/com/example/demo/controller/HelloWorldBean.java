package com.example.demo.controller;

public class HelloWorldBean {


private String messśage;
	public HelloWorldBean(String messśage) {
	this.messśage=messśage;
	}
	public void setMessśage(String messśage) {
		this.messśage = messśage;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [messśage=" + messśage + "]";
	}
	public String getMessśage() {
		return messśage;
	}


}
