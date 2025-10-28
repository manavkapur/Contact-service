package com.supremesolutions.contact.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class RedisTestController {

    private final StringRedisTemplate redisTemplate;

    public RedisTestController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/test-redis")
    public String testRedis() {
        try {
            redisTemplate.opsForValue().set("contact:test", "Hello from Contact Service!");
            String value = redisTemplate.opsForValue().get("contact:test");
            return "✅ Redis Connected (Contact Service)! Value: " + value;
        } catch (Exception e) {
            return "❌ Redis Connection Failed: " + e.getMessage();
        }
    }
}
