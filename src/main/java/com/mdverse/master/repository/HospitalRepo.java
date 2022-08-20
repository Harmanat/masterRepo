package com.mdverse.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdverse.master.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

}
