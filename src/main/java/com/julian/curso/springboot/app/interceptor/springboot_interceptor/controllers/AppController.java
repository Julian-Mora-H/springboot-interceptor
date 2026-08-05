package com.julian.curso.springboot.app.interceptor.springboot_interceptor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/time_foo")
    public Map<String, String> time_foo() {
        return Collections.singletonMap("message", "handler time_foo del controlador");
    }
    
    @GetMapping("/bar")
    public Map<String, String> bar() {
        return Collections.singletonMap("message", "handler bar del controlador");
    }

    @GetMapping("/vaz")
    public Map<String, String> vaz() {
        return Collections.singletonMap("message", "handler vaz del controlador");
    }
}
