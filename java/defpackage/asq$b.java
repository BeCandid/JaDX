package defpackage;

/* compiled from: TrampolineScheduler */
final class asq$b implements Comparable<asq$b> {
    final apy a;
    final Long b;
    final int c;

    public /* synthetic */ int compareTo(Object x0) {
        return a((asq$b) x0);
    }

    asq$b(apy action, Long execTime, int count) {
        this.a = action;
        this.b = execTime;
        this.c = count;
    }

    public int a(asq$b that) {
        int result = this.b.compareTo(that.b);
        if (result == 0) {
            return asq.a(this.c, that.c);
        }
        return result;
    }
}
