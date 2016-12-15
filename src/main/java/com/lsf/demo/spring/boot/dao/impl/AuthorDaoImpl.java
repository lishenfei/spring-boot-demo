package com.lsf.demo.spring.boot.dao.impl;

import com.lsf.demo.spring.boot.dao.AuthorDao;
import org.springframework.stereotype.Repository;

/**
 * Created by lishenfei on 2016-12-09.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void printf() {
        System.out.println("---->jdbcTemplate:" + jdbcTemplate);

        String sql = "select user_name from user_info limit 10";
        List<Author> list = jdbcTemplate.query(sql, (resultSet, i) -> Author.builder().name(resultSet.getString("user_name")).build());

        list.forEach(System.out::println);
    }*/
}
