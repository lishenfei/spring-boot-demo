package com.lsf.demo.spring.boot.controller;

import com.lsf.demo.spring.boot.entity.Person;
import com.lsf.demo.spring.boot.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lishenfei on 2016-12-07.
 */
@Api(value = "persons")
@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public Person save(@Valid @RequestBody Person person) {  // 使用@RequestBody, POST提交整个JSON字符串
        return personService.save(person);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person findOne(@ApiParam(value = "ID", required = true) @NotEmpty @PathVariable("id") Long id) {
        return personService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "ID", required = true) @NotEmpty @RequestParam("id") Long id) {
        personService.delete(id);
    }
}
