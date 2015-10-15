package com.avm.zoocode.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avm.zoocode.db.entity.User;
import com.avm.zoocode.db.repository.UserRepository;
import com.avm.zoocode.service.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	 	@Autowired
		private UserRepository userRepository;

	    @Override
	    public Optional<User> getUserById(long id) {
	        return Optional.ofNullable(userRepository.findOne(id));
	    }

	    @Override
	    public Optional<User> getUserByEmail(String email) {
	        return userRepository.findUserByEmail(email);
	    }

	    @Override
	    public Collection<User> getAllUsers() {
	        return userRepository.findAll(new Sort("email"));
	    }

	    @Override
	    public User create(UserDto userDto) {
	        User user = new User();
	        user.setEmail(userDto.getEmail());
	        user.setPasswordHash(new BCryptPasswordEncoder().encode(userDto.getPassword()));
	        user.setBirthDate(userDto.getBirthDate());
	        user.setStreet(userDto.getStreet());
	        user.setCity(userDto.getCity());
	        user.setZipCode(userDto.getZipCode());
	        user.setCountry(userDto.getCountry());
	        
	        return userRepository.save(user);
	    }
}
