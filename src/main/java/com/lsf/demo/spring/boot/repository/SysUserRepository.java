package com.lsf.demo.spring.boot.repository;

import com.lsf.demo.spring.boot.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lishenfei on 2016-12-15.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

}
