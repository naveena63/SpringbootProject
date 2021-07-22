package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList=new ArrayList<>();
	private static int usercount=3;
	static
	{
		userList.add(new User(1,"naveena",new Date()));
		userList.add(new User(2,"uday",new Date()));
		userList.add(new User(3,"kiran",new Date()));
		
	}
	
	public List<User> findAll(){
		return userList;
		
	}
	public User save(User users)
	{
		if(users.getId()==null)
		{
			users.setId(++usercount);
		}
		userList.add(users);
		return users;
	}
	public User findOne(int id)
	{
		for(User users:userList)
		{
			if(users.getId()==id)
			{
				return users;
			}
		}
	return null;
	}
	public User deleteById(int id)
	{
		Iterator<User> iterator=userList.iterator();
		while(iterator.hasNext()) {
		User users=iterator.next();
			if(users.getId()==id)
			{
				iterator.remove();
				return users;
			}
		}
		
	return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
