package com.mdverse.master.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdverse.master.entity.MasterStatistics;
import com.mdverse.master.repository.MasterStatRepo;


@Service
public class MasterStatisticsService {
	
	private final MasterStatRepo MasterStatRepo;
	
	public MasterStatisticsService(MasterStatRepo masterStatRepo) {
		this.MasterStatRepo = masterStatRepo;
	}

	@Transactional(readOnly = true)
	public List<MasterStatistics> getAllMasterStatistics(int count) {
		return this.MasterStatRepo.findAll().stream().limit(count).collect(Collectors.toList());
	}
}
