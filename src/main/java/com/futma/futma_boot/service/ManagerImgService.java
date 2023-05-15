package com.futma.futma_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.ManagerImgDao;
import com.futma.futma_boot.vo.ManagerImg;

@Service
public class ManagerImgService {
	
	
	@Autowired
	ManagerImgDao managerImgDao;
	
	
	
	public int delByMngIdx(ManagerImg mi) {
		return managerImgDao.delByMngIdx(mi);
	}
	
	public int add(ManagerImg mi) {
		return managerImgDao.add(mi);
	}
	
	public List<ManagerImg> fidnByMngIdx(int mng_idx){
		return managerImgDao.fidnByMngIdx(mng_idx);
	}
	
}
