package com.company.mybatis.test;

import com.company.mybatis.mapper.SQLMapper;
import com.company.mybatis.pojo.User;
import com.company.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/21 14:21
 * @Version 1.0
 */
public class TestSQLMapper {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByLike("张");
        System.out.println(userList);
    }
    @Test
    public void testDeleteMore(){
        /**
         * @Description:只能使用\${}.
         * 如果使用#{}，则解析后的sql语句为delete from t_user where id in ('1,2,3')，这样是将`1,2,3`看做是一个整体，只有id为`1,2,3`的数据会被删除。
         * 正确的语句应该是`delete from t_user where id in (1,2,3)`，或者`delete from t_user where id in ('1','2','3')`
         * @Author: wlb
         * @Date: 2022/4/21 14:44
         * @param
         * @return:void
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int count = mapper.deleteMore("2,3,5,6");
        System.out.println(count);
    }
    @Test
    public void testGetUserByTable(){
        /**
         * @Description:只能使用${}，因为表名不能加单引号
         * @Author: wlb
         * @Date: 2022/4/21 14:52
         * @param
         * @return:void
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByTable("t_user");
        System.out.println(userList);
    }
    @Test
    public void testInsertUser(){
        /**
         * @Description:
         * @Author: wlb
         * @Date: 2022/4/21 15:48
         * @param
         * @return:void
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"孙七","123",23,"男","123@qq.com");
        int count = mapper.insertUser(user);
        System.out.println(count);
        System.out.println(user);
    }
}
