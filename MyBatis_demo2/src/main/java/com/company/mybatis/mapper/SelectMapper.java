package com.company.mybatis.mapper;

import com.company.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.mapper
 * @Date 2022/4/21 9:51
 * @Version 1.0
 */
public interface SelectMapper {

    /**
     * @Description:根据id查询用户信息
     * @Author: wlb
     * @Date: 2022/4/21 10:15
     * @param id
     * @return:user
     */
    User getUserById(@Param("id") String id);

    /**
     * @Description:查询所有的用户信息
     * @Author: wlb
     * @Date: 2022/4/21 10:28
     * @param null
     * @return:
     */
    List<User> getAllUser();

    /**
     * @Description:查询用户信息的中记录数
     * @Author: wlb
     * @Date: 2022/4/21 10:34
     * @param null
     * @return:
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    int getCount();

    /**
     * @Description:查询一条数据为map集合
     * @Author: wlb
     * @Date: 2022/4/21 10:38
     * @param id
     * @return:
     */
    Map<String,Object> getUserToMap(@Param("id") String id);
    
    /**
     * @Description:查询所有用户信息为map集合
     * @Author: wlb
     * @Date: 2022/4/21 10:49
     * @param null
     * @return:
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；
     * 若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
     */
    List<Map<String,Object>> getAllUserToMap();
    
    /**
     * @Description:查询所有用户信息为map集合
     * @Author: wlb
     * @Date: 2022/4/21 10:53
     * @param null
     * @return:
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；
     * 若有多条数据，就会产生多个map集合，并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap2();
}

