package com.muti.embedded.redis.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * User Application
 *
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
@SpringBootApplication
public class Application {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        applicationContext = SpringApplication.run(Application.class, args);
    }
}