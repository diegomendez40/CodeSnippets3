package com.diegom40.flamencowitches.jobsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JobsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobsiteApplication.class, args);
    }

}
