package com.cg.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.cg.controller.UserController;
import com.cg.model.User;
import com.cg.service.impl.AuthorServiceImpl;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class TestUserController {
	
	@Autowired
    private MockMvc mockMvc;

	@InjectMocks
	UserController usercontroller;
	
	@MockBean
	AuthorServiceImpl service;
	
	 @Test
	void testRegister() {
		User user = new User();
		user.setId(1);
		user.setMobilenumber(123456);
		user.setPassword("susi");
		user.setUsername("susi");
		user.setEmail("susi");
		Mockito.when(service.register(user)).thenReturn(user);// mocking
		Integer registeredId = usercontroller.register(user);
		assertEquals(1, registeredId);
	} 
	 
	 	@Test
	    void testUserLogin()  throws Exception{
	   	
			User user = new User();
			user.setUsername("admin");
			user.setPassword("admin");
			usercontroller.userLogin(user);
	       service.userlogin(user);
	       /* ResultActions response = mockMvc.perform(post("/login")).andExpect(status().isOk());
	       response.andExpect(status().isOk())
	               .andDo(print());  */
	   }	 
	 	
	 	
	 	@Test
	     void testGetUsers() throws Exception {
	        List<User> user = new ArrayList<>();
	        User users = new User();
			users.setId(1);
			users.setMobilenumber(123456);
			users.setPassword("susi");
			users.setUsername("susi");
			users.setEmail("susi");
	        user.add(users);
	        Mockito.when(service.getUsers()).thenReturn(user);
	        mockMvc.perform(get("/books/user")).andExpect(status().isOk());
	        Iterable<User> getusers = usercontroller.getUsers();
	        assertEquals(user, getusers);
	        
	    }
	 	
	 	@Test
	     void testgetUserByUsername()  throws Exception{
	    	
	        Optional<User> users = Optional.of(new User());
	        Mockito.when(service.getUserByUsername("admin")).thenReturn(users);
	        mockMvc.perform(get("/books")).andExpect(status().isOk());
	        Optional<User> username = usercontroller.getUserByUsername("admin");
	        assertEquals(users,username);
	    } 
	 	
		@Test
	     void testdeleteUser()  throws Exception{
			int id = 1;
	        service.deleteUser(id);
	        ResultActions response = mockMvc.perform(delete("/books/user/{id}",id)).andExpect(status().isOk());
	        response.andExpect(status().isOk())
	                .andDo(print());
	    }
}
