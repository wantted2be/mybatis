package com.company.mybatis.mapper;

import com.company.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/22 14:53
 * @Version 1.0
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
}
