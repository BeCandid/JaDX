package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.GenericRequest;

/* compiled from: GenericRequestBuilder */
public class jv<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;
    protected final Class<ModelType> a;
    protected final Context b;
    protected final jx c;
    protected final Class<TranscodeType> d;
    protected final pt e;
    protected final po f;
    private px<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private kn i;
    private boolean j;
    private int k;
    private int l;
    private qf<? super ModelType, TranscodeType> m;
    private Float n;
    private jv<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private Priority s;
    private boolean t;
    private ql<TranscodeType> u;
    private int v;
    private int w;
    private DiskCacheStrategy x;
    private kr<ResourceType> y;
    private boolean z;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return g();
    }

    jv(qc<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> transcodeClass, jv<ModelType, ?, ?, ?> other) {
        this(other.b, other.a, loadProvider, transcodeClass, other.c, other.e, other.f);
        this.h = other.h;
        this.j = other.j;
        this.i = other.i;
        this.x = other.x;
        this.t = other.t;
    }

    jv(Context context, Class<ModelType> modelClass, qc<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> transcodeClass, jx glide, pt requestTracker, po lifecycle) {
        px pxVar = null;
        this.i = ra.a();
        this.p = Float.valueOf(1.0f);
        this.s = null;
        this.t = true;
        this.u = qm.a();
        this.v = -1;
        this.w = -1;
        this.x = DiskCacheStrategy.d;
        this.y = no.b();
        this.b = context;
        this.a = modelClass;
        this.d = transcodeClass;
        this.c = glide;
        this.e = requestTracker;
        this.f = lifecycle;
        if (loadProvider != null) {
            pxVar = new px(loadProvider);
        }
        this.g = pxVar;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (modelClass != null && loadProvider == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(kp<DataType, ResourceType> decoder) {
        if (this.g != null) {
            this.g.a((kp) decoder);
        }
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(km<DataType> sourceEncoder) {
        if (this.g != null) {
            this.g.a((km) sourceEncoder);
        }
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(DiskCacheStrategy strategy) {
        this.x = strategy;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(kr<ResourceType>... transformations) {
        this.z = true;
        if (transformations.length == 1) {
            this.y = transformations[0];
        } else {
            this.y = new ko(transformations);
        }
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> h() {
        return a(qm.a());
    }

    jv<ModelType, DataType, ResourceType, TranscodeType> a(ql<TranscodeType> animationFactory) {
        if (animationFactory == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.u = animationFactory;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(int resourceId) {
        this.k = resourceId;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(qf<? super ModelType, TranscodeType> requestListener) {
        this.m = requestListener;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(boolean skip) {
        this.t = !skip;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(int width, int height) {
        if (ri.a(width, height)) {
            this.w = width;
            this.v = height;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(kn signature) {
        if (signature == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.i = signature;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(ModelType model) {
        this.h = model;
        this.j = true;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> g() {
        try {
            jv<ModelType, DataType, ResourceType, TranscodeType> clone = (jv) super.clone();
            clone.g = this.g != null ? this.g.g() : null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends qy<TranscodeType>> Y a(Y target) {
        ri.a();
        if (target == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.j) {
            qd previous = target.getRequest();
            if (previous != null) {
                previous.d();
                this.e.b(previous);
                previous.a();
            }
            qd request = b((qy) target);
            target.setRequest(request);
            this.f.a(target);
            this.e.a(request);
            return target;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public qy<TranscodeType> a(ImageView view) {
        ri.a();
        if (view == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.z || view.getScaleType() == null)) {
            switch (jv$1.a[view.getScaleType().ordinal()]) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    f();
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    e();
                    break;
            }
        }
        return a(this.c.a(view, this.d));
    }

    void f() {
    }

    void e() {
    }

    private Priority a() {
        if (this.s == Priority.d) {
            return Priority.c;
        }
        if (this.s == Priority.c) {
            return Priority.b;
        }
        return Priority.a;
    }

    private qd b(qy<TranscodeType> target) {
        if (this.s == null) {
            this.s = Priority.c;
        }
        return a(target, null);
    }

    private qd a(qy<TranscodeType> target, qh parentCoordinator) {
        qh coordinator;
        if (this.o != null) {
            if (this.A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.o.u.equals(qm.a())) {
                this.o.u = this.u;
            }
            if (this.o.s == null) {
                this.o.s = a();
            }
            if (ri.a(this.w, this.v) && !ri.a(this.o.w, this.o.v)) {
                this.o.b(this.w, this.v);
            }
            coordinator = new qh(parentCoordinator);
            qd fullRequest = a(target, this.p.floatValue(), this.s, coordinator);
            this.A = true;
            qd thumbRequest = this.o.a(target, coordinator);
            this.A = false;
            coordinator.a(fullRequest, thumbRequest);
            return coordinator;
        } else if (this.n == null) {
            return a(target, this.p.floatValue(), this.s, parentCoordinator);
        } else {
            coordinator = new qh(parentCoordinator);
            coordinator.a(a(target, this.p.floatValue(), this.s, coordinator), a(target, this.n.floatValue(), a(), coordinator));
            return coordinator;
        }
    }

    private qd a(qy<TranscodeType> target, float sizeMultiplier, Priority priority, qe requestCoordinator) {
        return GenericRequest.a(this.g, this.h, this.i, this.b, priority, target, sizeMultiplier, this.q, this.k, this.r, this.l, this.B, this.C, this.m, requestCoordinator, this.c.b(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
    }
}
