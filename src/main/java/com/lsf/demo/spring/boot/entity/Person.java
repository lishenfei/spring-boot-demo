package com.lsf.demo.spring.boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lishenfei on 2016-12-14.
 */
@ApiModel(value = "Person", description = "Person")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
//@NamedQuery(name = "Person.findByName",
//        query = "select p from Person p where p.name = ?1")
public class Person implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Length(max = 20)
    private String name;

    @NotEmpty
    @Length(max = 200)
    private String address;

    @NotNull
    private Integer age;

    @JsonIgnore
    @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;
}
