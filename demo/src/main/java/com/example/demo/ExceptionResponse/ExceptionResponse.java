package com.example.demo.ExceptionResponse;

import java.util.Date;

public class ExceptionResponse {

	
	private Date timeStamp;
	private String mesaage;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String mesaage, String details) {
		super();
		this.timeStamp = timeStamp;
		this.mesaage = mesaage;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMesaage() {
		return mesaage;
	}

	public String getDetails() {
		return details;
	}

	
	
	

}
