package com.example.demo.user;

import java.net.URI;


import java.util.List;

import javax.validation.Valid;

import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@Validated
public class UserResource {
	@Autowired
	private UserDaoService userservce;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userservce.findAll();

	}

	@GetMapping(path = ("/users/{id}"))
	public EntityModel<User>    retrieveSpecificUser(@PathVariable int id) {
		User user=  userservce.findOne(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+id);
		
		 EntityModel<User> model=EntityModel.of(user);
		
		 WebMvcLinkBuilder linkToUsers=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 model.add(linkToUsers.withRel("alluisers"));
		 
		 
		return model;
	}
	@DeleteMapping(path = ("/users/{id}"))
	public void deleteUser(@PathVariable int id) {
		User user=  userservce.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User saveUser=userservce.save(user);
		// displaying status code of success i.e. 201   code 
	
	URI location=	ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();		
		
	}
}
