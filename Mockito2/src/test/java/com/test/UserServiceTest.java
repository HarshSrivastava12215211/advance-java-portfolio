package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.User;
import mockito.UserDao;
import mockito.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	UserDao ud;
	
	@InjectMocks
	UserService service;
	
	@Test
	public void typeOfUser() {
		// step 1 :  create mock object 
		///UserDao ud = mock(UserDao.class) ;
		
		// step 2 : // create fake object 
		
		User fake = new User() ;  // fake object we are creating
		fake.setBalance(2000);
		fake.setId(1);
		fake.setName("Allen");
		when(ud.findById(1)).thenReturn(fake) ;  // create fake object and simply return it
		//Injecting mock Object
		//UserService service = new UserService(ud);   
		String ans = service.typeOfUser(1) ;
		assertEquals("regular User",ans) ;
	}

	
}
