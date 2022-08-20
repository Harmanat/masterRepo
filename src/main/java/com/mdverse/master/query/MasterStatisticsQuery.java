package com.mdverse.master.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mdverse.master.entity.MasterStatistics;
import com.mdverse.master.service.MasterStatisticsService;

@Component
public class MasterStatisticsQuery implements GraphQLQueryResolver{
	
	@Autowired
	private MasterStatisticsService MasterStatisticsService;
    
    public List<MasterStatistics> getMasterstatistics(final int count) {
    	java.lang.System.out.println("Running getMasterStatistcs.....");
    	return this.MasterStatisticsService.getAllMasterStatistics(count);
    }
}
