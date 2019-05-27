package com.zyjg.adtech.bigscreen.mapper;

import com.zyjg.adtech.bigscreen.entity.Iosptxfdd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface IosptxfddMapper {

    int deleteByPrimaryKey(String id);

    int insert(Iosptxfdd record);

    int insertSelective(Iosptxfdd record);


    Iosptxfdd selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(Iosptxfdd record);

    int updateByPrimaryKey(Iosptxfdd record);

	List<Iosptxfdd> iosPtxfddlimit(Map<String, Object> map);

	int iosPtxfddlimitCount(Map<String, Object> map);

	Iosptxfdd getPtxfddInfo(String id);

	List<Iosptxfdd> getPtxfddInfoByYhid(@Param("userId") String userId, @Param("packageName") String packageName);

	List<Iosptxfdd> getPtxfddInfoByZt(@Param("zt") String zt, @Param("lx") String lx);

	List<Iosptxfdd> getPtxfddInfoByZtAndYhid(@Param("zt") String zt, @Param("ids") String ids, @Param("lx") String lx);

	void delete(String yhid);

	List<Iosptxfdd> getPtxfddByZt(Map<String, Object> ptxfddMap);

	List<Iosptxfdd> getPtxfddByZtTwo(Map<String, Object> ptxfddMap);

	List<Iosptxfdd> getSetupScrollLabelInfo(Map<String, Object> map);
}