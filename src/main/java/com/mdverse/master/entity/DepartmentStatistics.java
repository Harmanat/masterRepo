package com.mdverse.master.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Per Control-Plane high-level statistics.
 */
@Entity
@Table(name = "department_statistics")
public class DepartmentStatistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	/**
//	 * List of provisioned orgs
//	 */
//	@OneToMany
//	private List<Systems> systems; //TODO
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "hospitalId")
	private Hospital hospital;
	
	
	private Integer numOfClinicalStaff;
	private Integer numOfConsumers;
	private Integer numOfSessionsDone;
	private Long totalLengthOfAllSessions;
	private Long avgSessionDuration;
	private Integer avgAttendeesPerSession;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumOfClinicalStaff() {
		return numOfClinicalStaff;
	}
	public void setNumOfClinicalStaff(Integer numOfClinicalStaff) {
		this.numOfClinicalStaff = numOfClinicalStaff;
	}
	public Integer getNumOfConsumers() {
		return numOfConsumers;
	}
	public void setNumOfConsumers(Integer numOfConsumers) {
		this.numOfConsumers = numOfConsumers;
	}
	public Integer getNumOfSessionsDone() {
		return numOfSessionsDone;
	}
	public void setNumOfSessionsDone(Integer numOfSessionsDone) {
		this.numOfSessionsDone = numOfSessionsDone;
	}
	public Long getTotalLengthOfAllSessions() {
		return totalLengthOfAllSessions;
	}
	public void setTotalLengthOfAllSessions(Long totalLengthOfAllSessions) {
		this.totalLengthOfAllSessions = totalLengthOfAllSessions;
	}
	public Long getAvgSessionDuration() {
		return avgSessionDuration;
	}
	public void setAvgSessionDuration(Long avgSessionDuration) {
		this.avgSessionDuration = avgSessionDuration;
	}
	public Integer getAvgAttendeesPerSession() {
		return avgAttendeesPerSession;
	}
	public void setAvgAttendeesPerSession(Integer avgAttendeesPerSession) {
		this.avgAttendeesPerSession = avgAttendeesPerSession;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
