package com.lldt.fresh.until;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequsetParameterUtil {
	
	/**
	 * 把请求中的参数封装成map对象
	 * @param request
	 * @return
	 */
	public  static Map<String,Object> getRequsetParameter(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		Enumeration<String> params = request.getParameterNames();
		
		String key = null;
		while(params.hasMoreElements()){
			key = params.nextElement();
			map.put(key, request.getParameter(key));
		}
		
		return map;
		
	}
	
	public static Map<String ,Object> pageParameter(Integer page ,Integer rows){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("page",(page -1) * rows);
		map.put("rows",rows);
		return map;
		
	}
}
