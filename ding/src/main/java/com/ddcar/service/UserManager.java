package com.ddcar.service;

import com.ddcar.entity.TbManager;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;


public interface UserManager {

//	List<User> findUserList(Integer page, Integer size);

	TbManager loginManager(HashMap param);

}
