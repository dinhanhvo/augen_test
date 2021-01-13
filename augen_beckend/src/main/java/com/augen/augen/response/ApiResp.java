package com.augen.augen.response;

import java.util.List;
import java.util.Map;

public class ApiResp {
    private Object data;
    private String errors;
    
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getErrors() {
        return errors;
    }
    public void setErrors(String errors) {
        this.errors = errors;
    }
}
