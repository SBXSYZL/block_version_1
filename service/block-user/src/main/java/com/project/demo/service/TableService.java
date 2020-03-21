package com.project.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 20:27
 */
@Service
public interface TableService {
    List<String> selectUserTables();

    String selectUserLastTable();
}
