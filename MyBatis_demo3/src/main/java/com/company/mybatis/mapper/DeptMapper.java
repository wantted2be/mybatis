package com.company.mybatis.mapper;

import com.company.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/21 16:31
 * @Version 1.0
 */
public interface DeptMapper {
    //DeptMapper里的方法
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     * @param
     * @return com.atguigu.mybatis.pojo.Emp
     * @date 2022/2/27 20:23
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 部门以及部门中所有的员工信息
     */
    Dept getDeptAndEmp(@Param("id")Integer id);

    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
