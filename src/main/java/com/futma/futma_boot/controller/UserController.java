package com.futma.futma_boot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.service.UserService;
import com.futma.futma_boot.vo.User;



@RestController
@RequestMapping("user")
public class UserController {
	
	

	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("updateReqInf")
	public String updateReqInf(
				@RequestParam(value="uidx") int user_idx,
				@RequestParam(value="nick") String nick,
				@RequestParam(value="name") String name,
				@RequestParam(value="tel") String tel
			) {
		
		
		User user = new User();
		user.setUser_idx(user_idx);
		user.setNick(nick);
		user.setU_name(name);
		user.setTel(tel);
		
		userService.updateRequiredInfo(user);
		
		return "ok";
	}
	
	
	@GetMapping("/getUserByIdx")
	public User getUserByIdx(@RequestParam(value="idx") int user_idx) {
		
		User user =  new User();
		user.setUser_idx(user_idx);
		
		
		User res = userService.getUserByIdx(user);
		
		return res;
	}
	
	
	@GetMapping("/getUserByUUID")
	public User getUserByUUID(@RequestParam(value="uuid") String uuid) {
		
		
		User user = userService.findByUUID(uuid);
		
		return user;
	}
	
	
	@GetMapping("getUserByNick")
	public User getUserByNick(@RequestParam(value="nick") String nick) {
		
		User user =  new User();
		user.setNick(nick);
		User res = userService.getUserByNick(user);
		
		return res;
	}
	
	
	@GetMapping("updateUserNick")
	public String updateUserNick(
				@RequestParam(value="uidx") long user_idx,
				@RequestParam(value="nick") String nick
			) {
		
		
		User user =  new User();
		user.setNick(nick);
		user.setUser_idx(user_idx);
		userService.updateUserNick(user);
		
		
		return MyHttpHeader.SUCCESS;
	}
	
	
	@GetMapping("updateImageUrl")
	public String updateImageUrl(
				@RequestParam(value="uidx") long user_idx,
				@RequestParam(value="img_url") String image_url,
				@RequestParam(value="sm_img_url") String small_image_url
			) {
		
		
		User user =  new User();
		user.setUser_idx(user_idx);
		user.setImage_url(image_url);
		user.setSmall_image_url(small_image_url);
		
		userService.updateImageUrl(user);
		
		
		return MyHttpHeader.SUCCESS;
	}
	
	
	@GetMapping("findByTel")
	public User findByTel(
				@RequestParam(value="tel") String tel
			) {
		
		return userService.findByTel(tel);
	}

	
	@PostMapping(value="/save")
	public String save(
				@RequestParam(value="tel") String tel,
				@RequestParam(value="login_type") String login_type,
				@RequestParam(value="nick") String nick,
				@RequestParam(value="gender") String gender,
				@RequestParam(value="birth") String birth,
				@RequestParam(value="dosi") String dosi,
				@RequestParam(value="gu") String gu
			) {
		
		User user = new User();
		//uuid 설정 후 회원가입 하기
		String uuid = UUID.randomUUID().toString();
		user.setUser_uuid(uuid);
		user.setId(tel);
		user.setTel(tel);
		user.setLogin_type(login_type);
		user.setNick(nick);
		user.setGender(gender);
		user.setBirth(birth);
		user.setU_dosi(dosi);
		user.setU_gu(gu);
		
		
		//닉네임으로 먼저 조회
		User resultUser = userService.getUserByNick(user);
		
		if(resultUser==null) {
			userService.save(user);
			return MyHttpHeader.SUCCESS;
		}else {
			return "nick";
		}
	}
	
	@GetMapping("getby_id_logintype")
	public User getby_id_logintype(
				@RequestParam(value="id") String id,
				@RequestParam(value="login_type") String login_type
			) {
		
		
		User user = new User();
		user.setId(id);
		user.setLogin_type(login_type);
		
		User resultUser = userService.getUserByIdAndLoginType(user);
		
		
		return resultUser;
	}
	
	
}
