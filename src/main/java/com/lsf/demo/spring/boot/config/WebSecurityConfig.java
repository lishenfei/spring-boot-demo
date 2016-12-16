package com.lsf.demo.spring.boot.config;

import com.lsf.demo.spring.boot.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by lishenfei on 2016-12-15.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN角色可访问
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")  // ADMIN或USER可访问
                .anyRequest().permitAll()
//                .anyRequest().authenticated()   // 其他所有请求需要登录后访问
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll() // 定制登录行为
                .and()
                .logout().permitAll();
    }
}
