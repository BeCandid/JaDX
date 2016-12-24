package defpackage;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders */
public final class mp$a {
    private static final String a = System.getProperty("http.agent");
    private static final Map<String, List<mo>> b;
    private boolean c = true;
    private Map<String, List<mo>> d = b;
    private boolean e = true;
    private boolean f = true;

    static {
        Map<String, List<mo>> temp = new HashMap(2);
        if (!TextUtils.isEmpty(a)) {
            temp.put("User-Agent", Collections.singletonList(new mp$b(a)));
        }
        temp.put("Accept-Encoding", Collections.singletonList(new mp$b("identity")));
        b = Collections.unmodifiableMap(temp);
    }

    public mp a() {
        this.c = true;
        return new mp(this.d);
    }
}
