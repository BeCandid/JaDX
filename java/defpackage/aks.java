package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.venmo.view.TooltipView;

/* compiled from: BottomArrowLocation */
public class aks implements akr {
    public void a(TooltipView view, Canvas canvas) {
        view.setTooltipPath(new Path());
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.bottom -= (float) view.getArrowHeight();
        view.getTooltipPath().addRoundRect(rectF, (float) view.getCornerRadius(), (float) view.getCornerRadius(), Direction.CW);
        float middle = akq.a(view, rectF);
        view.getTooltipPath().moveTo(middle, (float) view.getHeight());
        int arrowDx = view.getArrowWidth() / 2;
        view.getTooltipPath().lineTo(middle - ((float) arrowDx), rectF.bottom);
        view.getTooltipPath().lineTo(((float) arrowDx) + middle, rectF.bottom);
        view.getTooltipPath().close();
        view.setPaint(new Paint(1));
        view.getTooltipPaint().setColor(view.getTooltipColor());
    }
}
