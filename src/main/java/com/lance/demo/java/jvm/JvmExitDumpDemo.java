package com.lance.demo.java.jvm;

public class JvmExitDumpDemo {
    /**
     * -XX:ErrorFile=/data/appLogs/hs_err_log.log
     * @throws Exception
     */
    public void dump() throws Exception {
        Thread.sleep(10000L);
        throw new Exception("error");
    }

    public static void main(String[] args) throws Exception {
        Thread.sleep(10000L);
        throw new Exception("error");
    }
}
