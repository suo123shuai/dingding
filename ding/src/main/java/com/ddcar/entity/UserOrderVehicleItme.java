package com.ddcar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class UserOrderVehicleItme extends TbUser implements Serializable {

    private List<TbOrderItem> listOrderItem;

    public List<TbOrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(List<TbOrderItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }
}
