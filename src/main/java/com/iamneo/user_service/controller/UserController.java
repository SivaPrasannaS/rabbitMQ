package com.iamneo.user_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.user_service.dto.MessageRequest;
import com.iamneo.user_service.dto.UserRequest;
import com.iamneo.user_service.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@PostMapping("/addUserFeedback")
	public ResponseEntity<String> addUserFeedback(@RequestBody UserRequest userRequest){
		userService.addUserFeedback(userRequest);
		return ResponseEntity.status(HttpStatus.OK).body("Feedback added!");
	}
	
	@PostMapping("/publishString")
	public ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest){
		userService.sendMessage(messageRequest);
		return ResponseEntity.status(HttpStatus.OK).body("Message sent to rabbitmq successfully!");
	}
	
	@PostMapping("/publishJson")
	public ResponseEntity<String> sendJsonMessage(@RequestBody MessageRequest messageRequest){
		userService.sendJsonMessage(messageRequest);
		return ResponseEntity.status(HttpStatus.OK).body("Message sent to rabbitmq successfully!");
	}
}
