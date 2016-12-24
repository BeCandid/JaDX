package defpackage;

import android.content.Context;
import java.io.File;

/* compiled from: FileStoreImpl */
public class anh implements ang {
    private final Context a;
    private final String b;
    private final String c;

    public anh(alc kit) {
        if (kit.E() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = kit.E();
        this.b = kit.G();
        this.c = "Android/" + this.a.getPackageName();
    }

    public File a() {
        return a(this.a.getFilesDir());
    }

    File a(File file) {
        if (file == null) {
            akx.h().a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            akx.h().d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
