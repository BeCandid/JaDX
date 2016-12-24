package defpackage;

import android.widget.FrameLayout.LayoutParams;

/* compiled from: ImageLoadingUtil */
class is$3$1 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ is$3 c;

    is$3$1(is$3 this$0, long j, long j2) {
        this.c = this$0;
        this.a = j;
        this.b = j2;
    }

    public void run() {
        LayoutParams layoutParams = (LayoutParams) this.c.b.getLayoutParams();
        layoutParams.width = this.c.c;
        layoutParams.height = (int) ((((long) jb.a(this.c.d, this.c.a)) * this.a) / this.b);
        this.c.b.setVisibility(0);
        this.c.b.setLayoutParams(layoutParams);
    }
}
