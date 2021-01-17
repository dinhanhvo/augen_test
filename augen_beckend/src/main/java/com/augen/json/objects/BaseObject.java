package com.augen.json.objects;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseObject {
	public String toJsonString() {
        String ret = "";
        ObjectMapper om = new ObjectMapper();
        try {
            ret = om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LogManager.getLogger(this).trace(e.getMessage(), e);

        }
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        ObjectMapper om = new ObjectMapper();
        try {
            ret = om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LogManager.getLogger(this).trace(e.getMessage(), e);

        }
        return ret;
    }
}
