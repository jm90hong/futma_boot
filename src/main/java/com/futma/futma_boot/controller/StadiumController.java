package com.futma.futma_boot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futma.futma_boot.service.StadiumService;
import com.futma.futma_boot.vo.Stadium;

@Controller
@RequestMapping("stadium")
public class StadiumController {
	
	

	
	@Autowired
	private StadiumService stadiumService;
	
	
	@RequestMapping(value="getByIdx",method=RequestMethod.GET)
	public @ResponseBody Stadium getByIdx(
				@RequestParam(value="stadium_idx") int stadium_idx
			) {
		
		
		Stadium stadium = new Stadium();
		stadium.setStadium_idx(stadium_idx);
		
		
		return stadiumService.getByIdx(stadium);
	}
	
	
	
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public @ResponseBody List<Stadium> search(
				@RequestParam(value="location",defaultValue="") String location,
				@RequestParam(value="word",defaultValue="") String word
			) {
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(location.equals("전체")) {
			map.put("location", null);
		}else {
			map.put("location", location);
		}
		
		if(word.equals("")) {
			map.put("word", null);
		}else {
			map.put("word", word);
		}
		
		List<Stadium> list = stadiumService.search(map);
		
		return list;
	}
	
	
}
