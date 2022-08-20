package com.mdverse.master.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	
	private String hospitalName;
	private String hospitalAdd;
	private String deptName;
	private String deptUserName;
	private String deptFirstName;
	private String deptLastName;
	private Long deptPhoneNumber;
	private String deptEmail;
	private LocalDate provisionedDate;
	
	@OneToOne(mappedBy = "hospital", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private DepartmentStatistics departmentStatistics;
	
	public int getId() {
		return hospitalId;
	}
	public void setId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAdd() {
		return hospitalAdd;
	}
	public void setHospitalAdd(String hospitalAdd) {
		this.hospitalAdd = hospitalAdd;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptUserName() {
		return deptUserName;
	}
	public void setDeptUserName(String deptUserName) {
		this.deptUserName = deptUserName;
	}
	public String getDeptFirstName() {
		return deptFirstName;
	}
	public void setDeptFirstName(String deptFirstName) {
		this.deptFirstName = deptFirstName;
	}
	public String getDeptLastName() {
		return deptLastName;
	}
	public void setDeptLastName(String deptLastName) {
		this.deptLastName = deptLastName;
	}
	public Long getDeptPhoneNumber() {
		return deptPhoneNumber;
	}
	public void setDeptPhoneNumber(Long deptPhoneNumber) {
		this.deptPhoneNumber = deptPhoneNumber;
	}
	public String getDeptEmail() {
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}
//	public DepartmentStatistics getDepartmentStatistics() {
//		return departmentStatistics;
//	}
//	public void setDepartmentStatistics(DepartmentStatistics departmentStatistics) {
//		this.departmentStatistics = departmentStatistics;
//	}
	public LocalDate getProvisionedDate() {
		return provisionedDate;
	}
	public void setProvisionedDate(LocalDate provisionedDate) {
		this.provisionedDate = provisionedDate;
	}
	
	
}
