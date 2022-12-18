package com.example.springasynctest.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final AsyncSerivce asyncSerivce;

    public void callNormalAndAsync1() {
        normalMethod1();
        asyncMethod1();
    }

    public void normalMethod1() {
        log.info("[NORMAL] normalMethod1 Called!");
    }

    @Async
    public void asyncMethod1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("[ASYNC] asyncMethod1");
    }

    public void callNormalAndAsync2() {
        normalMethod1();
        asyncSerivce.asyncMethod2();
    }

}

