package com.company.mybatis.test;

import com.company.mybatis.mapper.ParameterMapper;
import com.company.mybatis.pojo.User;
import com.company.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/20 9:50
 * @Version 1.0
 */
public class TestParameter {
    /**
     * Mybatis获取参数的两种方式${}  #{}
     * ${}本质字符串拼接---拼接单引号并且存在sql问题
     * #{}本质是占位符赋值
     * mybati获取参数值的各种情况
     * 1.mapper接口方法的参数为单个字面量类型
     * 可以通过#{}和￥{}以任意的字符串获取参数值，但是需要注意￥{}的单引号问题
     * 2.mapper接口方法参数为多个字面量类型
     * 此时mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以arg0，arg1...为键，以参数为值
     * b>以param1，param2....为键，以参数为址
     * 3.若mapper接口的参数有多个时，可以手动将这些参数放在一个map中进行存储
     * 只要通过#{}或者${}通过键的方式访问，但是这个键是自己设置的
     * 4.如果mapper接口的方法参数是实体类类型的参数
     * 以使用\${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
     * 5.使用@Param标识参数
     * a>以@Param注解的value属性值为键，以参数为值；
     * b>以param1,param2...为键，以参数为值；
     * 通过\${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
     * 6.总结
     * 分成两种情况处理，1. 实体类类型的参数  2. 使用@Param标识参数
     */
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        //调用Mapper接口中的方法
        List<User> userList = parameterMapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "张三";
        String password = "123";
        Class.forName("");
        Connection connection = DriverManager.getConnection("","","");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where username = ? and password = ?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,"123");
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        //调用Mapper接口中的方法
        User user = parameterMapper.getUserByUsername("李四");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        //调用Mapper接口中的方法
        User user = parameterMapper.checkLogin("李四","123");
        System.out.println(user);
    }
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("username","李四");
        map.put("password","123");
        //调用Mapper接口中的方法
        User user = parameterMapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(null,"王五","123",23,"男","123@qq.com");
        //调用Mapper接口中的方法
        int count = parameterMapper.insertUser(user);
        System.out.println(count);
    }
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLoginByParam("王五","123");
        System.out.println(user);
    }
}
