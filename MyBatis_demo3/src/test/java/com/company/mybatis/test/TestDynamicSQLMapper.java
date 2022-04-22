package com.company.mybatis.test;

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
 * @Date 2022/4/22 10:17
 * @Version 1.0
 */
public class TestDynamicSQLMapper {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"张三",23,"男","123@qq.com");
        List<Emp> empList = dynamicSQLMapper.getEmpByCondition(emp);
        System.out.println(empList);
    }
    @Test
    public void getEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null,null,null,null,null));
        System.out.println(emps);
    }
    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{5});
        System.out.println(result);
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a",1,"男","123@321.com");
        Emp emp2 = new Emp(null,"b",1,"男","123@321.com");
        Emp emp3 = new Emp(null,"c",1,"男","123@321.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }
}
