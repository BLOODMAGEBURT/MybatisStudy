package com.xu.dao;

import com.xu.pojo.User;
import com.xu.utils.MybatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapperTest.java
 * @Description TODO
 * @createTime 2020年08月12日 16:48:00
 */
public class UserMapperTest {

    @Test
    public void testUserMapper() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testSelectId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);

        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void testInsertOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.insertOne(new User(4, "xiaobo", "1235455"));

        //增删改 需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(5, "wangxi", "11111111"));


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserById(5);

        sqlSession.commit();
        sqlSession.close();
    }

}
