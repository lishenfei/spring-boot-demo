package com.lsf.demo.spring.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsf.demo.spring.boot.model.Author;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SampleController Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Transactional // 测试后的数据回滚
public class SampleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private JacksonTester<Author> json;

    @Before
    public void before() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        // Possibly configure the mapper
        JacksonTester.initFields(this, objectMapper);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: author()
     */
    @Test
    public void testAuthor() throws Exception {

        Author author = this.json.parseObject(this.restTemplate.getForObject("/authors", String.class));
        System.out.println(author);

        Author author2 = this.restTemplate.getForObject("/authors", Author.class);  // 支持直接反射成实体类
        System.out.println(author2);

        Author baseAuthor = Author.builder().name("lishenfei").email("lishenfei@foxmail.com").build();
        Assert.assertEquals(author, baseAuthor);
    }

}
