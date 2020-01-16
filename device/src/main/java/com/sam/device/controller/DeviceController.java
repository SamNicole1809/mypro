package com.sam.device.controller;


import com.sam.device.entity.Do.Device;
import com.sam.device.service.grpc.DeviceGrpcService;
import com.sam.device.service.impl.DeviceServiceImpl;
import com.sam.lib.utils.MongoUtils;
import com.sam.lib.utils.RedisUtils;
import com.sam.lib.utils.StringUtils;
import com.sam.lib.utils.TestUtils;
import org.bson.Document;
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
@RequestMapping("/device")
public class DeviceController {

    private final TestUtils testUtils;
    private final DeviceServiceImpl deviceService;
    private final RedisUtils redisUtils;
    private final MongoUtils mongoUtils;
    private final DeviceGrpcService deviceGrpcService;

    public DeviceController(TestUtils testUtils, DeviceServiceImpl deviceService, RedisUtils redisUtils, MongoUtils mongoUtils, DeviceGrpcService deviceGrpcService) {
        this.testUtils = testUtils;
        this.deviceService = deviceService;
        this.redisUtils = redisUtils;
        this.mongoUtils = mongoUtils;
        this.deviceGrpcService = deviceGrpcService;
    }

    @GetMapping("/get")
    public String getDevice() {
        return StringUtils.getResult(testUtils.setLabel("Device"));
    }

    @GetMapping("/mysql")
    public String setMysql() {
        Device device = new Device();
        device.setId(UUID.randomUUID().toString());
        device.setCode("123456");
        device.setName("device-dev");
        boolean flag = deviceService.save(device);
        if (flag) {
            return device.toString();
        }
        return "Save device error";
    }

    @GetMapping("/redis")
    public String setRedis() {
        redisUtils.vSet("name", "device");
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

    @GetMapping("/grpc")
    public String setGrpc() {
        String result = deviceGrpcService.getUser("device");
        if ("".equals(result)) {
            return "Result is blank";
        }
        return result;
    }
}

