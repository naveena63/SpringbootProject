package com.example.demo.filteringController;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
@RestController
public class FilteringController {
	
	//filed1,field2;
	
	private Object object;
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean()
	{
		
		SomeBean somebean=new SomeBean("value1","value2","value3");
		 SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("filed1");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		  MappingJacksonValue mapping =new MappingJacksonValue(somebean);
		 
		mapping.setFilters(filters);
		  
		  
		return mapping;
	}
	@GetMapping("/filtering-list")
public MappingJacksonValue retrieveListofSomeBeans()
{
		List<SomeBean> list= Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value11","value21","value31"));

		
		 SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("filed1");
			FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
			  MappingJacksonValue mapping =new MappingJacksonValue(list);
			 
			mapping.setFilters(filters);
			  
			  
			return mapping;
			}


}
