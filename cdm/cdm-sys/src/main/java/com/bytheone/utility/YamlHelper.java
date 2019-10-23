package com.bytheone.utility;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class YamlHelper {

    public static Map getMap(String filePath) {
        File ymalFile = new File(filePath);
        Map map = null;
        try {
            map = Yaml.loadType(ymalFile, HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static String getMapValue(Map map, String key) {
        String value = null;
        if (map != null && map.containsKey(key)) {
            value = map.get(key) != null ? map.get(key).toString() : "";
        }
        return value;
    }

    public static Map getMapDict(Map map, String key) {
        Map dict = null;
        if (map != null && map.containsKey(key)) {
            dict = map.get(key) != null ? (Map) map.get(key) : null;
        }
        return dict;

    }

}
