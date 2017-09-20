package com.lance.demo.java.pattern.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MMSCRouter {
    // 注意 volatile 的使用
    private static volatile MMSCRouter instance = new MMSCRouter();

    private final Map<String, MMSCInfo> routeMap;

    public MMSCRouter() {
        this.routeMap = MMSCRouter.retrieveFromDB();
    }

    private static Map<String, MMSCInfo> retrieveFromDB() {
        return new HashMap<>();
    }

    public static MMSCRouter getInstance() {
        return instance;
    }

    public static void setInstance(MMSCRouter mmscRouter) {
        instance = mmscRouter;
    }

    public MMSCInfo getMMSC(String msisdnPrefix) {
        return routeMap.get(msisdnPrefix);
    }

    private static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> map) {
        Map<String, MMSCInfo> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, map.get(key));
        }
        return result;
    }

    public Map<String, MMSCInfo> getRouteMap() {
        return Collections.unmodifiableMap(deepCopy(routeMap));
    }


}
