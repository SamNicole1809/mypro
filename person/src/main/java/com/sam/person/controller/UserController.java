package com.sam.person.controller;


import com.sam.lib.utils.MongoUtils;
import com.sam.lib.utils.RedisUtils;
import com.sam.lib.utils.StringUtils;
import com.sam.lib.utils.TestUtils;
import com.sam.person.entity.Do.User;
import com.sam.person.service.impl.UserServiceImpl;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sam
 * @since 2020-01-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final TestUtils testUtils;
    private final UserServiceImpl userService;
    private final RedisUtils redisUtils;
    private final MongoUtils mongoUtils;

    public UserController(TestUtils testUtils, UserServiceImpl userService, RedisUtils redisUtils, MongoUtils mongoUtils) {
        this.testUtils = testUtils;
        this.userService = userService;
        this.redisUtils = redisUtils;
        this.mongoUtils = mongoUtils;
    }

    @GetMapping("/get")
    public String getUser() {
        return StringUtils.getResult(testUtils.setLabel("User"));
    }

    @GetMapping("/mysql")
    public String setMysql() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("sam");
        user.setAge(31);
        user.setPassword("123456");
        boolean flag = userService.save(user);
        if (flag) {
            return user.toString();
        }
        return "Save user error";
    }

    @GetMapping("/redis")
    public String setRedis() {
        redisUtils.vSet("name", "person");
        String name = redisUtils.vGet("name").toString();
        return "Redis write success, name is " + name;
    }

    @GetMapping("/mongo")
    public String setMongo() {
        Document doc = new Document();
        String mid = UUID.randomUUID().toString();
        doc.put("mid", mid);
        doc.put("name", "device");
        mongoUtils.insertOne("device", doc);
        Document query = new Document();
        query.put("mid", mid);
        Document result = mongoUtils.findOne("device", query);
        return "Mongo write success, result is " + result.toString();
    }
}

