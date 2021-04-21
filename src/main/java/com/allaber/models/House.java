package com.allaber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class House {
    @JsonProperty("params")
    HashMap<String, String> params;

    public House() {
    }

    public House(HashMap<String, String> params) {
        this.params = params;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
}