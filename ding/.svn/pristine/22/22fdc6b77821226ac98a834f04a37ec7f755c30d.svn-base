package com.ddcar.service.impl;

import com.common.ExceptionMyself;
import com.ddcar.entity.TbInout;
import com.ddcar.entity.TbInvoice;
import com.ddcar.entity.TbManager;
import com.ddcar.entity.TbVehicle;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.TbVehicleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
@Service
public class TbVehicleServiceImpl implements TbVehicleService{

    @Autowired(required = false)
    TbVehicleMapper tbVehicleMapper;
    @Autowired(required = false)
    TbInoutMapper tbInoutMapper;

    @Override
    public List<TbVehicle> findTbVehicleList(Integer page, Integer size,Long brandId,Integer modelType,String branchName,Long vehicleId,Integer state,String start,String end,String ks,String js) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.findTbVehicleList(brandId,modelType,branchName,vehicleId,state,start,end,ks,js);
    }

    @Override
    public List<TbVehicle> TbVehicleexal(Long brandId, Integer modelType, String branchName, Long vehicleId, Integer state) {
        return tbVehicleMapper.findList(brandId,modelType,branchName,vehicleId,state);
    }

    @Override
    public List<TbVehicle> allist(Long brandId,Integer modelType,Long branchId,String branchName) {
        return tbVehicleMapper.exal(brandId,modelType,branchId,branchName);
    }

    @Override
    public List<TbVehicle> noOutTbVehicleList(Integer page, Integer size,Integer brandId,Integer modelType,Integer vehicleId) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.noOutTbVehicleList(brandId, modelType,vehicleId);
    }

    @Override
    public List<HashMap> returnTbVehicleList(Integer page, Integer size,Integer branchId,String branchName) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.returnTbVehicleList(branchId,branchName);
    }

    @Override
    public List<HashMap> returnTbVehicleList(Integer branchId,String branchName) {
        return tbVehicleMapper.returnTbVehicleList(branchId,branchName);
    }

    @Override
    public List<TbVehicle> wangReturnTbVehicleList(Integer page, Integer size, Long branchId,Long brandId,Integer modelType,String serialNumber) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.wangReturnTbVehicleList(branchId,brandId,modelType,serialNumber);
    }

    @Override
    public List<TbVehicle> findTbVehiclebranchList(Integer page, Integer size,Integer modelId) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.findTbVehiclebranchList(page, size,modelId);
    }

    @Override
    public List<TbVehicle> ruTbVehicleList(Integer page, Integer size,Long branchId,Integer brandId,Integer modelType,Integer wangUserId,Integer source,Integer vehicleId,Integer state) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.ruTbVehicleList(branchId,brandId,modelType,wangUserId,source,vehicleId,state);
    }

    @Override
    public List<HashMap> okTbVehicleList(Integer page, Integer size, Long branchId,Integer brandId,Integer modelType,String branchName,String state,Integer tName,String start,String end,String ks,String js) {
        PageHelper.startPage(page,size);
        List<HashMap> list= tbVehicleMapper.okTbVehicleList(branchId,brandId,modelType,branchName,state,tName,start,end,ks,js);
        for(HashMap vehicle:list){
            Double price=tbVehicleMapper.findModalPriceByModeIdBranchId(vehicle);
            vehicle.put("monthlyRent",price==null?0:price);
        }
        return list;
    }

    @Override
    public List<HashMap> okTbVehicleListout(Integer page, Integer size, Long branchId,Integer brandId,Integer modelType,Integer wangUserId,String branchName,Long vehicleId,String state,Integer tName) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.okTbVehicleListout(branchId,brandId,modelType,wangUserId,branchName,vehicleId,state,tName);
    }

    @Override
    public List<HashMap> ifoutwang(Integer page, Integer size, Long branchId, Long branchIds, Integer brandId, Integer modelType, Integer wangUserId, String branchName, Long vehicleId, String state, Integer tName) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.ifoutwang(branchId,branchIds,brandId,modelType,wangUserId,branchName,vehicleId,state,tName);
    }

    @Override
    public List<HashMap> comveh(Long branchId,Integer brandId,Integer modelType,Integer wangUserId,String branchName,Long vehicleId,String state,Integer tName) {
        return tbVehicleMapper.okveh(branchId,brandId,modelType,wangUserId,branchName,vehicleId,state,tName);
    }

    @Transactional
    @Override
    public void completedRk(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.completedRk(id);
        }
    }

    @Override
    public Integer ifout(long vehicleId) {
        return tbVehicleMapper.ifout(vehicleId);
    }

    @Override
    public Integer ifvin(String vin) {
        return tbVehicleMapper.ifvin(vin);
    }

    @Override
    public Integer ifgps(String gpsNumber) {
        return tbVehicleMapper.ifgps(gpsNumber);
    }

    @Override
    public Integer ifserial(String serialNumber) {
        return tbVehicleMapper.ifserial(serialNumber);
    }

    @Transactional
    @Override
    public void completedRe(Long[] vehicleId) {
        for (Long id:vehicleId){
           tbVehicleMapper.completedRe(id);
        }
    }

    @Transactional
    @Override
    public void delTbVehicle(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.delTbVehicle(id);
        }
    }

    @Transactional
    @Override
    public void comreturmTbVehicle(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.comreturmTbVehicle(id);
        }
    }

    @Transactional
    @Override
    public void updatestateOk(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.updatestateOk(id);
        }
    }

    @Transactional
    @Override
    public void updatestateRepair(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.updatestateRepair(id);
        }
    }

    @Transactional
    @Override
    public void updatestateokStop(Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.updatestateokStop(id);
        }
    }
    @Transactional
    @Override
    public void vehicleOutCom(Long branchId, Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.vehicleOutCom(branchId,id);
        }
    }
    @Transactional
    @Override
    public void vehicleOutWang(Long wangUserId, Long[] vehicleId,TbManager companyId ,Long branchId) {
        for (Long id:vehicleId){
            String com=companyId.getUserName();
            Long bid=companyId.getCompanyId();
            TbInout tbInout=new TbInout();
            tbInout.setVehicleId(id);//车电id
            tbInout.setFromId(Math.toIntExact(bid));//来源方（分公司id）
            tbInout.setState("1");//进行状态
            tbInout.setToId(branchId);//接收方（网点id）
            tbInout.setType(3);//接收方类型1平台2分公司3网点4团签5骑手
            tbInout.setInoutType(2);//1：入库  2：出库
            tbInout.setDeleteFlag(0);//未删
            tbInout.setCreateBy(com);//操作人（当前用户也就是分公司管理员）
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=format.format(date);
            tbInout.setCreateTime(time);//当前时间（出库的时间）
            tbInoutMapper.insertTbInout(tbInout);
        }
        for (Long id:vehicleId){
            Long priceId=tbVehicleMapper.findPriceIdByvehicleId(id);
            if(priceId==null){
                throw  new ExceptionMyself("没有价格！");
            }
            tbVehicleMapper.vehicleOutWang(wangUserId,id,priceId);
        }
    }

    @Transactional
    @Override
    public void vehicleOutPing(Long branchId, Long[] vehicleId) {
        for (Long id:vehicleId){
            tbVehicleMapper.vehicleOutPing(branchId,id);
        }
    }

    @Override
    public HashMap tbVehicleSeacherId(Long vehicleId) {
        return tbVehicleMapper.tbVehicleSeacherId(vehicleId);
    }

    @Override
    public Long maxqrcode() {
        return tbVehicleMapper.maxqrcode();
    }

    @Transactional
    @Override
    public void updateTbVehicle(TbVehicle tbVehicle) {
        tbVehicleMapper.updateTbVehicle(tbVehicle);
    }

    @Transactional
    @Override
    public void add(TbVehicle tbVehicle) {
        tbVehicleMapper.insert(tbVehicle);
    }

    @Override
    public List<TbInvoice> findRes(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return tbVehicleMapper.findRes();
    }

    @Override
    public void update(TbVehicle tbVehicle) {

    }

    @Override
    public void del(Integer id) {

    }

    @Override
    public List<HashMap> searchCarPosition(Long companyId,Integer page,Integer size,String userName) {
        PageHelper.offsetPage(page,size);
        return tbVehicleMapper.findCarPosition(companyId,userName);
    }
}
