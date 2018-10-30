package com.ddcar.mapper;

import com.ddcar.entity.TbInvoice;
import com.ddcar.entity.TbPrice;
import com.ddcar.entity.TbVehicle;
import com.ddcar.entity.Vehicles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TbVehicleMapper {

    List<TbVehicle> findTbVehicleList(@Param("brandId")Long brandId, @Param("modelType")Integer modelType,@Param("branchName")String branchName,@Param("vehicleId")Long vehicleId,@Param("state")Integer state,@Param("start")String start,@Param("end")String end,@Param("ks")String ks,@Param("js")String js);
    List<TbVehicle> findList(@Param("brandId")Long brandId, @Param("modelType")Integer modelType,@Param("branchName")String branchName,@Param("vehicleId")Long vehicleId,@Param("state")Integer state);

    List<TbVehicle> exal(@Param("brandId")Long brandId, @Param("modelType")Integer modelType,@Param("branchId")Long branchId,@Param("branchName")String branchName);

    List<TbVehicle> findTbVehiclebranchList(Integer page, Integer size, Integer modelId);
    //分公司查询没有入库的车电
    List<TbVehicle> ruTbVehicleList(@Param("branchId")Long branchId,@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("wangUserId")Integer wangUserId,@Param("source")Integer source,@Param("vehicleId")Integer vehicleId,@Param("state")Integer state);
    //查询分公司已入库的车电
    List<HashMap> okTbVehicleList(@Param("branchId")Long branchId,@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("branchName")String branchName,@Param("state")String state,@Param("tName")Integer tName,@Param("start")String start,@Param("end")String end,@Param("ks")String ks,@Param("js")String js);
    List<HashMap> okveh(@Param("branchId")Long branchId,@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("wangUserId")Integer wangUserId,@Param("branchName")String branchName,@Param("vehicleId")Long vehicleId,@Param("state")String state,@Param("tName")Integer tName);
    List<HashMap> okTbVehicleListout(@Param("branchId")Long branchId,@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("wangUserId")Integer wangUserId,@Param("branchName")String branchName,@Param("vehicleId")Long vehicleId,@Param("state")String state,@Param("tName")Integer tName);
    List<HashMap> ifoutwang(@Param("branchId")Long branchId,@Param("branchIds")Long branchIds,@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("wangUserId")Integer wangUserId,@Param("branchName")String branchName,@Param("vehicleId")Long vehicleId,@Param("state")String state,@Param("tName")Integer tName);
    //查询该车电是否是未出库出库的不可删除
    Integer ifout(@Param("vehicleId")long vehicleId);
    //查询是否有重复车架号
    Integer ifvin(@Param("vin")String vin);
    //查询是否有重复Gps号(如果这辆车删除只够gsp还是可用)
    Integer ifgps(@Param("gpsNumber")String gpsNumber);
    //查询是否有重复车架号
    Integer ifserial(@Param("serialNumber")String serialNumber);
    //分公司入库
    void completedRk(@Param("vehicleId") Long vehicleId);
    //删除车电
    void delTbVehicle(@Param("vehicleId") Long vehicleId);
    //分公司退回的车电再入库
    void comreturmTbVehicle(@Param("vehicleId") Long vehicleId);
    //可租
    void updatestateOk(@Param("vehicleId") Long vehicleId);
    //维修
    void updatestateRepair(@Param("vehicleId") Long vehicleId);
    //停用
    void updatestateokStop(@Param("vehicleId") Long vehicleId);
    //出库到分公司
    void vehicleOutCom(@Param("branchId") Long branchId,@Param("vehicleId") Long vehicleId);
    //出库到网点
    void vehicleOutWang(@Param("wangUserId") Long wangUserId,@Param("vehicleId") Long vehicleId,@Param("priceId") Long priceId);
    //根据id查询车辆信息
    HashMap tbVehicleSeacherId(Long vehicleId);
    //网点退回的分公司再入库
    void completedRe(@Param("vehicleId") Long vehicleId);
    //出库到平台
    void vehicleOutPing(@Param("branchId") Long branchId,@Param("vehicleId") Long vehicleId);
    //网点退回的车电
    List<TbVehicle> wangReturnTbVehicleList(@Param("branchId")Long branchId,@Param("brandId")Long brandId,@Param("modelType")Integer modelType,@Param("serialNumber")String serialNumber);
    //查出最大编号的qrcode的最大值
    Long maxqrcode();

    int deleteByPrimaryKey(Long vehicleId);

    int insert(TbVehicle record);
    //该公司车电发票查询
    List<TbInvoice> findRes();
//    //insert
//    int insertSelective(TbVehicle record);

    /**
     * 查询用户名下的租凭详细
     * @param userId
     * @return
     */
    List<Vehicles> selectByUserId(long userId);
    //编辑车电信息
    int updateTbVehicle(TbVehicle tbVehicle);
    //修改价格id
    int upveh(TbPrice tbPrice);
    //分公司退回的车电
    List<HashMap> returnTbVehicleList(@Param("branchId") Integer branchId,@Param("branchName") String branchName);


    int updateByPrimaryKeySelective(TbVehicle record);

    int updateByPrimaryKey(TbVehicle record);

    int branchVehicleCount(Map map);

    /**
     * 车电的更新
     * @param map
     * @return
     */
    int updVehicle(Map map);

    /**
     * 查询车电信息根据二维码
     * @param qrCode
     * @return
     */
    TbVehicle findVehicle(String qrCode);

    /**
     * 查询网点所有的车电
     * @param map
     * @return
     */
    List<Vehicles> findUserVehicle(Map map);

    /**
     * g根据车电id查询车电详情
     * @param vehicleId
     * @return
     */
    Vehicles findUserVehicleParticular(long vehicleId);
    //查询平台没有出库的车电
    List<TbVehicle> noOutTbVehicleList(@Param("brandId")Integer brandId,@Param("modelType")Integer modelType,@Param("vehicleId")Integer vehicleId);

    /**
     * 根据二维码查车电详情
     * @param map
     * @return
     */
    Vehicles getVehicleByqrCode(Map map);

    /**
     *
     * @param userId
     * @return
     */
    List<Vehicles> findRiderVehicle(long userId);

    /**
     * 网点出库更新
     * @param map
     * @return
     */
    int updInOut(Map map);

    /**
     * 网点出库车电列表查询
     * @param wangUserId
     * @return
     */
    int outWarehouse(long wangUserId);

    /**
     * 多个id查车电的价格
     * @param ids
     * @return
     */
    List<Vehicles> findprice(String[] ids);

    /**   查询车辆位置
     * @author ZhangXuanWei
     * @date 2018/9/20 15:53
     * @param companyId
     * @return java.util.List<java.util.HashMap>
     */
    List<HashMap> findCarPosition(@Param("companyId") Long companyId,@Param("userName") String userName);

    /**
     * 查车电
     * @param userId 用户id
     * @return
     */
    List<TbVehicle> listUserVehicleByUserId(long userId);

    /**
     * 更新车电信息状态
     * @param map
     * @return
     */
    int updateVehicleAll(TbVehicle vehicle);

    /**
     * 退租后车电的更新
     * @param ids
     * @return
     */
    int updateWithdrawalStatus(long userId);

    /**
     * 退租车电金额
     * @param ids
     * @return
     */
    Double getDeposit(String[] ids);

    /**
     * 用户id和车电二维码查车电
     * @param map
     * @return
     */
    TbVehicle getVehicleByUserIdAndVehicleId(Map map);

    List<Vehicles> getUsetV(Map map);

    /**
     * id查车电
     * @param vehicleId
     * @return
     */
    TbVehicle findVehicleById(Long vehicleId);

    Double findModalPriceByModeIdBranchId(HashMap vehicle);

    Long findPriceIdByvehicleId(Long id);

    /**
     * 用户租凭的车电
     * @param userId
     * @return
     */
    List<Vehicles> findUserVehicleInformation(Long userId);

    /**
     * 查询网点id
     * @param userId
     * @return
     */
    long findUserWangId(long userId);
}