package defpackage;

import android.util.DisplayMetrics;

/* compiled from: MemorySizeCalculator */
class mc$a implements mc$b {
    private final DisplayMetrics a;

    public mc$a(DisplayMetrics displayMetrics) {
        this.a = displayMetrics;
    }

    public int a() {
        return this.a.widthPixels;
    }

    public int b() {
        return this.a.heightPixels;
    }
}
