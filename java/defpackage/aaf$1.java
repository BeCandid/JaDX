package defpackage;

import java.util.Iterator;

class aaf$1 implements aai<T> {
    final /* synthetic */ aaf a;

    aaf$1(aaf aaf) {
        this.a = aaf;
    }

    public void a(T t) {
        this.a.a = t;
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aaf$a) it.next()).a(this.a.a);
        }
        this.a.c.clear();
        this.a.b = null;
    }
}
