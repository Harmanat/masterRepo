package com.mdverse.master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mdverse.master.entity.DepartmentStatistics;
import com.mdverse.master.entity.Hospital;
import com.mdverse.master.repository.DeptStatsRepo;
import com.mdverse.master.repository.HospitalRepo;

@Service
public class HospitalService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	private final HospitalRepo hospitalRepo;
	private final DeptStatsRepo deptStatsRepo;

	public HospitalService(HospitalRepo hospitalRepo, DeptStatsRepo deptStatsRepo) {
		this.hospitalRepo = hospitalRepo;
		this.deptStatsRepo = deptStatsRepo;
	}

	public List<Hospital> getAllHospital() {
		return hospitalRepo.findAll();
	}

	public Hospital createHospital(String hospitalName, String hospitalAdd, String deptName, String deptUserName,
			String deptFirstName, String deptLastName, Long deptPhoneNumber, String deptEmail) {

		Hospital hospital = new Hospital();
		hospital.setHospitalName(hospitalName);
		hospital.setHospitalAdd(hospitalAdd);
		hospital.setDeptName(deptName);
		hospital.setDeptUserName(deptUserName);
		hospital.setDeptFirstName(deptFirstName);
		hospital.setDeptLastName(deptLastName);
		hospital.setDeptPhoneNumber(deptPhoneNumber);
		hospital.setDeptEmail(deptEmail);
		hospital.setProvisionedDate(java.time.LocalDate.now());

		Hospital hospitalResult = this.hospitalRepo.save(hospital);

		createDeptStats(hospitalResult);
		sendMail(deptEmail);

		return hospitalResult;
	}

	/**
	 * Adding an entry in department statistics with the department ID. When we will
	 * create a patient or a medical professional in the admin service, then a call
	 * will be sent to update this table
	 * 
	 * @param hospitalResult
	 */
	public void createDeptStats(Hospital hospitalResult) {
		DepartmentStatistics deptStats = new DepartmentStatistics();
		deptStats.setId(hospitalResult.getId());
		deptStats.setNumOfClinicalStaff(0);
		deptStats.setNumOfConsumers(0);
		deptStats.setAvgAttendeesPerSession(0);
		deptStats.setAvgSessionDuration(0L);
		deptStats.setNumOfSessionsDone(0);
		deptStats.setTotalLengthOfAllSessions(0L);
		deptStats.setHospital(hospitalResult);

		deptStatsRepo.save(deptStats);
	}

	public void sendMail(String emailAddress) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(emailAddress);
			mailMessage.setText("Testing Email sent to the Department Admin on creating a Hospital/Department");
			mailMessage.setSubject("MDverse first mail");

			javaMailSender.send(mailMessage);
			System.out.println("Mail Sent Successfully...");
		} catch (Exception e) {
			System.out.println("Error while sending the mail" + e);
		}
	}

	public List<DepartmentStatistics> getAllDepartmentStatistics() {
		return deptStatsRepo.findAll();
	}
}
