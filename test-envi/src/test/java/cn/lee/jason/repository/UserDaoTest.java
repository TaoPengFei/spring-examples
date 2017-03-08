package cn.lee.jason.repository;

import java.util.List;

import cn.lee.jason.entity.User;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by jason on 17-3-8.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
@ActiveProfiles("test")
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll() {
        List<User> list = (List<User>) userDao.findAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
