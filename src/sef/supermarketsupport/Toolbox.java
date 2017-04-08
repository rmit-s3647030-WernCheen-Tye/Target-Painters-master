package sef.supermarketsupport;

import com.google.gson.Gson;

/**
 * Created by ngocbeo1121 on 5/12/16.
 */
public class Toolbox {

    private static Gson defaultGson;

    static {
        defaultGson = new Gson();
    }

    public static Gson getDefaultGson() {
        return defaultGson;
    }

}
