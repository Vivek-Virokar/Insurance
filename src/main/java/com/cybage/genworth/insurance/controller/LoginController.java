package com.cybage.genworth.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.genworth.insurance.model.User;
import com.cybage.genworth.insurance.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Jeevan
 */
@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	/*
	 * This method is used to login the user to the insurance system.
	 */

	@PostMapping("/login")
	@ApiOperation(value = "This method is used to login the user to the insurance system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 404, message = "not found") })
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		String username = user.getUsername();
		String password = user.getUserpwd();
		user = userService.loginUser(username, password);
		return ResponseEntity.ok().body(user);

	}

}
