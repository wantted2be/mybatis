package com.company.mybatis.mapper;

import com.company.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/21 14:16
 * @Version 1.0
 */
public interface SQLMapper {
    /**
     * @Description:根据用户名模糊查询用户信息
     * @Author: wlb
     * @Date: 2022/4/21 14:18
     * @param null
     * @return:
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * @Description:批量删除
     * @Author: wlb
     * @Date: 2022/4/21 14:36
     * @param null
     * @return:
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * @Description:查询指定表中的数据，动态设置表名，只能使用${}，因为表名不能加单引号
     * @Author: wlb
     * @Date: 2022/4/21 14:48
     * @param null
     * @return:
     */
    List<User> getUserByTable(@Param("tableName") String tableName);

    /**
     * @Description:添加用户信息
     * @Author: wlb
     * @Date: 2022/4/21 15:05
     * @param null
     * @return:
     */
    int insertUser(User user);
}
