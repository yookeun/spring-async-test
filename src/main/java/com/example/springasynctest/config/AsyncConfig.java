package com.example.springasynctest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50); //기본 스레드 수
        executor.setMaxPoolSize(100); //최대 스레드 수
        executor.setQueueCapacity(200); // Queue 사이즈
        executor.setThreadNamePrefix("ASYNC-TEST");
        executor.initialize();
        return executor;
    }
}
