package defpackage;

import java.util.ArrayList;

/* compiled from: LikeActionController */
class ws$j implements Runnable {
    private static ArrayList<String> a = new ArrayList();
    private String b;
    private boolean c;

    ws$j(String cacheItem, boolean shouldTrim) {
        this.b = cacheItem;
        this.c = shouldTrim;
    }

    public void run() {
        if (this.b != null) {
            a.remove(this.b);
            a.add(0, this.b);
        }
        if (this.c && a.size() >= 128) {
            while (64 < a.size()) {
                ws.c.remove((String) a.remove(a.size() - 1));
            }
        }
    }
}
