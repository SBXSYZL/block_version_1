package com.project.demo.dao;

import com.project.demo.DO.BlockDO;

public interface BlockDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlockDO record);

    int insertSelective(BlockDO record);

    BlockDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlockDO record);

    int updateByPrimaryKeyWithBLOBs(BlockDO record);

    int updateByPrimaryKey(BlockDO record);
}