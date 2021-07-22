	package com.example.demo.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@EntityScan("com.example.demo.user")
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")
	@Size(min =2 , message="Name should atleast 2 charachters")
	private String name;
	
	@Past
	@Column(length = 233)
	private Date birthdate;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	protected User() {
		
	}

}
