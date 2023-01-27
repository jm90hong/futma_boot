package com.futma.futma_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.ManagerDao;
import com.futma.futma_boot.vo.Manager;

@Service
public class ManagerService {
	
	
	@Autowired
	ManagerDao managerDao;
	
	
	public Manager findByUserIdx(long user_idx) {
		return  managerDao.findByUserIdx(user_idx);
	}
	
	public int add(Manager manager) {	
		return managerDao.add(manager);
	}
	
}
