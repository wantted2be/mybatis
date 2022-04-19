package com.company.mybatis.mapper;

import com.company.mybatis.pojo.User;

import java.util.List;

/**
 * mybatis面向接口编程的两个一致
 * 1.mapper接口的全类名要和映射文件的namespace空间一致
 * 2.映射文件中sql的id要和mapper接口中的方法名一致
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 根据id查询用户信息
     * return：User
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     * return list
     */
    List<User> getAllUser();


}
