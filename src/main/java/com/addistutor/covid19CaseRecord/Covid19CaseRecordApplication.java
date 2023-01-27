package com.addistutor.covid19CaseRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19CaseRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19CaseRecordApplication.class, args);
	}

}
