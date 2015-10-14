package com.avm.zoocode.db.entity;

import org.springframework.security.core.authority.AuthorityUtils;

public class UserDetailsExt extends org.springframework.security.core.userdetails.User {
	/**
	* 
	*/
	private static final long serialVersionUID = -82331789602047999L;
	private User user;

	public UserDetailsExt(User user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList("USER"));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Long getId() {
		return user.getId();
	}
	
	@Override
	public String toString() {
		return "UserDetailsExt{" + "user=" + user + "} " + super.toString();
	}
}
