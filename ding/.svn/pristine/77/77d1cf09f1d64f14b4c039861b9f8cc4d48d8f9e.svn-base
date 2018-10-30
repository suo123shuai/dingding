package com.ddcar.service.impl;

import com.common.Commonparam;
import com.common.DoubleOperation;
import com.ddcar.entity.*;
import com.ddcar.mapper.*;
import com.ddcar.service.WangMyModelService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WangMyModelServiceImpl implements WangMyModelService {

    @Autowired
    TbUserMapper userMapper;
    @Autowired
    TbVehicleMapper vehicleMapper;
    @Autowired
    TbBranchMapper branchMapper;
    @Autowired
    TbOrderItemMapper orderItemMapper;
    @Autowired
    private AccountFlowMapper accountFlowMapper;
    @Autowired
    private TbModelNumberMapper modelNumberMapper;

    @Override
    public List<Vehicles> findUserVehicle(Map map, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return vehicleMapper.findUserVehicle(map);
    }

    @Override
    public String fiindUserQrCode(long userId) {
        return branchMapper.fiindUserQrCode(userId);
    }

    @Override
    public Vehicles findUserVehicleParticular(long vehicleId) throws Exception {
        Vehicles vehicles = vehicleMapper.findUserVehicleParticular(vehicleId);
        if (StringUtils.isBlank(vehicles.getStopRentalTime())
                || StringUtils.isBlank(vehicles.getStartRentalTime())) {
            vehicles.setEmainingDays(0);
            vehicles.setStopRentalTime("0");
            vehicles.setStartRentalTime("0");
        } else {
            String stopRentalTime = vehicles.getStopRentalTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.setLenient(false);
            Date date1 = new Date();
            Date date2 = null;
            try {
                date2 = format.parse(stopRentalTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //计算差值，天数
            long days = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
            vehicles.setEmainingDays(days);
            String format1 = Commonparam.fmtshort.format(date2);
            vehicles.setStopRentalTime(format1);
        }
        return vehicles;
    }

    @Override
    public List<TbUser> listUser(long wangUserId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return userMapper.listUser(wangUserId);
    }

    @Override
    public int updUserState(Map map) {
        String state = (String) map.get("state");
        if ("0".equals(state)) {
            map.put("wangUserId", map.get("modifyBy"));
        } else {
            map.put("wangUserId", 0);
        }
        return userMapper.updUserState(map);
    }

    @Override
    public UserOrderVehicleItme findUserVehicle(long userId, Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return orderItemMapper.findUserVehicle(userId);
    }

    @Override
    public List<TbUser> findUserByLike(Map map, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return userMapper.findUserByLike(map);
    }

    @Override
    public UserVehicle findUser(long userId) {
        return userMapper.findUser(userId);
    }

    @Override
    public int updUserEmptyState(Map map) {
        List<TbVehicle> users = vehicleMapper.listUserVehicleByUserId((long) map.get("userId"));
        int i = 0;
        if (null == users || users.isEmpty()) {
            i = userMapper.updUserEmptyState(map);
        }
        return i;
    }

    @Override
    public TbUser getUserByUserId(long userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public Double getDeposit(String[] ids) {
        return vehicleMapper.getDeposit(ids);
    }

    @Override
    public AmountAndFlow findWangFlow(Long wangUserId, Integer page, Integer size) throws Exception {
        AmountAndFlow af = new AmountAndFlow();
        PageHelper.startPage(page, size);
        List<AccountFlow> wangFlow = accountFlowMapper.findWangFlow(wangUserId);
        for (AccountFlow afq : wangFlow) {
            String createTime = afq.getCreateTime();
            SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = adf.parse(createTime);
            SimpleDateFormat adf1 = new SimpleDateFormat("yyyy-MM-dd");
            String format = adf1.format(parse);
            afq.setCreateTime(format);
        }
        af.setAccountFlow(wangFlow);
        return af;
    }

    @Override
    public Map IncomeBreakdown(Long wangUserId) {
        Map map1 = accountFlowMapper.incomeTotal(wangUserId);
        Map map = accountFlowMapper.expenditureTotal(wangUserId);
        BigDecimal y = (BigDecimal) map1.get("y");
        BigDecimal t = (BigDecimal) map1.get("t");
        map1.put("zy", y.subtract(t));
        BigDecimal z = (BigDecimal) map1.get("z");
        BigDecimal b = (BigDecimal) map1.get("b");
        map1.put("zs", z.add(b));
        Map map2 = new HashMap(2);
        map2.put("Data1", map);
        map2.put("Data2", map1);
        return map2;
    }

    @Override
    public List<NumModel> findWangUserModelAmount(Map map) {
        return modelNumberMapper.findWangUserModelAmount(map);
    }

    @Override
    public Double expenditureTotal(Long wangUserId) {
        Map map = accountFlowMapper.expenditureTotal(wangUserId);
        BigDecimal y = new BigDecimal(0);
        BigDecimal z = new BigDecimal(0);
        BigDecimal t = new BigDecimal(0);
        BigDecimal b = new BigDecimal(0);

        if(null != map.get("y")){
            y = (BigDecimal) map.get("y");
        }
        if(null != map.get("z")){
            z = (BigDecimal) map.get("z");
        }
        if(null != map.get("t")){
            t = (BigDecimal) map.get("t");
        }
        if(null != map.get("b")){
            b = (BigDecimal) map.get("b");
        }
        BigDecimal subtract = y.add(z.add(b)).subtract(t);
//        Double sub = DoubleOperation.sub(DoubleOperation.sum(
//                DoubleOperation.sum(y, z), b), t);
        double v = subtract.doubleValue();
        return v;
    }

    @Override
    public List<Map> findWangUser(Map map, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Map> wangUser = userMapper.findWangUser(map);
        return wangUser;
    }
}
