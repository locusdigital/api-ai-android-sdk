package com.speaktoit.ai;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class GsonFactory {

    private static final Gson protocolGson = new GsonBuilder()
            .setDateFormat(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z", Locale.US).toPattern()).create();

    public static Gson getGson(){
        return protocolGson;
    }

}