package com.project.demo.service.Impl;

import com.project.demo.dao.TablesMapper;

import com.project.demo.service.TableService;
import com.project.demo.utils.MyLog;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 20:27
 */
@Service
public class TableServiceImpl implements TableService {
    private final TablesMapper tablesMapper;

    public TableServiceImpl(TablesMapper tablesMapper) {
        this.tablesMapper = tablesMapper;
    }

    @Override
    @Cacheable(value = "Tables#3600", key = "'userTables'")
    public List<String> selectUserTables() {
//        Cache userTablesCache = redisCacheManager.getCache("tables");
//
//        assert userTablesCache != null;
//        Cache.ValueWrapper cacheWrapper = userTablesCache.get("userTables");
//        List<String> userTables;
//        if (cacheWrapper != null) {
//            userTables = (List<String>) cacheWrapper.get();
//        } else {
//            userTables = tablesMapper.selectTables("user");
//            if (userTables != null) {
//                userTablesCache.putIfAbsent("userTables", userTables);
////                redisTemplate.opsForValue().set("userTables", userTables, 3600, TimeUnit.SECONDS);
//            }
//        }
//        return userTables;
        return tablesMapper.selectTables("user");


    }

    @Override
    @Cacheable(value = "Tables#3600", key = "'userLastTable'")
    public String selectUserLastTable() {
        return tablesMapper.selectLastTable("user");
    }
}
