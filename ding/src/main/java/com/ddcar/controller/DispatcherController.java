package com.ddcar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.common.Commonparam;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: ZhangXuanWei
 * Time: 2018/2/15 11:51
 * Description:
 */
@Controller
public class DispatcherController {
	
	@Value("${ueditorConfigPath}")
	public String ueditorConfigPath;
	
	@GetMapping("/page/{pagehtml}")
	public String page(@PathVariable("pagehtml") String page,HttpServletRequest request) {
		if(page!=null && page.equals("login")){
			request.getSession().setAttribute(Commonparam.USER_MANAGER_SESSION, null);
			request.getSession().invalidate();
		}
	    return page;
	}
    @GetMapping("/page/{folder}/{pagehtml}")
    public String page(@PathVariable("folder") String folder, @PathVariable("pagehtml") String page) {
        return folder + "/" + page;
    }

	@GetMapping("/phone/{pagehtml}")
	public String phone(@PathVariable("pagehtml") String page,HttpServletRequest request) {
		
	    return "phone/"+page;
	}
    @GetMapping("/phone/{folder}/{pagehtml}")
    public String phone(@PathVariable("folder") String folder, @PathVariable("pagehtml") String page) {
        return "phone/"+folder + "/" + page;
    }

    @GetMapping("/page/ueditor/controller")
    public void ueditorController(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding( "utf-8" );
    	response.setHeader("Content-Type" , "text/html");
    		
    	String rootPath = Commonparam.txt2String(ueditorConfigPath);
    		
    	response.getWriter().write( rootPath );
    }



}
