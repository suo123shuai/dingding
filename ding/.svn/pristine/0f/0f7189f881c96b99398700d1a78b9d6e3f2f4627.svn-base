package com.ddcar.mapper;

import com.ddcar.entity.AccountFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountFlowMapper {

    /**
     * 添加流水信息
     * @param accountFlow
     * @return
     */
    Integer saveFlow(AccountFlow accountFlow);

    /**
     * 网点查看流水信息
     * @param wangUserId
     * @return
     */
    List<AccountFlow> findWangFlow(Long wangUserId);

    /**
     * 网点的总收入支出金额明细
     * @param wangUserId
     * @return
     */
    Map incomeTotal(Long wangUserId);

    /**
     * 本月网点的的收支金额明细
     * @param wangUserId
     * @return
     */
    Map expenditureTotal(Long wangUserId);
}
