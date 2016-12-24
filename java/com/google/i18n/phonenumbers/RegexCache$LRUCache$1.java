package com.google.i18n.phonenumbers;

import defpackage.akd$a;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RegexCache$LRUCache$1 extends LinkedHashMap<K, V> {
    final /* synthetic */ akd$a a;

    public RegexCache$LRUCache$1(akd$a akd_a, int x0, float x1, boolean x2) {
        this.a = akd_a;
        super(x0, x1, x2);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.a.b;
    }
}
