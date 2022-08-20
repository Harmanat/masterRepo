package com.mdverse.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdverse.master.entity.Master;

@Repository
public interface MasterRepo extends JpaRepository<Master, Integer> {

}
