package defpackage;

import java.io.File;
import java.io.IOException;

/* compiled from: CrashlyticsFileMarker */
class tb {
    private final String a;
    private final ang b;

    public tb(String markerName, ang fileStore) {
        this.a = markerName;
        this.b = fileStore;
    }

    public boolean a() {
        boolean wasCreated = false;
        try {
            wasCreated = d().createNewFile();
        } catch (IOException e) {
            akx.h().e("CrashlyticsCore", "Error creating marker: " + this.a, e);
        }
        return wasCreated;
    }

    public boolean b() {
        return d().exists();
    }

    public boolean c() {
        return d().delete();
    }

    private File d() {
        return new File(this.b.a(), this.a);
    }
}
