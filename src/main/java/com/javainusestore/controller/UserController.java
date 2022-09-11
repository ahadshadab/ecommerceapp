package com.javainusestore.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javainusestore.db.UserRepository;
import com.javainusestore.model.User;
import com.javainusestore.model.Users;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return userRepository.findAll();	
	}
	
	@GetMapping(path="/getUsers", produces = "application/json")
	public Users getUserList() {
//		return userRepository.findAll();
		Users response = new Users();
		ArrayList<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		response.setUserList(list);
        return response;
	}
	
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
	@DeleteMapping(path = { "/{id}" })
	@CrossOrigin(origins = "http://localhost:8080")
	public User deleteUser(@PathVariable("id") long id) {
		User user = userRepository.getOne(id);
		userRepository.deleteById(id);
		return user;
	}


}
