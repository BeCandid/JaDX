package defpackage;

import java.util.Comparator;

/* compiled from: EventsFilesManager */
class amr$1 implements Comparator<amr$a> {
    final /* synthetic */ amr a;

    amr$1(amr amr) {
        this.a = amr;
    }

    public /* synthetic */ int compare(Object x0, Object x1) {
        return a((amr$a) x0, (amr$a) x1);
    }

    public int a(amr$a arg0, amr$a arg1) {
        return (int) (arg0.b - arg1.b);
    }
}
