package defpackage;

import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileLruCache */
public final class vp {
    static final String a = vp.class.getSimpleName();
    private static final AtomicLong b = new AtomicLong();
    private final String c;
    private final vp$d d;
    private final File e;
    private boolean f;
    private boolean g;
    private final Object h;
    private AtomicLong i = new AtomicLong(0);

    public vp(String tag, vp$d limits) {
        this.c = tag;
        this.d = limits;
        this.e = new File(ul.m(), tag);
        this.h = new Object();
        if (this.e.mkdirs() || this.e.isDirectory()) {
            vp$a.a(this.e);
        }
    }

    public InputStream a(String key) throws IOException {
        return a(key, null);
    }

    public InputStream a(String key, String contentTag) throws IOException {
        File file = new File(this.e, we.b(key));
        try {
            FileInputStream input = new FileInputStream(file);
            BufferedInputStream buffered = new BufferedInputStream(input, 8192);
            try {
                JSONObject header = vp$g.a(buffered);
                FileInputStream fileInputStream;
                if (header == null) {
                    fileInputStream = input;
                    return null;
                }
                String foundKey = header.optString("key");
                if (foundKey == null || !foundKey.equals(key)) {
                    if (null == null) {
                        buffered.close();
                    }
                    fileInputStream = input;
                    return null;
                }
                String headerContentTag = header.optString("tag", null);
                if ((contentTag != null || headerContentTag == null) && (contentTag == null || contentTag.equals(headerContentTag))) {
                    long accessTime = new Date().getTime();
                    vx.a(LoggingBehavior.CACHE, a, "Setting lastModified to " + Long.valueOf(accessTime) + " for " + file.getName());
                    file.setLastModified(accessTime);
                    if (!true) {
                        buffered.close();
                    }
                    fileInputStream = input;
                    return buffered;
                }
                if (null == null) {
                    buffered.close();
                }
                fileInputStream = input;
                return null;
            } finally {
                if (null == null) {
                    buffered.close();
                }
            }
        } catch (IOException e) {
            return null;
        }
    }

    public OutputStream b(String key) throws IOException {
        return b(key, null);
    }

    public OutputStream b(String key, String contentTag) throws IOException {
        File buffer = vp$a.b(this.e);
        buffer.delete();
        if (buffer.createNewFile()) {
            try {
                BufferedOutputStream buffered = new BufferedOutputStream(new vp$b(new FileOutputStream(buffer), new vp$1(this, System.currentTimeMillis(), buffer, key)), 8192);
                try {
                    JSONObject header = new JSONObject();
                    header.put("key", key);
                    if (!we.a(contentTag)) {
                        header.put("tag", contentTag);
                    }
                    vp$g.a(buffered, header);
                    if (!true) {
                        buffered.close();
                    }
                    return buffered;
                } catch (JSONException e) {
                    vx.a(LoggingBehavior.CACHE, 5, a, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                } catch (Throwable th) {
                    if (!false) {
                        buffered.close();
                    }
                }
            } catch (FileNotFoundException e2) {
                vx.a(LoggingBehavior.CACHE, 5, a, "Error creating buffer output stream: " + e2);
                throw new IOException(e2.getMessage());
            }
        }
        throw new IOException("Could not create file at " + buffer.getAbsolutePath());
    }

    public void a() {
        File[] filesToDelete = this.e.listFiles(vp$a.a());
        this.i.set(System.currentTimeMillis());
        if (filesToDelete != null) {
            ul.d().execute(new vp$2(this, filesToDelete));
        }
    }

    private void a(String key, File buffer) {
        if (!buffer.renameTo(new File(this.e, we.b(key)))) {
            buffer.delete();
        }
        c();
    }

    public InputStream a(String key, InputStream input) throws IOException {
        return new vp$c(input, b(key));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.c + " file:" + this.e.getName() + "}";
    }

    private void c() {
        synchronized (this.h) {
            if (!this.f) {
                this.f = true;
                ul.d().execute(new vp$3(this));
            }
        }
    }

    private void d() {
        synchronized (this.h) {
            this.f = false;
            this.g = true;
        }
        try {
            File file;
            vx.a(LoggingBehavior.CACHE, a, "trim started");
            PriorityQueue<vp$e> heap = new PriorityQueue();
            long size = 0;
            long count = 0;
            File[] filesToTrim = this.e.listFiles(vp$a.a());
            if (filesToTrim != null) {
                for (File file2 : filesToTrim) {
                    vp$e modified = new vp$e(file2);
                    heap.add(modified);
                    vx.a(LoggingBehavior.CACHE, a, "  trim considering time=" + Long.valueOf(modified.b()) + " name=" + modified.a().getName());
                    size += file2.length();
                    count++;
                }
            }
            while (true) {
                if (size > ((long) this.d.a()) || count > ((long) this.d.b())) {
                    file2 = ((vp$e) heap.remove()).a();
                    vx.a(LoggingBehavior.CACHE, a, "  trim removing " + file2.getName());
                    size -= file2.length();
                    count--;
                    file2.delete();
                } else {
                    synchronized (this.h) {
                        this.g = false;
                        this.h.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.h) {
                this.g = false;
                this.h.notifyAll();
            }
        }
    }
}
