package com.pillopl.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jakub Pilimon
 */
@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class MessagingApplication {

    public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

}

