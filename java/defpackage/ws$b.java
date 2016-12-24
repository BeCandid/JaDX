package defpackage;

import com.facebook.share.widget.LikeView.ObjectType;

/* compiled from: LikeActionController */
class ws$b implements Runnable {
    private String a;
    private ObjectType b;
    private ws$c c;

    ws$b(String objectId, ObjectType objectType, ws$c callback) {
        this.a = objectId;
        this.b = objectType;
        this.c = callback;
    }

    public void run() {
        ws.c(this.a, this.b, this.c);
    }
}
