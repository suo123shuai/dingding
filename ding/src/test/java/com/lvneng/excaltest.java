/*
package com.lvneng;

import com.ddcar.entity.TbVehicle;
import com.ddcar.util.ExcelUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


*/
/**
 * Created by Administrator on 2018-09-20.
 *//*

public class excaltest {

    public static void main(String[] args) {
        String sheetTitle = "车电信息";
        String[] title = {"品牌","车/电", "型号",};

        List<TbVehicle> list = new ArrayList<TbVehicle>();

        for(int i=0;i<5;i++){
            TbVehicle vehicle = new TbVehicle();
            vehicle.setSerialNumber("12222");
            vehicle.setVehicleId((long) 1);
            vehicle.setVin("车架号");
            list.add(vehicle);
        }

        byte b[] = ExcelUtil.export(sheetTitle, title, list);

        File f = new File("E:\\tmp\\"+sheetTitle+".xls");
        try {
            FileUtils.writeByteArrayToFile(f, b, true);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
*/
