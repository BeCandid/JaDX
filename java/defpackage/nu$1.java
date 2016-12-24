package defpackage;

/* compiled from: Downsampler */
class nu$1 extends nu {
    nu$1() {
    }

    protected int a(int inWidth, int inHeight, int outWidth, int outHeight) {
        return Math.min(inHeight / outHeight, inWidth / outWidth);
    }

    public String a() {
        return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
    }
}
