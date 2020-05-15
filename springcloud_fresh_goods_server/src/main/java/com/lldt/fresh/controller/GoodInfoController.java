package com.lldt.fresh.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lldt.fresh.entity.GoodsInfo;
import com.lldt.fresh.entity.GoodsType;
import com.lldt.fresh.service.IGoodInfoBiz;
import com.lldt.fresh.until.RequsetParameterUtil;
import com.lldt.fresh.until.StringUtil;


@RestController
@RequestMapping("/good")
public class GoodInfoController {
	@Autowired
	private IGoodInfoBiz goodInfoBiz;

	@RequestMapping("findAllType")
	public List<GoodsType> findAllType(){
		return goodInfoBiz.findAllType();
	}

	@RequestMapping("/findByPage")
	private Map<String, Object> findByPage(Integer page ,Integer rows)  {
		return goodInfoBiz.findByPage(RequsetParameterUtil.pageParameter(page, rows));

	}

	@RequestMapping("/findTypeByPage")
	private Map<String, Object> findTypeByPage(Integer page ,Integer rows)  {
		return goodInfoBiz.findTypeByPage(RequsetParameterUtil.pageParameter(page, rows));

	}


	@RequestMapping("findindexAll")
	public List<GoodsType> findindexAll(){
		return goodInfoBiz.findindexAll();
	}


	@RequestMapping("/findByTno")
	private Map<String, Object> findByTno(Integer page ,Integer rows,Integer tno) {
		Map<String, Object> map = RequsetParameterUtil.pageParameter(page, rows);
		map.put("tno", tno);
		return goodInfoBiz.findByTno(map);

	}

	@RequestMapping("/findByTnoprice")
	private Map<String, Object> findByTnoprice(Integer page ,Integer rows,Integer tno){
		Map<String, Object> map = RequsetParameterUtil.pageParameter(page, rows);
		map.put("tno", tno);
		return goodInfoBiz.findByTnoprice(map);

	}

	@RequestMapping("/findByGno")
	private GoodsInfo findByGno(Integer gno) {
		return goodInfoBiz.findByGno(gno);

	}


	@RequestMapping("upload")
	private Map<String,Object> upload(@RequestParam("upload") MultipartFile pic,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(!pic.isEmpty()){
			String savepath = "../pics";

			try {
				String path = request.getServletContext().getRealPath("");
				String temp = request.getServletContext().getInitParameter("uploadpath");

				if(!StringUtil.checkNull(temp)){
					savepath = temp;
				}

				savepath += "/" + new Date().getTime() + "_" + new Random().nextInt(10000) + "-" + pic.getOriginalFilename();
				File dest = new File(path,savepath);
				//将图片保存到服务器的指定文件
				pic.transferTo(dest);
				
				map.put("fileName", savepath.substring(savepath.lastIndexOf("/") + 1));
				map.put("uploaded", 1);
				map.put("url","../../" + savepath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();	
			}

		}
		
		
		return map;
	}

	

}