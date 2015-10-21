package com.avm.zoocode.service.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
	    public Optional<UserDto> getUserByEmail(String email) {
	    	Optional<User> optional = userRepository.findUserByEmail(email);
	    	if(optional.isPresent())
	    	{
	    		return Optional.of(convert(optional.get()));
	    	}
	    	else
	        return Optional.ofNullable(null);
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
	    
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		private UserDto convert(User user) {

			UserDto dto = new UserDto();
			dto.setBirthDate(user.getBirthDate());
			dto.setCity(user.getCity());
			dto.setCountry(user.getCity());
			dto.setEmail(user.getEmail());
			dto.setStreet(user.getStreet());
			dto.setZipCode(user.getZipCode());
			Set actvity = user.getActivityLogs();
			List activityList = new ArrayList(actvity);
			dto.setActivityLog(activityList);
			return dto;
		}
}
