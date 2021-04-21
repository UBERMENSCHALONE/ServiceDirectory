package com.allaber;

import com.allaber.models.House;

import java.util.HashMap;

public class ERP {

    public static House getHouse(){
        HashMap<String, String> params = new HashMap<>();
        params.put("cityId", "1");
        params.put("streetId", "1");

        House house = new House(params);
        return house;
    }
}