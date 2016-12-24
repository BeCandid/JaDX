package defpackage;

/* compiled from: NativeProtocol */
class vz$1 implements Runnable {
    vz$1() {
    }

    public void run() {
        try {
            for (vz$c appInfo : vz.b) {
                appInfo.a(true);
            }
        } finally {
            vz.d.set(false);
        }
    }
}
