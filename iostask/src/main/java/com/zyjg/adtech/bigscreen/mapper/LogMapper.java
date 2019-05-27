package com.zyjg.adtech.bigscreen.mapper;

import com.zyjg.adtech.bigscreen.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface LogMapper {

	void insert(Log log);

	List<Log> loglimit(Map<String, Object> map);

	int loglimitCount(Map<String, Object> map);

	Log getLogInfo(String id);
	
}