package com.zyjg.adtech.bigscreen.services;

import com.zyjg.adtech.bigscreen.entity.Iosptxfdd;
import com.zyjg.adtech.bigscreen.entity.Log;

import java.util.List;


public interface AllService {


	List<Iosptxfdd> getPtxfddInfoByZt(String string, String lx);
	void insetLog(Log log);
	void updatePtxxdd(Iosptxfdd pt) throws Exception;


}
