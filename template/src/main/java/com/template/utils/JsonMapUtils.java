package com.template.utils;

import java.util.HashMap;

public class JsonMapUtils {

    public static HashMap<String, Object> mapUtils(int status, String message, Object data) {

        return new HashMap<String, Object>() {{
            put("status", status);
            put("message", message);
            put("data", data);
        }};
    }
}
