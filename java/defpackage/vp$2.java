package defpackage;

import java.io.File;

/* compiled from: FileLruCache */
class vp$2 implements Runnable {
    final /* synthetic */ File[] a;
    final /* synthetic */ vp b;

    vp$2(vp this$0, File[] fileArr) {
        this.b = this$0;
        this.a = fileArr;
    }

    public void run() {
        for (File file : this.a) {
            file.delete();
        }
    }
}
