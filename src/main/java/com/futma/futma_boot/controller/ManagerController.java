package com.futma.futma_boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.service.ManagerImgService;
import com.futma.futma_boot.service.ManagerService;
import com.futma.futma_boot.service.UserService;
import com.futma.futma_boot.vo.Manager;
import com.futma.futma_boot.vo.ManagerImg;
import com.futma.futma_boot.vo.User;


@RestController
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

	
	@GetMapping("findByMngIdx")
	public List<ManagerImg> findByMngIdx(
				@RequestParam(value="mng_idx") int mng_idx
			) {
		
		return managerImgService.fidnByMngIdx(mng_idx);
	}
	
	@GetMapping("findByUserIdx")
	public Manager findByUserIdx(
				@RequestParam(value="user_idx") int user_idx
			) {
		return managerService.findByUserIdx(user_idx);
	}
	
	
	
	@PostMapping("/addOrUpdate")
	public  String addOrUpdate(
				@RequestBody Map<String, Object> map
			) throws Exception {
		
		
		//transaction
		DefaultTransactionDefinition def =new DefaultTransactionDefinition();
      	def.setName("mng_add");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		
		
		try {
			String mode = (String) map.get("mode");
			String mng_idx = (String) map.get("mng_idx");
			String user_idx = (String) map.get("u");
			String name = (String) map.get("n");
			String birth = (String) map.get("b");
			String address = (String) map.get("a");
			String content = (String) map.get("c");
			String actDosi = (String) map.get("dosi");
			String actGu = (String) map.get("gu");
			String owner_ny = (String) map.get("o");
			String kakao_pay_link=(String) map.get("kpl");
			String bank_name=(String) map.get("bn");
			String bank_account=(String) map.get("ba");
			@SuppressWarnings("unchecked")
			List<String> imgs = (List<String>) map.get("imgs");
			@SuppressWarnings("unchecked")
			List<String> strg_names = (List<String>) map.get("strg_names");
			
			
			Manager manager = new Manager();
			manager.setUser_idx(Integer.parseInt(user_idx));
			manager.setMng_idx(Integer.parseInt(mng_idx));
			manager.setName(name);
			manager.setBirth(birth);
			manager.setAddress(address);
			manager.setContent(content);
			manager.setAct_dosi(actDosi);
			manager.setAct_gu(actGu);
			manager.setOwner_ny(owner_ny);
			manager.setKakao_pay_link(kakao_pay_link);
			manager.setBank_name(bank_name);
			manager.setBank_account(bank_account);
			
			
			int new_manager_idx=0;
			if(mode.equals("a")) {
				managerService.add(manager);
				new_manager_idx=manager.getMng_idx();
			}else{
				managerService.update(manager);
				new_manager_idx=Integer.parseInt(mng_idx);
			}
			
			
			
			
			
			//delete existing manager images
			ManagerImg mi = new ManagerImg();
			mi.setMng_idx(new_manager_idx);
			managerImgService.delByMngIdx(mi);
			
			for(int i=0;i<imgs.size();i++) {
				
				//add manager images
				mi.setImg_url(imgs.get(i));
				
				//add firebase storage name
				mi.setStrg_name(strg_names.get(i));
				managerImgService.add(mi);
			}
			
			//update user's mng_req_state
			User user = new User();
			user.setUser_idx(Integer.parseInt(user_idx));
			user.setMng_req_state("p");
			userService.updateMngReqState(user);
			
			transactionManager.commit(status);
			return MyHttpHeader.SUCCESS;
			
		}catch(Exception e) {
			transactionManager.rollback(status);
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	
	
}
