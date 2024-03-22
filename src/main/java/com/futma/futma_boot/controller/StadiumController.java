
package com.futma.futma_boot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("getByIdx")
	public @ResponseBody Stadium getByIdx(
				@RequestParam(value="stadium_idx") int stadium_idx
			) {
		
		
		Stadium stadium = new Stadium();
		stadium.setStadium_idx(stadium_idx);
		
		
		return stadiumService.getByIdx(stadium);
	}
	
	
	
	
	@GetMapping("search")
	public @ResponseBody List<Stadium> search(
				@RequestParam(value="dosi",defaultValue="") String dosi,
				@RequestParam(value="word",defaultValue="") String word
			) {
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(dosi.equals("전체")) {
			map.put("dosi", null);
		}else {
			map.put("dosi", dosi);
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
