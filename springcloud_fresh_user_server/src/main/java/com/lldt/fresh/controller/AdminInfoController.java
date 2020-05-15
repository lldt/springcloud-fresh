package com.lldt.fresh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lldt.fresh.entity.AdminInfo;
import com.lldt.fresh.entity.MenberInfo;
import com.lldt.fresh.service.IAdminInfoService;
import com.lldt.fresh.until.ResponseUtil;
import com.lldt.fresh.until.SendMailUtil;




@RestController
@RequestMapping("/admin")
public class AdminInfoController{
	@Autowired
	private IAdminInfoService admininfo;
	
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@GetMapping("/check")
	public Map<String, Object> check(HttpSession session) {
		Object obj =session.getAttribute("currentLoginUser");
		if(obj == null){
			return ResponseUtil.responseMap(500	, null, null);

		}else{
			return ResponseUtil.responseMap(200	, null, obj);
		}
	}

	@RequestMapping("/login")
	public int login(AdminInfo af,HttpSession session) {
		int result = -1;
		
		
		AdminInfo afs = admininfo.login(af);
		if(afs != null){
			session.setAttribute("currentLoginUser", afs);
			result = 1;
		}
		return result;
		
	}
	@RequestMapping("/userlogin")
	public Map<String, Object> userlogin(MenberInfo mb,String yzm,HttpSession session) {
		String temp =(String) session.getAttribute("validateCode");
		if(!temp.equals(yzm) ){
			return ResponseUtil.responseMap(501, null, null);
		}
		System.out.println(mb);
		MenberInfo mbs = admininfo.userlogin(mb);
		if(mbs == null){
			return ResponseUtil.responseMap(502, null, null);
		}
		session.setAttribute("currentLoginUser", mbs);
		return ResponseUtil.responseMap(200, null, null);
		
	}
	
	@RequestMapping("/add")
	public int add(@RequestParam Map<String,String> map){
		return admininfo.add(map);
		
	}
	@RequestMapping("/findAll")
	public List<AdminInfo> findAll(){
		
		return admininfo.findAll();
		
	}
	
	@RequestMapping("/update")
	public int update(String aid){
		
		return admininfo.update(aid);
		
	}
	@RequestMapping("/finduserAll")
	public List<MenberInfo> finduserAll(){
		
		return admininfo.finduserAll();
		
	}
	
	@RequestMapping("/freeze")
	public int freeze(@RequestParam Map<String,String> map){
		return admininfo.freeze(map);
		
	}
	
	@RequestMapping("/code")
	public int sendCode(String Email,String name,HttpSession session){
		String code="";
		Random rd = new Random();
		while(code.length() < 6){
			code += rd.nextInt(10);
		}
		System.out.println( Email + "===" + name + "==" + code);
		if(sendMailUtil.sendHtmlMail(Email, name, code)){
			session.setAttribute("vcode", code);
			
			//定时器
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					session.removeAttribute("vcode");
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task, 180000);//3分钟之后执行任务一次
			return 1;
		}
		return 0;
	}
	
	
	/**
	 * -2：过期 -1：错误  -3：空 
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/useradd")
	public int useradd(@RequestParam Map<String,String> map ,HttpSession session){
		//获取发送的验证码
		Object obj = session.getAttribute("vcode");
		if(obj == null){
			return -2;
		}
		if(!String.valueOf(obj).equals(map.get("code"))){
			return -1;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间即注册日期
		map.put("regDate",date);
		return admininfo.useradd(map);
		
	}
	
	
}

