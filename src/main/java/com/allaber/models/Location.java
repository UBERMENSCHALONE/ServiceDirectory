package com.allaber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.function.Predicate;

public class Location implements Predicate<House> {

    @JsonProperty("params")
    HashMap<String, Parameter> params;
    @JsonProperty("type")
    String type;

    public Location() {
    }

    public Location(HashMap<String, Parameter> params, String type) {
        this.params = params;
        this.type = type;
    }

    @Override
    public boolean test(House house) {
        HashMap<String, String> houseParams = house.getParams();
        switch (type) {
            case "all":
                return isAll(houseParams);
            case "any":
                return isAny(houseParams);
            case "none":
                return isNone(houseParams);

        }
        return false;
    }

    private boolean isAll(HashMap<String, String> houseParams) {

        if (params.containsKey("cityId")) {
            if (!cityPredicate(params.get("cityId"), houseParams.get("cityId"))) {
                return false;
            }
        }

        if (params.containsKey("streetId")) {
            if (!streetPredicate(params.get("streetId"), houseParams.get("streetId"))) {
                return false;
            }
        }

        return true;
    }

    private boolean isAny(HashMap<String, String> houseParams) {

        return false;
    }

    private boolean isNone(HashMap<String, String> houseParams) {
        if (params.containsKey("cityId")) {
            if (cityPredicate(params.get("cityId"), houseParams.get("cityId"))) {
                return false;
            }
        }

        if (params.containsKey("streetId")) {
            if (streetPredicate(params.get("streetId"), houseParams.get("streetId"))) {
                return false;
            }
        }
        return true;
    }


    private boolean cityPredicate(Parameter parameter, String cityId) {
        switch (parameter.operator) {
            case "contains":
                return parameter.argument.contains(cityId);
        }
        return false;
    }

    private boolean streetPredicate(Parameter parameter, String streetId) {
        switch (parameter.operator) {
            case "contains":
                return parameter.argument.contains(streetId);
        }
        return false;
    }

    public HashMap<String, Parameter> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Parameter> params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}