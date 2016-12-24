package defpackage;

import java.util.Arrays;

class yk$5 extends yk {
    final /* synthetic */ char[] p;

    yk$5(char[] cArr) {
        this.p = cArr;
    }

    public boolean b(char c) {
        return Arrays.binarySearch(this.p, c) >= 0;
    }
}
