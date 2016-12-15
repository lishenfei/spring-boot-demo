package com.lsf.demo.spring.boot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lishenfei on 2016-12-15.
 */
@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
