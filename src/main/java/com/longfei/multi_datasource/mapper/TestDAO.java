package com.longfei.multi_datasource.mapper;

import com.longfei.multi_datasource.entity.Test;
import com.longfei.multi_datasource.entity.TestExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * TestDAO继承基类
 */
@Mapper
@Repository
public interface TestDAO extends MyBatisBaseDao<Test, Integer, TestExample> {
}