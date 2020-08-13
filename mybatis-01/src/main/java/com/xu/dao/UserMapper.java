package com.xu.dao;

import com.xu.pojo.User;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年08月12日 16:35:00
 */
public interface UserMapper {

    // 获取全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 添加用户
    int insertOne(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUserById(int id);
}
