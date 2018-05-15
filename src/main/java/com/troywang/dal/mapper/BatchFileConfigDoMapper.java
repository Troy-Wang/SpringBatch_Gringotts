package com.troywang.dal.mapper;

import com.troywang.dal.entity.BatchFileConfigDo;
import com.troywang.dal.entity.BatchFileConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchFileConfigDoMapper {
    int countByExample(BatchFileConfigDoExample example);

    int deleteByExample(BatchFileConfigDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BatchFileConfigDo record);

    int insertSelective(BatchFileConfigDo record);

    List<BatchFileConfigDo> selectByExample(BatchFileConfigDoExample example);

    BatchFileConfigDo selectByPrimaryKey(Long id);

    List<BatchFileConfigDo> selectByExampleWithPaging(BatchFileConfigDoExample example);

    int updateByExampleSelective(@Param("record") BatchFileConfigDo record, @Param("example") BatchFileConfigDoExample example);

    int updateByExample(@Param("record") BatchFileConfigDo record, @Param("example") BatchFileConfigDoExample example);

    int updateByPrimaryKeySelective(BatchFileConfigDo record);

    int updateByPrimaryKey(BatchFileConfigDo record);

    List<BatchFileConfigDo> selectByExampleForUpdate(BatchFileConfigDoExample example);

    BatchFileConfigDo selectByPrimaryKeyForUpdate(Long id);

    int insertBatch(List<BatchFileConfigDo> record);
}