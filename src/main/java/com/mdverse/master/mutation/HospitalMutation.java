package com.mdverse.master.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdverse.master.entity.Hospital;
import com.mdverse.master.service.HospitalService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class HospitalMutation implements GraphQLMutationResolver {

	@Autowired
	public HospitalService HospitalService;

	public Hospital createHospital(String hospitalName, String hospitalAdd, String deptName, String deptUserName,
			String deptFirstName, String deptLastName, Long deptPhoneNumber, String deptEmail) {

		System.out.println("Running createHospital...");
		
		return this.HospitalService.createHospital(hospitalName, hospitalAdd, deptName, deptUserName, deptFirstName,
				deptLastName, deptPhoneNumber, deptEmail);
	}
}
