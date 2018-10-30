package com.ddcar.controller;

import com.common.BaseBean;
import com.common.MD5Util;
import com.ddcar.entity.TbBranch;
import com.ddcar.entity.TbUser;
import com.ddcar.service.ITbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/appLogin")
public class WxUserController {

    @Autowired
    ITbUser user;

    /**
     * 网点首页登录
     *
     * @param account
     * @param password
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/login")
    public @ResponseBody
    BaseBean loginUser(String account, String password,
                       HttpServletRequest request) throws Exception {

        BaseBean bean = new BaseBean();
        Map param = new HashMap();
        param.put("userName", account);
        param.put("pwd", MD5Util.digest(password));
        param.put("type", 2);
        TbBranch tbUser = user.loginUser(param);
        if (tbUser == null) {
            bean.setStatus(400);
            bean.setMsg("账号或密码错误!");
        } else {
            if (tbUser.getBranchState() == 0) {
                bean.setStatus(200);
                bean.setRows(tbUser);
            } else {
                bean.setStatus(400);
                bean.setMsg("账号未开启!");
            }
        }
        return bean;
    }
}
