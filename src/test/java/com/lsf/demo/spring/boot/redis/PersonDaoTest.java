package com.lsf.demo.spring.boot.redis;

import com.lsf.demo.spring.boot.entity.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PersonDao Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSetString() throws Exception {
        personDao.setString("abc", "123456");
    }

    @Test
    public void testGetString() throws Exception {
        System.out.println(personDao.getString("abc"));
    }

    @Test
    public void testSetPerson() throws Exception {
        personDao.savePerson("person", Person.builder().name("wmm").age(18).address("湖南长沙").build());
    }

    @Test
    public void testGetPerson() throws Exception {
        System.out.println(personDao.getPerson("person", "wmm"));
    }
}
