package com.lsf.demo.spring.boot.redis;

import com.lsf.demo.spring.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lishenfei on 2016-12-14.
 */
@Repository
public class PersonDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOpsObj;

    public void setString(String key, String value) {
//        valOpsStr.set(key, value);
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
//        return valOpsStr.get(key);
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void savePerson(String key, Person value) {
//        valOpsObj.set(key, value);
        redisTemplate.boundHashOps("person").put(value.getName(), value);
    }

    public Person getPerson(String key, String name) {
//        return (Person) valOpsObj.get(key + "." + name);
        return (Person) redisTemplate.boundHashOps(key).get(name);
    }
}
