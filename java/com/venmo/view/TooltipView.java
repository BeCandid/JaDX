package com.venmo.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.akr;
import defpackage.aks;
import defpackage.akt$a;
import defpackage.akt$b;
import defpackage.akt$c;
import defpackage.aku;

public class TooltipView extends TextView {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private akr f;
    private ArrowAlignment g;
    private int h;
    private int i;
    private Paint j;
    private Path k;

    public TooltipView(Context context) {
        super(context);
        a(null, 0);
    }

    public TooltipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(attrs, 0);
    }

    public TooltipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a(attrs, defStyle);
    }

    private void a(AttributeSet attrs, int defStyle) {
        Resources res = getResources();
        TypedArray a = getContext().obtainStyledAttributes(attrs, akt$c.TooltipView, defStyle, 0);
        try {
            this.d = a.getResourceId(akt$c.TooltipView_anchoredView, -1);
            this.e = a.getColor(akt$c.TooltipView_tooltipColor, 0);
            this.c = a(a, akt$c.TooltipView_cornerRadius, akt$a.tooltip_default_corner_radius);
            this.a = a(a, akt$c.TooltipView_arrowHeight, akt$a.tooltip_default_arrow_height);
            this.b = a(a, akt$c.TooltipView_arrowWidth, akt$a.tooltip_default_arrow_width);
            this.i = a.getInteger(akt$c.TooltipView_arrowLocation, res.getInteger(akt$b.tooltip_default_arrow_location));
            this.f = this.i == 0 ? new aku() : new aks();
            this.g = ArrowAlignment.a(a.getInteger(akt$c.TooltipView_arrowAlignment, res.getInteger(akt$b.tooltip_default_arrow_alignment)));
            this.h = a(a, akt$c.TooltipView_arrowAlignmentOffset, akt$a.tooltip_default_offset);
        } finally {
            a.recycle();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + this.a);
    }

    public void invalidate() {
        super.invalidate();
        this.k = null;
        this.j = null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k == null || this.j == null) {
            this.f.a(this, canvas);
        }
        canvas.drawPath(this.k, this.j);
        super.onDraw(canvas);
    }

    public Paint getTooltipPaint() {
        return this.j;
    }

    public void setPaint(Paint paint) {
        this.j = paint;
    }

    public Path getTooltipPath() {
        return this.k;
    }

    public void setTooltipPath(Path tooltipPath) {
        this.k = tooltipPath;
    }

    public int getArrowHeight() {
        return this.a;
    }

    public void setArrowHeight(int arrowHeight) {
        this.a = arrowHeight;
        invalidate();
    }

    public void setArrowHeightResource(int resId) {
        this.a = getResources().getDimensionPixelSize(resId);
        invalidate();
    }

    public int getArrowWidth() {
        return this.b;
    }

    public void setArrowWidth(int arrowWidth) {
        this.b = arrowWidth;
        invalidate();
    }

    public void setArrowWidthResource(int resId) {
        this.b = getResources().getDimensionPixelSize(resId);
        invalidate();
    }

    public int getCornerRadius() {
        return this.c;
    }

    public void setCornerRadius(int cornerRadius) {
        this.c = cornerRadius;
        invalidate();
    }

    public void setCornerRadiusResource(int resId) {
        this.c = getResources().getDimensionPixelSize(resId);
        invalidate();
    }

    public int getAnchoredViewId() {
        return this.d;
    }

    public void setAnchoredViewId(int anchoredViewId) {
        this.d = anchoredViewId;
        invalidate();
    }

    public int getTooltipColor() {
        return this.e;
    }

    public void setTooltipColor(int tooltipColor) {
        this.e = tooltipColor;
        invalidate();
    }

    public void setArrowPositioning(int arrowPositioning) {
        this.i = arrowPositioning;
        invalidate();
    }

    public ArrowAlignment getArrowAlignment() {
        return this.g;
    }

    public void setArrowAlignment(ArrowAlignment arrowAlignment) {
        this.g = arrowAlignment;
        invalidate();
    }

    public int getAlignmentOffset() {
        return this.h;
    }

    public void setAlignmentOffset(int offset) {
        this.h = offset;
        invalidate();
    }

    public void setAlignmentOffsetResource(int resId) {
        this.h = getResources().getDimensionPixelSize(resId);
        invalidate();
    }

    private int a(TypedArray a, int styleableId, int defaultDimension) {
        int result = a.getDimensionPixelSize(styleableId, Integer.MIN_VALUE);
        if (result == Integer.MIN_VALUE) {
            return getResources().getDimensionPixelSize(defaultDimension);
        }
        return result;
    }
}
