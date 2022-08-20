package com.mdverse.master.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdverse.master.entity.Master;
import com.mdverse.master.service.MasterService;

@Component
public class MasterMutation implements GraphQLMutationResolver {

	@Autowired
	private MasterService MasterService;

	public Master createMaster(int id, String userName, String password, String firstName, String lastName,
			Long phoneNumber, String emailAddress) {
		System.out.println("Running createMaster...");
		return this.MasterService.createMaster(id, userName, password, firstName, lastName, phoneNumber, emailAddress);
	}
}
