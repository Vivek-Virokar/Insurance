package com.cybage.genworth.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.genworth.insurance.model.User;
import com.cybage.genworth.insurance.service.InsuranceTypeService;
import com.cybage.genworth.insurance.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Jeevan
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	  
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	@ApiOperation(value = "This method is used to store the user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 404, message = "not found") })
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		logger.info("Inside UserController class : createUser method" +user);
		User users = userService.saveUser(user);
		return ResponseEntity.ok().body(users);
	}

	@PostMapping("/savepolicy")
	@ApiOperation(value = "This method is used to save the policy for an user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 404, message = "not found") })
	public ResponseEntity<User> createUserPolicy(@RequestBody User user) throws Exception {
		User users = userService.saveUser(user);
		logger.info("In UserController class-->createUserPolicy() method and User is>>" +users);
		return ResponseEntity.ok().body(users);

	}

	// Design Rest API which gives the list of city user

	@GetMapping("/getcity/{city}")
	@ApiOperation(value = "This method is used to gives the list of users by city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 404, message = "not found") })
	public ResponseEntity<List<User>> getUserByCity(@PathVariable("city") String city) {
		List<User> user = userService.getListByCity(city);
		return ResponseEntity.ok().body(user);
	}

}
