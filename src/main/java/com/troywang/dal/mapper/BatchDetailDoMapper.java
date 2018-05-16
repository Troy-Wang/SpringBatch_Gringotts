package com.troywang.dal.mapper;

import com.troywang.dal.entity.BatchDetailDo;
import com.troywang.dal.entity.BatchDetailDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchDetailDoMapper {
    int countByExample(BatchDetailDoExample example);

    int deleteByExample(BatchDetailDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BatchDetailDo record);

    int insertSelective(BatchDetailDo record);

    List<BatchDetailDo> selectByExample(BatchDetailDoExample example);

    BatchDetailDo selectByPrimaryKey(Long id);

    List<BatchDetailDo> selectByExampleWithPaging(BatchDetailDoExample example);

    int updateByExampleSelective(@Param("record") BatchDetailDo record, @Param("example") BatchDetailDoExample example);

    int updateByExample(@Param("record") BatchDetailDo record, @Param("example") BatchDetailDoExample example);

    int updateByPrimaryKeySelective(BatchDetailDo record);

    int updateByPrimaryKey(BatchDetailDo record);

    List<BatchDetailDo> selectByExampleForUpdate(BatchDetailDoExample example);

    BatchDetailDo selectByPrimaryKeyForUpdate(Long id);

    int insertBatch(List<BatchDetailDo> record);
}