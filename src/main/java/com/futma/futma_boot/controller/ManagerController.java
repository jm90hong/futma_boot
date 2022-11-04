package com.futma.futma_boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futma.futma_boot.service.ManagerImgService;
import com.futma.futma_boot.service.ManagerService;
import com.futma.futma_boot.service.UserService;
import com.futma.futma_boot.vo.Manager;
import com.futma.futma_boot.vo.ManagerImg;
import com.futma.futma_boot.vo.User;

@Controller
@RequestMapping("mng")
public class ManagerController {
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	
	
	@Autowired
	private ManagerService managerService;
	

	@Autowired
	private ManagerImgService managerImgService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody String testadd(@RequestBody Map<String, Object> map) throws Exception {
		
		
		//transaction
		DefaultTransactionDefinition def =new DefaultTransactionDefinition();
      	def.setName("mng_add");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		
		
		try {
			String user_idx = (String) map.get("u");
			String name = (String) map.get("n");
			String birth = (String) map.get("b");
			String address = (String) map.get("a");
			String content = (String) map.get("c");
			String actAdress1 = (String) map.get("a1");
			String actAdress2 = (String) map.get("a2");
			String owner_ny = (String) map.get("o");
			String kakao_pay_link=(String) map.get("kakao_pay_link");
			@SuppressWarnings("unchecked")
			List<String> imgs = (List<String>) map.get("imgs");
			
			
			Manager manager = new Manager();
			manager.setUser_idx(Integer.parseInt(user_idx));
			manager.setName(name);
			manager.setBirth(birth);
			manager.setAddress(address);
			manager.setContent(content);
			manager.setAct_addr1(actAdress1);
			manager.setAct_addr2(actAdress2);
			manager.setOwner_ny(owner_ny);
			manager.setKakao_pay_link(kakao_pay_link);
			
			managerService.add(manager);
			
			int new_manager_idx=manager.getMng_idx();
			
			
			//delete existing manager images
			ManagerImg mi = new ManagerImg();
			mi.setManager_idx(new_manager_idx);
			managerImgService.delByMngIdx(mi);
			
			for(int i=0;i<imgs.size();i++) {
				
				//add manager images
				mi.setImg_url(imgs.get(i));
				managerImgService.add(mi);
			}
			
			//update user's mng_req_state
			User user = new User();
			user.setUser_idx(Integer.parseInt(user_idx));
			user.setMng_req_state("p");
			userService.updateMngReqState(user);
			
			transactionManager.commit(status);
			return "ok";
			
		}catch(Exception e) {
			transactionManager.rollback(status);
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	
	
}
