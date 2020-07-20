package com.ohsam.blog.repository;

import com.ohsam.blog.model.User;

public interface UserRepository {
	public void save(User user);
	public User login(User user);
}
