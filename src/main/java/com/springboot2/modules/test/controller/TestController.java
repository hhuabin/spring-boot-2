package com.springboot2.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hhuabin
 * @date 2026-10-09 17:00
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String handle() {
        return "Hello World";
    }
}
