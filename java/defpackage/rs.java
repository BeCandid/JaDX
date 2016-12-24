package defpackage;

import java.io.File;
import java.util.List;

/* compiled from: AnswersRetryFilesSender */
class rs implements amv {
    private final se a;
    private final sb b;

    public static rs a(se filesSender) {
        return new rs(filesSender, new sb(new amp(new sa(new amn(1000, 8), 0.1d), new amm(5))));
    }

    rs(se filesSender, sb retryManager) {
        this.a = filesSender;
        this.b = retryManager;
    }

    public boolean a(List<File> files) {
        long currentNanoTime = System.nanoTime();
        if (!this.b.a(currentNanoTime)) {
            return false;
        }
        if (this.a.a(files)) {
            this.b.a();
            return true;
        }
        this.b.b(currentNanoTime);
        return false;
    }
}
