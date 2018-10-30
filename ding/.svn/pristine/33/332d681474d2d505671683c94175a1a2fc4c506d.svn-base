package com.ddcar.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ddcar.entity.TbManager;
import com.ddcar.mapper.TbManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddcar.entity.Manager;
import com.ddcar.entity.User;
import com.ddcar.mapper.UserMapper;
import com.ddcar.service.UserManager;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserManagerImpl implements UserManager{

	@Resource
	UserMapper userMapper;
	@Resource
	TbManagerMapper tbManagerMapper;

//	@Override
//	public List<User> findUserList(Integer page, Integer size) {
//		PageHelper.startPage(page,size);
//		return userMapper.findUserList();
//	}
	@Transactional
	@Override
	public TbManager loginManager(HashMap param) {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		TbManager tbManager=userMapper.loginManager(param);
		if(tbManager!=null){
			TbManager managers=new TbManager();
			managers.setManagerId(tbManager.getManagerId());
			managers.setCompanyId(tbManager.getCompanyId());
			managers.setLastTime(time);
			tbManagerMapper.updateManager(managers);
		}
		// TODO Auto-generated method stub
		return tbManager;


	}

}
