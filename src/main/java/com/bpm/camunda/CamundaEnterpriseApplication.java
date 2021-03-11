package com.bpm.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class CamundaEnterpriseApplication {

  public static void main(String[] args) {
    SpringApplication.run(CamundaEnterpriseApplication.class, args);
  }

}
