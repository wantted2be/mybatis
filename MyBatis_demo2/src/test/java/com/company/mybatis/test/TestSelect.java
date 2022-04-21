package com.company.mybatis.test;

import com.company.mybatis.mapper.SelectMapper;
import com.company.mybatis.pojo.User;
import com.company.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import java.util.Map;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/21 10:18
 * @Version 1.0
 */
public class TestSelect {
    /**
     * @Description:mybatis的各种查询功能
     * 1.若查询出的数据只有一条，可以通过实体类对象或者集合接收
     * 2.若查询数据有多条，一定不能通过实体类对象接收，只能以集合来接收，此时会抛异常TooManyResult
     * 3.
     * @Author: wlb
     * @Date: 2022/4/21 10:23
     * @param
     * @return:void
     */
    @Test
    public void testGetUserById(){
        /**
         * @Description:测试GetUserById()方法
         * @Author: wlb
         * @Date: 2022/4/21 10:18
         * @param
         * @return:void
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById("2");
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        /**
         * @Description:
         * @Author: wlb
         * @Date: 2022/4/21 10:30
         * @param
         * @return:void
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = selectMapper.getAllUser();
        System.out.println(userList);
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testGetUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = selectMapper.getUserToMap("2");
        System.out.println(map);
    }
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String,Object>> mapList = selectMapper.getAllUserToMap();
        System.out.println(mapList);
    }
    @Test
    public void testGetAllUserToMap2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = selectMapper.getAllUserToMap2();
        System.out.println(map);
    }
}
