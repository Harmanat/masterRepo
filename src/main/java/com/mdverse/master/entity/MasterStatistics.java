package com.mdverse.master.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This will have the high-level statistics of Master.
 */
@Entity
@Table(name = "master_statistics")
public class MasterStatistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Per Control-Plane high-level statistics
	 */
	@OneToOne
	private Master master;
	
//	/**
//	 * List of provisioned orgs
//	 */
//	@OneToMany
//	private List<Systems> systems; //TODO
	
	private Integer numOfInstances; //TODO 
	private Long upSince;
	
	/**
	 * System Admin name and contact info.
	 */
	private String sysAdmFName;
	private String sysAdmLName;
	private Long sysAdmPhone;
	private String sysAdmEmail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Master getMasterService() {
		return master;
	}
	public void setMasterService(Master master) {
		this.master = master;
	}
	public Integer getNumOfInstances() {
		return numOfInstances;
	}
	public void setNumOfInstances(Integer numOfInstances) {
		this.numOfInstances = numOfInstances;
	}
	public Long getUpSince() {
		return upSince;
	}
	public String getSysAdmFName() {
		return sysAdmFName;
	}
	public void setSysAdmFName(String sysAdmFName) {
		this.sysAdmFName = sysAdmFName;
	}
	public String getSysAdmLName() {
		return sysAdmLName;
	}
	public void setSysAdmLName(String sysAdmLName) {
		this.sysAdmLName = sysAdmLName;
	}
	public Long getSysAdmPhone() {
		return sysAdmPhone;
	}
	public void setSysAdmPhone(Long sysAdmPhone) {
		this.sysAdmPhone = sysAdmPhone;
	}
	public String getSysAdmEmail() {
		return sysAdmEmail;
	}
	public void setSysAdmEmail(String sysAdmEmail) {
		this.sysAdmEmail = sysAdmEmail;
	}
	public void setUpSince(Long upSince) {
		this.upSince = upSince;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
//	public List<System> getSystems() {
//		return systems;
//	}
//	public void setSystems(List<System> systems) {
//		this.systems = systems;
//	}

}
