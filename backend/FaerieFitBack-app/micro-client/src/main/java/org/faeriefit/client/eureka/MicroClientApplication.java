package org.faeriefit.client.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroClientApplication.class, args);
    }

}
