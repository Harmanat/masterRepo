package com.mdverse.master.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdverse.master.entity.MasterStatistics;

@Repository
public interface MasterStatRepo extends JpaRepository<MasterStatistics, Integer> {

}
