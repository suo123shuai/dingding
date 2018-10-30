package com.ddcar.mapper;


import com.ddcar.entity.TbBranch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TbBranchMapper {
    //???
    List<TbBranch> findTbBranchList(Integer page,Integer size);
    //查询分公司
    List<TbBranch> findTbBranchbranchList(@Param("branchId")Integer branchId, @Param("branchName")String branchName,@Param("websiteType")Integer websiteType);
    //查询该公司的所有网点
    List<TbBranch> selectcomWang(@Param("parentId")Long parentId,@Param("websiteType")Integer websiteType,@Param("branchId")Long branchId,@Param("branchName")String branchName);
    List<TbBranch> wout(@Param("parentId")Long parentId,@Param("websiteType")Integer websiteType,@Param("branchId")Long branchId,@Param("branchName")String branchName);
    List<TbBranch> filWang(@Param("parentId")Long parentId);
    List<TbBranch> wang(@Param("branchId")Long branchId);
    //查询该分公司下是否有网点
    Integer ifdelcom(@Param("parentId")long parentId);
    Integer ifdeltuan(@Param("branchId")long branchId);
    Integer ifdeltv(@Param("branchId")long branchId);
    Integer ifdelwtv(@Param("wangUserId")long wangUserId);

    List<TbBranch> fen();
    //查询库里是否有该用户名
    Integer ifbranchName(@Param("userName")String userName);
    //查询
    List<TbBranch> Wang(@Param("parentId")Long parentId);
    //查出最大编号的最大值
    Long maxqrcode();
    //删除分公司delTbBranch
    void delTbBranch(@Param("branchId") Long branchId);
    //启用
    void enable(@Param("branchId") Long branchId);
    //关停
    void close(@Param("branchId") Long branchId);
    //废弃
    int deleteByPrimaryKey(Long branchId);
    //添加分公司
    int insert(TbBranch tbBranch);
    //添加网点
    int insertDot(TbBranch tbBranch);

    int insertSelective(TbBranch record);
    //id查询
    TbBranch branchSearchId(Long branchId);
    //全部收益合计
    HashMap allSum(Long branchId);
    //本月收益合计
    HashMap monthSum(Long branchId);
    //本月支出合计
    HashMap exitSum(Long branchId);

    //全部
    HashMap qyj(Long branchId);
    HashMap qzj(Long branchId);
    HashMap qbj(Long branchId);
    HashMap qzc(Long branchId);
    //本月
    HashMap byj(Long branchId);
    HashMap bzj(Long branchId);
    HashMap bbj(Long branchId);
    HashMap bzc(Long branchId);


    //修改分公司信息
    int updateTbBranch(TbBranch record);
    //编辑网点信息
    int updateDot(TbBranch tbBranch);

    TbBranch selectByPrimaryKey(Long branchId);

    int updateByPrimaryKeySelective(TbBranch record);

    int updateByPrimaryKey(TbBranch record);

    /**
     * 所有网点信息
     * @param items
     * @return
     * @throws Exception
     */
    List<TbBranch> listBranch(Map map);

    /**
     * 查询网点信息和距离
     * @param map
     * @return
     */
    List<TbBranch> lingVehicleJvli(Map map);

    /**
     * 网点登陆
     * @param map
     * @return
     */
    TbBranch loginUser(Map map);

    /**
     * 网点二维码
     * @param userId
     * @return
     */
    String fiindUserQrCode(long userId);

    /**
     * 查分公司的折扣价格
     * @param branchId
     * @return
     */
    TbBranch findDiscount(long branchId);

    //查询分公司坐标
    HashMap findCompanyPosition(Long branchId);

    /**
     * 二维码查网点id
     * @param qrCode
     * @return
     */
    Map qrCodeGetBranchId(String qrCode);

    /**
     *  网点id查分公司id
     */
    Long findBranchId(Long branchId);
}