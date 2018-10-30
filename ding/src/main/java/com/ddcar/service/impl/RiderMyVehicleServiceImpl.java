package com.ddcar.service.impl;

import com.common.OrderSequence;
import com.ddcar.entity.*;
import com.ddcar.mapper.PatchOrderMapper;
import com.ddcar.mapper.TbInvoiceMapper;
import com.ddcar.mapper.TbUserMapper;
import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.RiderMyVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiderMyVehicleServiceImpl implements RiderMyVehicleService {

    @Autowired
    private TbVehicleMapper vehicleMapper;
    @Autowired
    private TbInvoiceMapper invoiceMapper;
    @Autowired
    private PatchOrderMapper patchOrderMapper;
    @Autowired
    private TbUserMapper tbUserMapper;


    @Override
    public List<Vehicles> findUserVehicle(long userId) {
        List<Vehicles> riderVehicle = vehicleMapper.findRiderVehicle(userId);
        for (Vehicles vehicles : riderVehicle){
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
            long days=(date2.getTime()-date1.getTime())/(1000*60*60*24);
            vehicles.setEmainingDays(days);
        }
        return riderVehicle;
    }

    @Override
    @Transactional
    public int saveInvoice(TbInvoice invoice) {
        int i = invoiceMapper.insertSelective(invoice);
        if(i > 0){
            return i;
        }
        return 0;
    }

    @Override
    public TbVehicle getVehicleByUserIdAndVehicleId(Map map) {
        return vehicleMapper.getVehicleByUserIdAndVehicleId(map);
    }
    @Override
    public Map savePatchOrder(Long userId, Double money)throws Exception {
        String orderNo = patchOrderMapper.getOrderNo();
        Map map = new HashMap();
        long userWangId = vehicleMapper.findUserWangId(userId);
        UserVehicle user = tbUserMapper.findUser(userId);
        String state = "b";
        //        获取订单号
        String orderId = OrderSequence.getOrderId(orderNo, state);
        PatchOrder patchOrder = new PatchOrder();
        patchOrder.setMoney(money);
        patchOrder.setOrderNo(orderId);
        patchOrder.setUserId(userId);
        patchOrder.setWangUserId(userWangId);
        patchOrder.setParentId(user.getParentId());
        map.put("orderNo", orderId);
        patchOrderMapper.savePatchOrder(patchOrder);
        return map;
    }

    @Override
    public int updateUserTuiState(Map map) throws Exception {
        return tbUserMapper.updateUserTuiState(map);
    }
}
