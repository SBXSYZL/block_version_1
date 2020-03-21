package com.project.demo.dao;

import com.project.demo.DO.BlockTypeDO;

public interface BlockTypeDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlockTypeDO record);

    int insertSelective(BlockTypeDO record);

    BlockTypeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlockTypeDO record);

    int updateByPrimaryKey(BlockTypeDO record);
}