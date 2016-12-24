package defpackage;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;

/* compiled from: LikeActionController */
abstract class ws$a implements ws$n {
    protected String a;
    protected ObjectType b;
    protected FacebookRequestError c;
    final /* synthetic */ ws d;
    private GraphRequest e;

    protected abstract void a(uo uoVar);

    protected ws$a(ws wsVar, String objectId, ObjectType objectType) {
        this.d = wsVar;
        this.a = objectId;
        this.b = objectType;
    }

    public void a(un batch) {
        batch.a(this.e);
    }

    public FacebookRequestError a() {
        return this.c;
    }

    protected void a(GraphRequest request) {
        this.e = request;
        request.a("v2.6");
        request.a(new ws$a$1(this));
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error running request for object '%s' with type '%s' : %s", this.a, this.b, error);
    }
}
