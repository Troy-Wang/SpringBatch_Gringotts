package com.troywang.dal.mapper;

import com.troywang.dal.entity.BatchScheduleDo;
import com.troywang.dal.entity.BatchScheduleDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchScheduleDoMapper {
    int countByExample(BatchScheduleDoExample example);

    int deleteByExample(BatchScheduleDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BatchScheduleDo record);

    int insertSelective(BatchScheduleDo record);

    List<BatchScheduleDo> selectByExample(BatchScheduleDoExample example);

    BatchScheduleDo selectByPrimaryKey(Long id);

    List<BatchScheduleDo> selectByExampleWithPaging(BatchScheduleDoExample example);

    int updateByExampleSelective(@Param("record") BatchScheduleDo record, @Param("example") BatchScheduleDoExample example);

    int updateByExample(@Param("record") BatchScheduleDo record, @Param("example") BatchScheduleDoExample example);

    int updateByPrimaryKeySelective(BatchScheduleDo record);

    int updateByPrimaryKey(BatchScheduleDo record);

    List<BatchScheduleDo> selectByExampleForUpdate(BatchScheduleDoExample example);

    BatchScheduleDo selectByPrimaryKeyForUpdate(Long id);

    int insertBatch(List<BatchScheduleDo> record);
}