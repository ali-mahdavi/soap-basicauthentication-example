package com.haytech.wsbasicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.haytech.wsbasicauth")
public class SpringWsBasicAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWsBasicAuthenticationApplication.class, args);
    }

}
