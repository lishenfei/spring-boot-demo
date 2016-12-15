package com.lsf.demo.spring.boot.service.impl;

import com.lsf.demo.spring.boot.entity.Person;
import com.lsf.demo.spring.boot.repository.PersonRepository;
import com.lsf.demo.spring.boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by lishenfei on 2016-12-14.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @CachePut(value = "person", key = "#person.id")
    @Override
    public Person save(Person person) {
        System.out.println(person);
        return personRepository.save(person);
    }

    @Cacheable(value = "person", key = "#id")
    @Override
    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }

    @CacheEvict(value = "person", key = "#id")
    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }


}
