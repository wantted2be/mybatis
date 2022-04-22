package com.company.mybatis.test;

import com.company.mybatis.mapper.CacheMapper;
import com.company.mybatis.mapper.DynamicSQLMapper;
import com.company.mybatis.pojo.Emp;
import com.company.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/22 14:54
 * @Version 1.0
 */
public class TestCacheMapper {
    @Test
    public void testGetEmpByEid(){
        /**
         * 一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问
         *
         * 使一级缓存失效的四种情况：
         * 1.不同的SqlSession对应不同的一级缓存
         * 2.同一个SqlSession但是查询条件不同
         * 3.同一个SqlSession两次查询期间执行了任何一次增删改操作
         * 4.同一个SqlSession两次查询期间手动清空了缓存
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpByEid(8);
        System.out.println(emp);
        Emp emp2 = mapper.getEmpByEid(8);//注意没有执行sql语句
        System.out.println(emp2);
    }
}
