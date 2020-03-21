package com.project.demo.dao;


import com.project.demo.DO.ViewRecordDO;

public interface ViewRecordDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ViewRecordDO record);

    int insertSelective(ViewRecordDO record);

    ViewRecordDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewRecordDO record);

    int updateByPrimaryKey(ViewRecordDO record);
}