package com.company.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.utils
 * @Date 2022/4/20 9:59
 * @Version 1.0
 */
public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            //1.通过Resources读取mybatis核心配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2.获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //3.通过SqlSessionFactoryBuilder的builder方法传入字节流inputStream构建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            //4.通过SqlSession的openSession方法开启sqlSession对象，设置自动提交
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
