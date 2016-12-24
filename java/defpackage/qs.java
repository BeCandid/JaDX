package defpackage;

import android.widget.ImageView;

/* compiled from: GlideDrawableImageViewTarget */
public class qs extends qt<oh> {
    private int a;
    private oh b;

    public /* synthetic */ void onResourceReady(Object x0, qk x1) {
        a((oh) x0, x1);
    }

    protected /* synthetic */ void setResource(Object x0) {
        a((oh) x0);
    }

    public qs(ImageView view) {
        this(view, -1);
    }

    public qs(ImageView view, int maxLoopCount) {
        super(view);
        this.a = maxLoopCount;
    }

    public void a(oh resource, qk<? super oh> animation) {
        if (!resource.a()) {
            float drawableRatio = ((float) resource.getIntrinsicWidth()) / ((float) resource.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.view).getWidth()) / ((float) ((ImageView) this.view).getHeight())) - 1.0f) <= 0.05f && Math.abs(drawableRatio - 1.0f) <= 0.05f) {
                resource = new qx(resource, ((ImageView) this.view).getWidth());
            }
        }
        super.onResourceReady(resource, animation);
        this.b = resource;
        resource.a(this.a);
        resource.start();
    }

    protected void a(oh resource) {
        ((ImageView) this.view).setImageDrawable(resource);
    }

    public void onStart() {
        if (this.b != null) {
            this.b.start();
        }
    }

    public void onStop() {
        if (this.b != null) {
            this.b.stop();
        }
    }
}
