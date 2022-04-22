package com.company.mybatis.test;

import com.company.mybatis.mapper.EmpMapper;
import com.company.mybatis.pojo.Emp;
import com.company.mybatis.pojo.EmpExample;
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
 * @Date 2022/4/22 16:21
 * @Version 1.0
 */
public class TestMBG {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            //List<Emp> empList = mapper.selectByExample(null);
            //System.out.println(empList);
            //根据条件查询
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEmpNameEqualTo("张三");
            empExample.or().andAgeIsNotNull();
            List<Emp> empList = mapper.selectByExample(empExample);
            System.out.println(empList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
