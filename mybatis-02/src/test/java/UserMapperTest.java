import com.xu.dao.UserMapper;
import com.xu.pojo.User;
import com.xu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapperTest.java
 * @Description TODO
 * @createTime 2020年08月13日 15:41:00
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

    @Test
    public void testLog4j() {
        Logger logger = Logger.getLogger(this.getClass());

        logger.error("this is error msg 好了吗");
        logger.info("this is info msg");
        logger.debug("this is debug msg");
    }

    @Test
    public void testLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 15);
        List<User> userByLimit = mapper.getUserByLimit(map);

        for (User user : userByLimit) {
            System.out.println(user);
        }

        sqlSession.close();
    }


}
