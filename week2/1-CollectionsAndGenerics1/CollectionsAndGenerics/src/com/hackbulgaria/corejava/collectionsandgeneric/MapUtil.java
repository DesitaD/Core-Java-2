package com.hackbulgaria.corejava.collectionsandgeneric;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static String mapToString(Map<String, String> map) {

        StringBuilder stringBuilder = new StringBuilder();

        for (String key : map.keySet()) {

            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }

            String value = map.get(key);
            try {
                stringBuilder.append((key != null ? URLEncoder.encode(key, "UTF-8") : ""));

                stringBuilder.append("=");
                stringBuilder.append(value != null ? URLEncoder.encode(value, "UTF-8") : "");
            } catch (UnsupportedEncodingException e) {

                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }

        }

        return stringBuilder.toString();
    }
}