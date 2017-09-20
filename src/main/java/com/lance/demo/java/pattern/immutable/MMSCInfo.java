package com.lance.demo.java.pattern.immutable;

import lombok.Getter;

@Getter
public class MMSCInfo {
    private final String deviceID;

    private final String url;

    private final int maxAttachSizeInBytes;

    public MMSCInfo(String deviceID, String url, int maxAttachSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttachSizeInBytes = maxAttachSizeInBytes;
    }

    public MMSCInfo(MMSCInfo prototype) {
        this.deviceID = prototype.deviceID;
        this.url = prototype.url;
        this.maxAttachSizeInBytes = prototype.maxAttachSizeInBytes;
    }

}
