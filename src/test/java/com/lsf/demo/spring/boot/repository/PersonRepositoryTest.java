package com.lsf.demo.spring.boot.repository;

import com.lsf.demo.spring.boot.entity.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PersonService Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test() throws Exception {

//        personRepository.save(Person.builder().name("lishenfei").address("岳阳").age(18).build());

//        List<Person> list = personRepository.findByAddress("岳阳");
//        list.forEach(System.out::println);

        Person p = personRepository.findOne(1L);
        System.out.println(p);

    }

}
