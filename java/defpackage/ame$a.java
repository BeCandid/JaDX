package defpackage;

import java.util.concurrent.Executor;

/* compiled from: PriorityAsyncTask */
class ame$a<Result> implements Executor {
    private final Executor a;
    private final ame b;

    public ame$a(Executor ex, ame task) {
        this.a = ex;
        this.b = task;
    }

    public void execute(Runnable command) {
        this.a.execute(new ame$a$1(this, command, null));
    }
}
