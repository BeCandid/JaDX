package defpackage;

/* compiled from: Downsampler */
class nu$2 extends nu {
    nu$2() {
    }

    protected int a(int inWidth, int inHeight, int outWidth, int outHeight) {
        int i = 1;
        int maxIntegerFactor = (int) Math.ceil((double) Math.max(((float) inHeight) / ((float) outHeight), ((float) inWidth) / ((float) outWidth)));
        int lesserOrEqualSampleSize = Math.max(1, Integer.highestOneBit(maxIntegerFactor));
        if (lesserOrEqualSampleSize >= maxIntegerFactor) {
            i = 0;
        }
        return lesserOrEqualSampleSize << i;
    }

    public String a() {
        return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }
}
