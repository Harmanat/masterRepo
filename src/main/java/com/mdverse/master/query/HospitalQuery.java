package com.mdverse.master.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdverse.master.entity.DepartmentStatistics;
import com.mdverse.master.entity.Hospital;
import com.mdverse.master.service.HospitalService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class HospitalQuery implements GraphQLQueryResolver{
	
	@Autowired
	private final HospitalService hospitalService;
	
	public HospitalQuery(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	
	public List<Hospital> getHospitals(int count){
		return hospitalService.getAllHospital();
	}
	
	public List<DepartmentStatistics> getDepartmentStatistics(int count){
		return hospitalService.getAllDepartmentStatistics();
	}
	
}
