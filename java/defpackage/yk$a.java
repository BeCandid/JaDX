package defpackage;

import java.util.ArrayList;
import java.util.List;

class yk$a extends yk {
    List<yk> p;

    yk$a(List<yk> list) {
        this.p = list;
    }

    public yk a(yk ykVar) {
        List arrayList = new ArrayList(this.p);
        arrayList.add((yk) xz.a((Object) ykVar));
        return new yk$a(arrayList);
    }

    public boolean b(char c) {
        for (yk b : this.p) {
            if (b.b(c)) {
                return true;
            }
        }
        return false;
    }
}
