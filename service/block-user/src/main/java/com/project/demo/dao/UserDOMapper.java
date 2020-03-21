package com.project.demo.dao;

import com.project.demo.DO.UserDO;
import com.project.demo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO selectByEmail(@Param("email") String email, @Param("tables") List<String> tables);

    int registered(@Param("name") String name, @Param("email") String email, @Param("password") String password, @Param("table") String table);

    UserVO selectInfoByEmail(@Param("email") String email, @Param("tables") List<String> tables);

}