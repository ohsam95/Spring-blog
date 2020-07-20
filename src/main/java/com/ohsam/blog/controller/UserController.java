package com.ohsam.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohsam.blog.controller.dto.CommonRespDto;
import com.ohsam.blog.model.User;
import com.ohsam.blog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public  @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { 
		//user는 x-www-form-urlencode만 받을 수 있음 -> 제이슨 받을려면 @RequestBody를 적어야함
		int result = userService.회원가입(user);
		return new CommonRespDto<String>(result,"회원가입 결과 : "+result);
	}
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user,HttpSession session){
		User persistUser =	userService.로그인(user);
	
		if (ObjectUtils.isEmpty(persistUser)) {
			return new CommonRespDto<String>(-1, "로그인 결과 실패"); 
		}else {
			session.setAttribute("principal", persistUser); //세션등록
			return new CommonRespDto<String>(1, "로그인 결과 성공");
		}

	}
	
}
