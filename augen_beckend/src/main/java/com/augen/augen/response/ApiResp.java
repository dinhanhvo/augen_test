package com.augen.augen.response;

import java.util.List;
import java.util.Map;

public class ApiResp {
    
    private Object data;
    private List<RestError> errors;
    
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public List<RestError> getErrors() {
        return errors;
    }
    public void setErrors(List<RestError> errors) {
        this.errors = errors;
    }
    
}
