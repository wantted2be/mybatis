package com.company.mybatis.mapper;

import com.company.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/20 9:43
 * @Version 1.0
 */
public interface ParameterMapper {
    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username,String password);

    /**
     * 验证登录（参数map）
     */
    User checkLoginByMap(Map<String,String> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录使用@param注解
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
