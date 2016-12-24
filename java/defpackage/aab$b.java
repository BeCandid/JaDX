package defpackage;

import java.util.Arrays;

class aab$b extends aab$a {
    private final byte[] a;

    aab$b(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    byte[] c() {
        return this.a;
    }
}
