package com.ddcar.service.impl;

import com.ddcar.entity.TbBranch;
import com.ddcar.entity.TbManager;
import com.ddcar.mapper.TbBranchMapper;
import com.ddcar.service.TbBranchService;
import com.ddcar.service.TbManagerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
@Service
public class TbBranchServiceImpl implements TbBranchService{

    @Autowired(required = false)
    TbBranchMapper tbBranchMapper;
    @Autowired(required = false)
    TbManagerService tbManagerService;

    @Override
    public List<TbBranch> findTbBranchMapperList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return tbBranchMapper.findTbBranchList(page,size);
    }

    @Override
    public List<TbBranch> findTbBranchbranchList(Integer page, Integer size,Integer branchId,String branchName,Integer websiteType) {
        PageHelper.startPage(page,size);
        return tbBranchMapper.findTbBranchbranchList(branchId,branchName,websiteType);
    }

    @Override
    public Integer ifbranchName(String userName) {
        return tbBranchMapper.ifbranchName(userName);
    }

    @Override
    public Long maxqrcode() {
        return tbBranchMapper.maxqrcode();
    }

    @Override
    public Integer ifdelcom(long parentId) {
        return tbBranchMapper.ifdelcom(parentId);
    }

    @Override
    public Integer ifdeltuan(long branchId) {
        return tbBranchMapper.ifdeltuan(branchId);
    }

    @Override
    public Integer ifdeltv(long branchId) {
        return tbBranchMapper.ifdeltv(branchId);
    }

    @Override
    public Integer ifdelwtv(long wangUserId) {
        return tbBranchMapper.ifdelwtv(wangUserId);
    }

    @Override
    public List<TbBranch> findTbBranchbranchList(Integer branchId,String branchName,Integer websiteType) {
        return tbBranchMapper.findTbBranchbranchList(branchId,branchName,websiteType);
    }

    @Override
    public List<TbBranch> selectcomWang(Long parentId,Integer page, Integer size,Integer websiteType,Long branchId,String branchName) {
        PageHelper.startPage(page,size);
        return tbBranchMapper.selectcomWang(parentId,websiteType,branchId,branchName);
    }

    @Override
    public List<TbBranch> wout(Long parentId, Integer page, Integer size, Integer websiteType, Long branchId, String branchName) {
        PageHelper.startPage(page,size);
        return tbBranchMapper.wout(parentId,websiteType,branchId,branchName);
    }

    @Override
    public List<TbBranch> filWang(Long parentId) {
        return tbBranchMapper.filWang(parentId);
    }

    @Override
    public List<TbBranch> wang(Long branchId) {
        return tbBranchMapper.wang(branchId);
    }

    @Override
    public List<TbBranch> fen() {
        return tbBranchMapper.fen();
    }

    @Override
    public List<TbBranch> Wang(Long parentId,Integer websiteType,Long branchId,String branchName) {
        return tbBranchMapper.selectcomWang(parentId,websiteType,branchId,branchName);
    }

    @Transactional
    @Override
    public void add(TbBranch tbBranch) {
        tbBranchMapper.insertSelective(tbBranch);
    }

    @Transactional
    @Override
    public void insertDot(TbBranch tbBranch) {
        tbBranchMapper.insertDot(tbBranch);
    }

    @Transactional
    @Override
    public void update(TbBranch tbBranch) {
        tbBranchMapper.updateTbBranch(tbBranch);
    }

    @Transactional
    @Override
    public void updateDot(TbBranch tbBranch) {
        tbBranchMapper.updateDot(tbBranch);
    }

    @Transactional
    @Override
    public void delTbBranch(Long[] branchId) {
        for (Long id:branchId){
            tbBranchMapper.delTbBranch(id);
        }
    }

    @Transactional
    @Override
    public void enable(Long[] branchId) {
        for (Long id:branchId){
            tbBranchMapper.enable(id);
        }
    }

    @Transactional
    @Override
    public void close(Long[] branchId) {
        for (Long id:branchId){
            tbBranchMapper.close(id);
        }
    }

    @Override
    public TbBranch branchSearchId(Long branchId) {
        return tbBranchMapper.branchSearchId(branchId);
    }

    @Override
    public HashMap allsum(Long branchId) {
        return tbBranchMapper.allSum(branchId);
    }

    @Override
    public HashMap monthSum(Long branchId) {
        return tbBranchMapper.monthSum(branchId);
    }

    @Override
    public HashMap exitSum(Long branchId) {
        return tbBranchMapper.exitSum(branchId);
    }

    @Override
    public HashMap qyj(Long branchId) {
        return tbBranchMapper.qyj(branchId);
    }

    @Override
    public HashMap qzj(Long branchId) {
        return tbBranchMapper.qzj(branchId);
    }

    @Override
    public HashMap qbj(Long branchId) {
        return tbBranchMapper.qbj(branchId);
    }

    @Override
    public HashMap qzc(Long branchId) {
        return tbBranchMapper.qzc(branchId);
    }

    @Override
    public HashMap byj(Long branchId) {
        return tbBranchMapper.byj(branchId);
    }

    @Override
    public HashMap bzj(Long branchId) {
        return tbBranchMapper.bzj(branchId);
    }

    @Override
    public HashMap bbj(Long branchId) {
        return tbBranchMapper.bbj(branchId);
    }

    @Override
    public HashMap bzc(Long branchId) {
        return tbBranchMapper.bzc(branchId);
    }

    @Override
    public void del(Integer id) {

    }

    @Override
    public HashMap searchCompanyPosition(Long branchId) {
        return tbBranchMapper.findCompanyPosition(branchId);
    }
}
