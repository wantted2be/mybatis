package com.company.mybatis.mapper;

import com.company.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/21 16:31
 * @Version 1.0
 */
public interface EmpMapper {
    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();
    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid")Integer eid);
    //EmpMapper里的方法
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第一步：查询员工信息
     * @param
     * @return com.atguigu.mybatis.pojo.Emp
     * @date 2022/2/27 20:17
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第一步：查询部门信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
