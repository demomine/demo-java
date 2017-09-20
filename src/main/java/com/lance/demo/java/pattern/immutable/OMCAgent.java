package com.lance.demo.java.pattern.immutable;

import java.util.Map;

public class OMCAgent extends Thread {
    @Override
    public void run() {
        boolean isTableModification = false;
        String updatedTableName = null;

        while (true) {
            /**
             * 读取socket判断是否变更了配置如果变更 isTableModification 设置为true
             */
            MMSCRouter mmscRouter = MMSCRouter.getInstance();
            Map<String, MMSCInfo> routeMap = mmscRouter.getRouteMap();
            routeMap.put("", new MMSCInfo("","",0));
            // mmscRouter.setInstance(routeMap);
            isTableModification = true;
            if (isTableModification) {
                if ("MMSCInfo".equals(updatedTableName)) {
                    MMSCRouter.setInstance(mmscRouter);
                }
                isTableModification = false;
            }
        }
    }
}
