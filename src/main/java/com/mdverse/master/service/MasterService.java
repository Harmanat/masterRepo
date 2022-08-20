package com.mdverse.master.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdverse.master.entity.Master;
import com.mdverse.master.repository.MasterRepo;


@Service
public class MasterService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	private final MasterRepo MasterRepo;

	public MasterService(final MasterRepo MasterRepo) {
		this.MasterRepo = MasterRepo;
	}

	@Transactional(readOnly = true)
	public List<Master> getAllMasters(int count) {
		return this.MasterRepo.findAll().stream().limit(count).collect(Collectors.toList());
	}


	@Transactional
	public Master createMaster(int id, String userName, String password, String firstName, String lastName,
			Long phoneNumber, String emailAddress) {

//		sendMail(emailAddress);
//		
//		Master master = new Master();
//		master.setId(id);
//		master.setUserName(userName);
//		master.setPassword(password);
//		master.setFirstName(firstName);
//		master.setLastName(lastName);
//		master.setPhoneNumber(phoneNumber);
//		master.setEmailAddress(emailAddress);
//		return this.MasterRepo.save(master);
		return null;
	}
	
	public void sendMail(String emailAddress) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo("singh_harmanat@yahoo.co.in");
			mailMessage.setText("message body");
			mailMessage.setSubject("message subject");

			javaMailSender.send(mailMessage);
			System.out.println("Mail Sent Successfully...");
		} catch (Exception e) {
			System.out.println("Error while sending the mail" + e);
		}
	}

}
