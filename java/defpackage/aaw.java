package defpackage;

import java.io.IOException;

public final class aaw {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    static int a(int i) {
        return i & 7;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(aas aas, int i) throws IOException {
        return aas.b(i);
    }

    public static int b(int i) {
        return i >>> 3;
    }

    public static final int b(aas aas, int i) throws IOException {
        int i2 = 1;
        int p = aas.p();
        aas.b(i);
        while (aas.a() == i) {
            aas.b(i);
            i2++;
        }
        aas.e(p);
        return i2;
    }
}
