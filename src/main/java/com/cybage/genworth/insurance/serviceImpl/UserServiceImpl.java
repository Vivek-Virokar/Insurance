package com.cybage.genworth.insurance.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.genworth.insurance.controller.UserController;
import com.cybage.genworth.insurance.exception.LifeInsuranceException;
import com.cybage.genworth.insurance.model.User;
import com.cybage.genworth.insurance.repository.UserRepository;
import com.cybage.genworth.insurance.service.UserService;

/**
 *
 * @author Jeevan
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			//
			throw new LifeInsuranceException("You entered incorrect username.");
		} else {
			//
			if (user.getUserpwd().equals(password)) {
				//
				return user;
			}
			throw new LifeInsuranceException("You entered incorrect password.");
		}
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		logger.info("Inside UserServiceImpl class : saveUser() method" +user);
		return userRepository.save(user);
	}

	@Override
	public List<User> getListByCity(String city) {
		List<User> user = userRepository.findByCity(city);
		return user;
	}
}
