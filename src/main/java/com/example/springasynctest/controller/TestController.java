package com.example.springasynctest.controller;

import com.example.springasynctest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test/async1")
    public void async1() {
        log.info("========= async1 start ==========");
        testService.callNormalAndAsync1();
        log.info("========= async1 end ==========");
    }

    @GetMapping("/test/async2")
    public void async2() {
        log.info("========= async2 start ==========");
        testService.normalMethod1();
        testService.asyncMethod1();
        log.info("========= async2 end ==========");
    }

    @GetMapping("/test/async3")
    public void async3() {
        log.info("========= async3 start ==========");
        testService.callNormalAndAsync2();
        log.info("========= async3 end ==========");
    }
}

