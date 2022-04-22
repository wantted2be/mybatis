package com.company.mybatis.test;

import com.company.mybatis.mapper.DeptMapper;
import com.company.mybatis.mapper.EmpMapper;
import com.company.mybatis.pojo.Dept;
import com.company.mybatis.pojo.Emp;
import com.company.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.test
 * @Date 2022/4/21 19:25
 * @Version 1.0
 */
public class TestResultMap {
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emp = empMapper.getAllEmp();
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDept(2);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp);
    }
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建Mapper接口的代理实现类对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmp(1);
        System.out.println(dept);
    }
}
