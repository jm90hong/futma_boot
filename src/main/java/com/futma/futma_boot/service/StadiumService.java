package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.StadiumDao;
import com.futma.futma_boot.vo.Stadium;

@Service
public class StadiumService {
	
	@Autowired
	StadiumDao stadiumDao;
	
	public Stadium getByIdx(Stadium stadium) {
		return stadiumDao.getByIdx(stadium);
	}
	
	public List<Stadium> search(HashMap<String, Object> map){
		return stadiumDao.search(map);
	}
	
}
