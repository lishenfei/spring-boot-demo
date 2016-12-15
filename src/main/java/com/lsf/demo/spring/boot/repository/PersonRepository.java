package com.lsf.demo.spring.boot.repository;

import com.lsf.demo.spring.boot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lishenfei on 2016-12-14.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * 使用了Person类中定义的@NamedQuery查询
     *
     * @param name
     * @return
     */
    List<Person> findByName(String name);

//    @Query("select p from Person p where p.address = ?1")  // 遵循命名规范，可省略SQL，框架自动生成
    List<Person> findByAddress(String address);

    @Query("select p from Person p where p.address = :create_time")
    List<Person> findByCreateTimeAfter(@Param("create_time") Date createTime);

    @Transactional
    @Modifying
    @Query("update Person p set p.name = ?1 where p.id = ?2")
    int setName(String name, String id);
}
