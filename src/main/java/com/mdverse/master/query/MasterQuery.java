package com.mdverse.master.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mdverse.master.entity.Departments;
import com.mdverse.master.entity.Master;
import com.mdverse.master.service.MasterService;

@Component
public class MasterQuery implements GraphQLQueryResolver {

	@Autowired
	private MasterService MasterService;

	public List<Master> getMasters(final int count) {
		java.lang.System.out.println("Running getMaster.....");
		return this.MasterService.getAllMasters(count);
	}

	public List<Departments> getMasterDepartments(int count) {
		System.out.println("running masterDepartment...");
		
		try {
			System.out.println("running callDepartmentService...");
			final String uri = "http://localhost:8081/graphql/departments";

		    RestTemplate restTemplate = new RestTemplate();
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("content-type", "application/graphql");
		    
		    String query = "{\r\n" + 
		    		"    departments(count:1){\r\n" + 
		    		"        deptName,\r\n" + 
		    		"        depAdmFName,\r\n" + 
		    		"        depAdmLName,\r\n" + 
		    		"        depAdmUserName,\r\n" + 
		    		"        depAdmEmail,\r\n" + 
		    		"        depAdmPhone\r\n" + 
		    		"    }\r\n" + 
		    		"}";

		    ResponseEntity<String> response = restTemplate.postForEntity(uri, new HttpEntity<>(query, headers), String.class);
		      System.out.println("The response================="+response);
		      
//		    String result = restTemplate.getForObject(uri, String.class);
		      
		
		}
		catch(Exception e) {
			System.out.println("ERROR ERROR ERROR: "+e);
		}
		
		return null;
	}
}
