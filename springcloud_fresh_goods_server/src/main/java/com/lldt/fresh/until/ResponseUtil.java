package com.lldt.fresh.until;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
	/**
	 * 响应对象
	 * @param code 响应的状态码
	 * @param msg  响应的信息
	 * @param data  响应的数据
	 * @return
	 */
	public static Map<String, Object> responseMap(int code, String msg, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
}
