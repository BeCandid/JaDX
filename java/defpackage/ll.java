package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: AttributeStrategy */
class ll implements lr {
    private final ll$b a = new ll$b();
    private final lp<ll$a, Bitmap> b = new lp();

    ll() {
    }

    public void a(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap a(int width, int height, Config config) {
        return (Bitmap) this.b.a(this.a.a(width, height, config));
    }

    public Bitmap a() {
        return (Bitmap) this.b.a();
    }

    public String b(Bitmap bitmap) {
        return ll.d(bitmap);
    }

    public String b(int width, int height, Config config) {
        return ll.d(width, height, config);
    }

    public int c(Bitmap bitmap) {
        return ri.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    private static String d(Bitmap bitmap) {
        return ll.d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    private static String d(int width, int height, Config config) {
        return "[" + width + "x" + height + "], " + config;
    }
}
