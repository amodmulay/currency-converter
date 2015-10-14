package com.avm.zoocode.service.user;

import java.util.Collection;
import java.util.Optional;

import com.avm.zoocode.db.dto.UserDto;
import com.avm.zoocode.db.entity.User;

public interface UserService {
	Optional<User> getUserById(long id);

	Optional<User> getUserByEmail(String email);

	Collection<User> getAllUsers();

	User create(UserDto form);
}
