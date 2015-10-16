package com.avm.zoocode.service.user;

import java.util.Collection;
import java.util.Optional;

import com.avm.zoocode.db.entity.User;
import com.avm.zoocode.service.dto.UserDto;

public interface UserService {
	Optional<User> getUserById(Integer id);

	Optional<User> getUserByEmail(String email);

	Collection<User> getAllUsers();

	User create(UserDto form);
}
