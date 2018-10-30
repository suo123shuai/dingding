package com.ddcar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"handler"})
public class UserVehicleParticular extends TbVehicle implements Serializable {


    private String userName;

    private TbModelNumber modelNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public TbModelNumber getModelNumber() {
        return modelNumber;
    }

    @Override
    public void setModelNumber(TbModelNumber modelNumber) {
        this.modelNumber = modelNumber;
    }
}

