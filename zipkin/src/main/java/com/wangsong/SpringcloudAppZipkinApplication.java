package com.wangsong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer //启动ZipkinServer段
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudAppZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAppZipkinApplication.class, args);
    }

    @Primary
    @Bean
    public TaskExecutor primaryTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
    }