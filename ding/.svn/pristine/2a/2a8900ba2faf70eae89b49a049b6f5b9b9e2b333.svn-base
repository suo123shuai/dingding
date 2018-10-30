package com.ddcar.mapper;


import com.ddcar.entity.TbInvoice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbInvoiceMapper {
    int deleteByPrimaryKey(Long invoiceId);

    int insert(TbInvoice record);

    int insertSelective(TbInvoice record);

    TbInvoice selectByPrimaryKey(Long invoiceId);

    int updateByPrimaryKeySelective(TbInvoice record);

    int updateByPrimaryKey(TbInvoice record);
}