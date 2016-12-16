package com.lsf.demo.spring.boot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by lishenfei on 2016-12-15.
 */
@Entity
@Data
public class People {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT")
    private Long id;

    @Size(max = 4, min = 2)
    private String name;

    private int age;

    private String nation;

    private String address;

}
