package com.mdverse.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdverse.master.entity.DepartmentStatistics;

@Repository
public interface DeptStatsRepo extends JpaRepository<DepartmentStatistics, Integer>{

}
