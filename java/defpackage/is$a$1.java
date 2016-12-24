package defpackage;

import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageLoadingUtil */
class is$a$1 implements ku<InputStream> {
    final /* synthetic */ String a;
    final /* synthetic */ is$a b;

    is$a$1(is$a this$0, String str) {
        this.b = this$0;
        this.a = str;
    }

    public /* synthetic */ Object b(Priority priority) throws Exception {
        return a(priority);
    }

    public InputStream a(Priority priority) throws Exception {
        throw new IOException("Forced Glide network failure");
    }

    public void a() {
    }

    public String b() {
        return this.a;
    }

    public void c() {
    }
}
