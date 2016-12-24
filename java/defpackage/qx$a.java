package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: SquaringDrawable */
class qx$a extends ConstantState {
    private final ConstantState a;
    private final int b;

    qx$a(qx$a other) {
        this(other.a, other.b);
    }

    qx$a(ConstantState wrapped, int side) {
        this.a = wrapped;
        this.b = side;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources res) {
        return new qx(this, null, res);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
