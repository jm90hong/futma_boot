package com.futma.futma_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.UserDao;
import com.futma.futma_boot.vo.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public int updateDelNy(User user) {
		return userDao.updateDelNy(user);
	}
	
	public User findByTel(String tel) {
		return userDao.findByTel(tel);
	}
	
	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}
	
	public int updateRequiredInfo(User user) {
		return userDao.updateRequiredInfo(user);
	}
	
	public int updateWithReview_add(User user) {
		return userDao.updateWithReview_add(user);
	}
	
	public int addMakeCnt(User user) {
		return userDao.addMakeCnt(user);
	}
	
	public int addJoinCnt(User user) {
		return userDao.addJoinCnt(user);
	}
	
	public User getUserByIdx(User user) {
		return userDao.getUserByIdx(user);
	}
	
	
	public int updateMngReqState(User user) {
		return userDao.updateMngReqState(user);
	}
	
	
	public int save (User user) {
		return userDao.save(user);
	}
	
	public User getUserByIdAndLoginType (User user) {
		return userDao.getUserByIdAndLoginType(user);
	}
	
	
	public User getUserByNick(User user) {
		return userDao.getUserByNick(user);
	}
	
	
	public int updateUserNick(User user) {
		return userDao.updateUserNick(user);
	}
	
	
	public int updateImageUrl(User user) {
		return userDao.updateImageUrl(user);
	}
	
}
