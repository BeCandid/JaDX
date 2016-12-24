package defpackage;

import android.text.TextUtils;

public class aib {
    private static final Object a = new Object();
    private final aid b;

    public aib(aid aid) {
        this.b = aid;
    }

    public String a() {
        String str = null;
        synchronized (a) {
            String string = this.b.a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    public boolean a(String str) {
        boolean z;
        synchronized (a) {
            String string = this.b.a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.b.a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
