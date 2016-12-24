package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DiskLruCache */
final class ka$b {
    File[] a;
    File[] b;
    final /* synthetic */ ka c;
    private final String d;
    private final long[] e;
    private boolean f;
    private ka$a g;
    private long h;

    private ka$b(ka kaVar, String key) {
        this.c = kaVar;
        this.d = key;
        this.e = new long[kaVar.h];
        this.a = new File[kaVar.h];
        this.b = new File[kaVar.h];
        StringBuilder fileBuilder = new StringBuilder(key).append('.');
        int truncateTo = fileBuilder.length();
        for (int i = 0; i < kaVar.h; i++) {
            fileBuilder.append(i);
            this.a[i] = new File(kaVar.b, fileBuilder.toString());
            fileBuilder.append(".tmp");
            this.b[i] = new File(kaVar.b, fileBuilder.toString());
            fileBuilder.setLength(truncateTo);
        }
    }

    public String a() throws IOException {
        StringBuilder result = new StringBuilder();
        for (long size : this.e) {
            result.append(' ').append(size);
        }
        return result.toString();
    }

    private void a(String[] strings) throws IOException {
        if (strings.length != this.c.h) {
            throw b(strings);
        }
        int i = 0;
        while (i < strings.length) {
            try {
                this.e[i] = Long.parseLong(strings[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strings);
            }
        }
    }

    private IOException b(String[] strings) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strings));
    }

    public File a(int i) {
        return this.a[i];
    }

    public File b(int i) {
        return this.b[i];
    }
}
