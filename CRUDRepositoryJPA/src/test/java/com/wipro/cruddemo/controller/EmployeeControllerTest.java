package com.wipro.cruddemo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.cruddemo.model.Employee;
import com.wipro.cruddemo.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	private EmployeeService empservice;
	
	
	@Test
	public void Hellworld() throws Exception {
		
		RequestBuilder request=MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(request).andReturn();
		
	   assertEquals("Welcome to TestController",mvcresult.getResponse().getContentAsString());
		
		
		//MvcResult mvcresult=mockmvc.perform(request).andExpect(status().isOk()).andExpect(content().string("Welcome to TestController")).andReturn();
		
		//assertEquals("Welcome to TestController",mvcresult.getResponse().getContentAsString());
		
	}
	

	
	@Test
	public void getEmployeeByIdTest() throws Exception
	{
	//Employee emp=new Employee(100,"RAJ","C1",200000);
		 when(empservice.getEmployeeById(100)).thenReturn(new Employee(100,"RAJ","C1",200000));
		 
		 
		RequestBuilder request=MockMvcRequestBuilders.get("/employee/{id}",100).accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcresult=mockmvc.perform(request).andExpect(status().isOk()).andExpect(content().json("{empid:100,empname:RAJ,empband:C1,empsal:200000}")).andReturn();
		//ResultActions mvcresult=mockmvc.perform(request).andExpect(status().isOk());//.andExpect(MockMvcResultMatchers.jsonPath("$.empname").value(100));	
	//assertEquals("RAJ",mvcresult);
		
		
	  
		//String e=mvcresult.getResponse().getContentAsString();
		//assertEquals( emp.toString(),e.);
	/*	mockmvc.perform(
				get("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // HTTP response is 200
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].empname",is("RAJ")));
			
		*/
		
		
		
		
		
	}
	

@Test
public void getEmployeesTest() throws Exception
{
	
	List<Employee> list = new ArrayList<Employee>();
    Employee empOne = new Employee(1, "RAJ", "C1", 200000);
    Employee empTwo = new Employee(2, "DAKSHITH", "B1", 200000); 
    Employee empThree = new Employee(3, "KIRAN", "B1", 200000);
    list.add(empOne);
    list.add(empTwo);
    list.add(empThree);
    
    when(empservice.getAllEmployees()).thenReturn(list);
    
    
    RequestBuilder request=MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON);
     mockmvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$[*].empid").isNotEmpty());
}
 /*   
    
    RequestBuilder request=MockMvcRequestBuilders.get("/employess").accept(MediaType.APPLICATION_JSON);
	MvcResult mvcresult=mockmvc.perform(request).andReturn();
 // assertEquals(3,mvcresult.getResponse().getContentAsByteArray().length);
  //String str=mvcresult.getResponse()..getContentAsString();
  //System.out.println(str);
	


	ObjectMapper mapper = new ObjectMapper();

	// this uses a TypeReference to inform Jackson about the Lists's generic type
	List<Employee> actual = mapper.readValue(mvcresult.getResponse().getContentAsString(), new TypeReference<List<Employee>>(){});

	assertEquals("RAJ",actual.get(0).getEmpname());
	assertEquals("DAKSHITH",actual.get(1).getEmpname());
	assertEquals("C1",actual.get(0).getEmpband());
	
	
  
 // assertEquals(3, empList.size());
  verify(empservice, times(1)).getAllEmployees();  
  
    
}
	
	
	@Test
	public void test1GetDefault() throws Exception {
		
		//System.out.println(mockmvc);
		
		
		/*mockmvc.perform(
				get("/hello")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // HTTP response is 200
				.andExpect(MockMvcResultMatchers.jsonPath("$").value("Welcome to TestController"));
				
		*/
	
		
	}
	
	
	


