package com.company.mybatis.mapper;

import com.company.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/22 10:06
 * @Version 1.0
 */
public interface DynamicSQLMapper {
    /**
     * 实现多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);
    /**
     * getEmpByChoose
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组批量删除使用循环
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过集合实现批量添加
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
