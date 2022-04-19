package com.company.mybatis.test;

import com.company.mybatis.mapper.UserMapper;
import com.company.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/19 20:00
 * @Version 1.0
 */
public class TestMybatis {
    @Test
    public void testInsert() throws IOException {
        //1.加载mybatis核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //创建SqlSession对象，设置true，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int count = userMapper.insertUser();
        //7.提交事务
        //sqlSession.commit();
        //8.测试功能
        System.out.println("count:" + count);
    }

    @Test
    public void testUpdate() throws IOException {
        //1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过核心配置文件对应的字节流文件创建工厂类，生产SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.获取SqlSession对象,并设置自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用接口中的方法执行sql语句
        int count = userMapper.updateUser();
        //7.提交事务
        //8.测试功能
        System.out.println("count:"+count);
    }
    @Test
    public void testDelete() throws IOException {
        //1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过核心配置文件对应的字节流文件创建工厂类，生产SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.获取SqlSession对象,并设置自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用接口中的方法执行sql语句
        int count = userMapper.deleteUser();
        //7.提交事务
        //8.测试功能
        System.out.println("count:"+count);
    }
    @Test
    public void testGetUserById() throws IOException {
        //1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过核心配置文件对应的字节流文件创建工厂类，生产SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.获取SqlSession对象,并设置自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用接口中的方法执行sql语句
        User user = userMapper.getUserById();
        //7.提交事务
        //8.测试功能
        System.out.println(user);
    }
    @Test
    public void testGetAllUser() throws IOException {
        //1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过核心配置文件对应的字节流文件创建工厂类，生产SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.获取SqlSession对象,并设置自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用接口中的方法执行sql语句
        List<User> userList = userMapper.getAllUser();
        //7.提交事务
        //8.测试功能
        userList.forEach(user -> {
            System.out.println(user);
        });
    }

}
