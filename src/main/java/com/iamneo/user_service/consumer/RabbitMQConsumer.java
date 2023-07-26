package com.iamneo.user_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.iamneo.user_service.dto.MessageRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message) {
		log.info(String.format("Received message from queue --> %s", message));
	}
	
	@RabbitListener(queues = {"${rabbitmq.json_queue.name}"})
	public void consumeJson(MessageRequest messageRequest) {
		log.info(String.format("Received message from queue --> %s", messageRequest.toString()));
	}
}
