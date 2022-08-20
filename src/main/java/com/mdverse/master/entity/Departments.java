package com.mdverse.master.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department in a Hospital (if departments exists). Prototype will contain only
 * one Department And the System Administrator will be the same as the
 * Department Administrator. So the info for Department need not be separately
 * collected in the Prototype - - just copied from the System-level data.
 */
@Entity
@Table
public class Departments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Department name in a Hospital (if departments exists) or <code>DEFAULT</code>
	 * - for Practices that don’t have departments.
	 */
	private String deptName;

	// For Each Department, Department Administrator details
	/**
	 * linkage from DepartmentAdministrator to a Department Prototype will contain
	 * only one Department, and the System Administrator will be the same as the
	 * Departmental Administrator. So the info for Department need not be separately
	 * collected in the Prototype - just copied from the System-level data.
	 */
	private String depAdmUserName;
	private String depAdmPassword;
	private String depAdmFName;
	private String depAdmLName;
	private Long depAdmPhone;
	private String depAdmEmail;

	public String getName() {
		return deptName;
	}

	public void setName(String deptName) {
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepAdmUserName() {
		return depAdmUserName;
	}

	public void setDepAdmUserName(String depAdmUserName) {
		this.depAdmUserName = depAdmUserName;
	}

	public String getDepAdmPassword() {
		return depAdmPassword;
	}

	public void setDepAdmPassword(String depAdmPassword) {
		this.depAdmPassword = depAdmPassword;
	}

	public String getDepAdmFName() {
		return depAdmFName;
	}

	public void setDepAdmFName(String depAdmFName) {
		this.depAdmFName = depAdmFName;
	}

	public String getDepAdmLName() {
		return depAdmLName;
	}

	public void setDepAdmLName(String depAdmLName) {
		this.depAdmLName = depAdmLName;
	}

	public Long getDepAdmPhone() {
		return depAdmPhone;
	}

	public void setDepAdmPhone(Long depAdmPhone) {
		this.depAdmPhone = depAdmPhone;
	}

	public String getDepAdmEmail() {
		return depAdmEmail;
	}

	public void setDepAdmEmail(String depAdmEmail) {
		this.depAdmEmail = depAdmEmail;
	}

}
