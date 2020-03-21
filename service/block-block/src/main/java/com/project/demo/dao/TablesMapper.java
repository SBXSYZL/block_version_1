package com.project.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TablesMapper {

    List<String> selectTables(@Param("prefix") String prefix);

    String selectLastTable(@Param("prefix") String prefix);
}
