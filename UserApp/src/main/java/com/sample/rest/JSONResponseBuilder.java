package com.sample.rest;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hvaswani on 11/11/2015.
 */
public class JSONResponseBuilder {

    public static String getJSONResponse(String status, String message, Object payload) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("message", message);
        map.put("payload", payload);
        return new Gson().toJson(map);
    }
}
