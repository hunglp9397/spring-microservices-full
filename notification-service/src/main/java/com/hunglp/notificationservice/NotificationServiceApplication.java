package com.hunglp.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
		System.out.println("NotificationServiceApplication  started!");
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(OrderPlaceEvent orderPlaceEvent){
		log.info("Received notification for order : {}", orderPlaceEvent.getOrderNumber());
	}
}
