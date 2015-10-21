package com.avm.zoocode.service.user;

import java.util.Optional;

import com.avm.zoocode.db.entity.User;
import com.avm.zoocode.service.dto.UserDto;

public interface UserService {

	Optional<UserDto> getUserByEmail(String email);

	User create(UserDto form);
}
