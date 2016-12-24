package defpackage;

import android.annotation.TargetApi;
import io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class amj extends ThreadPoolExecutor {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = (a + 1);
    private static final int c = ((a * 2) + 1);

    public /* synthetic */ BlockingQueue getQueue() {
        return b();
    }

    <T extends Runnable & amc & amk & amh> amj(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, DependencyPriorityBlockingQueue<T> workQueue, ThreadFactory factory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, factory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & amc & amk & amh> amj a(int corePoolSize, int maxPoolSize) {
        return new amj(corePoolSize, maxPoolSize, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new amj$a(10));
    }

    public static amj a() {
        return amj.a(b, c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new amg(runnable, value);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new amg(callable);
    }

    @TargetApi(9)
    public void execute(Runnable command) {
        if (ami.a((Object) command)) {
            super.execute(command);
        } else {
            super.execute(newTaskFor(command, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable throwable) {
        amk task = (amk) runnable;
        task.b(true);
        task.a(throwable);
        b().d();
        super.afterExecute(runnable, throwable);
    }

    public DependencyPriorityBlockingQueue b() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
