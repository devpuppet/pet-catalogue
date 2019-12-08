package com.kkukielka.petcatalogueweb.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {

    private Gson gson;
    private GsonBuilder gsonBuilder;

    public GsonHelper() {
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder
                .setPrettyPrinting()
                .create();
    }

    public <T> String toJson(T object) {
        return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

}
