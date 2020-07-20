package com.ohsam.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohsam.blog.model.User;
import com.ohsam.blog.repository.UserRepository;

//Controller , Repository, Configuration, Service, Component
//RestController, Bean

@Service //IoC
public class UserService {

	@Autowired
	private UserRepository userRepository; //DI
	
	@Transactional
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
	}
	@Transactional(readOnly = true) //고립성으로 데이터의 정합성을 높이기 위해!
	public User 로그인 (User user) {
		
		return userRepository.login(user);
		
	}
	
}
