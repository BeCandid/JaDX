package com.facebook.share.internal;

import defpackage.vj;

public enum OpenGraphMessageDialogFeature implements vj {
    OG_MESSAGE_DIALOG(20140204);
    
    private int b;

    private OpenGraphMessageDialogFeature(int minVersion) {
        this.b = minVersion;
    }

    public String a() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    public int b() {
        return this.b;
    }
}
