package com.avm.zoocode.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avm.zoocode.db.entity.User;
import com.avm.zoocode.db.repository.UserRepository;
import com.avm.zoocode.service.dto.UserDetailsExt;

@Service
public class UserDetailsServiceExtImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetailsExt loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
		return new UserDetailsExt(user);
	}
}
