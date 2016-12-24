package defpackage;

/* compiled from: TrampolineScheduler */
public final class asq extends apo {
    private static final asq b = new asq();

    public static asq a() {
        return b;
    }

    public apo$a createWorker() {
        return new asq$a();
    }

    asq() {
    }

    static int a(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }
}
