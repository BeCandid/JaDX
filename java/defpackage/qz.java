package defpackage;

import android.view.View;

/* compiled from: ViewTarget */
public abstract class qz<T extends View, Z> extends qp<Z> {
    private static boolean a = false;
    private static Integer b = null;
    private final qz$a c;
    public final T view;

    public static void setTagId(int tagId) {
        if (b != null || a) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        b = Integer.valueOf(tagId);
    }

    public qz(T view) {
        if (view == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.view = view;
        this.c = new qz$a(view);
    }

    public T getView() {
        return this.view;
    }

    public void getSize(qw cb) {
        this.c.a(cb);
    }

    public void setRequest(qd request) {
        a(request);
    }

    public qd getRequest() {
        qd tag = a();
        if (tag == null) {
            return null;
        }
        if (tag instanceof qd) {
            return tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void a(Object tag) {
        if (b == null) {
            a = true;
            this.view.setTag(tag);
            return;
        }
        this.view.setTag(b.intValue(), tag);
    }

    private Object a() {
        if (b == null) {
            return this.view.getTag();
        }
        return this.view.getTag(b.intValue());
    }

    public String toString() {
        return "Target for: " + this.view;
    }
}
