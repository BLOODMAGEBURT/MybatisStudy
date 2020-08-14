package com.xu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MybatisUtils.java
 * @Description TODO
 * @createTime 2020年08月14日 14:23:00
 */
public class MybatisUtils {

    public static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession() {

        return sqlSessionFactory.openSession(true);
    }

}
