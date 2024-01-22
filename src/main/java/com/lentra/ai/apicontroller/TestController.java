package com.lentra.ai.apicontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lentra.ai.entities.UserModel;
import com.lentra.ai.repository.UserRepository;

@RestController
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/test")
	  String testApi() {
		log.info("Invoking test API!");
	    return "Hello";
	}
	
//	@GetMapping("/users")
//    public ResponseEntity<List<UserModel>> getAllUsers(){
//		log.info("Fetching all users");
//		List<UserModel> users = userRepo.findAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
	
	@PostMapping("/users")
	public ResponseEntity<?> createUser(
			@RequestBody UserModel user) {
		log.info("Creating user with details: {}", user);
		return ResponseEntity.ok(userRepo.save(user));
	}
}
