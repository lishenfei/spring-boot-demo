package com.lsf.demo.spring.boot.service;

import com.lsf.demo.spring.boot.entity.Person;

/**
 * Created by lishenfei on 2016-12-14.
 */
public interface PersonService {
    Person save(Person person);

    Person findOne(Long id);

    void delete(Long id);
}
