package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing  //데이터가 생성 또는 수정되는 것을 감지하는 리스너 활성화
@SpringBootApplication
public class Project31Application {

	public static void main(String[] args) {
		SpringApplication.run(Project31Application.class, args);
	}

}
