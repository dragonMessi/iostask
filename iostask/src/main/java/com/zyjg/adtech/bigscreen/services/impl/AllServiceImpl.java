package com.zyjg.adtech.bigscreen.services.impl;


import com.zyjg.adtech.bigscreen.entity.Iosptxfdd;
import com.zyjg.adtech.bigscreen.entity.Log;
import com.zyjg.adtech.bigscreen.mapper.IosptxfddMapper;
import com.zyjg.adtech.bigscreen.mapper.LogMapper;
import com.zyjg.adtech.bigscreen.services.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AllServiceImpl implements AllService {

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private IosptxfddMapper ptxfddpMapper;


    public List<Iosptxfdd> getPtxfddInfoByZt(String zt, String lx) {
        return ptxfddpMapper.getPtxfddInfoByZt(zt, lx);
    }


    public void insetLog(Log log) {
        logMapper.insert(log);

    }

    public void updatePtxxdd(Iosptxfdd pt) throws Exception {
        int result = ptxfddpMapper.updateByPrimaryKeySelective(pt);
    }


}
