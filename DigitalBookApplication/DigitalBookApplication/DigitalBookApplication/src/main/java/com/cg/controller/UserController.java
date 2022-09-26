package com.cg.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.User;
import com.cg.services.AuthorService;

@RestController
@CrossOrigin 
@RequestMapping("/books")
public class UserController {

	 private AuthorService authorservice;

	 public UserController(AuthorService authorservice) {
	        this.authorservice = authorservice;
	    }
	
	@PostMapping("/login")
	public User userLogin(@RequestBody User userdata){
		authorservice.userlogin(userdata);
		return userdata;
	}
	
    @PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	 public Integer register(@Valid @RequestBody User user) {
		authorservice.register(user);
		return user.getId(); 
	}  
	
	@GetMapping("/user")
	public
	Iterable<User> getUsers() {
		return authorservice.getUsers();
	}
	
	@GetMapping("/user/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username){
        return authorservice.getUserByUsername(username);
    }
	
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable("id") Integer id) {
		authorservice.deleteUser(id);
	}
}