package com.avm.zoocode.db.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.avm.zoocode.AbstractZooCodApplicationTest;
import com.avm.zoocode.db.entity.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest extends AbstractZooCodApplicationTest {

	@Autowired
	UserRepository userRepository;
	
	@Test()
	public void testUser1()
	{
		User user = new User();
        user.setEmail("test@test.com");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("secure"));
        user.setBirthDate(new Date());
        user.setStreet("Leopoldstr. 1");
        user.setCity("München");
        user.setZipCode("81175");
        user.setCountry("DE");
		userRepository.save(user);
		assertNotNull(userRepository.findUserByEmail("test@test.com").get());
	}
	@Test(expected=JpaSystemException.class)
	public void testUser2()
	{
		User user = new User();	
        user.setEmail("test@test.com");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("secure"));
        user.setBirthDate(new Date());
        user.setStreet("Leopoldstr. 2");
        user.setCity("München");
        user.setZipCode("81175");
        user.setCountry("DE");
		userRepository.save(user);
	}
	
	@Test
	public void testUser3()
	{
		//test find users
		userRepository.findUserByEmail("test@test.com");
		assertEquals("test@test.com", userRepository.findUserByEmail("test@test.com").get().getEmail());
	}
	
	
}
