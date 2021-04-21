package com.allaber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {

    @JsonProperty("operator")
    String operator;
    @JsonProperty("argument")
    String argument;

    public Parameter() {
    }

    public Parameter(String operator, String argument) {
        this.operator = operator;
        this.argument = argument;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}