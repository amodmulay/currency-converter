package com.avm.zoocode.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avm.zoocode.db.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findUserByEmail(String email);
}
