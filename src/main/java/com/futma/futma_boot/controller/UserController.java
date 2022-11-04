package com.futma.futma_boot.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.dao.UserDao;
import com.futma.futma_boot.service.UserService;
import com.futma.futma_boot.vo.User;



@Controller()
@RequestMapping("user")
public class UserController {
	
	

	
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="/getUserByNick",method=RequestMethod.GET)
	public @ResponseBody User getUserByNick(@RequestParam(value="nick") String nick) {
		
		User user =  new User();
		user.setNick(nick);
		User res = userService.getUserByNick(user);
		
		return res;
	}
	
	
	@RequestMapping(value="/updateUserNick",method=RequestMethod.GET)
	public @ResponseBody String updateUserNick(
				@RequestParam(value="uidx") long user_idx,
				@RequestParam(value="nick") String nick
			) {
		
		
		User user =  new User();
		user.setNick(nick);
		user.setUser_idx(user_idx);
		userService.updateUserNick(user);
		
		
		return MyHttpHeader.SUCCESS;
	}
	
	
	@RequestMapping(value="/updateImageUrl",method=RequestMethod.GET)
	public @ResponseBody String updateImageUrl(
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
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public @ResponseBody String add(
				@RequestParam(value="id") String id,
				@RequestParam(value="login_type") String login_type
			) {
		
		User user = new User();
		user.setId(id);
		user.setLogin_type(login_type);
		
		User resultUser = userService.getUserByIdAndLoginType(user);
		
		if(resultUser==null) {
			userService.insert(user);
		}
		
		
		return MyHttpHeader.SUCCESS;
	}
	
	@RequestMapping(value="/getby_id_logintype",method=RequestMethod.GET)
	public @ResponseBody User getby_id_logintype(
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
