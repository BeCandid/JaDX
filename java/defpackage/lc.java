package defpackage;

import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineRunnable;
import com.bumptech.glide.load.engine.EngineRunnable.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: Engine */
public class lc implements le, lh$a, mb$a {
    private final Map<kn, ld> a;
    private final lg b;
    private final mb c;
    private final lc$a d;
    private final Map<kn, WeakReference<lh<?>>> e;
    private final lk f;
    private final lc$b g;
    private ReferenceQueue<lh<?>> h;

    public lc(mb memoryCache, lu$a diskCacheFactory, ExecutorService diskCacheService, ExecutorService sourceService) {
        this(memoryCache, diskCacheFactory, diskCacheService, sourceService, null, null, null, null, null);
    }

    lc(mb cache, lu$a diskCacheFactory, ExecutorService diskCacheService, ExecutorService sourceService, Map<kn, ld> jobs, lg keyFactory, Map<kn, WeakReference<lh<?>>> activeResources, lc$a engineJobFactory, lk resourceRecycler) {
        this.c = cache;
        this.g = new lc$b(diskCacheFactory);
        if (activeResources == null) {
            activeResources = new HashMap();
        }
        this.e = activeResources;
        if (keyFactory == null) {
            keyFactory = new lg();
        }
        this.b = keyFactory;
        if (jobs == null) {
            jobs = new HashMap();
        }
        this.a = jobs;
        if (engineJobFactory == null) {
            engineJobFactory = new lc$a(diskCacheService, sourceService, this);
        }
        this.d = engineJobFactory;
        if (resourceRecycler == null) {
            resourceRecycler = new lk();
        }
        this.f = resourceRecycler;
        cache.a((mb$a) this);
    }

    public <T, Z, R> lc$c a(kn signature, int width, int height, ku<T> fetcher, py<T, Z> loadProvider, kr<Z> transformation, pf<Z, R> transcoder, Priority priority, boolean isMemoryCacheable, DiskCacheStrategy diskCacheStrategy, qg cb) {
        ri.a();
        long startTime = re.a();
        kn key = this.b.a(fetcher.b(), signature, width, height, loadProvider.a(), loadProvider.b(), transformation, loadProvider.d(), transcoder, loadProvider.c());
        lh<?> cached = b(key, isMemoryCacheable);
        if (cached != null) {
            cb.a((lj) cached);
            if (Log.isLoggable("Engine", 2)) {
                lc.a("Loaded resource from cache", startTime, key);
            }
            return null;
        }
        lh<?> active = a(key, isMemoryCacheable);
        if (active != null) {
            cb.a((lj) active);
            if (Log.isLoggable("Engine", 2)) {
                lc.a("Loaded resource from active resources", startTime, key);
            }
            return null;
        }
        ld current = (ld) this.a.get(key);
        if (current != null) {
            current.a(cb);
            if (Log.isLoggable("Engine", 2)) {
                lc.a("Added to existing load", startTime, key);
            }
            return new lc$c(cb, current);
        }
        ld engineJob = this.d.a(key, isMemoryCacheable);
        a aVar = engineJob;
        EngineRunnable engineRunnable = new EngineRunnable(aVar, new lb(key, width, height, fetcher, loadProvider, transformation, transcoder, this.g, diskCacheStrategy, priority), priority);
        this.a.put(key, engineJob);
        engineJob.a(cb);
        engineJob.a(engineRunnable);
        if (Log.isLoggable("Engine", 2)) {
            lc.a("Started new load", startTime, key);
        }
        return new lc$c(cb, engineJob);
    }

    private static void a(String log, long startTime, kn key) {
        Log.v("Engine", log + " in " + re.a(startTime) + "ms, key: " + key);
    }

    private lh<?> a(kn key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        WeakReference<lh<?>> activeRef = (WeakReference) this.e.get(key);
        if (activeRef == null) {
            return null;
        }
        lh<?> active = (lh) activeRef.get();
        if (active != null) {
            active.e();
            return active;
        }
        this.e.remove(key);
        return active;
    }

    private lh<?> b(kn key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        lh<?> cached = a(key);
        if (cached == null) {
            return cached;
        }
        cached.e();
        this.e.put(key, new lc$e(key, cached, a()));
        return cached;
    }

    private lh<?> a(kn key) {
        lj<?> cached = this.c.a(key);
        if (cached == null) {
            return null;
        }
        if (cached instanceof lh) {
            return (lh) cached;
        }
        return new lh(cached, true);
    }

    public void a(lj resource) {
        ri.a();
        if (resource instanceof lh) {
            ((lh) resource).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void a(kn key, lh<?> resource) {
        ri.a();
        if (resource != null) {
            resource.a(key, this);
            if (resource.a()) {
                this.e.put(key, new lc$e(key, resource, a()));
            }
        }
        this.a.remove(key);
    }

    public void a(ld engineJob, kn key) {
        ri.a();
        if (engineJob.equals((ld) this.a.get(key))) {
            this.a.remove(key);
        }
    }

    public void b(lj<?> resource) {
        ri.a();
        this.f.a(resource);
    }

    public void b(kn cacheKey, lh resource) {
        ri.a();
        this.e.remove(cacheKey);
        if (resource.a()) {
            this.c.b(cacheKey, resource);
        } else {
            this.f.a(resource);
        }
    }

    private ReferenceQueue<lh<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new lc$d(this.e, this.h));
        }
        return this.h;
    }
}
