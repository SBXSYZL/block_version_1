package com.project.demo.dao;

import com.project.demo.DO.CommentDO;

public interface CommentDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    CommentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKeyWithBLOBs(CommentDO record);

    int updateByPrimaryKey(CommentDO record);
}