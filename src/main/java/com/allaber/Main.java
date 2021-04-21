package com.allaber;

import com.allaber.jackson.Converter;
import com.allaber.models.House;
import com.allaber.models.Location;
import com.allaber.models.Parameter;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        House house = ERP.getHouse();
        HashMap<String, Parameter> params = new HashMap<>();
        params.put("cityId", new Parameter("contains", "2"));
        params.put("streetId", new Parameter("contains", "2"));


        Location location = new Location(params, "all");

        if (location.test(house)) {
            System.out.println("Уфа");
        } else {
            System.out.println("Локация не определена");
        }

        String s1 = toJsonTest(location);
        Location locationUfa = toJavaObjectTest(s1);

        System.out.println(locationUfa.getType());
        String s2 = toJsonTest(locationUfa);


    }

    private static String toJsonTest(Location location) {
        String s = null;
        Converter converter = new Converter();
        try {
            s = converter.toJSON(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private static Location toJavaObjectTest(String s) {
        Converter converter = new Converter();
        Location location = null;
        try {
            location = converter.toJavaObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }
}