package com.jaylm.mycar.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by ${jaylm}
 * on 2017/12/1.
 */

public class GsonUtils {

    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, type);
    }

    public static <T> ArrayList<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        ArrayList<JsonObject> jsonObjects = gson.fromJson(jsonData, new TypeToken<ArrayList<JsonObject>>() {
        }.getType());


        ArrayList<T> result = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            T t = gson.fromJson(jsonObject, type);
            result.add(t);
        }
        return result;
    }
}
